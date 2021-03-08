package com.benew.client.goodtogo.Controllers.Activities;

import android.content.Intent;
import android.net.Uri;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.benew.client.goodtogo.Bases.BaseActivity;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.benew.client.goodtogo.widget.CanaroTextView;
import com.google.android.material.textfield.TextInputLayout;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.benew.client.goodtogo.APIs.DatabaseAPI.saveDataRestaurantOnDatabase;
import static com.benew.client.goodtogo.APIs.GettingPictureAPI.RC_IMAGE_PERMS;
import static com.benew.client.goodtogo.APIs.GettingPictureAPI.chooseImageFromPhone;
import static com.benew.client.goodtogo.APIs.GettingPictureAPI.handleResponse;
import static com.benew.client.goodtogo.APIs.OtherFonctionsAPI.searchTrueValueInArray;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateNumber;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateString;

public class ProfilActivity extends BaseActivity {

    @BindView(R.id.name_restaurant) CanaroTextView nameOfRestaurant;
    @BindView(R.id.text_input_rue_restaurant) TextInputLayout rueRestaurantInput;
    @BindView(R.id.text_input_number_restaurant) TextInputLayout numberRestaurantInput;
    @BindView(R.id.plat_simple_case) CheckBox platSimpleCheckBox;
    @BindView(R.id.menu_case) CheckBox menuCheckBox;
    @BindView(R.id.speciality_case) CheckBox specialityCheckBox;
    @BindView(R.id.assiette_case) CheckBox assietteCheckBox;
    @BindView(R.id.plat_du_jour_case) CheckBox platDuJourCheckBox;
    @BindView(R.id.boissons_case) CheckBox boissonsCheckBox;
    @BindView(R.id.dessert_case) CheckBox dessertCheckBox;
    @BindView(R.id.poulet_case) CheckBox pouletCheckBox;
    @BindView(R.id.viande_case) CheckBox viandeCheckBox;
    @BindView(R.id.poisson_case) CheckBox poissonCheckBox;
    @BindView(R.id.oeufs_case) CheckBox oeufsCheckBox;
    @BindView(R.id.fruit_mer_case) CheckBox fruitDeMerCheckBox;
    @BindView(R.id.burger_case) CheckBox burgerCheckBox;
    @BindView(R.id.sandwich_case) CheckBox sandwichCheckBox;
    @BindView(R.id.riz_case) CheckBox rizCheckBox;
    @BindView(R.id.spaghetti_case) CheckBox spaghettiCheckBox;
    @BindView(R.id.moukbaza_case) CheckBox moukbazaCheckBox;
    @BindView(R.id.pizza_case) CheckBox pizzaCheckBox;
    @BindView(R.id.kebab_case) CheckBox kebabCheckBox;
    @BindView(R.id.tacos_case) CheckBox tacosCheckBox;
    @BindView(R.id.haricot_vert_case) CheckBox haricotVertCheckBox;
    @BindView(R.id.frites_case) CheckBox fritesCheckBox;
    @BindView(R.id.potatoes_case) CheckBox potatoesCheckBox;
    @BindView(R.id.crepes_salees_case) CheckBox crepesSaleesCheckBox;
    @BindView(R.id.crepes_sucrees_case) CheckBox crepesSucreesCheckBox;
    @BindView(R.id.galettes_case) CheckBox galettesCheckBox;
    @BindView(R.id.salades_case) CheckBox saladesCheckBox;
    @BindView(R.id.eau_case) CheckBox eauCheckBox;
    @BindView(R.id.alcoolisees_case) CheckBox alcooliseesCheckBox;
    @BindView(R.id.gazeuses_case) CheckBox gazeusesCheckBox;
    @BindView(R.id.soda_case) CheckBox sodaCheckBox;
    @BindView(R.id.jus_case) CheckBox jusCheckBox;
    @BindView(R.id.milkshake_case) CheckBox milkshakeCheckBox;
    @BindView(R.id.the_case) CheckBox theCheckBox;
    @BindView(R.id.cafe_case) CheckBox cafeCheckBox;
    @BindView(R.id.cappuccino_case) CheckBox cappuccinoCheckBox;
    @BindView(R.id.chocolat_chaud_case) CheckBox chocolatChaudCheckBox;
    @BindView(R.id.cremes_glacees_case) CheckBox cremesGlaceesCheckBox;
    @BindView(R.id.gateaux_case) CheckBox gateauxCheckBox;
    @BindView(R.id.tablettes_case) CheckBox tablettesCheckBox;
    @BindView(R.id.bonbons_case) CheckBox bonbonsCheckBox;
    @BindView(R.id.crepes_case) CheckBox crepesCheckBox;
    @BindView(R.id.mousse_case) CheckBox mousseCheckBox;
    @BindView(R.id.profil_picture_restaurant) ImageView imageView;

    LoadToast toast;

    // 1 - Uri of image selected by user
    private Uri uriImageSelected;

    String rueRestaurant, numberRestaurant;
    int rueResto, absenceNumero, numeroIncorrecte;

    @Override
    protected int getLayout() { return R.layout.activity_profil; }

    @Override
    protected void configuration() {
        nameOfRestaurant.setText(Prevalent.currentRestoOnline.getName());

        rueResto = R.string.absence_rue_restaurant_text_input_layout;
        absenceNumero = R.string.absence_numero_restaurant_text_input_layout;
        numeroIncorrecte = R.string.incorrecte_numero_restaurant_text_input_layout;
    }

    @OnClick(R.id.add_picture_restaurant)
    // 5 - Calling the appropriate method
    @AfterPermissionGranted(RC_IMAGE_PERMS)
    public void onClickGetPicFromGalery() { chooseImageFromPhone(this, this); }

    @OnClick(R.id.enregistrer_profil_button)
    void onClickEnregistrerProfilButton() {
        toast = new LoadToast(this);
        toast.setBackgroundColor(getResources().getColor(R.color.black));
        toast.setTranslationY(450);

        if (!validateString(this, rueRestaurantInput, rueResto) |
                !validateNumber(this, numberRestaurantInput, absenceNumero, numeroIncorrecte))
            return;

        if ((Integer) countTypeProductsCheckedBox().get(0) < 3) Toasty.info(this, getResources().getString(R.string.toast_cochez_3_cases_products)).show();
        else if ((Integer) countTypeViandesCheckedBox().get(0) < 2) Toasty.info(this, getResources().getString(R.string.toast_cochez_2_cases_viandes)).show();
        else if ((Integer) countTypePlatCheckedBox().get(0) < 3) Toasty.info(this, getResources().getString(R.string.toast_cochez_3_cases_accompagnement)).show();
        else if ((Integer) countBoissonsCheckedBox().get(0) < 2) Toasty.info(this, getResources().getString(R.string.toast_cochez_2_cases_boissons)).show();
        else if (dessertCheckBox.isChecked() && (Integer) countDessertCheckedBox().get(0) == 0) Toasty.info(this, getResources().getString(R.string.toast_cochez_case_dessert)).show();
        else if (uriImageSelected == null) Toasty.info(this, getResources().getString(R.string.toast_mettre_photo)).show();
        else {
            toast.show();

            rueRestaurant = rueRestaurantInput.getEditText().getText().toString().trim();
            numberRestaurant = numberRestaurantInput.getEditText().getText().toString().trim();

            saveDataRestaurantOnDatabase(this, this, numberRestaurant, rueRestaurant, uriImageSelected, countTypeProductsCheckedBox().get(1),
                    countTypeViandesCheckedBox().get(1), countTypePlatCheckedBox().get(1),
                    countBoissonsCheckedBox().get(1), countDessertCheckedBox().get(1), toast);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 2 - Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 6 - Calling the appropriate method after activity result
        uriImageSelected = handleResponse(this, this, imageView, requestCode, resultCode, data);
    }

    @OnClick(R.id.logout_profil)
    void onClickLogout() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        Prevalent.currentRestoOnline = null;
        finish();
    }

    private List countTypeProductsCheckedBox() {
        List<CheckBox> typeProductsCheckBoxes = new ArrayList<>();
        typeProductsCheckBoxes.add(platSimpleCheckBox);
        typeProductsCheckBoxes.add(menuCheckBox);
        typeProductsCheckBoxes.add(specialityCheckBox);
        typeProductsCheckBoxes.add(assietteCheckBox);
        typeProductsCheckBoxes.add(platDuJourCheckBox);
        typeProductsCheckBoxes.add(boissonsCheckBox);
        typeProductsCheckBoxes.add(dessertCheckBox);

        return searchTrueValueInArray(typeProductsCheckBoxes);
    }

    private List countTypeViandesCheckedBox() {
        List<CheckBox> typeViandesCheckBoxes = new ArrayList<>();
        typeViandesCheckBoxes.add(pouletCheckBox);
        typeViandesCheckBoxes.add(viandeCheckBox);
        typeViandesCheckBoxes.add(poissonCheckBox);
        typeViandesCheckBoxes.add(oeufsCheckBox);
        typeViandesCheckBoxes.add(fruitDeMerCheckBox);

        return searchTrueValueInArray(typeViandesCheckBoxes);
    }

    private List countTypePlatCheckedBox() {
        List<CheckBox> typePlatCheckBoxes = new ArrayList<>();
        typePlatCheckBoxes.add(burgerCheckBox);
        typePlatCheckBoxes.add(sandwichCheckBox);
        typePlatCheckBoxes.add(rizCheckBox);
        typePlatCheckBoxes.add(spaghettiCheckBox);
        typePlatCheckBoxes.add(moukbazaCheckBox);
        typePlatCheckBoxes.add(pizzaCheckBox);
        typePlatCheckBoxes.add(kebabCheckBox);
        typePlatCheckBoxes.add(tacosCheckBox);
        typePlatCheckBoxes.add(haricotVertCheckBox);
        typePlatCheckBoxes.add(fritesCheckBox);
        typePlatCheckBoxes.add(potatoesCheckBox);
        typePlatCheckBoxes.add(crepesSaleesCheckBox);
        typePlatCheckBoxes.add(crepesSucreesCheckBox);
        typePlatCheckBoxes.add(galettesCheckBox);
        typePlatCheckBoxes.add(saladesCheckBox);

        return searchTrueValueInArray(typePlatCheckBoxes);
    }

    private List countBoissonsCheckedBox() {
        List<CheckBox> boissonsCheckBoxes = new ArrayList<>();
        boissonsCheckBoxes.add(eauCheckBox);
        boissonsCheckBoxes.add(alcooliseesCheckBox);
        boissonsCheckBoxes.add(gazeusesCheckBox);
        boissonsCheckBoxes.add(sodaCheckBox);
        boissonsCheckBoxes.add(jusCheckBox);
        boissonsCheckBoxes.add(milkshakeCheckBox);
        boissonsCheckBoxes.add(theCheckBox);
        boissonsCheckBoxes.add(cafeCheckBox);
        boissonsCheckBoxes.add(cappuccinoCheckBox);
        boissonsCheckBoxes.add(chocolatChaudCheckBox);

        return searchTrueValueInArray(boissonsCheckBoxes);
    }

    private List countDessertCheckedBox() {
        List<CheckBox> dessertCheckBoxes = new ArrayList<>();
        dessertCheckBoxes.add(cremesGlaceesCheckBox);
        dessertCheckBoxes.add(gateauxCheckBox);
        dessertCheckBoxes.add(tablettesCheckBox);
        dessertCheckBoxes.add(bonbonsCheckBox);
        dessertCheckBoxes.add(crepesCheckBox);
        dessertCheckBoxes.add(mousseCheckBox);

        return searchTrueValueInArray(dessertCheckBoxes);
    }
}