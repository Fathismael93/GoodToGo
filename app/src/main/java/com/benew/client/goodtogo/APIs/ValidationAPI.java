package com.benew.client.goodtogo.APIs;

import android.content.Context;

import com.google.android.material.textfield.TextInputLayout;

import static com.benew.client.goodtogo.Utils.Constants.FRITES;
import static com.benew.client.goodtogo.Utils.Constants.SAUCES;

public class ValidationAPI {

    public static boolean validateString(Context context, TextInputLayout inputLayout, int id) {
        String name = inputLayout.getEditText().getText().toString().trim();

        if (name.isEmpty()) {
            inputLayout.setError(context.getResources().getString(id));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public static boolean validateNumber(Context context, TextInputLayout inputLayout, int noNumber, int falseNumber) {
        String numberRestaurant = inputLayout.getEditText().getText().toString().trim();

        if (numberRestaurant.isEmpty()) {
            inputLayout.setError(context.getResources().getString(noNumber));
            return false;
        } else if (numberRestaurant.length() != 8) {
            inputLayout.setError(context.getResources().getString(falseNumber));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public static boolean validatePassword(Context context, TextInputLayout inputLayout, int absencePass, int moinsQue5) {
        String password = inputLayout.getEditText().getText().toString().trim();

        if (password.isEmpty()) {
            inputLayout.setError(context.getResources().getString(absencePass));
            return false;
        } else if (password.length() <= 5) {
            inputLayout.setError(context.getResources().getString(moinsQue5));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public static boolean validateCategory(Context context, String category, TextInputLayout inputLayout, int id) {

        if (category == null) {
            inputLayout.setError(context.getResources().getString(id));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }

    public static boolean validatePrix(Context context, String category, TextInputLayout inputLayout, int idPrix, int idFrites) {
        String price = inputLayout.getEditText().getText().toString().trim();

        if (price.isEmpty() && !category.equals(SAUCES)) {
            inputLayout.setError(context.getResources().getString(idPrix));
            return false;
        } else if (price.isEmpty() && category != null && category.equals(FRITES)) {
            inputLayout.setError(context.getResources().getString(idFrites));
            return false;
        } else {
            inputLayout.setError(null);
            return true;
        }
    }
}
