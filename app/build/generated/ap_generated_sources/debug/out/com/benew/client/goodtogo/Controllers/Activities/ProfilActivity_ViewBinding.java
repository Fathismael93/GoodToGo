// Generated code from Butter Knife. Do not modify!
package com.benew.client.goodtogo.Controllers.Activities;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.widget.CanaroTextView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfilActivity_ViewBinding implements Unbinder {
  private ProfilActivity target;

  private View view7f080057;

  private View view7f0800ee;

  private View view7f08013d;

  @UiThread
  public ProfilActivity_ViewBinding(ProfilActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfilActivity_ViewBinding(final ProfilActivity target, View source) {
    this.target = target;

    View view;
    target.nameOfRestaurant = Utils.findRequiredViewAsType(source, R.id.name_restaurant, "field 'nameOfRestaurant'", CanaroTextView.class);
    target.rueRestaurantInput = Utils.findRequiredViewAsType(source, R.id.text_input_rue_restaurant, "field 'rueRestaurantInput'", TextInputLayout.class);
    target.numberRestaurantInput = Utils.findRequiredViewAsType(source, R.id.text_input_number_restaurant, "field 'numberRestaurantInput'", TextInputLayout.class);
    target.platSimpleCheckBox = Utils.findRequiredViewAsType(source, R.id.plat_simple_case, "field 'platSimpleCheckBox'", CheckBox.class);
    target.menuCheckBox = Utils.findRequiredViewAsType(source, R.id.menu_case, "field 'menuCheckBox'", CheckBox.class);
    target.specialityCheckBox = Utils.findRequiredViewAsType(source, R.id.speciality_case, "field 'specialityCheckBox'", CheckBox.class);
    target.assietteCheckBox = Utils.findRequiredViewAsType(source, R.id.assiette_case, "field 'assietteCheckBox'", CheckBox.class);
    target.platDuJourCheckBox = Utils.findRequiredViewAsType(source, R.id.plat_du_jour_case, "field 'platDuJourCheckBox'", CheckBox.class);
    target.boissonsCheckBox = Utils.findRequiredViewAsType(source, R.id.boissons_case, "field 'boissonsCheckBox'", CheckBox.class);
    target.dessertCheckBox = Utils.findRequiredViewAsType(source, R.id.dessert_case, "field 'dessertCheckBox'", CheckBox.class);
    target.pouletCheckBox = Utils.findRequiredViewAsType(source, R.id.poulet_case, "field 'pouletCheckBox'", CheckBox.class);
    target.viandeCheckBox = Utils.findRequiredViewAsType(source, R.id.viande_case, "field 'viandeCheckBox'", CheckBox.class);
    target.poissonCheckBox = Utils.findRequiredViewAsType(source, R.id.poisson_case, "field 'poissonCheckBox'", CheckBox.class);
    target.oeufsCheckBox = Utils.findRequiredViewAsType(source, R.id.oeufs_case, "field 'oeufsCheckBox'", CheckBox.class);
    target.fruitDeMerCheckBox = Utils.findRequiredViewAsType(source, R.id.fruit_mer_case, "field 'fruitDeMerCheckBox'", CheckBox.class);
    target.burgerCheckBox = Utils.findRequiredViewAsType(source, R.id.burger_case, "field 'burgerCheckBox'", CheckBox.class);
    target.sandwichCheckBox = Utils.findRequiredViewAsType(source, R.id.sandwich_case, "field 'sandwichCheckBox'", CheckBox.class);
    target.rizCheckBox = Utils.findRequiredViewAsType(source, R.id.riz_case, "field 'rizCheckBox'", CheckBox.class);
    target.spaghettiCheckBox = Utils.findRequiredViewAsType(source, R.id.spaghetti_case, "field 'spaghettiCheckBox'", CheckBox.class);
    target.moukbazaCheckBox = Utils.findRequiredViewAsType(source, R.id.moukbaza_case, "field 'moukbazaCheckBox'", CheckBox.class);
    target.pizzaCheckBox = Utils.findRequiredViewAsType(source, R.id.pizza_case, "field 'pizzaCheckBox'", CheckBox.class);
    target.kebabCheckBox = Utils.findRequiredViewAsType(source, R.id.kebab_case, "field 'kebabCheckBox'", CheckBox.class);
    target.tacosCheckBox = Utils.findRequiredViewAsType(source, R.id.tacos_case, "field 'tacosCheckBox'", CheckBox.class);
    target.haricotVertCheckBox = Utils.findRequiredViewAsType(source, R.id.haricot_vert_case, "field 'haricotVertCheckBox'", CheckBox.class);
    target.fritesCheckBox = Utils.findRequiredViewAsType(source, R.id.frites_case, "field 'fritesCheckBox'", CheckBox.class);
    target.potatoesCheckBox = Utils.findRequiredViewAsType(source, R.id.potatoes_case, "field 'potatoesCheckBox'", CheckBox.class);
    target.crepesSaleesCheckBox = Utils.findRequiredViewAsType(source, R.id.crepes_salees_case, "field 'crepesSaleesCheckBox'", CheckBox.class);
    target.crepesSucreesCheckBox = Utils.findRequiredViewAsType(source, R.id.crepes_sucrees_case, "field 'crepesSucreesCheckBox'", CheckBox.class);
    target.galettesCheckBox = Utils.findRequiredViewAsType(source, R.id.galettes_case, "field 'galettesCheckBox'", CheckBox.class);
    target.saladesCheckBox = Utils.findRequiredViewAsType(source, R.id.salades_case, "field 'saladesCheckBox'", CheckBox.class);
    target.wrapCheckBox = Utils.findRequiredViewAsType(source, R.id.wrap_case, "field 'wrapCheckBox'", CheckBox.class);
    target.eauCheckBox = Utils.findRequiredViewAsType(source, R.id.eau_case, "field 'eauCheckBox'", CheckBox.class);
    target.alcooliseesCheckBox = Utils.findRequiredViewAsType(source, R.id.alcoolisees_case, "field 'alcooliseesCheckBox'", CheckBox.class);
    target.gazeusesCheckBox = Utils.findRequiredViewAsType(source, R.id.gazeuses_case, "field 'gazeusesCheckBox'", CheckBox.class);
    target.sodaCheckBox = Utils.findRequiredViewAsType(source, R.id.soda_case, "field 'sodaCheckBox'", CheckBox.class);
    target.jusCheckBox = Utils.findRequiredViewAsType(source, R.id.jus_case, "field 'jusCheckBox'", CheckBox.class);
    target.milkshakeCheckBox = Utils.findRequiredViewAsType(source, R.id.milkshake_case, "field 'milkshakeCheckBox'", CheckBox.class);
    target.theCheckBox = Utils.findRequiredViewAsType(source, R.id.the_case, "field 'theCheckBox'", CheckBox.class);
    target.cafeCheckBox = Utils.findRequiredViewAsType(source, R.id.cafe_case, "field 'cafeCheckBox'", CheckBox.class);
    target.cappuccinoCheckBox = Utils.findRequiredViewAsType(source, R.id.cappuccino_case, "field 'cappuccinoCheckBox'", CheckBox.class);
    target.chocolatChaudCheckBox = Utils.findRequiredViewAsType(source, R.id.chocolat_chaud_case, "field 'chocolatChaudCheckBox'", CheckBox.class);
    target.cremesGlaceesCheckBox = Utils.findRequiredViewAsType(source, R.id.cremes_glacees_case, "field 'cremesGlaceesCheckBox'", CheckBox.class);
    target.gateauxCheckBox = Utils.findRequiredViewAsType(source, R.id.gateaux_case, "field 'gateauxCheckBox'", CheckBox.class);
    target.tablettesCheckBox = Utils.findRequiredViewAsType(source, R.id.tablettes_case, "field 'tablettesCheckBox'", CheckBox.class);
    target.bonbonsCheckBox = Utils.findRequiredViewAsType(source, R.id.bonbons_case, "field 'bonbonsCheckBox'", CheckBox.class);
    target.crepesCheckBox = Utils.findRequiredViewAsType(source, R.id.crepes_case, "field 'crepesCheckBox'", CheckBox.class);
    target.mousseCheckBox = Utils.findRequiredViewAsType(source, R.id.mousse_case, "field 'mousseCheckBox'", CheckBox.class);
    target.imageView = Utils.findRequiredViewAsType(source, R.id.profil_picture_restaurant, "field 'imageView'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.add_picture_restaurant, "method 'onClickGetPicFromGalery'");
    view7f080057 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickGetPicFromGalery();
      }
    });
    view = Utils.findRequiredView(source, R.id.enregistrer_profil_button, "method 'onClickEnregistrerProfilButton'");
    view7f0800ee = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickEnregistrerProfilButton();
      }
    });
    view = Utils.findRequiredView(source, R.id.logout_profil, "method 'onClickLogout'");
    view7f08013d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickLogout();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfilActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.nameOfRestaurant = null;
    target.rueRestaurantInput = null;
    target.numberRestaurantInput = null;
    target.platSimpleCheckBox = null;
    target.menuCheckBox = null;
    target.specialityCheckBox = null;
    target.assietteCheckBox = null;
    target.platDuJourCheckBox = null;
    target.boissonsCheckBox = null;
    target.dessertCheckBox = null;
    target.pouletCheckBox = null;
    target.viandeCheckBox = null;
    target.poissonCheckBox = null;
    target.oeufsCheckBox = null;
    target.fruitDeMerCheckBox = null;
    target.burgerCheckBox = null;
    target.sandwichCheckBox = null;
    target.rizCheckBox = null;
    target.spaghettiCheckBox = null;
    target.moukbazaCheckBox = null;
    target.pizzaCheckBox = null;
    target.kebabCheckBox = null;
    target.tacosCheckBox = null;
    target.haricotVertCheckBox = null;
    target.fritesCheckBox = null;
    target.potatoesCheckBox = null;
    target.crepesSaleesCheckBox = null;
    target.crepesSucreesCheckBox = null;
    target.galettesCheckBox = null;
    target.saladesCheckBox = null;
    target.wrapCheckBox = null;
    target.eauCheckBox = null;
    target.alcooliseesCheckBox = null;
    target.gazeusesCheckBox = null;
    target.sodaCheckBox = null;
    target.jusCheckBox = null;
    target.milkshakeCheckBox = null;
    target.theCheckBox = null;
    target.cafeCheckBox = null;
    target.cappuccinoCheckBox = null;
    target.chocolatChaudCheckBox = null;
    target.cremesGlaceesCheckBox = null;
    target.gateauxCheckBox = null;
    target.tablettesCheckBox = null;
    target.bonbonsCheckBox = null;
    target.crepesCheckBox = null;
    target.mousseCheckBox = null;
    target.imageView = null;

    view7f080057.setOnClickListener(null);
    view7f080057 = null;
    view7f0800ee.setOnClickListener(null);
    view7f0800ee = null;
    view7f08013d.setOnClickListener(null);
    view7f08013d = null;
  }
}
