package com.benew.client.goodtogo.Controllers.Fragments;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.benew.client.goodtogo.Adapters.AddProductPager;
import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.R;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;


public class AddProductFragment extends BaseFragment {

    @BindView(R.id.add_products_tabs) TabLayout tabLayout;
    @BindView(R.id.add_products_viewpager) ViewPager viewPager;

    public AddProductFragment() {}

    public static AddProductFragment newInstance() { return new AddProductFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_add_product; }

    @Override
    public void configuration() {
        configureViewPagerAndTabs();
    }

    private void configureViewPagerAndTabs()
    {
        //Set Adapter PageAdapter and glue it together
        viewPager.setAdapter(new AddProductPager(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
;
        // 2 - Glue TabLayout and ViewPager together
        tabLayout.setupWithViewPager(viewPager);
        // 3 - Design purpose. Tabs have the same width
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}