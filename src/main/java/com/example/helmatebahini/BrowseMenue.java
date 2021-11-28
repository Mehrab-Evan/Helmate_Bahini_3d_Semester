package com.example.helmatebahini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BrowseMenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_menue);
    }

    public void ToAppetizer(View ForAppetizer)
    {
        Intent AppetizerWindow = new Intent(this, Appetizer.class);
        startActivity(AppetizerWindow);
    }
    public void ToMainCourse(View ForMainCourse)
    {
        Intent MainCourseWindow = new Intent(this, MainCourse.class);
        startActivity(MainCourseWindow);
    }
    public void ToDessert(View ForDessert)
    {
        Intent ToDessert = new Intent(this, Dessert.class);
        startActivity(ToDessert);
    }
    public void ToDrinks(View ForDrinks)
    {
        Intent ToDrink = new Intent(this, Drinks.class);
        startActivity(ToDrink);
    }
    public void ToReceipt(View ForRecipt)
    {
        Intent Receipt = new Intent(this, Recipt_Activity.class);
        startActivity(Receipt);
    }

}