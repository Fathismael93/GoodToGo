package com.benew.client.goodtogo.APIs;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.benew.client.goodtogo.R;
import com.bumptech.glide.Glide;

import es.dmoral.toasty.Toasty;
import pub.devrel.easypermissions.EasyPermissions;

import static android.app.Activity.RESULT_OK;

public class GettingPictureAPI {

    // 1 - STATIC DATA FOR PICTURE
    public static final String PERMS = Manifest.permission.READ_EXTERNAL_STORAGE;

    public static void chooseImageFromPhone(Context context, Activity activity, int perms, int choosePhoto){
        if (!EasyPermissions.hasPermissions(context, PERMS)) {
            EasyPermissions.requestPermissions(activity, context.getResources().getString(R.string.easy_permission_dialog), perms, PERMS);
            return;
        }

        // 3 - Launch an "Selection Image" Activity
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(i, choosePhoto);
    }

    // 4 - Handle activity response (after user has chosen or not a picture)
    public static Uri handleResponse(Context context, Activity activity, ImageView imageViewPlat, int choosePhoto, int requestCode, int resultCode, Intent data){
        Uri uriImageSelected = null;

        if (requestCode == choosePhoto) {
            if (resultCode == RESULT_OK) { //SUCCESS
                uriImageSelected = data.getData();
                Glide.with(activity) //SHOWING PREVIEW OF IMAGE
                        .load(uriImageSelected)
                        .into(imageViewPlat);
                imageViewPlat.setBackground(null);
            } else {
                Toasty.info(context, context.getResources().getString(R.string.toast_pas_photo)).show();
            }
        }

        return uriImageSelected;
    }
}
