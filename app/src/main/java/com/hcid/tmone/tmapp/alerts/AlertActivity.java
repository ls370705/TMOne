package com.hcid.tmone.tmapp.alerts;

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
import android.widget.TextView;

import com.hcid.tmone.tmapp.R;
import com.hcid.tmone.tmapp.utilities.MemDB;

public class AlertActivity extends Fragment {

    MemDB memDB = new MemDB();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_alert, container, false);
        setHasOptionsMenu(true);

        TextView title = (TextView) v.findViewById(R.id.incident_title);
        TextView severity = (TextView) v.findViewById(R.id.incident_severity);
        TextView date = (TextView) v.findViewById(R.id.incident_date);
        TextView description = (TextView) v.findViewById(R.id.incident_description);

        title.setText(AlertListActivity.currentIncident);
        severity.setText(memDB.getIncidentSeverity(AlertListActivity.currentIncident));
        date.setText(memDB.getIncidentDate(AlertListActivity.currentIncident));
        description.setText(memDB.getIncidentDescription(AlertListActivity.currentIncident));

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_check_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.check_help) {
            DialogEvent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogEvent() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Help")
                .setMessage("Click the create button to comment.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .show();
    }

}
