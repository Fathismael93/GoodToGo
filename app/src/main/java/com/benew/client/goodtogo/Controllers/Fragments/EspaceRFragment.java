package com.benew.client.goodtogo.Controllers.Fragments;

import android.content.Intent;

import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.Controllers.Activities.RestaurantActivity;
import com.benew.client.goodtogo.FirebaseUsage.FirestoreUsage;
import com.benew.client.goodtogo.Modals.Restaurant;
import com.benew.client.goodtogo.Modals.TypeAccompagnementSousForme;
import com.benew.client.goodtogo.Modals.TypeBoissons;
import com.benew.client.goodtogo.Modals.TypeDesserts;
import com.benew.client.goodtogo.Modals.TypeProducts;
import com.benew.client.goodtogo.Modals.TypeViandes;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.firestore.DocumentSnapshot;

import net.steamcrafted.loadtoast.LoadToast;

import at.favre.lib.crypto.bcrypt.BCrypt;
import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

import static com.benew.client.goodtogo.APIs.ValidationAPI.validatePassword;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateString;
import static com.benew.client.goodtogo.Utils.Constants.BOISSONS_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.DESSERT_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.PLAT_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.PRODUCTS_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.SELLINGS_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.VIANDES_COLLECTION;


public class EspaceRFragment extends BaseFragment {

    @BindView(R.id.text_input_name_restaurant) TextInputLayout nameRestaurantInput;
    @BindView(R.id.text_input_password_account) TextInputLayout passwordInput;

    LoadToast toast;

    private String nameRestaurant, password;
    int pseudoResto, absencePass, moinsQue5;

    public EspaceRFragment() {}

    public static EspaceRFragment newInstance() { return new EspaceRFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_espace_r; }

    @Override
    public void configuration() {
        pseudoResto = R.string.absence_pseudo_text_input_layout;
        absencePass = R.string.absence_mot_de_passe_connexion_text_input_layout;
        moinsQue5 = R.string.mot_de_passe_connexion_inferieur_a_5_text_input_layout;
    }

    @OnClick(R.id.connexion_button)
    void onClickEnregistrementButton() {
        toast = new LoadToast(getContext());
        toast.setBackgroundColor(getResources().getColor(R.color.black));
        toast.setTranslationY(450);

        if (!validateString(getContext(), nameRestaurantInput, pseudoResto) |
                !validatePassword(getContext(), passwordInput, absencePass, moinsQue5))
            return;

        toast.show();

        nameRestaurant = nameRestaurantInput.getEditText().getText().toString().trim();
        password = passwordInput.getEditText().getText().toString().trim();

        connectToRestaurantAccount();
    }

    private void connectToRestaurantAccount() {
        FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).get().addOnCompleteListener(task -> {
            DocumentSnapshot documentSnapshot = task.getResult();

            assert documentSnapshot != null;
            if (!documentSnapshot.exists()) {
                Toasty.info(getContext(), getResources().getString(R.string.toasty_info_existe_pas)).show();
                toast.hide();
            } else {
                Restaurant resto = documentSnapshot.toObject(Restaurant.class);

                assert resto != null;
                BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), resto.getPassword());

                if (result.verified) {
                    FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).collection(SELLINGS_COLLECTION).document(PRODUCTS_COLLECTION).get()
                            .addOnCompleteListener(task1 -> Prevalent.currentRestoOnlineTypeProducts = task1.getResult().toObject(TypeProducts.class));

                    FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).collection(SELLINGS_COLLECTION).document(VIANDES_COLLECTION).get()
                            .addOnCompleteListener(task2 -> Prevalent.currentRestoOnlineTypeViandes = task2.getResult().toObject(TypeViandes.class));

                    FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).collection(SELLINGS_COLLECTION).document(DESSERT_COLLECTION).get()
                            .addOnCompleteListener(task21 -> Prevalent.currentRestoOnlineTypeDesserts = task21.getResult().toObject(TypeDesserts.class));

                    FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).collection(SELLINGS_COLLECTION).document(BOISSONS_COLLECTION).get()
                            .addOnCompleteListener(task3 -> Prevalent.currentRestoOnlineTypeBoissons = task3.getResult().toObject(TypeBoissons.class));

                    FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).collection(SELLINGS_COLLECTION).document(PLAT_COLLECTION).get()
                            .addOnCompleteListener(task4 -> Prevalent.currentRestoOnlineTypeAccompagnementSousForme = task4.getResult().toObject(TypeAccompagnementSousForme.class));

                    Toasty.success(getContext(), getResources().getString(R.string.toasty_success_connexion)).show();
                    Prevalent.currentRestoOnline = resto;

                    startActivity(new Intent(getContext(), RestaurantActivity.class));
                    toast.hide();
                }
            }
        });
    }
}