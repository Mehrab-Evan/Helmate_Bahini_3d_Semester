package com.example.helmatebahini;

public class Passing_Data_From_Appetizer {
    Double FrenchFries, Wonton, ChickenSoup, CornSoup, ChickenRoll, BeefBurger, CheeseBurger;

    public Passing_Data_From_Appetizer(double a, double b, double c, double d, double e, double f, double g)
    {
        FrenchFries = a;
        Wonton = b;
        ChickenSoup = c;
        CornSoup = d;
        ChickenRoll = e;
        BeefBurger = f;
        CheeseBurger = g;
    }

    public double getFrenchFries() {
        return FrenchFries;
    }

    public double getWonton() {
        return Wonton;
    }

    public double getChickenSoup() {
        return ChickenSoup;
    }

    public double getCornSoup() {
        return CornSoup;
    }

    public double getChickenRoll() {
        return ChickenRoll;
    }

    public double getBeefBurger() {
        return BeefBurger;
    }

    public double getCheeseBurger() {
        return CheeseBurger;
    }
}
