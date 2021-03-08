package com.benew.client.goodtogo.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.benew.client.goodtogo.Controllers.Fragments.BoissonsFragment;
import com.benew.client.goodtogo.Controllers.Fragments.DessertsFragment;
import com.benew.client.goodtogo.Controllers.Fragments.PlatFragment;
import com.benew.client.goodtogo.Controllers.Fragments.SauceFritesFragment;

public class AddProductPager extends FragmentPagerAdapter {


    public AddProductPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Plat";
            case 1:
                return "Boissons";
            case 2:
                return "Desserts";
            case 3:
                return "Sauces/frites";
            default:
                return null;
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PlatFragment.newInstance();
            case 1:
                return BoissonsFragment.newInstance();
            case 2:
                return DessertsFragment.newInstance();
            case 3:
                return SauceFritesFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() { return 4; }
}
