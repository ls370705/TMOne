package com.hcid.tmone.tmapp.alerts;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hcid.tmone.tmapp.R;
import com.hcid.tmone.tmapp.framework.FrameworkActivity;
import com.hcid.tmone.tmapp.utilities.MemDB;

public class AlertListActivity extends Fragment {

    public static String currentIncident = "incident 1";
    int[] images = new int[] {R.drawable.ic_danger, R.drawable.ic_question, R.drawable.ic_question,
            R.drawable.ic_danger, R.drawable.ic_danger, R.drawable.ic_question, R.drawable.ic_danger};
    MemDB memDB = new MemDB();
    String[] titles = memDB.getIncidentTitles();
    String[] severities = new String[memDB.getNUMBER_OF_INCEDENTS()];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_alert_list, container, false);
        setHasOptionsMenu(true);

        for(int i = 0 ; i < memDB.getNUMBER_OF_INCEDENTS() ; i++){
            severities[i] = memDB.getIncidentSeverity(titles[i]);
        }

        final ListView listView = (ListView)v.findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(getActivity()));


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentIncident = listView.getItemAtPosition(position).toString();

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, new AlertActivity());
                FrameworkActivity.canBack = true;
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater myInflater;

        public MyAdapter(Context c) {
            myInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = myInflater.inflate(R.layout.alert_listview, null);

            ImageView image_list = (ImageView) convertView.findViewById(R.id.list_image);
            TextView title_list = (TextView) convertView.findViewById(R.id.list_title);
            TextView severity_list = (TextView) convertView.findViewById(R.id.list_severity);

            image_list.setImageResource(images[position]);
            title_list.setText(titles[position]);
            severity_list.setText(severities[position]);

            return convertView;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_alert_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.alert_help) {
            DialogEvent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogEvent() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Help")
                .setMessage("Put some help messages here.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                })
                .show();
    }
}
