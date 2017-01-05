package com.hcid.tmone.tmapp.framework;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.hcid.tmone.tmapp.WelcomeActivity;
import com.hcid.tmone.tmapp.alerts.AlertListActivity;
import com.hcid.tmone.tmapp.checklist.CheckListActivity;
import com.hcid.tmone.tmapp.introduction.DestinationActivity;
import com.hcid.tmone.tmapp.account.AccountActivity;
import com.hcid.tmone.tmapp.introduction.HomeActivity;
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

        setTitle(WelcomeActivity.currentSelectedPlace);

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.menu_bottom_bar, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.summary:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HomeActivity()).commit();
                        break;
                    case R.id.scene:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new DestinationActivity()).commit();
                        break;
                    case R.id.need:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new CheckListActivity()).commit();
                        break;
                    case R.id.forum:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new AlertListActivity()).commit();
                        break;
                    case R.id.account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new AccountActivity()).commit();
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
            }
        });
    }

}
