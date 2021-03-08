package com.benew.client.goodtogo.FirebaseUsage;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.benew.client.goodtogo.Utils.Constants.RESTAURANTS_COLLECTION;
import static com.benew.client.goodtogo.Utils.Constants.SELLINGS_COLLECTION;

public class FirestoreUsage {

    // ALL RESTAURANTS COLLECTION REFERENCE
    public static CollectionReference getRestaurantsCollectionReference() {
        return FirebaseFirestore.getInstance().collection(RESTAURANTS_COLLECTION);
    }

    // ONE RESTAURANT DOCUMENT REFERENCE
    public static DocumentReference getRestaurantDocumentReference(String restaurantName) {
        return getRestaurantsCollectionReference().document(restaurantName);
    }

    // SELLINGS OF A RESTAURANT COLLECTION REFERENCE
    public static CollectionReference getSellingsCollectionReference(String restaurantName) {
        return getRestaurantDocumentReference(restaurantName).collection(SELLINGS_COLLECTION);
    }

    // CATEGORY OF SELLING DOCUMENT REFERENCE
    public static DocumentReference getCategoryOfSellingDocumentRef(String restaurantName, String category) {
        return getSellingsCollectionReference(restaurantName).document(category);
    }

    // ALL RESTAURANTS STORAGE REFERENCE
    public static StorageReference getAllRestaurantsStorageRef() {
        return FirebaseStorage.getInstance().getReference().child(RESTAURANTS_COLLECTION);
    }

    // ONE RESTAURANT STORAGE REFERENCE
    public static StorageReference getRestaurantPictureReference(String restaurantName) {
        return getAllRestaurantsStorageRef().child(restaurantName).child("IMAGES");
    }

    public static StorageReference getCategoryOfProductStorageRef(String restaurantName) {
        return getRestaurantPictureReference(restaurantName).child(SELLINGS_COLLECTION);
    }
}
