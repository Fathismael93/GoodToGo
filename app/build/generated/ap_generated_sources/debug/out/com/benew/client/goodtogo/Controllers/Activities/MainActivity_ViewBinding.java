// Generated code from Butter Knife. Do not modify!
package com.benew.client.goodtogo.Controllers.Activities;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.widget.CanaroTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.activity_main_toolbar, "field 'toolbar'", Toolbar.class);
    target.root = Utils.findRequiredViewAsType(source, R.id.activity_main_root, "field 'root'", FrameLayout.class);
    target.contentHamburger = Utils.findRequiredView(source, R.id.activity_main_content_hamburger, "field 'contentHamburger'");
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.activity_main_toolbar_title, "field 'toolbarTitle'", CanaroTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
    target.root = null;
    target.contentHamburger = null;
    target.toolbarTitle = null;
  }
}
