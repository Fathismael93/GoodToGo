// Generated code from Butter Knife. Do not modify!
package com.benew.client.goodtogo.Controllers.Fragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.benew.client.goodtogo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileFragment_ViewBinding implements Unbinder {
  private ProfileFragment target;

  @UiThread
  public ProfileFragment_ViewBinding(ProfileFragment target, View source) {
    this.target = target;

    target.pictureRestaurant = Utils.findRequiredViewAsType(source, R.id.profil_picture_restaurant, "field 'pictureRestaurant'", ImageView.class);
    target.nameResto = Utils.findRequiredViewAsType(source, R.id.name_restaurant, "field 'nameResto'", TextView.class);
    target.nameOwner = Utils.findRequiredViewAsType(source, R.id.name_owner, "field 'nameOwner'", TextView.class);
    target.numberOwner = Utils.findRequiredViewAsType(source, R.id.number_owner, "field 'numberOwner'", TextView.class);
    target.numberRestaurant = Utils.findRequiredViewAsType(source, R.id.number_restaurant, "field 'numberRestaurant'", TextView.class);
    target.secteurResto = Utils.findRequiredViewAsType(source, R.id.secteur_restaurant, "field 'secteurResto'", TextView.class);
    target.rueResto = Utils.findRequiredViewAsType(source, R.id.rue_restaurant, "field 'rueResto'", TextView.class);
    target.platSimple = Utils.findRequiredViewAsType(source, R.id.plat_simple_indication, "field 'platSimple'", TextView.class);
    target.menu = Utils.findRequiredViewAsType(source, R.id.menu_indication, "field 'menu'", TextView.class);
    target.speciality = Utils.findRequiredViewAsType(source, R.id.speciality_indication, "field 'speciality'", TextView.class);
    target.assiettes = Utils.findRequiredViewAsType(source, R.id.assiette_indication, "field 'assiettes'", TextView.class);
    target.platDuJour = Utils.findRequiredViewAsType(source, R.id.plat_du_jour_indication, "field 'platDuJour'", TextView.class);
    target.boissons = Utils.findRequiredViewAsType(source, R.id.boissons_indication, "field 'boissons'", TextView.class);
    target.desserts = Utils.findRequiredViewAsType(source, R.id.desserts_indication, "field 'desserts'", TextView.class);
    target.poulet = Utils.findRequiredViewAsType(source, R.id.poulet_indication, "field 'poulet'", TextView.class);
    target.viande = Utils.findRequiredViewAsType(source, R.id.viande_indication, "field 'viande'", TextView.class);
    target.poisson = Utils.findRequiredViewAsType(source, R.id.poisson_indication, "field 'poisson'", TextView.class);
    target.oeufs = Utils.findRequiredViewAsType(source, R.id.oeufs_indication, "field 'oeufs'", TextView.class);
    target.fruitsDeMer = Utils.findRequiredViewAsType(source, R.id.fruits_de_mer_indication, "field 'fruitsDeMer'", TextView.class);
    target.burger = Utils.findRequiredViewAsType(source, R.id.burger_indication, "field 'burger'", TextView.class);
    target.sandwich = Utils.findRequiredViewAsType(source, R.id.sandwich_indication, "field 'sandwich'", TextView.class);
    target.riz = Utils.findRequiredViewAsType(source, R.id.riz_indication, "field 'riz'", TextView.class);
    target.spaghetti = Utils.findRequiredViewAsType(source, R.id.spaghetti_indication, "field 'spaghetti'", TextView.class);
    target.moukbaza = Utils.findRequiredViewAsType(source, R.id.moukbaza_indication, "field 'moukbaza'", TextView.class);
    target.pizza = Utils.findRequiredViewAsType(source, R.id.pizza_indication, "field 'pizza'", TextView.class);
    target.kebab = Utils.findRequiredViewAsType(source, R.id.kebab_indication, "field 'kebab'", TextView.class);
    target.tacos = Utils.findRequiredViewAsType(source, R.id.tacos_indication, "field 'tacos'", TextView.class);
    target.haricotVert = Utils.findRequiredViewAsType(source, R.id.haricot_vert_indication, "field 'haricotVert'", TextView.class);
    target.frites = Utils.findRequiredViewAsType(source, R.id.frites_indication, "field 'frites'", TextView.class);
    target.potatoes = Utils.findRequiredViewAsType(source, R.id.potatoes_indication, "field 'potatoes'", TextView.class);
    target.crepesSalees = Utils.findRequiredViewAsType(source, R.id.crepes_salees_indication, "field 'crepesSalees'", TextView.class);
    target.crepesSucrees = Utils.findRequiredViewAsType(source, R.id.crepes_sucrees_indication, "field 'crepesSucrees'", TextView.class);
    target.galettes = Utils.findRequiredViewAsType(source, R.id.galettes_indication, "field 'galettes'", TextView.class);
    target.salades = Utils.findRequiredViewAsType(source, R.id.salades_indication, "field 'salades'", TextView.class);
    target.eauMinerales = Utils.findRequiredViewAsType(source, R.id.eau_indication, "field 'eauMinerales'", TextView.class);
    target.alcoolisees = Utils.findRequiredViewAsType(source, R.id.alcoolisees_indication, "field 'alcoolisees'", TextView.class);
    target.gazeuses = Utils.findRequiredViewAsType(source, R.id.gazeuses_indication, "field 'gazeuses'", TextView.class);
    target.soda = Utils.findRequiredViewAsType(source, R.id.soda_indication, "field 'soda'", TextView.class);
    target.jus = Utils.findRequiredViewAsType(source, R.id.jus_indication, "field 'jus'", TextView.class);
    target.milkshake = Utils.findRequiredViewAsType(source, R.id.milkshake_indication, "field 'milkshake'", TextView.class);
    target.the = Utils.findRequiredViewAsType(source, R.id.the_indication, "field 'the'", TextView.class);
    target.cafe = Utils.findRequiredViewAsType(source, R.id.cafe_indication, "field 'cafe'", TextView.class);
    target.cappuccino = Utils.findRequiredViewAsType(source, R.id.cappuccino_indication, "field 'cappuccino'", TextView.class);
    target.chocolatChaud = Utils.findRequiredViewAsType(source, R.id.chocolat_chaud_indication, "field 'chocolatChaud'", TextView.class);
    target.cremesGlacees = Utils.findRequiredViewAsType(source, R.id.cremes_glacees_indication, "field 'cremesGlacees'", TextView.class);
    target.gateaux = Utils.findRequiredViewAsType(source, R.id.gateaux_indication, "field 'gateaux'", TextView.class);
    target.tablettes = Utils.findRequiredViewAsType(source, R.id.tablettes_indication, "field 'tablettes'", TextView.class);
    target.bonbons = Utils.findRequiredViewAsType(source, R.id.bonbons_indication, "field 'bonbons'", TextView.class);
    target.crepes = Utils.findRequiredViewAsType(source, R.id.crepes_indication, "field 'crepes'", TextView.class);
    target.mousse = Utils.findRequiredViewAsType(source, R.id.mousse_indication, "field 'mousse'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ProfileFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pictureRestaurant = null;
    target.nameResto = null;
    target.nameOwner = null;
    target.numberOwner = null;
    target.numberRestaurant = null;
    target.secteurResto = null;
    target.rueResto = null;
    target.platSimple = null;
    target.menu = null;
    target.speciality = null;
    target.assiettes = null;
    target.platDuJour = null;
    target.boissons = null;
    target.desserts = null;
    target.poulet = null;
    target.viande = null;
    target.poisson = null;
    target.oeufs = null;
    target.fruitsDeMer = null;
    target.burger = null;
    target.sandwich = null;
    target.riz = null;
    target.spaghetti = null;
    target.moukbaza = null;
    target.pizza = null;
    target.kebab = null;
    target.tacos = null;
    target.haricotVert = null;
    target.frites = null;
    target.potatoes = null;
    target.crepesSalees = null;
    target.crepesSucrees = null;
    target.galettes = null;
    target.salades = null;
    target.eauMinerales = null;
    target.alcoolisees = null;
    target.gazeuses = null;
    target.soda = null;
    target.jus = null;
    target.milkshake = null;
    target.the = null;
    target.cafe = null;
    target.cappuccino = null;
    target.chocolatChaud = null;
    target.cremesGlacees = null;
    target.gateaux = null;
    target.tablettes = null;
    target.bonbons = null;
    target.crepes = null;
    target.mousse = null;
  }
}
