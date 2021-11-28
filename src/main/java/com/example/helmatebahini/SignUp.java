package com.example.helmatebahini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class SignUp extends AppCompatActivity {

    EditText Username_SignUp, Email_SignUp, Phone_SignUp, Location_SignUp, Password_SignUp;
    Button Siup, Siin;
    DatabaseReference HELMATE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        Username_SignUp = (EditText) findViewById(R.id.Uname_in_Signup);
        Email_SignUp = (EditText) findViewById(R.id.email);
        Phone_SignUp = (EditText) findViewById(R.id.phone);
        Location_SignUp = (EditText) findViewById(R.id.Location);
        Password_SignUp = (EditText) findViewById(R.id.Password_in_Signup);
        Siup = (Button) findViewById(R.id.Signup_Signup);
        Siin = (Button) findViewById(R.id.Signin_Signin);

        HELMATE = FirebaseDatabase.getInstance().getReference("Clients");

        Siin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoTo();
            }
        });
        Siup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpeningAccount();
            }
        });

    }

    public void OpeningAccount()
    {
        String Uname = Username_SignUp.getText().toString().trim();
        String email = Email_SignUp.getText().toString().trim();
        String ph = Phone_SignUp.getText().toString().trim();
        String loc = Location_SignUp.getText().toString().trim();
        String pwd = Password_SignUp.getText().toString().trim();
        if(!TextUtils.isEmpty(Uname) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(ph) && !TextUtils.isEmpty(loc) && !TextUtils.isEmpty(pwd))
        {
            String KEY;
            KEY = Uname;
            DatabaseReference ForCheckData = FirebaseDatabase.getInstance().getReference("Clients");
            Query CheckUser = ForCheckData.orderByChild("IcchamotoNamDhoro_karon_eitar_kaj_nai").equalTo(Uname);
            CheckUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists())
                    {
                        Toast.makeText(SignUp.this, "Username Has already an account", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        PassingACOpeningInfotoDB AccountInfo = new PassingACOpeningInfotoDB(Uname,email,ph,loc,pwd);
                        HELMATE.child(KEY).setValue(AccountInfo);
                        //Toast.makeText(this,"Account Opened Press Sign in to Sign in", Toast.LENGTH_LONG).show();
                        Toast.makeText(SignUp.this, "Account Created", Toast.LENGTH_SHORT).show();
                        Username_SignUp.setText("");
                        Email_SignUp.setText("");
                        Phone_SignUp.setText("");
                        Location_SignUp.setText("");
                        Password_SignUp.setText("");
                        GoTo();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }

    public void GoTo()
    {
        Intent LoginPage = new Intent(SignUp.this, NotunLogin.class);
        startActivity(LoginPage);
    }

    /*public void GoToLogIn(View LoginKorbo)
    {
        Intent LoginPage = new Intent(SignUp.this, NotunLogin.class);
        startActivity(LoginPage);
    }*/
}