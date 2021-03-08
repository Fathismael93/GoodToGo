package com.benew.client.goodtogo.Utils;

public class Constants {

    // for Guillotine Animation
    public static final long RIPPLE_DURATION = 250;

    // MAIN ACTIVITY Fragment Identifier (for showing Fragments)
    public final static int FRAGMENT_RESTO = 1;
    public final static int FRAGMENT_PLAT = 2;
    public final static int FRAGMENT_ENREGISTREMENT = 3;
    public final static int FRAGMENT_ESPACE_RESTO = 4;

    // RESTAURANT ACTIVITY Fragment Identifier (for showing Fragments)
    public final static int FRAGMENT_PRODUCTS = 1;
    public final static int FRAGMENT_ADD_PRODUCTS = 2;
    public final static int FRAGMENT_PROFILE = 3;

    // Retaurants collection for firestore
    public static final String RESTAURANTS_COLLECTION = "RESTAURANTS";
    //Sellings of a restaurant collection for firestore
    public static final String SELLINGS_COLLECTION = "SELLINGS";
    //Type of Sellings of a restaurant document for firestore
    public static final String PRODUCTS_COLLECTION = "Products";
    public static final String VIANDES_COLLECTION = "Meat";
    public static final String PLAT_COLLECTION = "Accompagnement Sous-forme";
    public static final String BOISSONS_COLLECTION = "Boissons";
    public static final String DESSERT_COLLECTION = "Desserts";

    //SAUCES AND FRITES COLLECTIONS OF A RESTAURANT
    public static final String SAUCES = "SAUCES";
    public static final String FRITES = "FRITES";

    //BOISSONS COLLECTION OF A RESTAURANT
    public static final String BOISSONS = "BOISSONS";

    //CATEGORIE BOISSON
    public static final String THE = "Thé";
    public static final String SODA = "Soda";
    public static final String MILKSHAKE = "Milkshake";
    public static final String JUS = "Jus";
    public static final String EAU = "Eau";
    public static final String CHOCOLAT_CHAUD = "Chocolat chaud";
    public static final String CAPPUCCINO = "Cappuccino";
    public static final String CAFE = "Cafe";
    public static final String ALCOOLISEES = "Alcoolisees";
    public static final String GAZEUSES = "Gazeuses";

    //DESSERTS COLLECTION OF A RESTAURANT
    public static final String DESSERTS = "DESSERTS";

    //CATEGORIE BOISSON
    public static final String BONBONS = "Bonbons";
    public static final String CREPES = "Crêpes";
    public static final String TABLETTES = "Tablettes";
    public static final String MOUSSE = "de la Mousse";
    public static final String GATEAUX = "Gateaux";
    public static final String CREMES_GLACEES = "Crêmes glacées";

    //CATEGORIE PRODUCTS
    public static final String ASSIETTE = "Assiette";
    public static final String MENU = "Menu";
    public static final String PLAT_DU_JOUR = "Plat du jour";
    public static final String PLAT_SIMPLE = "Plat Simple";
    public static final String SPECIALITY = "Spécialité";

    //CATEGORIE ACCOMPAGNEMENT
    public static final String BURGER = "Burger";
    public static final String FRITE = "Frites";
    public static final String GALETTES = "Galettes";
    public static final String KEBAB = "Kebab";
    public static final String MOUKBAZA = "Moukbaza";
    public static final String PIZZA = "Pizza";
    public static final String POTATOES = "Potatoes";
    public static final String RIZ = "Riz";
    public static final String SALADES = "Salades";
    public static final String SANDWICH = "Sandwich";
    public static final String SPAGHETTI = "Spaghetti";
    public static final String TACOS = "Tacos";
    public static final String HARICOT_VERT = "Haricot vert";
    public static final String CREPES_SALEES = "Crepes salees";
    public static final String CREPES_SUCREES = "Crepes sucrees";

    //CATEGORIE VIANDE
    public static final String VIANDE = "Viande";
    public static final String POULET = "Poulet";
    public static final String POISSON = "Poisson";
    public static final String OEUFS = "Oeufs";
    public static final String FRUITS_DE_MER = "Fruits de mer";
}
