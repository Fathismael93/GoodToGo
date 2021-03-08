package com.benew.client.goodtogo.Modals;

public class TypeBoissons {

    private boolean the, soda, milkshake, jus, eau, chocolat_chaud, cappuccino, cafe, boissons_gazeuses, boissons_alcoolisees;

    public TypeBoissons() {}

    public TypeBoissons(boolean the, boolean soda, boolean milkshake, boolean jus, boolean eau, boolean chocolat_chaud, boolean cappuccino, boolean cafe, boolean boissons_gazeuses, boolean boissons_alcoolisees) {
        this.the = the;
        this.soda = soda;
        this.milkshake = milkshake;
        this.jus = jus;
        this.eau = eau;
        this.chocolat_chaud = chocolat_chaud;
        this.cappuccino = cappuccino;
        this.cafe = cafe;
        this.boissons_gazeuses = boissons_gazeuses;
        this.boissons_alcoolisees = boissons_alcoolisees;
    }

    public boolean isThe() {
        return the;
    }

    public boolean isSoda() {
        return soda;
    }

    public boolean isMilkshake() {
        return milkshake;
    }

    public boolean isJus() {
        return jus;
    }

    public boolean isEau() {
        return eau;
    }

    public boolean isChocolat_chaud() {
        return chocolat_chaud;
    }

    public boolean isCappuccino() {
        return cappuccino;
    }

    public boolean isCafe() {
        return cafe;
    }

    public boolean isBoissons_gazeuses() {
        return boissons_gazeuses;
    }

    public boolean isBoissons_alcoolisees() {
        return boissons_alcoolisees;
    }

    public void setThe(boolean the) {
        this.the = the;
    }

    public void setSoda(boolean soda) {
        this.soda = soda;
    }

    public void setMilkshake(boolean milkshake) {
        this.milkshake = milkshake;
    }

    public void setJus(boolean jus) {
        this.jus = jus;
    }

    public void setEau(boolean eau) {
        this.eau = eau;
    }

    public void setChocolat_chaud(boolean chocolat_chaud) {
        this.chocolat_chaud = chocolat_chaud;
    }

    public void setCappuccino(boolean cappuccino) {
        this.cappuccino = cappuccino;
    }

    public void setCafe(boolean cafe) {
        this.cafe = cafe;
    }

    public void setBoissons_gazeuses(boolean boissons_gazeuses) {
        this.boissons_gazeuses = boissons_gazeuses;
    }

    public void setBoissons_alcoolisees(boolean boissons_alcoolisees) {
        this.boissons_alcoolisees = boissons_alcoolisees;
    }
}
