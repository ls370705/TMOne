package com.hcid.tmone.tmapp.alerts;

import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.TextView;

import com.hcid.tmone.tmapp.R;

public class AlertListActivity extends Fragment {

    int[] images = new int[] {R.drawable.ic_danger, R.drawable.ic_question, R.drawable.ic_question,
            R.drawable.ic_danger, R.drawable.ic_danger, R.drawable.ic_question, R.drawable.ic_danger};
    String[] titles = new String[] {"title1", "title2", "title3", "title4", "title5", "title6", "title7"};
    String[] times = new String[] {"time1", "time2", "time3", "time4", "time5", "time6", "time7"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_alert_list, container, false);
        setHasOptionsMenu(true);

        ListView listView = (ListView)v.findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(getActivity()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, new AlertActivity());
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
            return images[position];
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
            TextView time_list = (TextView) convertView.findViewById(R.id.list_time);

            image_list.setImageResource(images[position]);
            title_list.setText(titles[position]);
            time_list.setText(times[position]);

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
