package com.example.helmatebahini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Appetizer extends AppCompatActivity {

    EditText FrenchFries, Wonton, ChickenSoup, CornSoup, ChickenRoll,
            BeefBurger, CheeseBurger, ChickenBurger;
    Button Confirm_Appetizer, Back_from_appetizer;

    int Total_French=0, Total_Won=0, Total_ChickenSoup=0, Total_CornSoup=0, Total_Chicken_Roll=0, Total_Beef_Burger=0,
            Total_Cheese_Burger=0, Total_Chicken_Burger=0, Appetizer_total=0;
    int Frenchqn=0, Wonqn=0, Chickenqn=0, Cornqn=0, Rollqn=0, Beefqn=0, CheBurqn=0,
            ChickenBurqn=0;
    private static String Appetizer_total_String = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizer);

        FrenchFries = (EditText) findViewById(R.id.FrenchFries);
        Wonton = (EditText) findViewById(R.id.Wonton);
        ChickenSoup = (EditText) findViewById(R.id.ChickenSoup);
        CornSoup = (EditText) findViewById(R.id.CornSoup);
        ChickenRoll = (EditText) findViewById(R.id.ChickenRoll);
        BeefBurger = (EditText) findViewById(R.id.BeefBurger);
        CheeseBurger = (EditText) findViewById(R.id.CheeseBurger);
        ChickenBurger = (EditText) findViewById(R.id.ChickenBurger);
        Confirm_Appetizer = (Button) findViewById(R.id.Confirm_Appetizer);
        Back_from_appetizer = (Button) findViewById(R.id.Back_from_Appetizer);


        Confirm_Appetizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ADDTOCALCUlATION();
                Intent Appetizer_shesh = new Intent(Appetizer.this, BrowseMenue.class);
                //Appetizer_total_String = "1000";
                //Appetizer_shesh.putExtra("Appetizer_er_TK", Appetizer_total_String);
                Toast.makeText(Appetizer.this, "Appetizer Order Stored", Toast.LENGTH_SHORT).show();
                startActivity(Appetizer_shesh);
            }
        });
        Back_from_appetizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Appetizer_shesh = new Intent(Appetizer.this, BrowseMenue.class);
                Toast.makeText(Appetizer.this, "Previous Appetizer Order Stored", Toast.LENGTH_SHORT).show();
                startActivity(Appetizer_shesh);
            }
        });
    }
    public static String getAppetizerBill()
    {
        return Appetizer_total_String;
    }
    public void ADDTOCALCUlATION()
    {
        String value1= FrenchFries.getText().toString();
        Frenchqn = Integer.parseInt(value1);
        Total_French = 180 * Frenchqn;
        //Appetizer_total_String = String.valueOf(Total_French);

        String value2= Wonton.getText().toString();
        Wonqn = Integer.parseInt(value2);
        Total_Won = 40 * Wonqn;
        //Appetizer_total_String = String.valueOf(Total_French);

        String value3 = ChickenSoup.getText().toString();
        Chickenqn = Integer.parseInt(value3);
        Total_ChickenSoup = 200 * Chickenqn;

        String value4 = CornSoup.getText().toString();
        Cornqn = Integer.parseInt(value4);
        Total_CornSoup = 180 * Cornqn;

        String value5 = ChickenRoll.getText().toString();
        Rollqn = Integer.parseInt(value5);
        Total_Chicken_Roll = 180 * Rollqn;

        String value6 = BeefBurger.getText().toString();
        Beefqn = Integer.parseInt(value6);
        Total_Beef_Burger = 300 * Beefqn;

        String value7 = CheeseBurger.getText().toString();
        CheBurqn = Integer.parseInt(value7);
        Total_Cheese_Burger = 400 * CheBurqn;

        String value8 = ChickenBurger.getText().toString();
        ChickenBurqn = Integer.parseInt(value8);
        Total_Chicken_Burger = 200 * ChickenBurqn;

        Appetizer_total = Total_French + Total_Won + Total_ChickenSoup + Total_CornSoup +
                            Total_Chicken_Roll + Total_Beef_Burger + Total_Cheese_Burger + Total_Chicken_Burger;
        //String Appetizer_total_String = Double.toString(Appetizer_total);
        Appetizer_total_String = String.valueOf(Appetizer_total);

        /*try {
            FileOutputStream Writing = openFileOutput("Calculation.txt", Context.MODE_PRIVATE);
            Writing.write();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }

      /*  //DatabaseReference HishabKorbo = FirebaseDatabase.getInstance().getReference("HishabNikash");
        Query TakaDaw = CALCULATION.orderByChild("ekhane_kichu_lagbe_na").equalTo("Calculation_Here");
        TakaDaw.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!snapshot.exists())
                {
                    Passing_Data_From_Appetizer Calc = new Passing_Data_From_Appetizer(Total_French, Total_Won, Total_ChickenSoup, Total_CornSoup, Total_Chicken_Roll, Total_Beef_Burger, Total_Cheese_Burger);
                    CALCULATION.child("HishabNikash").setValue(Calc);
                    Toast.makeText(Appetizer.this, "Your Order is Stored", Toast.LENGTH_SHORT).show();
                    Appetizer_Confirm();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }*/
    /*public void Appetizer_Confirm()
    {
        Intent To_Browse_Menue = new Intent(Appetizer.this, BrowseMenue.class);
        startActivity(To_Browse_Menue);
    }*/

}