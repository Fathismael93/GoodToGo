package com.benew.client.goodtogo.Modals;

public class TypeViandes {

    private boolean viande, poulet, poisson, oeufs, fruits_de_mer;

    public TypeViandes() {}

    public TypeViandes(boolean viande, boolean poulet, boolean poisson, boolean oeufs, boolean fruits_de_mer) {
        this.viande = viande;
        this.poulet = poulet;
        this.poisson = poisson;
        this.oeufs = oeufs;
        this.fruits_de_mer = fruits_de_mer;
    }

    public boolean isViande() {
        return viande;
    }

    public boolean isPoulet() {
        return poulet;
    }

    public boolean isPoisson() {
        return poisson;
    }

    public boolean isOeufs() {
        return oeufs;
    }

    public boolean isFruits_de_mer() {
        return fruits_de_mer;
    }

    public void setViande(boolean viande) {
        this.viande = viande;
    }

    public void setPoulet(boolean poulet) {
        this.poulet = poulet;
    }

    public void setPoisson(boolean poisson) {
        this.poisson = poisson;
    }

    public void setOeufs(boolean oeufs) {
        this.oeufs = oeufs;
    }

    public void setFruits_de_mer(boolean fruits_de_mer) {
        this.fruits_de_mer = fruits_de_mer;
    }
}
