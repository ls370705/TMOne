package com.hcid.tmone.tmapp.framework;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.hcid.tmone.tmapp.alerts.AlertListActivity;
import com.hcid.tmone.tmapp.checklist.CheckListActivity;
import com.hcid.tmone.tmapp.introduction.DestinationActivity;
import com.hcid.tmone.tmapp.settings.SettingsActivity;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.hcid.tmone.tmapp.R;

public class FrameworkActivity extends AppCompatActivity {

    BottomBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framework);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_home_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.menu_bottom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.scene:
                        DestinationActivity d = new DestinationActivity();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, d).commit();
                        break;
                    case R.id.need:
                        CheckListActivity c = new CheckListActivity();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, c).commit();
                        break;
                    case R.id.forum:
                        AlertListActivity a = new AlertListActivity();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, a).commit();
                        break;
                    case R.id.account:
                        SettingsActivity s = new SettingsActivity();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, s).commit();
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
            }
        });
    }
}
