package com.hcid.tmone.tmapp.alerts;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;

import com.hcid.tmone.tmapp.R;

public class AlertListActivity extends Fragment implements OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_alert_list, container, false);
        setHasOptionsMenu(true);

        Button b1 = (Button) v.findViewById(R.id.button1);
        b1.setOnClickListener(this);

        Button b2 = (Button) v.findViewById(R.id.button2);
        b2.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, new AlertActivity());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_alert_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
