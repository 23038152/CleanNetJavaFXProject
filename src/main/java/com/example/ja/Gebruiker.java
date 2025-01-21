//package models;
package com.example.ja;

public class Gebruiker {
    private int gebruikerID;
    private String username;
    private String email;
    private String wachtwoord;

    public Gebruiker(int gebruikerID, String username, String email, String wachtwoord) {
        this.gebruikerID = gebruikerID;
        this.username = username;
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    public int getGebruikerID() {
        return gebruikerID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    @Override
    public String toString() {
        return "Gebruiker{" +
                "gebruikerID=" + gebruikerID +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
