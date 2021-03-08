// Generated code from Butter Knife. Do not modify!
package com.benew.client.goodtogo.Controllers.Fragments;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.benew.client.goodtogo.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PlatFragment_ViewBinding implements Unbinder {
  private PlatFragment target;

  private View view7f080056;

  @UiThread
  public PlatFragment_ViewBinding(final PlatFragment target, View source) {
    this.target = target;

    View view;
    target.namePlatInput = Utils.findRequiredViewAsType(source, R.id.nom_plat, "field 'namePlatInput'", TextInputLayout.class);
    target.imageViewPlat = Utils.findRequiredViewAsType(source, R.id.plat_picture, "field 'imageViewPlat'", ImageView.class);
    target.dropdownTypePlat = Utils.findRequiredViewAsType(source, R.id.dropdown_category_plat, "field 'dropdownTypePlat'", AutoCompleteTextView.class);
    target.dropdownTypeAccompagnement = Utils.findRequiredViewAsType(source, R.id.dropdown_accompagnement, "field 'dropdownTypeAccompagnement'", AutoCompleteTextView.class);
    target.dropdownTypeViande = Utils.findRequiredViewAsType(source, R.id.dropdown_viande, "field 'dropdownTypeViande'", AutoCompleteTextView.class);
    target.drinkingChoices = Utils.findRequiredViewAsType(source, R.id.drinking_choices, "field 'drinkingChoices'", LinearLayout.class);
    target.ifMenu = Utils.findRequiredViewAsType(source, R.id.if_menu, "field 'ifMenu'", TextView.class);
    view = Utils.findRequiredView(source, R.id.add_picture_plat, "method 'onClickGetPicFromGalery'");
    view7f080056 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickGetPicFromGalery();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    PlatFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.namePlatInput = null;
    target.imageViewPlat = null;
    target.dropdownTypePlat = null;
    target.dropdownTypeAccompagnement = null;
    target.dropdownTypeViande = null;
    target.drinkingChoices = null;
    target.ifMenu = null;

    view7f080056.setOnClickListener(null);
    view7f080056 = null;
  }
}
