package com.benew.client.goodtogo.APIs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.benew.client.goodtogo.Controllers.Activities.RestaurantActivity;
import com.benew.client.goodtogo.FirebaseUsage.FirestoreUsage;
import com.benew.client.goodtogo.Modals.Restaurant;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Constants;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.storage.StorageReference;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.HashMap;
import java.util.Map;

import at.favre.lib.crypto.bcrypt.BCrypt;
import es.dmoral.toasty.Toasty;

import static com.benew.client.goodtogo.Utils.Constants.BOISSONS_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.DESSERT_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.PLAT_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.PRODUCTS_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.VIANDES_COLLECTION;

public class DatabaseAPI {

    public static void saveRestaurantForValidation(Context context, Activity activity, String nameRestaurant, String password, String numberOwner, String nameOwner, String secteurRestaurant, LoadToast toast) {
        FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).get().addOnCompleteListener(task -> {
            DocumentSnapshot documentSnapshot = task.getResult();

            assert documentSnapshot != null;
            if (documentSnapshot.exists()) {
                Toasty.info(context, context.getResources().getString(R.string.toasty_info_existe_deja)).show();
                toast.hide();
            } else {
                String passwordHashed = BCrypt.withDefaults().hashToString(12, password.toCharArray());

                Map<String, Object> restaurantMap = new HashMap<>();
                restaurantMap.put("name", nameRestaurant);
                restaurantMap.put("phone_owner", numberOwner);
                restaurantMap.put("name_owner", nameOwner);
                restaurantMap.put("secteur", secteurRestaurant);
                restaurantMap.put("password", passwordHashed);
                restaurantMap.put("profile_done", false);

                FirestoreUsage.getRestaurantDocumentReference(nameRestaurant).set(restaurantMap)
                        .addOnSuccessListener(aVoid -> {

                            Prevalent.currentRestoOnline = new Restaurant();
                            Prevalent.currentRestoOnline.setName(nameRestaurant);
                            Prevalent.currentRestoOnline.setName_owner(nameOwner);
                            Prevalent.currentRestoOnline.setPhone_owner(numberOwner);
                            Prevalent.currentRestoOnline.setSecteur(secteurRestaurant);
                            Prevalent.currentRestoOnline.setPassword(passwordHashed);
                            Prevalent.currentRestoOnline.setProfile_done(false);

                            activity.startActivity(new Intent(context, RestaurantActivity.class));
                            Toasty.success(context, context.getResources().getString(R.string.toasty_success_enregistrer)).show();
                            toast.hide();

                        }).addOnFailureListener(e -> {
                    toast.hide();
                    Toasty.error(context, context.getResources().getString(R.string.toasty_error_erreur_enregistrement) + e.getMessage()).show();
                });
            }
        });
    }

    public static void saveDataRestaurantOnDatabase(Context context, Activity activity, String numberRestaurant, String rueRestaurant, Uri uriImageSelected, Object o, Object o1, Object o2, Object o3, Object o4, LoadToast toast) {
        StorageReference restaurantPicture = FirestoreUsage.getRestaurantPictureReference(Prevalent.currentRestoOnline.getName()).child("picture_restaurant.jpg");
        restaurantPicture.putFile(uriImageSelected)
                .addOnSuccessListener(activity, taskSnapshot -> {
                    String pathImageSavedInFirebase = taskSnapshot.getMetadata().getPath();

                    HashMap<String, Object> coordonneesMap = new HashMap();
                    coordonneesMap.put("rue", rueRestaurant);
                    coordonneesMap.put("phone_restaurant", numberRestaurant);
                    coordonneesMap.put("picture", pathImageSavedInFirebase);
                    coordonneesMap.put("profile_done", true);

                    FirestoreUsage.getRestaurantDocumentReference(Prevalent.currentRestoOnline.getName()).update(coordonneesMap).addOnSuccessListener(o5 -> {

                        FirestoreUsage.getCategoryOfSellingDocumentRef(Prevalent.currentRestoOnline.getName(), PRODUCTS_COLLECTION).set(o);
                        FirestoreUsage.getCategoryOfSellingDocumentRef(Prevalent.currentRestoOnline.getName(), VIANDES_COLLECTION).set(o1);
                        FirestoreUsage.getCategoryOfSellingDocumentRef(Prevalent.currentRestoOnline.getName(), PLAT_COLLECTION).set(o2);
                        FirestoreUsage.getCategoryOfSellingDocumentRef(Prevalent.currentRestoOnline.getName(), BOISSONS_COLLECTION).set(o3);
                        FirestoreUsage.getCategoryOfSellingDocumentRef(Prevalent.currentRestoOnline.getName(), DESSERT_COLLECTION).set(o4);

                        Prevalent.currentRestoOnline.setProfile_done(true);
                        Toasty.success(context, context.getResources().getString(R.string.toast_enregistrement_sellings)).show();
                        activity.startActivity(new Intent(context, RestaurantActivity.class));
                        toast.hide();

                    }).addOnFailureListener(e -> {
                        Toasty.info(context, context.getResources().getString(R.string.toast_erreur_enregistrement_sellings)).show();
                        toast.hide();
                    });
                }).addOnFailureListener(e -> {
            Toasty.info(context, context.getResources().getString(R.string.toast_erreur_enregistrement_photo)).show();
            toast.hide();
        });
    }
}
