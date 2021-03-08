package com.benew.client.goodtogo.Controllers.Activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.benew.client.goodtogo.Bases.BaseActivity;
import com.benew.client.goodtogo.Controllers.Fragments.AddProductFragment;
import com.benew.client.goodtogo.Controllers.Fragments.ProductsFragment;
import com.benew.client.goodtogo.Controllers.Fragments.ProfileFragment;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.Utils.Prevalent;
import com.benew.client.goodtogo.widget.CanaroTextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import net.steamcrafted.loadtoast.LoadToast;

import butterknife.BindView;

import static com.benew.client.goodtogo.Utils.Constants.FRAGMENT_ADD_PRODUCTS;
import static com.benew.client.goodtogo.Utils.Constants.FRAGMENT_PRODUCTS;
import static com.benew.client.goodtogo.Utils.Constants.FRAGMENT_PROFILE;
import static com.benew.client.goodtogo.Utils.Constants.RIPPLE_DURATION;

public class RestaurantActivity extends BaseActivity {

    private Fragment fragmentProducts;
    private Fragment fragmentAddProducts;
    private Fragment fragmentProfil;

    GuillotineAnimation animation;
    View guillotineMenu;

    @BindView(R.id.activity_restaurant_toolbar) Toolbar toolbar;
    @BindView(R.id.activity_restaurant_root) FrameLayout root;
    @BindView(R.id.activity_restaurant_content_hamburger) View contentHamburger;
    @BindView(R.id.activity_restaurant_toolbar_title) CanaroTextView toolbarTitle;

    CanaroTextView guillotineToolbarTitle, products, addProducts, profil, logout;

    LoadToast toast;

    @Override
    protected int getLayout() { return R.layout.activity_restaurant; }

    @Override
    protected void configuration() {
        if (!Prevalent.currentRestoOnline.isProfile_done()) {
            startActivity(new Intent(this, ProfilActivity.class));
        }

        toast = new LoadToast(this);
        toast.setBackgroundColor(getResources().getColor(R.color.black));

        configureToolbar();

        guillotineMenu = inflateGuillotineMenu();
        animation = configureGuillotine();

        guillotineToolbarTitle = guillotineMenu.findViewById(R.id.activity_restaurant_guillotine_toolbar_title);
        guillotineToolbarTitle.setText(Prevalent.currentRestoOnline.getName());
        products = guillotineMenu.findViewById(R.id.show_products);
        addProducts = guillotineMenu.findViewById(R.id.add_products);
        profil = guillotineMenu.findViewById(R.id.profile);
        logout = guillotineMenu.findViewById(R.id.logout);

        configureOnClicks();
    }

    private void configureToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
            toolbarTitle.setText(Prevalent.currentRestoOnline.getName());
        }
    }

    private View inflateGuillotineMenu() {
        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.activity_restaurant_guillotine, null);
        root.addView(guillotineMenu);

        return guillotineMenu;
    }

    private GuillotineAnimation configureGuillotine() {
        animation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.activity_restaurant_guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(false).build();

        showFirstFragment();

        return animation;
    }

    private void configureOnClicks() {

        products.setOnClickListener(v -> {
            toast.show();
            toolbarTitle.setText(R.string.produits);
            showFragment(FRAGMENT_PRODUCTS);
        });

        addProducts.setOnClickListener(v -> {
            toast.show();
            toolbarTitle.setText(R.string.ajouter_produits);
            showFragment(FRAGMENT_ADD_PRODUCTS);
        });

        profil.setOnClickListener(v -> {
            toast.show();
            toolbarTitle.setText(R.string.profil);
            showFragment(FRAGMENT_PROFILE);
        });

        logout.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            Prevalent.currentRestoOnline = null;
            finish();
        });
    }

    private void showFragment(int fragmentIdentifier){
        switch (fragmentIdentifier){
            case FRAGMENT_PRODUCTS :
                this.showProductsFragment();
                break;
            case FRAGMENT_ADD_PRODUCTS:
                this.showAddProductFragment();
                break;
            case FRAGMENT_PROFILE:
                this.showProfileFragment();
                break;
            default:
                break;
        }
    }

    // 1 - Show first fragment when activity is created
    private void showFirstFragment(){
        Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);
        if (visibleFragment == null){
            // 1.1 - Show News Fragment
            toolbarTitle.setText(R.string.produits);
            this.showFragment(FRAGMENT_PRODUCTS);
        }
    }

    private void showProductsFragment() {
        if (this.fragmentProducts == null) this.fragmentProducts = ProductsFragment.newInstance();
        this.startTransactionFragment(this.fragmentProducts);
    }

    private void showAddProductFragment() {
        if (this.fragmentAddProducts == null) this.fragmentAddProducts = AddProductFragment.newInstance();
        this.startTransactionFragment(this.fragmentAddProducts);
    }

    private void showProfileFragment() {
        if (this.fragmentProfil == null) this.fragmentProfil = ProfileFragment.newInstance();
        this.startTransactionFragment(this.fragmentProfil);
    }

    private void startTransactionFragment(Fragment fragment){
        if (!fragment.isVisible()){

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_restaurant_frame_layout, fragment).commit();

            new Handler(Looper.getMainLooper()).postDelayed(() -> animation.close(), 25);
        } else animation.close();

        toast.hide();
    }
}