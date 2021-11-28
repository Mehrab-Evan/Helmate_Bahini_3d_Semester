package com.example.helmatebahini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainCourse extends AppCompatActivity {

    private static String Main_Course_Total_String = "0";
    EditText SteamRice, FriedRice, Kacchi, ChickenFry, Beef, BeefBiriyani, CheesePizza, TunaFish;
    Button Confirm_Main, Back_From_Main;

    int Total_StRice=0, Total_FRice=0, Total_Kacchi=0, Total_ChFry=0, Total_BeefBiriyani=0, Total_Beef=0, Total_ChPizza=0, Total_TunaFish=0;
    int StQn=0, FRQn=0, KacchiQn=0, ChFryQn=0, BeefQn=0, BeefBiriyaniQn=0, CheesePizzaQn=0, TunaFishQn=0;
    int Main_Course_Total = 0;
    //String Main_Course_Total_String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_course);

        SteamRice = (EditText) findViewById(R.id.SteamRice);
        FriedRice = (EditText) findViewById(R.id.FriedRice);
        Kacchi = (EditText) findViewById(R.id.Kacchi);
        ChickenFry = (EditText) findViewById(R.id.ChickenFry);
        Beef = (EditText) findViewById(R.id.Beef);
        BeefBiriyani = (EditText) findViewById(R.id.BeefBiriyani);
        CheesePizza = (EditText) findViewById(R.id.CheesePizza);
        TunaFish = (EditText) findViewById(R.id.TunaFish);

        Confirm_Main = (Button) findViewById(R.id.Confirm_MainCourse);
        Back_From_Main = (Button) findViewById(R.id.Back_from_MainCourse);

        Confirm_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MAINCOURSE_ER_HISHAB();
                Intent MainCourseShesh = new Intent(MainCourse.this, BrowseMenue.class);
                Toast.makeText(MainCourse.this, "Main Course Order is Stored", Toast.LENGTH_SHORT).show();
                startActivity(MainCourseShesh);
            }
        });
        Back_From_Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainCourseShesh = new Intent(MainCourse.this, BrowseMenue.class);
                Toast.makeText(MainCourse.this, "Previous Main Course Order is Stored", Toast.LENGTH_SHORT).show();
                startActivity(MainCourseShesh);
            }
        });
    }

    public static String getFromMainCourse()
    {
        return Main_Course_Total_String;
    }

    public void MAINCOURSE_ER_HISHAB()
    {
        String value1 = SteamRice.getText().toString();
        StQn = Integer.parseInt(value1);
        Total_StRice = 180 * StQn;

        String value2 = FriedRice.getText().toString();
        FRQn = Integer.parseInt(value2);
        Total_FRice = 180 * FRQn;

        String value3 = Kacchi.getText().toString();
        KacchiQn = Integer.parseInt(value3);
        Total_Kacchi = 180 * KacchiQn;

        String value4 = ChickenFry.getText().toString();
        ChFryQn = Integer.parseInt(value4);
        Total_ChFry = 180 * ChFryQn;

        String value5 = Beef.getText().toString();
        BeefQn = Integer.parseInt(value5);
        Total_Beef = 180 * BeefQn;

        String value6 = BeefBiriyani.getText().toString();
        BeefBiriyaniQn = Integer.parseInt(value6);
        Total_BeefBiriyani = 180 * BeefBiriyaniQn;

        String value7 = CheesePizza.getText().toString();
        CheesePizzaQn = Integer.parseInt(value7);
        Total_ChPizza = 180 * CheesePizzaQn;

        String value8 = TunaFish.getText().toString();
        TunaFishQn = Integer.parseInt(value8);
        Total_TunaFish = 180 * TunaFishQn;

        Main_Course_Total = Total_StRice + Total_FRice + Total_Kacchi + Total_ChFry + Total_Beef + Total_BeefBiriyani + Total_ChPizza + Total_TunaFish;
        Main_Course_Total_String = String.valueOf(Main_Course_Total);
    }
}