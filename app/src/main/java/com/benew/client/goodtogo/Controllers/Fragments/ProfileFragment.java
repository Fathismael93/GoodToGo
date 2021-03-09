package com.benew.client.goodtogo.Controllers.Fragments;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import butterknife.BindView;


public class ProfileFragment extends BaseFragment {

    @BindView(R.id.profil_picture_restaurant) ImageView pictureRestaurant;
    @BindView(R.id.name_restaurant) TextView nameResto;
    @BindView(R.id.name_owner) TextView nameOwner;
    @BindView(R.id.number_owner) TextView numberOwner;
    @BindView(R.id.number_restaurant) TextView numberRestaurant;
    @BindView(R.id.secteur_restaurant) TextView secteurResto;
    @BindView(R.id.rue_restaurant) TextView rueResto;
    @BindView(R.id.plat_simple_indication) TextView platSimple;
    @BindView(R.id.menu_indication) TextView menu;
    @BindView(R.id.speciality_indication) TextView speciality;
    @BindView(R.id.assiette_indication) TextView assiettes;
    @BindView(R.id.plat_du_jour_indication) TextView platDuJour;
    @BindView(R.id.boissons_indication) TextView boissons;
    @BindView(R.id.desserts_indication) TextView desserts;
    @BindView(R.id.poulet_indication) TextView poulet;
    @BindView(R.id.viande_indication) TextView viande;
    @BindView(R.id.poisson_indication) TextView poisson;
    @BindView(R.id.oeufs_indication) TextView oeufs;
    @BindView(R.id.fruits_de_mer_indication) TextView fruitsDeMer;
    @BindView(R.id.burger_indication) TextView burger;
    @BindView(R.id.sandwich_indication) TextView sandwich;
    @BindView(R.id.riz_indication) TextView riz;
    @BindView(R.id.spaghetti_indication) TextView spaghetti;
    @BindView(R.id.moukbaza_indication) TextView moukbaza;
    @BindView(R.id.pizza_indication) TextView pizza;
    @BindView(R.id.kebab_indication) TextView kebab;
    @BindView(R.id.tacos_indication) TextView tacos;
    @BindView(R.id.haricot_vert_indication) TextView haricotVert;
    @BindView(R.id.frites_indication) TextView frites;
    @BindView(R.id.potatoes_indication) TextView potatoes;
    @BindView(R.id.crepes_salees_indication) TextView crepesSalees;
    @BindView(R.id.crepes_sucrees_indication) TextView crepesSucrees;
    @BindView(R.id.galettes_indication) TextView galettes;
    @BindView(R.id.salades_indication) TextView salades;
    @BindView(R.id.wrap_indication) TextView wrap;
    @BindView(R.id.eau_indication) TextView eauMinerales;
    @BindView(R.id.alcoolisees_indication) TextView alcoolisees;
    @BindView(R.id.gazeuses_indication) TextView gazeuses;
    @BindView(R.id.soda_indication) TextView soda;
    @BindView(R.id.jus_indication) TextView jus;
    @BindView(R.id.milkshake_indication) TextView milkshake;
    @BindView(R.id.the_indication) TextView the;
    @BindView(R.id.cafe_indication) TextView cafe;
    @BindView(R.id.cappuccino_indication) TextView cappuccino;
    @BindView(R.id.chocolat_chaud_indication) TextView chocolatChaud;
    @BindView(R.id.cremes_glacees_indication) TextView cremesGlacees;
    @BindView(R.id.gateaux_indication) TextView gateaux;
    @BindView(R.id.tablettes_indication) TextView tablettes;
    @BindView(R.id.bonbons_indication) TextView bonbons;
    @BindView(R.id.crepes_indication) TextView crepes;
    @BindView(R.id.mousse_indication) TextView mousse;

    public ProfileFragment() {}

    public static ProfileFragment newInstance() { return new ProfileFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_profile; }

    @Override
    public void configuration() {
        nameResto.setText(Prevalent.currentRestoOnline.getName());
        nameOwner.setText(Prevalent.currentRestoOnline.getName_owner());
        numberOwner.setText(Prevalent.currentRestoOnline.getPhone_owner());
        numberRestaurant.setText(Prevalent.currentRestoOnline.getPhone_restaurant());
        secteurResto.setText(Prevalent.currentRestoOnline.getSecteur());
        rueResto.setText(Prevalent.currentRestoOnline.getRue());

        StorageReference storageReference = FirebaseStorage.getInstance().getReference(Prevalent.currentRestoOnline.getPicture());
        storageReference.getDownloadUrl().addOnCompleteListener(task -> {
            Uri uri = task.getResult();
            Glide.with(getActivity()).load(uri).into(pictureRestaurant);
            pictureRestaurant.setBackground(null);
        });


        platSimple.setText(result(R.string.plat_simple_profil, Prevalent.currentRestoOnlineTypeProducts.isPlat_simple()));
        menu.setText(result(R.string.menu_profil, Prevalent.currentRestoOnlineTypeProducts.isMenu()));
        speciality.setText(result(R.string.speciality_profil, Prevalent.currentRestoOnlineTypeProducts.isSpeciality()));
        assiettes.setText(result(R.string.assiettes_profil, Prevalent.currentRestoOnlineTypeProducts.isAssiette()));
        platDuJour.setText(result(R.string.plat_du_jour_profil, Prevalent.currentRestoOnlineTypeProducts.isPlat_du_jour()));
        boissons.setText(result(R.string.boissons_profil, Prevalent.currentRestoOnlineTypeProducts.isBoisson()));
        desserts.setText(result(R.string.dessert_profil, Prevalent.currentRestoOnlineTypeProducts.isDessert()));
        poulet.setText(result(R.string.poulet_profil, Prevalent.currentRestoOnlineTypeViandes.isPoulet()));
        viande.setText(result(R.string.viande_profil, Prevalent.currentRestoOnlineTypeViandes.isViande()));
        poisson.setText(result(R.string.poisson_profil, Prevalent.currentRestoOnlineTypeViandes.isPoisson()));
        oeufs.setText(result(R.string.oeuf_profil, Prevalent.currentRestoOnlineTypeViandes.isOeufs()));
        fruitsDeMer.setText(result(R.string.fruits_mer_profil, Prevalent.currentRestoOnlineTypeViandes.isFruits_de_mer()));
        burger.setText(result(R.string.burger_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isBurger()));
        sandwich.setText(result(R.string.sandwich_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isSandwich()));
        riz.setText(result(R.string.riz_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isRiz()));
        spaghetti.setText(result(R.string.spaghetti_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isSpaghetti()));
        moukbaza.setText(result(R.string.moukbaza_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isMoukbaza()));
        pizza.setText(result(R.string.pizza_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isPizza()));
        kebab.setText(result(R.string.kebab_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isKebab()));
        tacos.setText(result(R.string.tacos_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isTacos()));
        haricotVert.setText(result(R.string.haricot_vert_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isHaricot_vert()));
        frites.setText(result(R.string.frites_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isFrites()));
        potatoes.setText(result(R.string.potatoes_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isPotatoes()));
        crepesSalees.setText(result(R.string.crepes_salees_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isCrepes_salees()));
        crepesSucrees.setText(result(R.string.crepes_sucrees_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isCrepes_sucrees()));
        galettes.setText(result(R.string.galettes_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isGalettes()));
        salades.setText(result(R.string.salades_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isSalades()));
        wrap.setText(result(R.string.wrap_profil, Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isWrap()));
        eauMinerales.setText(result(R.string.eau_profil, Prevalent.currentRestoOnlineTypeBoissons.isEau()));
        alcoolisees.setText(result(R.string.alcoolisees_profil, Prevalent.currentRestoOnlineTypeBoissons.isBoissons_alcoolisees()));
        gazeuses.setText(result(R.string.gazeuses_profil, Prevalent.currentRestoOnlineTypeBoissons.isBoissons_gazeuses()));
        jus.setText(result(R.string.jus_profil, Prevalent.currentRestoOnlineTypeBoissons.isJus()));
        soda.setText(result(R.string.soda_profil, Prevalent.currentRestoOnlineTypeBoissons.isSoda()));
        milkshake.setText(result(R.string.milkshake_profil, Prevalent.currentRestoOnlineTypeBoissons.isMilkshake()));
        the.setText(result(R.string.the_profil, Prevalent.currentRestoOnlineTypeBoissons.isThe()));
        cafe.setText(result(R.string.cafe_profil, Prevalent.currentRestoOnlineTypeBoissons.isCafe()));
        cappuccino.setText(result(R.string.cappuccino_profil, Prevalent.currentRestoOnlineTypeBoissons.isCappuccino()));
        chocolatChaud.setText(result(R.string.chocolat_chaud_profil, Prevalent.currentRestoOnlineTypeBoissons.isChocolat_chaud()));
        cremesGlacees.setText(result(R.string.cremes_glacees_profil, Prevalent.currentRestoOnlineTypeDesserts.isCremes_glacees()));
        gateaux.setText(result(R.string.gateaux_profil, Prevalent.currentRestoOnlineTypeDesserts.isGateaux()));
        tablettes.setText(result(R.string.tablettes_profil, Prevalent.currentRestoOnlineTypeDesserts.isTablettes()));
        bonbons.setText(result(R.string.bonbons_profil, Prevalent.currentRestoOnlineTypeDesserts.isBonbons()));
        crepes.setText(result(R.string.crepes_profil, Prevalent.currentRestoOnlineTypeDesserts.isCrepes()));
        mousse.setText(result(R.string.mousse_profil, Prevalent.currentRestoOnlineTypeDesserts.isMousse()));
    }

    private String result(int id, boolean isChecked) {
        String ouiNon = (isChecked) ? getResources().getString(R.string.oui) : getResources().getString(R.string.non);
        return getResources().getString(id) + ouiNon;
    }

}