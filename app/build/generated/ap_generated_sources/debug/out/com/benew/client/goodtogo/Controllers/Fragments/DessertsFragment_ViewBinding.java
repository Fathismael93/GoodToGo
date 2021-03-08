// Generated code from Butter Knife. Do not modify!
package com.benew.client.goodtogo.Controllers.Fragments;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.benew.client.goodtogo.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DessertsFragment_ViewBinding implements Unbinder {
  private DessertsFragment target;

  private View view7f08005d;

  private View view7f08005e;

  @UiThread
  public DessertsFragment_ViewBinding(final DessertsFragment target, View source) {
    this.target = target;

    View view;
    target.nameDessertsInput = Utils.findRequiredViewAsType(source, R.id.nom_desserts, "field 'nameDessertsInput'", TextInputLayout.class);
    target.prixDessertsInput = Utils.findRequiredViewAsType(source, R.id.prix_desserts, "field 'prixDessertsInput'", TextInputLayout.class);
    target.dessertsCategoryInput = Utils.findRequiredViewAsType(source, R.id.category_desserts, "field 'dessertsCategoryInput'", TextInputLayout.class);
    target.dropdownCategory = Utils.findRequiredViewAsType(source, R.id.dropdown_category, "field 'dropdownCategory'", AutoCompleteTextView.class);
    target.newCategory = Utils.findRequiredViewAsType(source, R.id.new_category, "field 'newCategory'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.ajouter_button, "method 'onClickCategoryChoosing'");
    view7f08005d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickCategoryChoosing();
      }
    });
    view = Utils.findRequiredView(source, R.id.ajouter_new_category, "method 'onClickAjouterNouvelleCategorie'");
    view7f08005e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickAjouterNouvelleCategorie();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DessertsFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameDessertsInput = null;
    target.prixDessertsInput = null;
    target.dessertsCategoryInput = null;
    target.dropdownCategory = null;
    target.newCategory = null;

    view7f08005d.setOnClickListener(null);
    view7f08005d = null;
    view7f08005e.setOnClickListener(null);
    view7f08005e = null;
  }
}
