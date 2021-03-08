package com.benew.client.goodtogo.Controllers.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Constants;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.benew.client.goodtogo.APIs.GettingPictureAPI.RC_IMAGE_PERMS;
import static com.benew.client.goodtogo.APIs.GettingPictureAPI.chooseImageFromPhone;
import static com.benew.client.goodtogo.APIs.GettingPictureAPI.handleResponse;

public class PlatFragment extends BaseFragment {

    @BindView(R.id.nom_plat) TextInputLayout namePlatInput;
    @BindView(R.id.plat_picture) ImageView imageViewPlat;
    @BindView(R.id.dropdown_category_plat) AutoCompleteTextView dropdownTypePlat;
    @BindView(R.id.dropdown_accompagnement) AutoCompleteTextView dropdownTypeAccompagnement;
    @BindView(R.id.dropdown_viande) AutoCompleteTextView dropdownTypeViande;
    @BindView(R.id.drinking_choices) LinearLayout drinkingChoices;
    @BindView(R.id.if_menu) TextView ifMenu;

    // 1 - Uri of image selected by user
    private Uri uriImageSelected;

    List categoriesProducts, categoriesAccompagnement, categoriesViande, categoriesBoissons;

    public PlatFragment() {}

    public static PlatFragment newInstance() { return new PlatFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_plat; }

    @Override
    public void configuration() {
        categoriesProducts = new ArrayList<>();
        categoriesAccompagnement = new ArrayList<>();
        categoriesViande = new ArrayList<>();
        categoriesBoissons = new ArrayList<>();

        if (Prevalent.currentRestoOnlineTypeBoissons.isBoissons_alcoolisees()) categoriesBoissons.add(Constants.ALCOOLISEES);
        if (Prevalent.currentRestoOnlineTypeBoissons.isBoissons_gazeuses()) categoriesBoissons.add(Constants.GAZEUSES);
        if (Prevalent.currentRestoOnlineTypeBoissons.isCafe()) categoriesBoissons.add(Constants.CAFE);
        if (Prevalent.currentRestoOnlineTypeBoissons.isCappuccino()) categoriesBoissons.add(Constants.CAPPUCCINO);
        if (Prevalent.currentRestoOnlineTypeBoissons.isChocolat_chaud()) categoriesBoissons.add(Constants.CHOCOLAT_CHAUD);
        if (Prevalent.currentRestoOnlineTypeBoissons.isEau()) categoriesBoissons.add(Constants.EAU);
        if (Prevalent.currentRestoOnlineTypeBoissons.isJus()) categoriesBoissons.add(Constants.JUS);
        if (Prevalent.currentRestoOnlineTypeBoissons.isMilkshake()) categoriesBoissons.add(Constants.MILKSHAKE);
        if (Prevalent.currentRestoOnlineTypeBoissons.isSoda()) categoriesBoissons.add(Constants.SODA);
        if (Prevalent.currentRestoOnlineTypeBoissons.isThe()) categoriesBoissons.add(Constants.THE);

        if (Prevalent.currentRestoOnlineTypeProducts.isAssiette()) categoriesProducts.add(Constants.ASSIETTE);
        if (Prevalent.currentRestoOnlineTypeProducts.isMenu()) categoriesProducts.add(Constants.MENU);
        if (Prevalent.currentRestoOnlineTypeProducts.isPlat_du_jour()) categoriesProducts.add(Constants.PLAT_DU_JOUR);
        if (Prevalent.currentRestoOnlineTypeProducts.isPlat_simple()) categoriesProducts.add(Constants.PLAT_SIMPLE);
        if (Prevalent.currentRestoOnlineTypeProducts.isSpeciality()) categoriesProducts.add(Constants.SPECIALITY);

        categoriesAccompagnement.add("Rien");
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isBurger()) categoriesAccompagnement.add(Constants.BURGER);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isCrepes_salees()) categoriesAccompagnement.add(Constants.CREPES_SALEES);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isCrepes_sucrees()) categoriesAccompagnement.add(Constants.CREPES_SUCREES);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isFrites()) categoriesAccompagnement.add(Constants.FRITE);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isGalettes()) categoriesAccompagnement.add(Constants.GALETTES);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isHaricot_vert()) categoriesAccompagnement.add(Constants.HARICOT_VERT);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isKebab()) categoriesAccompagnement.add(Constants.KEBAB);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isMoukbaza()) categoriesAccompagnement.add(Constants.MOUKBAZA);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isPizza()) categoriesAccompagnement.add(Constants.PIZZA);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isPotatoes()) categoriesAccompagnement.add(Constants.POTATOES);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isRiz()) categoriesAccompagnement.add(Constants.RIZ);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isSalades()) categoriesAccompagnement.add(Constants.SALADES);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isSandwich()) categoriesAccompagnement.add(Constants.SANDWICH);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isSpaghetti()) categoriesAccompagnement.add(Constants.SPAGHETTI);
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isTacos()) categoriesAccompagnement.add(Constants.TACOS);

        categoriesViande.add("Rien");
        if (Prevalent.currentRestoOnlineTypeViandes.isFruits_de_mer()) categoriesViande.add(Constants.FRUITS_DE_MER);
        if (Prevalent.currentRestoOnlineTypeViandes.isOeufs()) categoriesViande.add(Constants.OEUFS);
        if (Prevalent.currentRestoOnlineTypeViandes.isPoisson()) categoriesViande.add(Constants.POISSON);
        if (Prevalent.currentRestoOnlineTypeViandes.isPoulet()) categoriesViande.add(Constants.POULET);
        if (Prevalent.currentRestoOnlineTypeViandes.isViande()) categoriesViande.add(Constants.VIANDE);

        setAdapter(categoriesProducts, dropdownTypePlat);

        setAdapter(categoriesProducts, dropdownTypePlat);
        setAdapter(categoriesAccompagnement, dropdownTypeAccompagnement);
        setAdapter(categoriesViande, dropdownTypeViande);

    }

    private void setAdapter(List categories, AutoCompleteTextView dropdown) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_category, categories);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemClickListener((parent, view, position, id) -> {
            Object item = parent.getItemAtPosition(position);
            String category = item.toString();

            if (category.equals(Constants.MENU)) {
                for (int i=0; i<categoriesBoissons.size(); i++) {
                    View drinkingChoiceView = getLayoutInflater().inflate(R.layout.checkbox_layout, null, false);
                    CheckBox checkBox = drinkingChoiceView.findViewById(R.id.checkbox);
                    checkBox.setTag(categoriesBoissons.get(i));
                    checkBox.setText((CharSequence) categoriesBoissons.get(i));
                    drinkingChoices.addView(drinkingChoiceView);
                    ifMenu.setVisibility(View.VISIBLE);
                    drinkingChoices.setVisibility(View.VISIBLE);
                }
            } else if (!category.equals(Constants.MENU) && drinkingChoices.getChildCount()>0) {
                ifMenu.setVisibility(View.GONE);
                drinkingChoices.setVisibility(View.GONE);
                drinkingChoices.removeAllViews();
            }
        });
    }

    @OnClick(R.id.add_picture_plat)
    // 5 - Calling the appropriate method
    @AfterPermissionGranted(RC_IMAGE_PERMS)
    public void onClickGetPicFromGalery() { chooseImageFromPhone(getContext(), getActivity()); }

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
        uriImageSelected = handleResponse(getContext(), getActivity(), imageViewPlat,requestCode, resultCode, data);
    }

    private boolean validateName(TextInputLayout inputLayout) {
        String name = inputLayout.getEditText().getText().toString().trim();

        if (name.isEmpty()) {
            inputLayout.setError(getResources().getString(R.string.absence_nom_produit_text_input_layout));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    private boolean validatePrix(TextInputLayout inputLayout) {
        String price = inputLayout.getEditText().getText().toString().trim();

        if (price.isEmpty()) {
            inputLayout.setError(getResources().getString(R.string.absence_prix_text_input_layout));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }
}