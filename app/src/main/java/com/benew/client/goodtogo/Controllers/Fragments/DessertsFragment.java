package com.benew.client.goodtogo.Controllers.Fragments;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.FirebaseUsage.FirestoreUsage;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Constants;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

import static com.benew.client.goodtogo.APIs.ValidationAPI.validateCategory;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validatePrix;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateString;

public class DessertsFragment extends BaseFragment {

    @BindView(R.id.nom_desserts) TextInputLayout nameDessertsInput;
    @BindView(R.id.prix_desserts) TextInputLayout prixDessertsInput;
    @BindView(R.id.category_desserts) TextInputLayout dessertsCategoryInput;
    @BindView(R.id.dropdown_category) AutoCompleteTextView dropdownCategory;
    @BindView(R.id.new_category) LinearLayout newCategory;

    LoadToast toast;

    private String category;
    List categories;
    Map categoriesSelectedMap;
    ArrayAdapter<String> adapter;

    int nbreVuesCrees = 0;
    int idNom, idCategorie, idPrix, idFrites;

    public DessertsFragment() {}

    public static DessertsFragment newInstance() { return new DessertsFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_desserts; }

    @Override
    public void configuration() {
        categories = new ArrayList<>();

        if (Prevalent.currentRestoOnlineTypeDesserts.isBonbons()) categories.add(Constants.BONBONS);
        if (Prevalent.currentRestoOnlineTypeDesserts.isCremes_glacees()) categories.add(Constants.CREMES_GLACEES);
        if (Prevalent.currentRestoOnlineTypeDesserts.isCrepes()) categories.add(Constants.CREPES);
        if (Prevalent.currentRestoOnlineTypeDesserts.isGateaux()) categories.add(Constants.GATEAUX);
        if (Prevalent.currentRestoOnlineTypeDesserts.isMousse()) categories.add(Constants.MOUSSE);
        if (Prevalent.currentRestoOnlineTypeDesserts.isTablettes()) categories.add(Constants.TABLETTES);

        categoriesSelectedMap = new HashMap();

        adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_category, categories);
        dropdownCategory.setAdapter(adapter);
        dropdownCategory.setOnItemClickListener((parent, view, position, id) -> {
            Object item = parent.getItemAtPosition(position);
            category = item.toString();
        });

        idNom = R.string.absence_nom_produit_text_input_layout;
        idCategorie = R.string.absence_choix_categorie_text_input_layout;
        idPrix = R.string.absence_prix_text_input_layout;
        idFrites = R.string.absence_prix_frites_text_input_layout;
    }

    @OnClick(R.id.ajouter_button)
    void onClickCategoryChoosing() {
        toast = new LoadToast(getContext());
        toast.setBackgroundColor(getResources().getColor(R.color.black));
        toast.setTranslationY(450);

        if (!validateString(getContext(), nameDessertsInput, idNom) |
                !validateCategory(getContext(), category, dessertsCategoryInput, idCategorie) |
                !validatePrix(getContext(), category, prixDessertsInput, idPrix, idFrites))
            return;

        String nom = nameDessertsInput.getEditText().getText().toString().trim();
        String prix = prixDessertsInput.getEditText().getText().toString().trim();

        toast.show();
        saveProducts(getContext(), toast, nom, category, prix);
        checkIfValidAndSave();
    }

    @OnClick(R.id.ajouter_new_category)
    void onClickAjouterNouvelleCategorie() {
        addView();
    }

    private void addView() {
        View newCategoryView = getLayoutInflater().inflate(R.layout.ajouter_autre_produit, null, false);

        ImageView deleteView = newCategoryView.findViewById(R.id.delete_autre_imageview);
        AutoCompleteTextView dropdownCategorie = newCategoryView.findViewById(R.id.dropdown_categorie);
        dropdownCategorie.setAdapter(adapter);

        nbreVuesCrees++;
        newCategoryView.setTag(nbreVuesCrees);
        int viewTag = (int) newCategoryView.getTag();
        categoriesSelectedMap.put(viewTag, "");
        newCategory.addView(newCategoryView);

        dropdownCategorie.setOnItemClickListener((parent, view, position, id) -> {
            Object item = parent.getItemAtPosition(position);
            String categorie = item.toString();
            categoriesSelectedMap.put(viewTag, categorie);
        });

        deleteView.setOnClickListener(v -> {
            removeView(newCategoryView);
            categoriesSelectedMap.remove(viewTag);
            nbreVuesCrees--;
        });
    }

    private void removeView(View view){
        newCategory.removeView(view);
    }

    private void checkIfValidAndSave() {

        for(int i=0; i < newCategory.getChildCount(); i++) {

            View newCategoryView = newCategory.getChildAt(i);
            int viewTag = (int) newCategoryView.getTag();

            TextInputLayout nameSaucesFritesInput = newCategoryView.findViewById(R.id.name_autres);
            TextInputLayout priceSaucesFritesInput = newCategoryView.findViewById(R.id.price_autres);
            TextInputLayout categorieSaucesFritesInput = newCategoryView.findViewById(R.id.categorie_autres);

            String categorie = (String) categoriesSelectedMap.get(viewTag);

            if (!validateString(getContext(), nameSaucesFritesInput, idNom) |
                    !validateCategory(getContext(), categorie, categorieSaucesFritesInput, idCategorie) |
                    !validatePrix(getContext(), categorie, priceSaucesFritesInput, idPrix, idFrites))
                return;

            String name = nameSaucesFritesInput.getEditText().getText().toString().trim();
            String price = priceSaucesFritesInput.getEditText().getText().toString().trim();

            saveProducts(getContext(), toast, name, categorie, price);
        }
    }

    private void saveProducts(Context context, LoadToast toast, String nom, String category, String prix) {
        Map productMap = new HashMap();
        productMap.put("name", nom);
        productMap.put("category", category);
        productMap.put("price", prix);

        FirestoreUsage.getRestaurantDocumentReference(Prevalent.currentRestoOnline.getName()).collection(Constants.DESSERTS).document(nom).get().addOnCompleteListener(task -> {
            DocumentSnapshot documentSnapshot = task.getResult();

            if (documentSnapshot.exists()) {
                Toasty.info(context, context.getResources().getString(R.string.toasty_produit_existe_deja)).show();
                toast.hide();
            } else {
                FirestoreUsage.getRestaurantDocumentReference(Prevalent.currentRestoOnline.getName()).collection(Constants.DESSERTS).document(nom)
                        .set(productMap).addOnSuccessListener(aVoid -> {
                    Toasty.success(context, context.getResources().getString(R.string.toasty_produit_success_enregistrer)).show();
                    toast.hide();
                });
            }
        });
    }
}