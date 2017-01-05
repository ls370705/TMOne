package com.hcid.tmone.tmapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

import com.hcid.tmone.tmapp.framework.FrameworkActivity;
import com.hcid.tmone.tmapp.utilities.EditDistance;
import com.hcid.tmone.tmapp.utilities.MemDB;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.select_dialog_singlechoice,memDB.getPlaces());
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.drop_down);
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(adapter);
        }

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

    public void search(View view){
        String destination = autoCompleteTextView.getText().toString();
        autoCompleteTextView.setText("");

        currentSelectedPlace = EditDistance.getResult(destination,memDB.getPlaces());

        Log.d("PLACEWEL",currentSelectedPlace);
        Intent intent = new Intent(WelcomeActivity.this, FrameworkActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

}
