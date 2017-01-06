package com.hcid.tmone.tmapp.introduction;

import android.content.DialogInterface;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.hcid.tmone.tmapp.R;
import com.hcid.tmone.tmapp.WelcomeActivity;
import com.hcid.tmone.tmapp.utilities.MemDB;

import java.util.ArrayList;

public class DestinationActivity extends Fragment {

    private ImageView heart[] = new ImageView[3];
    private int heart_flag[] = new int[3];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_destination, container, false);
        setHasOptionsMenu(true);

        MemDB memDB = new MemDB();
        ArrayList<String> attractions = memDB.getAttractions(WelcomeActivity.currentSelectedPlace);
        TextView title1 = (TextView) v.findViewById(R.id.title1);
        TextView title2 = (TextView) v.findViewById(R.id.title2);
        TextView title3 = (TextView) v.findViewById(R.id.title3);

        title1.setText(attractions.get(0));
        title2.setText(attractions.get(1));
        title3.setText(attractions.get(2));
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_destination, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.destination_help) {
            DialogEvent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogEvent() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Help")
                .setMessage("These are scenes found by other travelers here. Post what you've met in your journey. Give it a heart if you like it!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .show();
    }
}
