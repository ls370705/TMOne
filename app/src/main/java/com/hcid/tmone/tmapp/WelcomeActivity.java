package com.hcid.tmone.tmapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.hcid.tmone.tmapp.framework.FrameworkActivity;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView image[] = new ImageView[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        image[0] = (ImageView) findViewById(R.id.image1);
        image[1] = (ImageView) findViewById(R.id.image2);
        image[2] = (ImageView) findViewById(R.id.image3);
        image[3] = (ImageView) findViewById(R.id.image4);
        image[4] = (ImageView) findViewById(R.id.image5);
        for (int i = 0; i < 5; i++) {
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(WelcomeActivity.this, FrameworkActivity.class));
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.main_search));
        //searchView.setOnQueryTextListener(queryListener);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
