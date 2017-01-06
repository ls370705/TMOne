package com.hcid.tmone.tmapp.checklist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hcid.tmone.tmapp.R;
import com.hcid.tmone.tmapp.framework.FrameworkActivity;
import com.hcid.tmone.tmapp.utilities.MemDB;

public class CheckListActivity extends Fragment {

    public static String currentSelectedItem = "";
    MemDB memDB = new MemDB();
    private final LinearLayout[] items = new LinearLayout[memDB.getNUMBER_OF_ITEMS()];
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_check_list, container, false);
        setHasOptionsMenu(true);

        LinearLayout left_col = (LinearLayout) v.findViewById(R.id.left_col);
        LinearLayout right_col = (LinearLayout) v.findViewById(R.id.right_col);
        String[] checklist = memDB.getChecklist();

        for(int i = 0 ; i < left_col.getChildCount() ; i++){
            LinearLayout temp = (LinearLayout) left_col.getChildAt(i);
            TextView tempTextTitle = (TextView)(((RelativeLayout)temp.getChildAt(1)).getChildAt(0));
            //TextView tempTextVote = (TextView)(((RelativeLayout)temp.getChildAt(1)).getChildAt(1));
            tempTextTitle.setText(checklist[i * 2]);
            //String votes = "votes: " + memDB.getItemVotes(checklist[i * 2]) + "";
            //tempTextVote.setText(votes);
            items[i * 2] = (LinearLayout) left_col.getChildAt(i);

            temp = (LinearLayout) right_col.getChildAt(i);
            tempTextTitle = (TextView)(((RelativeLayout)temp.getChildAt(1)).getChildAt(0));
            //tempTextVote = (TextView)(((RelativeLayout)temp.getChildAt(1)).getChildAt(1));
            tempTextTitle.setText(checklist[i * 2 + 1]);
            //votes = "votes: " + memDB.getItemVotes(checklist[i * 2 + 1]) + "";
            //tempTextVote.setText(votes);
            items[i * 2 + 1] = (LinearLayout) right_col.getChildAt(i);
        }

        /*for(final LinearLayout i : items){
            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentSelectedItem = ((TextView)((RelativeLayout) i.getChildAt(1)).getChildAt(0)).getText().toString();

                    getFragmentManager().beginTransaction().replace(R.id.frame,new ItemActivity()).addToBackStack(null).commit();
                    FrameworkActivity.canBack = true;
                }
            });
        }*/
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
                .setMessage("These are what other travelers put in their backpacks. You might need them in your journey. Give it a heart if it's useful!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }
}
