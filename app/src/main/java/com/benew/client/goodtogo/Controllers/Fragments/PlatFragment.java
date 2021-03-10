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
import com.benew.client.goodtogo.FirebaseUsage.FirestoreUsage;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Constants;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.storage.StorageReference;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.benew.client.goodtogo.APIs.GettingPictureAPI.chooseImageFromPhone;
import static com.benew.client.goodtogo.APIs.GettingPictureAPI.handleResponse;
import static com.benew.client.goodtogo.APIs.OtherFonctionsAPI.searchTrueValueInArray;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateCategory;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validatePrix;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateString;

public class PlatFragment extends BaseFragment {

    private static final int RC_IMAGE_PLAT_PERMS = 400;
    private static final int RC_CHOOSE_PHOTO_PLAT = 500;

    @BindView(R.id.nom_plat) TextInputLayout namePlatInput;
    @BindView(R.id.plat_picture) ImageView imageViewPlat;
    @BindView(R.id.category_plat) TextInputLayout categoryPlatInput;
    @BindView(R.id.category_accompagnement) TextInputLayout categoryAccompagnementInput;
    @BindView(R.id.category_viande) TextInputLayout categoryViandeInput;
    @BindView(R.id.dropdown_category_plat) AutoCompleteTextView dropdownTypePlat;
    @BindView(R.id.dropdown_accompagnement) AutoCompleteTextView dropdownTypeAccompagnement;
    @BindView(R.id.dropdown_viande) AutoCompleteTextView dropdownTypeViande;
    @BindView(R.id.drinking_choices) LinearLayout drinkingChoices;
    @BindView(R.id.if_menu) TextView ifMenu;
    @BindView(R.id.nature_extra) TextInputLayout nameExtraInput;
    @BindView(R.id.nature_extra_2) TextInputLayout nameExtraTwoInput;
    @BindView(R.id.prix_extra) TextInputLayout priceExtraInput;
    @BindView(R.id.prix_extra_2) TextInputLayout priceExtraTwoInput;
    @BindView(R.id.prix_plat) TextInputLayout pricePlatInput;

    LoadToast toast;

    // 1 - Uri of image selected by user
    private Uri uriImageSelected;

    List categoriesProducts, categoriesAccompagnement, categoriesViande, categoriesBoissons;

    List selectedCheckboxes;
    List<CheckBox> boissonsCheckBoxes = new ArrayList<>();

    String namePlat, nameExtraOne, nameExtraTwo, pricePlat, priceExtraOne, priceExtraTwo;
    String categoryProduct, categoryAccompagnement, categoryViande;
    int idNom, idCategorie, idPrix;

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
        if (Prevalent.currentRestoOnlineTypeAccompagnementSousForme.isWrap()) categoriesAccompagnement.add(Constants.WRAP);

        categoriesViande.add("Rien");
        if (Prevalent.currentRestoOnlineTypeViandes.isFruits_de_mer()) categoriesViande.add(Constants.FRUITS_DE_MER);
        if (Prevalent.currentRestoOnlineTypeViandes.isOeufs()) categoriesViande.add(Constants.OEUFS);
        if (Prevalent.currentRestoOnlineTypeViandes.isPoisson()) categoriesViande.add(Constants.POISSON);
        if (Prevalent.currentRestoOnlineTypeViandes.isPoulet()) categoriesViande.add(Constants.POULET);
        if (Prevalent.currentRestoOnlineTypeViandes.isViande()) categoriesViande.add(Constants.VIANDE);

        setAdapter(categoriesProducts, dropdownTypePlat);
        setAdapter(categoriesAccompagnement, dropdownTypeAccompagnement);
        setAdapter(categoriesViande, dropdownTypeViande);

        idNom = R.string.absence_nom_produit_text_input_layout;
        idCategorie = R.string.absence_choix_categorie_text_input_layout;
        idPrix = R.string.absence_prix_text_input_layout;

    }

    @OnClick(R.id.add_picture_plat)
    // 5 - Calling the appropriate method
    @AfterPermissionGranted(RC_IMAGE_PLAT_PERMS)
    public void onClickGetPicFromGalery() { chooseImageFromPhone(getContext(), getActivity(), RC_IMAGE_PLAT_PERMS, RC_CHOOSE_PHOTO_PLAT); }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 2 - Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, getContext());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 6 - Calling the appropriate method after activity result
        uriImageSelected = handleResponse(getContext(), getActivity(), imageViewPlat, RC_CHOOSE_PHOTO_PLAT, requestCode, resultCode, data);
    }

    @OnClick(R.id.enregistrer_plat_button)
    void onClickEnregistrerPlat() {
        toast = new LoadToast(getContext());
        toast.setBackgroundColor(getResources().getColor(R.color.black));
        toast.setTranslationY(450);

        if (!validateString(getContext(), namePlatInput, idNom)
                | !validateCategory(getContext(), categoryProduct, categoryPlatInput, idCategorie)
                | !validateCategory(getContext(), categoryAccompagnement, categoryAccompagnementInput, idCategorie)
                | !validateCategory(getContext(), categoryViande, categoryViandeInput, idCategorie)
                | !validatePrix(getContext(), pricePlatInput, idPrix))
            return;

        namePlat = namePlatInput.getEditText().getText().toString().trim();
        pricePlat = pricePlatInput.getEditText().getText().toString().trim();
        nameExtraOne = nameExtraInput.getEditText().getText().toString().trim();
        nameExtraTwo = nameExtraTwoInput.getEditText().getText().toString().trim();
        priceExtraOne = priceExtraInput.getEditText().getText().toString().trim();
        priceExtraTwo = priceExtraTwoInput.getEditText().getText().toString().trim();

        if (uriImageSelected == null) Toasty.info(getContext(), getResources().getString(R.string.toast_mettre_photo_plat)).show();

        selectedCheckboxes = searchTrueValueInArray(boissonsCheckBoxes);

        if (categoryProduct.equals(Constants.MENU) && (int) selectedCheckboxes.get(0) == 0)
            Toasty.info(getContext(), "Votre menu n'a pas une boisson incluse ??").show();

        checkExtra(nameExtraOne, priceExtraOne, nameExtraInput, priceExtraInput);
        checkExtra(nameExtraTwo, priceExtraTwo, nameExtraTwoInput, priceExtraTwoInput);

        toast.show();
        savePlatOnDatabase();
    }

    private void setAdapter(List categories, AutoCompleteTextView dropdown) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_category, categories);
        dropdown.setAdapter(adapter);
        String dropdownTag = (String) dropdown.getTag();

        dropdown.setOnItemClickListener((parent, view, position, id) -> {
            Object item = parent.getItemAtPosition(position);
            String category= item.toString();

            if (dropdownTag.equals("1"))
                categoryProduct = category;
            else if (dropdownTag.equals("2"))
                categoryAccompagnement = category;
            else if (dropdownTag.equals("3"))
                categoryViande = category;

            if (category.equals(Constants.MENU)) {

                ifMenu.setVisibility(View.VISIBLE);

                for (int i=0; i<categoriesBoissons.size(); i++) {

                    View drinkingChoiceView = getLayoutInflater().inflate(R.layout.checkbox_layout, null, false);
                    CheckBox checkBox = drinkingChoiceView.findViewById(R.id.checkbox);

                    checkBox.setTag(categoriesBoissons.get(i));
                    checkBox.setText((CharSequence) categoriesBoissons.get(i));

                    boissonsCheckBoxes.add(checkBox);

                    drinkingChoices.addView(drinkingChoiceView);
                    drinkingChoices.setVisibility(View.VISIBLE);
                }
            } else if (drinkingChoices.getChildCount() > 0) {

                ifMenu.setVisibility(View.GONE);
                drinkingChoices.setVisibility(View.GONE);
                drinkingChoices.removeAllViews();
            }
        });
    }

    private void checkExtra(String nameExtraTwo, String priceExtraTwo, TextInputLayout nameExtraTwoInput, TextInputLayout priceExtraTwoInput) {
        if ((nameExtraTwo.isEmpty() && !priceExtraTwo.isEmpty()) || (!nameExtraTwo.isEmpty() && priceExtraTwo.isEmpty())) {
            nameExtraTwoInput.setError("Renseignez ce champs si l'autre champs n'est pas vide");
            priceExtraTwoInput.setError("Renseignez ce champs si l'autre champs n'est pas vide");
        } else {
            nameExtraTwoInput.setError(null);
            priceExtraTwoInput.setError(null);
        }
    }

    private void savePlatOnDatabase() {
        Map platMap = new HashMap();
        platMap.put("name", namePlat);
        platMap.put("price", pricePlat);
        platMap.put("type", categoryProduct);
        platMap.put("accompagnement", categoryAccompagnement);
        platMap.put("viande", categoryViande);

        if (!nameExtraOne.isEmpty()) {
            platMap.put("extra_one_name", nameExtraOne);
            platMap.put("extra_one_price", priceExtraOne);
        }

        if (!nameExtraTwo.isEmpty()) {
            platMap.put("extra_two_name", nameExtraTwo);
            platMap.put("extra_two_price", priceExtraTwo);
        }

        if (categoryProduct.equals(Constants.MENU)) {
            Map selectedCheckboxesMap = (Map) selectedCheckboxes.get(1);

            for (int j=0; j < selectedCheckboxesMap.size(); j++)
                if ((boolean) selectedCheckboxesMap.get(boissonsCheckBoxes.get(j).getTag()))
                    platMap.put(boissonsCheckBoxes.get(j).getTag(), selectedCheckboxesMap.get(boissonsCheckBoxes.get(j).getTag()));
        }

        StorageReference restaurantPicture = FirestoreUsage.getRestaurantPictureReference(Prevalent.currentRestoOnline.getName())
                .child("PLATS").child(namePlat + ".jpg");

        restaurantPicture.putFile(uriImageSelected).addOnSuccessListener(getActivity(), taskSnapshot -> {

                    String pathImageSavedInFirebase = taskSnapshot.getMetadata().getPath();
                    platMap.put("picture", pathImageSavedInFirebase);

                    String documentName = namePlat + "-" + categoryProduct;

                    FirestoreUsage.getRestaurantDocumentReference(Prevalent.currentRestoOnline.getName()).collection(Constants.PLATS).document(documentName)
                            .get().addOnCompleteListener(task -> {

                        DocumentSnapshot documentSnapshot = task.getResult();

                        if (documentSnapshot.exists()) {
                            Toasty.info(getContext(), getResources().getString(R.string.toasty_produit_existe_deja)).show();
                            toast.hide();
                        } else {
                            FirestoreUsage.getRestaurantDocumentReference(Prevalent.currentRestoOnline.getName()).collection(Constants.DESSERTS).document(namePlat)
                                    .set(platMap).addOnSuccessListener(aVoid -> {
                                Toasty.success(getContext(), getResources().getString(R.string.toasty_produit_success_enregistrer)).show();
                                toast.hide();
                            });
                        }
                    });

                }).addOnFailureListener(e -> {
            Toasty.info(getContext(), getResources().getString(R.string.toast_erreur_enregistrement_photo)).show();
            toast.hide();
        });
    }
}