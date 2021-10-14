package com.isi.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

public class AnimActivity extends AppCompatActivity {

    boolean bartShow = true;

    public void fade(View view){

        Log.i("info" , "image tapped");

        ImageView bartimageView = (ImageView) findViewById(R.id.bart);



        ImageView homerimageView = (ImageView) findViewById(R.id.homer);



        //trying to change image picture at click on if
        if(bartShow){

            bartShow = false;
            //we set the animate to zero and duration 2 secs
            bartimageView.animate().alpha(0).setDuration(2000);
            homerimageView.animate().alpha(1).setDuration(2000);


        }else if (bartShow){
            bartShow = true;
            homerimageView.animate().alpha(1).setDuration(2000);
            bartimageView.animate().alpha(0).setDuration(2000);


        }else{
            bartShow = false;
            bartimageView.animate().alpha(1).setDuration(2000);
            homerimageView.animate().alpha(0).setDuration(2000);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        setTitle("Animation Page");

        //this will take us back back to the previous page
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    //this takes us back to the home page
    public boolean onOptionsItemSelected(MenuItem item) {
        //takes you bavck to home
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}