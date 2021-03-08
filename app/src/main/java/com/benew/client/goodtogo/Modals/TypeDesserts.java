package com.benew.client.goodtogo.Modals;

public class TypeDesserts {

    private boolean bonbons, crepes, tablettes, mousse, gateaux, cremes_glacees;

    public TypeDesserts() {}

    public TypeDesserts(boolean bonbons, boolean crepes, boolean tablettes, boolean mousse, boolean gateaux, boolean cremes_glacees) {
        this.bonbons = bonbons;
        this.crepes = crepes;
        this.tablettes = tablettes;
        this.mousse = mousse;
        this.gateaux = gateaux;
        this.cremes_glacees = cremes_glacees;
    }

    public boolean isBonbons() {
        return bonbons;
    }

    public boolean isCrepes() {
        return crepes;
    }

    public boolean isTablettes() {
        return tablettes;
    }

    public boolean isMousse() {
        return mousse;
    }

    public boolean isGateaux() {
        return gateaux;
    }

    public boolean isCremes_glacees() {
        return cremes_glacees;
    }

    public void setBonbons(boolean bonbons) {
        this.bonbons = bonbons;
    }

    public void setCrepes(boolean crepes) {
        this.crepes = crepes;
    }

    public void setTablettes(boolean tablettes) {
        this.tablettes = tablettes;
    }

    public void setMousse(boolean mousse) {
        this.mousse = mousse;
    }

    public void setGateaux(boolean gateaux) {
        this.gateaux = gateaux;
    }

    public void setCremes_glacees(boolean cremes_glacees) {
        this.cremes_glacees = cremes_glacees;
    }
}
