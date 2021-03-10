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

  private View view7f0800ed;

  @UiThread
  public PlatFragment_ViewBinding(final PlatFragment target, View source) {
    this.target = target;

    View view;
    target.namePlatInput = Utils.findRequiredViewAsType(source, R.id.nom_plat, "field 'namePlatInput'", TextInputLayout.class);
    target.imageViewPlat = Utils.findRequiredViewAsType(source, R.id.plat_picture, "field 'imageViewPlat'", ImageView.class);
    target.categoryPlatInput = Utils.findRequiredViewAsType(source, R.id.category_plat, "field 'categoryPlatInput'", TextInputLayout.class);
    target.categoryAccompagnementInput = Utils.findRequiredViewAsType(source, R.id.category_accompagnement, "field 'categoryAccompagnementInput'", TextInputLayout.class);
    target.categoryViandeInput = Utils.findRequiredViewAsType(source, R.id.category_viande, "field 'categoryViandeInput'", TextInputLayout.class);
    target.dropdownTypePlat = Utils.findRequiredViewAsType(source, R.id.dropdown_category_plat, "field 'dropdownTypePlat'", AutoCompleteTextView.class);
    target.dropdownTypeAccompagnement = Utils.findRequiredViewAsType(source, R.id.dropdown_accompagnement, "field 'dropdownTypeAccompagnement'", AutoCompleteTextView.class);
    target.dropdownTypeViande = Utils.findRequiredViewAsType(source, R.id.dropdown_viande, "field 'dropdownTypeViande'", AutoCompleteTextView.class);
    target.drinkingChoices = Utils.findRequiredViewAsType(source, R.id.drinking_choices, "field 'drinkingChoices'", LinearLayout.class);
    target.ifMenu = Utils.findRequiredViewAsType(source, R.id.if_menu, "field 'ifMenu'", TextView.class);
    target.nameExtraInput = Utils.findRequiredViewAsType(source, R.id.nature_extra, "field 'nameExtraInput'", TextInputLayout.class);
    target.nameExtraTwoInput = Utils.findRequiredViewAsType(source, R.id.nature_extra_2, "field 'nameExtraTwoInput'", TextInputLayout.class);
    target.priceExtraInput = Utils.findRequiredViewAsType(source, R.id.prix_extra, "field 'priceExtraInput'", TextInputLayout.class);
    target.priceExtraTwoInput = Utils.findRequiredViewAsType(source, R.id.prix_extra_2, "field 'priceExtraTwoInput'", TextInputLayout.class);
    target.pricePlatInput = Utils.findRequiredViewAsType(source, R.id.prix_plat, "field 'pricePlatInput'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.add_picture_plat, "method 'onClickGetPicFromGalery'");
    view7f080056 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickGetPicFromGalery();
      }
    });
    view = Utils.findRequiredView(source, R.id.enregistrer_plat_button, "method 'onClickEnregistrerPlat'");
    view7f0800ed = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickEnregistrerPlat();
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
    target.categoryPlatInput = null;
    target.categoryAccompagnementInput = null;
    target.categoryViandeInput = null;
    target.dropdownTypePlat = null;
    target.dropdownTypeAccompagnement = null;
    target.dropdownTypeViande = null;
    target.drinkingChoices = null;
    target.ifMenu = null;
    target.nameExtraInput = null;
    target.nameExtraTwoInput = null;
    target.priceExtraInput = null;
    target.priceExtraTwoInput = null;
    target.pricePlatInput = null;

    view7f080056.setOnClickListener(null);
    view7f080056 = null;
    view7f0800ed.setOnClickListener(null);
    view7f0800ed = null;
  }
}
