package com.benew.client.goodtogo.Bases;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.benew.client.goodtogo.Receivers.ConnectivityReceiver;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements ConnectivityReceiver.ConnectivityReceiverListener{

    public abstract int getLayout();
    public abstract void configuration();

    private ConnectivityReceiver connectivityReceiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);

        configuration();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        final IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        connectivityReceiver = new ConnectivityReceiver();
        getContext().registerReceiver(connectivityReceiver,filter);

        ConnectivityReceiver.setConnectivityListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(connectivityReceiver);
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {}
}
