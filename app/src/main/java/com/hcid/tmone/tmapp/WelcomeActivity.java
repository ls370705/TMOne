package com.hcid.tmone.tmapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.hcid.tmone.tmapp.framework.FrameworkActivity;
import com.hcid.tmone.tmapp.utilities.EditDistance;
import com.hcid.tmone.tmapp.utilities.MemDB;

/**
 * Welcome Activity.
 * For user to get started and choose a destination
 */
public class WelcomeActivity extends AppCompatActivity {

    MemDB memDB = new MemDB();
    private AutoCompleteTextView autoCompleteTextView;
    private ImageView image[] = new ImageView[5];
    public static String currentSelectedPlace = "Cambodia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

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
                    startActivity(new Intent(WelcomeActivity.this, FrameworkActivity.class));
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.main_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Search for you next destination...   ");
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                item.collapseActionView();
                startActivity(new Intent(WelcomeActivity.this, FrameworkActivity.class));
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setIconifiedByDefault(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
