// Generated code from Butter Knife. Do not modify!
package com.benew.client.goodtogo.Controllers.Fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.benew.client.goodtogo.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EspaceRFragment_ViewBinding implements Unbinder {
  private EspaceRFragment target;

  private View view7f0800a7;

  @UiThread
  public EspaceRFragment_ViewBinding(final EspaceRFragment target, View source) {
    this.target = target;

    View view;
    target.nameRestaurantInput = Utils.findRequiredViewAsType(source, R.id.text_input_name_restaurant, "field 'nameRestaurantInput'", TextInputLayout.class);
    target.passwordInput = Utils.findRequiredViewAsType(source, R.id.text_input_password_account, "field 'passwordInput'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.connexion_button, "method 'onClickEnregistrementButton'");
    view7f0800a7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickEnregistrementButton();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    EspaceRFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameRestaurantInput = null;
    target.passwordInput = null;

    view7f0800a7.setOnClickListener(null);
    view7f0800a7 = null;
  }
}
