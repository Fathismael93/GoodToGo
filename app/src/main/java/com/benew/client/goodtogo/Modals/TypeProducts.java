package com.benew.client.goodtogo.Modals;

public class TypeProducts {

    private boolean assiette, boisson, dessert, menu, plat_du_jour, plat_simple, speciality;

    public TypeProducts() {}

    public TypeProducts(boolean assiette, boolean boisson, boolean dessert, boolean menu, boolean plat_du_jour, boolean plat_simple, boolean speciality) {
        this.assiette = assiette;
        this.boisson = boisson;
        this.dessert = dessert;
        this.menu = menu;
        this.plat_du_jour = plat_du_jour;
        this.plat_simple = plat_simple;
        this.speciality = speciality;
    }

    public boolean isAssiette() {
        return assiette;
    }

    public boolean isBoisson() {
        return boisson;
    }

    public boolean isDessert() {
        return dessert;
    }

    public boolean isMenu() {
        return menu;
    }

    public boolean isPlat_du_jour() {
        return plat_du_jour;
    }

    public boolean isPlat_simple() {
        return plat_simple;
    }

    public boolean isSpeciality() {
        return speciality;
    }

    public void setAssiette(boolean assiette) {
        this.assiette = assiette;
    }

    public void setBoisson(boolean boisson) {
        this.boisson = boisson;
    }

    public void setDessert(boolean dessert) {
        this.dessert = dessert;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public void setPlat_du_jour(boolean plat_du_jour) {
        this.plat_du_jour = plat_du_jour;
    }

    public void setPlat_simple(boolean plat_simple) {
        this.plat_simple = plat_simple;
    }

    public void setSpeciality(boolean speciality) {
        this.speciality = speciality;
    }
}
