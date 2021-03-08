package com.benew.client.goodtogo.Modals;

public class Restaurant {

    private String name, name_owner, password, phone_restaurant, phone_owner, secteur, rue, picture;
    private boolean profile_done;

    public Restaurant() {}

    public Restaurant(String name, String name_owner, String password, String phone_restaurant, String phone_owner, String secteur, String rue, String picture, boolean profile_done) {
        this.name = name;
        this.name_owner = name_owner;
        this.password = password;
        this.phone_restaurant = phone_restaurant;
        this.phone_owner = phone_owner;
        this.secteur = secteur;
        this.rue = rue;
        this.picture = picture;
        this.profile_done = profile_done;
    }

    public Restaurant(String name, String name_owner, String password, String phone_owner, String secteur, boolean profile_done) {
        this.name = name;
        this.name_owner = name_owner;
        this.password = password;
        this.phone_owner = phone_owner;
        this.secteur = secteur;
        this.profile_done = profile_done;
    }

    public String getName() {
        return name;
    }

    public String getName_owner() {
        return name_owner;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_restaurant() {
        return phone_restaurant;
    }

    public String getPhone_owner() {
        return phone_owner;
    }

    public String getSecteur() {
        return secteur;
    }

    public String getRue() {
        return rue;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isProfile_done() {
        return profile_done;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_owner(String name_owner) {
        this.name_owner = name_owner;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_restaurant(String phone_restaurant) {
        this.phone_restaurant = phone_restaurant;
    }

    public void setPhone_owner(String phone_owner) {
        this.phone_owner = phone_owner;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setProfile_done(boolean profile_done) {
        this.profile_done = profile_done;
    }
}
