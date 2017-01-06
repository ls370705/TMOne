package com.hcid.tmone.tmapp.introduction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hcid.tmone.tmapp.R;
import com.hcid.tmone.tmapp.WelcomeActivity;
import com.hcid.tmone.tmapp.utilities.MemDB;

public class HomeActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home, container, false);
        setHasOptionsMenu(true);

        /*MemDB memDB = new MemDB();

        TextView intro_title = (TextView) v.findViewById(R.id.intro_title);
        TextView intro_info = (TextView) v.findViewById(R.id.intro_info);
        TextView intro_description = (TextView) v.findViewById(R.id.intro_description);
        String currentPlace = WelcomeActivity.currentSelectedPlace;

        intro_title.setText(currentPlace);
        intro_info.setText(memDB.getInfo(currentPlace));
        intro_description.setText(memDB.getIntro(currentPlace));


        Button changeCity = (Button) v.findViewById(R.id.change_destination);
        changeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WelcomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                getActivity().finish();
            }
        });*/
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_welcome, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home_help) {
            DialogEvent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogEvent() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Help")
                .setMessage("These are overview information for the country.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .show();
    }
}
