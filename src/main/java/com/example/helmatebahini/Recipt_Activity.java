package com.example.helmatebahini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Recipt_Activity extends AppCompatActivity {

    TextView Appetizer_Bill, Main_Course_Bill, Dessert_Bill, Total_Pay, Drinks_Bill;
    EditText PayPal, Bkash;
    Button Done_Purchase, Back_from_Receipt;
    int Drinks_er_TK = 0, Dessert_er_TK = 0, maincourse=0, appetizer=0, Total=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt);

        PayPal = (EditText) findViewById(R.id.Paypal);
        Bkash = (EditText) findViewById(R.id.Bkash);
        Main_Course_Bill = (TextView) findViewById(R.id.Main_Course_Bill);
        Appetizer_Bill = (TextView) findViewById(R.id.Appetizer_Bill);
        Total_Pay = (TextView) findViewById(R.id.Total_Pay);
        Dessert_Bill = (TextView) findViewById(R.id.Dessert_Bill);
        Drinks_Bill = (TextView) findViewById(R.id.Drinks_Bill);
        Done_Purchase = (Button) findViewById(R.id.Done_purchase);
        Back_from_Receipt = (Button) findViewById(R.id.Back_from_recipt);

        Drinks Dr = new Drinks();
        String DrinksCalc = Dr.getToReceipt();
        Drinks_er_TK = Integer.parseInt(DrinksCalc);
        Drinks_Bill.setText("Drinks : "+DrinksCalc);

        Dessert DS = new Dessert();
        String DessertCalc = DS.getFromDessert_Bill();
        Dessert_er_TK = Integer.parseInt(DessertCalc);
        Dessert_Bill.setText("Dessert : "+DessertCalc);

        MainCourse MC = new MainCourse();
        String MainC = MC.getFromMainCourse();
        maincourse = Integer.parseInt(MainC);
        Main_Course_Bill.setText("MainCourse : "+MainC);

        Appetizer Ap = new Appetizer();
        String App = Ap.getAppetizerBill();
        appetizer = Integer.parseInt(App);
        Appetizer_Bill.setText("Appetizer : "+App);

        Total = maincourse + appetizer + Dessert_er_TK + Drinks_er_TK;
        String total = String.valueOf(Total);
        Total_Pay.setText("Total : "+total);

        Back_from_Receipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoBrowseMenu = new Intent(Recipt_Activity.this,BrowseMenue.class);
                Toast.makeText(Recipt_Activity.this, "Previous Orders are Stored", Toast.LENGTH_SHORT).show();
                startActivity(backtoBrowseMenu);
            }
        });
        Done_Purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(PayPal.getText().toString()) || !TextUtils.isEmpty(Bkash.getText().toString()))
                {
                    Intent Thanks = new Intent(Recipt_Activity.this, Thanks.class);
                    Toast.makeText(Recipt_Activity.this, "Paid Thank You", Toast.LENGTH_SHORT).show();
                    startActivity(Thanks);
                }
                else
                {
                    Toast.makeText(Recipt_Activity.this, "Please Fill up the Transaction ID in Bkash or PayPal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}