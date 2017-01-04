package com.hcid.tmone.tmapp.alerts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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

}
