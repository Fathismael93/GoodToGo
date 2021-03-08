package com.benew.client.goodtogo.Controllers.Fragments;

import com.benew.client.goodtogo.Bases.BaseFragment;
import com.benew.client.goodtogo.R;

public class RestoFragment extends BaseFragment {


    public RestoFragment() {}

    public static RestoFragment newInstance() { return new RestoFragment(); }

    @Override
    public int getLayout() { return R.layout.fragment_resto; }

    @Override
    public void configuration() {}
}