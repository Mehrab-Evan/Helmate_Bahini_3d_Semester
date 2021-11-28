package com.example.helmatebahini;

public class PassingACOpeningInfotoDB {
    String Username;
    String Email;
    String Phone;
    String Location;
    String Password;

    public PassingACOpeningInfotoDB(String U, String E, String Ph, String Lo, String Pwd)
    {
        Username = U;
        Email = E;
        Phone = Ph;
        Location = Lo;
        Password = Pwd;
    }

    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getLocation() {
        return Location;
    }

    public String getPassword() {
        return Password;
    }
}
