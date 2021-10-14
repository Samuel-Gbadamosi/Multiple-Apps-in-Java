package com.isi.navigationdrawer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

public class CameraActivity extends AppCompatActivity {

    //initialize variable
    ImageView imageView;
    Button btOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        setTitle("Camera Room");

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        imageView = findViewById(R.id.imageViewers);
        btOpen = findViewById(R.id.bt_open);

        //request for camera permission
        if(ContextCompat.checkSelfPermission(CameraActivity.this ,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(CameraActivity.this,
                    new  String[]{
                            Manifest.permission.CAMERA }, 100);
        }

        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent , 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode , @Nullable Intent data){
        if(requestCode == 100){


            //get captured image
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            //set capture image to imageview
            imageView.setImageBitmap(captureImage);


        }
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