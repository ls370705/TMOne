package com.hcid.tmone.tmapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.hcid.tmone.tmapp.framework.FrameworkActivity;
import com.hcid.tmone.tmapp.utilities.MemDB;

public class MainActivity extends AppCompatActivity {

    private ImageView image[] = new ImageView[5];
    public static String currentSelectedPlace = "Cambodia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MemDB memDB = new MemDB();
        final String[] places = memDB.getPlaces();

        image[0] = (ImageView) findViewById(R.id.image1);
        image[1] = (ImageView) findViewById(R.id.image2);
        image[2] = (ImageView) findViewById(R.id.image3);
        image[3] = (ImageView) findViewById(R.id.image4);
        image[4] = (ImageView) findViewById(R.id.image5);
        for (int i = 0; i < 5; i++) {
            final String selectedPlace = places[i];
            image[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentSelectedPlace = selectedPlace;
                    startActivity(new Intent(MainActivity.this, FrameworkActivity.class));
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.main_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                item.collapseActionView();
                startActivity(new Intent(MainActivity.this, FrameworkActivity.class));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_help) {
            DialogEvent();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void DialogEvent() {
        new AlertDialog.Builder(MainActivity.this)
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
