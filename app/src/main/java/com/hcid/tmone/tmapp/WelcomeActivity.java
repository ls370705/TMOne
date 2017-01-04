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

        ImageView mimageView = (ImageView) findViewById(R.id.image1);

        Bitmap mbitmap = ((BitmapDrawable)mimageView.getDrawable()).getBitmap();
//        Bitmap mbitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.img_angkor_wat,null)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 100, 100, mpaint);// Round Image Corner 100 100 100 100
        mimageView.setImageBitmap(imageRounded);

    }

    public void search(View view){
        String destination = autoCompleteTextView.getText().toString();
        autoCompleteTextView.setText("");

        MainActivity.currentSelectedPlace = EditDistance.getResult(destination,memDB.getPlaces());

        Intent intent = new Intent(WelcomeActivity.this, FrameworkActivity.class);
        startActivity(intent);
    }

}
