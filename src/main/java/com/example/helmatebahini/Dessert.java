package com.example.helmatebahini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dessert extends AppCompatActivity {

    EditText Mixed_fruits, Cream, Pudding, CupCake, Donut, Jilapi, Cheese, ChocolateCake, VanilaCake;
    Button Confirm_Dessert, Back_From_Dessert;
    int Mixed_fruitQn=0, CreamQn=0, PuddingQn=0, CupCakeQn=0, DonutQn=0, JilapiQn=0, CheeseQn=0, ChocolateQn=0, VanilaqQn=0;
    int Total_mx=0, Total_Cream=0, Total_Pudding=0, Total_Cake=0, Total_Donut=0, Total_Jilapi=0, Total_Cheese=0, Total_Chocolate=0, TotalVanila=0;
    int Total_Dessert_Bill = 0;
    private static String Total_Dessert_Bill_String = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dessert);

        Mixed_fruits = (EditText) findViewById(R.id.Mixed_fruits);
        Cream = (EditText) findViewById(R.id.Cream);
        Pudding = (EditText) findViewById(R.id.Pudding);
        CupCake = (EditText) findViewById(R.id.CupCake);
        Donut = (EditText) findViewById(R.id.Donut);
        Jilapi = (EditText) findViewById(R.id.Jilapi);
        Cheese = (EditText) findViewById(R.id.Cheese);
        ChocolateCake = (EditText) findViewById(R.id.ChocolateCake);
        VanilaCake = (EditText) findViewById(R.id.VanilaCake);

        Confirm_Dessert = (Button) findViewById(R.id.Dessert_er_Kaaj_Done);
        Back_From_Dessert = (Button) findViewById(R.id.Back_from_Dessert);

        Confirm_Dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dessert_er_Hishab();
                Intent DoneDessert = new Intent(Dessert.this, BrowseMenue.class);
                Toast.makeText(Dessert.this, "Dessert Order is Stored", Toast.LENGTH_SHORT).show();
                startActivity(DoneDessert);
            }
        });
        Back_From_Dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BackToBrowseFromDessert = new Intent(Dessert.this, BrowseMenue.class);
                Toast.makeText(Dessert.this, "Previous Dessert Order is Stored", Toast.LENGTH_SHORT).show();
                startActivity(BackToBrowseFromDessert);
            }
        });
    }

    public static String getFromDessert_Bill()
    {
        return Total_Dessert_Bill_String;
    }

    public void Dessert_er_Hishab()
    {
        String val1 = Mixed_fruits.getText().toString();
        Mixed_fruitQn = Integer.parseInt(val1);
        Total_mx = 100 * Mixed_fruitQn;

        String val2 = Cream.getText().toString();
        CreamQn = Integer.parseInt(val2);
        Total_Cream = 80 * CreamQn;

        String val3 = Pudding.getText().toString();
        PuddingQn = Integer.parseInt(val3);
        Total_Pudding = 40 * PuddingQn;

        String val4 = CupCake.getText().toString();
        CupCakeQn = Integer.parseInt(val4);
        Total_Cake = 100 * CupCakeQn;

        String val5 = Donut.getText().toString();
        DonutQn = Integer.parseInt(val5);
        Total_Donut = 100 * DonutQn;

        String val6 = Jilapi.getText().toString();
        JilapiQn = Integer.parseInt(val6);
        Total_Jilapi = 40 * JilapiQn;

        String val7 = Cheese.getText().toString();
        CheeseQn = Integer.parseInt(val7);
        Total_Cheese = 100 * CheeseQn;

        String val8 =  ChocolateCake.getText().toString();
        ChocolateQn = Integer.parseInt(val8);
        Total_Chocolate = 100 * ChocolateQn;

        String val9 = VanilaCake.getText().toString();
        VanilaqQn = Integer.parseInt(val9);
        TotalVanila = 100 * VanilaqQn;

        Total_Dessert_Bill = Total_mx + Total_Cream + Total_Pudding + Total_Cake + Total_Donut + Total_Jilapi + Total_Cheese + Total_Chocolate + TotalVanila;
        Total_Dessert_Bill_String = String.valueOf(Total_Dessert_Bill);
    }
}