package com.hcid.tmone.tmapp.checklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hcid.tmone.tmapp.R;
import com.hcid.tmone.tmapp.utilities.MemDB;

public class ItemActivity extends Fragment {

    MemDB memDB = new MemDB();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_item, container, false);
        setHasOptionsMenu(true);

        String currentItem = CheckListActivity.currentSelectedItem;
        TextView name = (TextView) v.findViewById(R.id.item_name);
        TextView description = (TextView) v.findViewById(R.id.item_description);
        TextView votes = (TextView) v.findViewById(R.id.item_votes);

        name.setText(currentItem);
        description.setText(memDB.getItemDescription(currentItem));
        String voteString = "Votes: " + memDB.getItemVotes(currentItem) + "";
        votes.setText(voteString);

        return v;
    }

}
