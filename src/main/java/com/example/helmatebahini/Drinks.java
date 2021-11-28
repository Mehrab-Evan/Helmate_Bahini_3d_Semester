package com.example.helmatebahini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Drinks extends AppCompatActivity {

    EditText CocaCola, Pepsi, Borhani, Lacchi, Tea, Sprite, MilkShake, Coffee;
    Button Back_From_Drinks, Confirm_Drinks;
    int CocaQn=0, PepsiQn=0, BorhaniQn=0, LacchiQn=0, TeaQn=0, SpriteQn=0, MilkShakeQn=0, CoffeeQn=0;
    int Total_CocaCola=0, Total_Pepsi=0, Total_Borhani=0, Total_Lacchi=0, Total_Tea=0, Total_Sprite=0, Total_MilkShake=0, Total_Coffee=0;
    int Total_Drinks_Costs=0;
    private static String Total_Drinks_Cost_String = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        CocaCola = (EditText) findViewById(R.id.CocaCola);
        Pepsi = (EditText) findViewById(R.id.Pepsi);
        Borhani = (EditText) findViewById(R.id.Borhani);
        Lacchi = (EditText) findViewById(R.id.Lacchi);
        Tea = (EditText) findViewById(R.id.Tea);
        Sprite = (EditText) findViewById(R.id.Sprite);
        MilkShake = (EditText) findViewById(R.id.MilkShake);
        Coffee = (EditText) findViewById(R.id.Coffee);
        Back_From_Drinks = (Button) findViewById(R.id.Back_from_Drinks);
        Confirm_Drinks = (Button) findViewById(R.id.Confirm_Drinks);

        Back_From_Drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Back_to_Browse_from_Drinks = new Intent(Drinks.this, BrowseMenue.class);
                Toast.makeText(Drinks.this, "Previous Drinks Order is Stored", Toast.LENGTH_SHORT).show();
                startActivity(Back_to_Browse_from_Drinks);
            }
        });

        Confirm_Drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Drinks_Er_HishabNikash();
                Intent Confirmed_and_goTo_Browse = new Intent(Drinks.this, BrowseMenue.class);
                Toast.makeText(Drinks.this, "Drinks Order is Stored", Toast.LENGTH_SHORT).show();
                startActivity(Confirmed_and_goTo_Browse);
            }
        });

    }

    public static String getToReceipt()
    {
        return Total_Drinks_Cost_String;
    }
    public void Drinks_Er_HishabNikash()
    {
        String val1 = CocaCola.getText().toString();
        CocaQn = Integer.parseInt(val1);
        Total_CocaCola = 50 * CocaQn;

        String val2 = Pepsi.getText().toString();
        PepsiQn = Integer.parseInt(val2);
        Total_Pepsi = 50 * PepsiQn;

        String val3 = Borhani.getText().toString();
        BorhaniQn = Integer.parseInt(val3);
        Total_Borhani = 70 * BorhaniQn;

        String val4 = Lacchi.getText().toString();
        LacchiQn = Integer.parseInt(val4);
        Total_Lacchi = 70 * LacchiQn;

        String val5 = Tea.getText().toString();
        TeaQn = Integer.parseInt(val5);
        Total_Tea = 10 * TeaQn;

        String val6 = Sprite.getText().toString();
        SpriteQn = Integer.parseInt(val6);
        Total_Sprite = 50 * SpriteQn;

        String val7 = MilkShake.getText().toString();
        MilkShakeQn = Integer.parseInt(val7);
        Total_MilkShake = 80 * MilkShakeQn;

        String val8 = Coffee.getText().toString();
        CoffeeQn = Integer.parseInt(val8);
        Total_Coffee = 20 * CoffeeQn;

        Total_Drinks_Costs = Total_CocaCola + Total_Pepsi + Total_Borhani + Total_Lacchi + Total_Tea + Total_Sprite + Total_MilkShake + Total_Coffee;
        Total_Drinks_Cost_String = String.valueOf(Total_Drinks_Costs);
    }
}