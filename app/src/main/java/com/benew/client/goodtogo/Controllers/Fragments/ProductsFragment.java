package com.benew.client.goodtogo.Controllers.Fragments;

import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.R;


public class ProductsFragment extends BaseFragment {


    public ProductsFragment() {}

    public static ProductsFragment newInstance() { return new ProductsFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_products; }

    @Override
    public void configuration() {

    }
}