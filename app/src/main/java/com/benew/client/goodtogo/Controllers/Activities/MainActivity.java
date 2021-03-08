package com.benew.client.goodtogo.Controllers.Activities;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.benew.client.goodtogo.Bases.BaseActivity;
import com.benew.client.goodtogo.Controllers.Fragments.EnregistrementFragment;
import com.benew.client.goodtogo.Controllers.Fragments.EspaceRFragment;
import com.benew.client.goodtogo.Controllers.Fragments.RestoFragment;
import com.benew.client.goodtogo.Controllers.Fragments.SearchPlatFragment;
import com.benew.client.goodtogo.R;
import com.benew.client.goodtogo.widget.CanaroTextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import net.steamcrafted.loadtoast.LoadToast;

import butterknife.BindView;

import static com.benew.client.goodtogo.Utils.Constants.FRAGMENT_ENREGISTREMENT;
import static com.benew.client.goodtogo.Utils.Constants.FRAGMENT_ESPACE_RESTO;
import static com.benew.client.goodtogo.Utils.Constants.FRAGMENT_PLAT;
import static com.benew.client.goodtogo.Utils.Constants.FRAGMENT_RESTO;
import static com.benew.client.goodtogo.Utils.Constants.RIPPLE_DURATION;

public class MainActivity extends BaseActivity {

    private Fragment fragmentResto;
    private Fragment fragmentPlat;
    private Fragment fragmentEnregistrement;
    private Fragment fragmentEspaceResto;

    GuillotineAnimation animation;
    View guillotineMenu;

    @BindView(R.id.activity_main_toolbar) Toolbar toolbar;
    @BindView(R.id.activity_main_root) FrameLayout root;
    @BindView(R.id.activity_main_content_hamburger) View contentHamburger;
    @BindView(R.id.activity_main_toolbar_title) CanaroTextView toolbarTitle;

    CanaroTextView resto, plat, enregistrement, espaceResto, guillotineToolbarTitle;

    LoadToast toast;

    @Override
    protected int getLayout() { return R.layout.activity_main; }

    @Override
    protected void configuration() {
        toast = new LoadToast(this);
        toast.setBackgroundColor(getResources().getColor(R.color.black));

        configureToolbar();

        guillotineMenu = inflateGuillotineMenu();
        animation = configureGuillotine();

        resto = guillotineMenu.findViewById(R.id.resto);
        plat = guillotineMenu.findViewById(R.id.plat);
        enregistrement = guillotineMenu.findViewById(R.id.enregistrement);
        espaceResto = guillotineMenu.findViewById(R.id.espace_resto);
        guillotineToolbarTitle = guillotineMenu.findViewById(R.id.activity_main_guillotine_toolbar_title);
        guillotineToolbarTitle.setText(R.string.app_name);

        configureOnClicks();
    }

    private void configureToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }
    }

    private View inflateGuillotineMenu() {
        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.activity_main_guillotine, null);
        root.addView(guillotineMenu);

        return guillotineMenu;
    }

    private GuillotineAnimation configureGuillotine() {
        animation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.activity_main_guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(false).build();

        showFirstFragment();

        return animation;
    }

    private void configureOnClicks() {

        resto.setOnClickListener(v -> {
            toast.show();
            toolbarTitle.setText(R.string.restaurant);
            showFragment(FRAGMENT_RESTO);
        });

        plat.setOnClickListener(v -> {
            toast.show();
            toolbarTitle.setText(R.string.plat);
            showFragment(FRAGMENT_PLAT);
        });

        enregistrement.setOnClickListener(v -> {
            toast.show();
            toolbarTitle.setText(R.string.enregistrement);
            showFragment(FRAGMENT_ENREGISTREMENT);
        });

        espaceResto.setOnClickListener(v -> {
            toast.show();
            toolbarTitle.setText(R.string.espace_resto);
            showFragment(FRAGMENT_ESPACE_RESTO);
        });
    }

    private void showFragment(int fragmentIdentifier){
        switch (fragmentIdentifier){
            case FRAGMENT_RESTO :
                this.showRestoFragment();
                break;
            case FRAGMENT_PLAT:
                this.showPlatFragment();
                break;
            case FRAGMENT_ENREGISTREMENT:
                this.showEnregistrementFragment();
                break;
            case FRAGMENT_ESPACE_RESTO:
                this.showEspaceRestoFragment();
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
            toolbarTitle.setText(R.string.plat);
            this.showFragment(FRAGMENT_PLAT);
        }
    }


    private void showRestoFragment(){
        if (this.fragmentResto == null) this.fragmentResto = RestoFragment.newInstance();
        this.startTransactionFragment(this.fragmentResto);
    }

    private void showPlatFragment(){
        if (this.fragmentPlat == null) this.fragmentPlat = SearchPlatFragment.newInstance();
        this.startTransactionFragment(this.fragmentPlat);
    }

    private void showEnregistrementFragment(){
        if (this.fragmentEnregistrement == null) this.fragmentEnregistrement = EnregistrementFragment.newInstance();
        this.startTransactionFragment(this.fragmentEnregistrement);
    }

    private void showEspaceRestoFragment(){
        if (this.fragmentEspaceResto == null) this.fragmentEspaceResto = EspaceRFragment.newInstance();
        this.startTransactionFragment(this.fragmentEspaceResto);
    }

    private void startTransactionFragment(Fragment fragment){
        if (!fragment.isVisible()){

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_frame_layout, fragment).commit();

            new Handler(Looper.getMainLooper()).postDelayed(() -> animation.close(), 25);
        } else animation.close();

        toast.hide();
    }
}