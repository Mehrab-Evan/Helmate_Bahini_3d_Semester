package com.example.helmatebahini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Thanks extends AppCompatActivity {

    Button Logout, ToBrowseFromThanks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
        Logout = (Button) findViewById(R.id.logout);
        ToBrowseFromThanks = (Button) findViewById(R.id.Browse_Menu_from_Thanks);


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LOGOUT = new Intent(Thanks.this, MainActivity.class);
                Toast.makeText(Thanks.this, "Logged Out", Toast.LENGTH_SHORT).show();
                startActivity(LOGOUT);
            }
        });

        ToBrowseFromThanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent TOBROWSEMENU = new Intent(Thanks.this,BrowseMenue.class);
                Toast.makeText(Thanks.this, "Want to Change Order?", Toast.LENGTH_SHORT).show();
                startActivity(TOBROWSEMENU);
            }
        });
    }
}