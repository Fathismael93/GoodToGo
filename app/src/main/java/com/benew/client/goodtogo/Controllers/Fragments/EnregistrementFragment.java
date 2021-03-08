package com.benew.client.goodtogo.Controllers.Fragments;

import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.R;
import com.google.android.material.textfield.TextInputLayout;

import net.steamcrafted.loadtoast.LoadToast;

import butterknife.BindView;
import butterknife.OnClick;

import static com.benew.client.goodtogo.APIs.DatabaseAPI.saveRestaurantForValidation;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateNumber;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validatePassword;
import static com.benew.client.goodtogo.APIs.ValidationAPI.validateString;

public class EnregistrementFragment extends BaseFragment {

    @BindView(R.id.text_input_name_restaurant) TextInputLayout nameRestaurantInput;
    @BindView(R.id.text_input_name_owner) TextInputLayout nameOwnerInput;
    @BindView(R.id.text_input_number_owner) TextInputLayout numberOwnerInput;
    @BindView(R.id.text_input_secteur_restaurant) TextInputLayout secteurRestaurantInput;
    @BindView(R.id.text_input_password_account) TextInputLayout passwordInput;

    LoadToast toast;

    private String nameRestaurant, nameOwner, numberOwner, secteurRestaurant, password;
    int nomResto, nomOwner, secteurResto, absenceNumero, numeroIncorrecte, absencePass, moinsQue5;

    public EnregistrementFragment() {}

    public static EnregistrementFragment newInstance() { return new EnregistrementFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_enregistrement; }

    @Override
    public void configuration() {
        nomResto = R.string.absence_nom_restaurant_text_input_layout;
        nomOwner = R.string.absence_nom_proprietaire_text_input_layout;
        secteurResto = R.string.absence_secteur_restaurant_text_input_layout;
        absenceNumero = R.string.absence_numero_proprietaire_text_input_layout;
        numeroIncorrecte = R.string.incorrecte_numero_proprietaire_text_input_layout;
        absencePass = R.string.absence_mot_de_passe_text_input_layout;
        moinsQue5 = R.string.mot_de_passe_inferieur_a_5_text_input_layout;
    }

    @OnClick(R.id.enregistrement_button)
    void onClickEnregistrementButton() {
        toast = new LoadToast(getContext());
        toast.setBackgroundColor(getResources().getColor(R.color.black));
        toast.setTranslationY(450);

        if (!validateString(getContext(), nameRestaurantInput, nomResto) | !validateString(getContext(), nameOwnerInput, nomOwner) |
                !validateNumber(getContext(), numberOwnerInput, absenceNumero, numeroIncorrecte) | !validateString(getContext(), secteurRestaurantInput, secteurResto) |
                !validatePassword(getContext(), passwordInput, absencePass, moinsQue5))
            return;

        toast.show();

        nameRestaurant = nameRestaurantInput.getEditText().getText().toString().trim();
        nameOwner = nameOwnerInput.getEditText().getText().toString().trim();
        numberOwner = numberOwnerInput.getEditText().getText().toString().trim();
        secteurRestaurant = secteurRestaurantInput.getEditText().getText().toString().trim();
        password = passwordInput.getEditText().getText().toString().trim();

        saveRestaurantForValidation(getContext(), getActivity(), nameRestaurant, password, numberOwner, nameOwner, secteurRestaurant, toast);
    }
}