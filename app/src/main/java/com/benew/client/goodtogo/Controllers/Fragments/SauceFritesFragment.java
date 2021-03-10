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
import com.benew.client.goodtogo.Utils.Prevalent;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

import static com.benew.client.goodtogo.APIs.ValidationAPI.validateCategory;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateString;
import static com.benew.client.goodtogo.Utils.Constants.FRITES;
import static com.benew.client.goodtogo.Utils.Constants.SAUCES;

public class SauceFritesFragment extends BaseFragment {

    @BindView(R.id.nom_sauces_frites) TextInputLayout nameSaucesFritesInput;
    @BindView(R.id.prix_sauces_frites) TextInputLayout prixSaucesFritesInput;
    @BindView(R.id.category_sauces_frites) TextInputLayout sauceFritesCategoryInput;
    @BindView(R.id.dropdown_category) AutoCompleteTextView dropdownCategory;
    @BindView(R.id.new_category) LinearLayout newCategory;

    LoadToast toast;

    private String category;
    String[] categories;
    Map categoriesSelectedMap;
    ArrayAdapter<String> adapter;

    int nbreVuesCrees = 0;
    int idNom, idCategorie, idFrites;

    public SauceFritesFragment() {}

    public static SauceFritesFragment newInstance() { return new SauceFritesFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_sauce_frites; }

    @Override
    public void configuration() {
        categories = new String[] {SAUCES, FRITES};
        categoriesSelectedMap = new HashMap();

        adapter = new ArrayAdapter<>(getContext(), R.layout.dropdown_category, categories);
        dropdownCategory.setAdapter(adapter);
        dropdownCategory.setOnItemClickListener((parent, view, position, id) -> {
            Object item = parent.getItemAtPosition(position);
            category = item.toString();
        });

        idNom = R.string.absence_nom_produit_text_input_layout;
        idCategorie = R.string.absence_choix_categorie_text_input_layout;
        idFrites = R.string.absence_prix_frites_text_input_layout;
    }

    @OnClick(R.id.ajouter_button)
    void onClickCategoryChoosing() {
        toast = new LoadToast(getContext());
        toast.setBackgroundColor(getResources().getColor(R.color.black));
        toast.setTranslationY(450);

        if (!validateString(getContext(), nameSaucesFritesInput, idNom) |
                !validateCategory(getContext(), category, sauceFritesCategoryInput, idCategorie) |
                !validatePrix(getContext(), category, prixSaucesFritesInput, idFrites))
            return;

        String nom = nameSaucesFritesInput.getEditText().getText().toString().trim();
        String prix = prixSaucesFritesInput.getEditText().getText().toString().trim();

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
                    !validatePrix(getContext(), categorie, priceSaucesFritesInput, idFrites))
                return;

            String name = nameSaucesFritesInput.getEditText().getText().toString().trim();
            String price = priceSaucesFritesInput.getEditText().getText().toString().trim();

            saveProducts(getContext(), toast, name, categorie, price);
        }
    }

    private boolean validatePrix(Context context, String category, TextInputLayout inputLayout, int idFrites) {
        String price = inputLayout.getEditText().getText().toString().trim();

        if (price.isEmpty() && category != null && category.equals(FRITES)) {
            inputLayout.setError(context.getResources().getString(idFrites));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    private void saveProducts(Context context, LoadToast toast, String nom, String category, String prix) {
        Map productMap = new HashMap();
        productMap.put("name", nom);
        productMap.put("category", category);
        productMap.put("price", prix);

        FirestoreUsage.getRestaurantDocumentReference(Prevalent.currentRestoOnline.getName()).collection(category).document(nom)
                .get().addOnCompleteListener(task -> {

            DocumentSnapshot documentSnapshot = task.getResult();

            if (documentSnapshot.exists()) {
                Toasty.info(context, context.getResources().getString(R.string.toasty_produit_existe_deja)).show();
                toast.hide();
            } else {
                String documentName = nom + "-" + category;

                FirestoreUsage.getRestaurantDocumentReference(Prevalent.currentRestoOnline.getName()).collection(category).document(documentName)
                        .set(productMap).addOnSuccessListener(aVoid -> {
                    Toasty.success(context, context.getResources().getString(R.string.toasty_produit_success_enregistrer)).show();
                    toast.hide();
                });
            }
        });
    }
}