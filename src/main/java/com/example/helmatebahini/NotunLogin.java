package com.example.helmatebahini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class NotunLogin extends AppCompatActivity {

    EditText Username, Password;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notun_login);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);
        Login = (Button) findViewById(R.id.LOGIN);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               LoggedinOrNot();
            }
        });
    }
    public void LoggedinOrNot()
    {
        String UN = Username.getText().toString().trim();
        String PW = Password.getText().toString().trim();

        DatabaseReference MatchingInputWithDatabase = FirebaseDatabase.getInstance().getReference("Clients");
        Query Checking = MatchingInputWithDatabase.orderByChild("username").equalTo(UN);
        Checking.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    String PasswordFromDB = snapshot.child(UN).child("password").getValue(String.class);
                    if(PasswordFromDB.equals(PW))
                    {
                        Toast.makeText(NotunLogin.this, "Welcome "+UN, Toast.LENGTH_SHORT).show();
                        Username.setText("");
                        Password.setText("");
                        OpenBrowseMenue();
                    }
                    else
                    {
                        Toast.makeText(NotunLogin.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                        Username.setText("");
                        Password.setText("");
                    }
                }
                else
                {
                    Toast.makeText(NotunLogin.this, "Username or Password doesn't exist", Toast.LENGTH_SHORT).show();
                    Username.setText("");
                    Password.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void OpenBrowseMenue()
    {
        Intent GotoBrowseMenue = new Intent(this, BrowseMenue.class);
        startActivity(GotoBrowseMenue);
    }
}