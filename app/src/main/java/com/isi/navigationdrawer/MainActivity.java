package com.isi.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.ImageDecoder;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
//when we want to build a navigation bar to our project
//we implement it
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //declare a public drawerlayout
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");


        //drawer layout instance to toggle the menu icon to open
        //drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        //pass the openand close toggle for the drawer layout listener
        //to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //this navigation view get the navigation view Id
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        //to make the navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
//we declare it here too

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId() ;

        if(id == R.id.blogready) {
            Intent i = new Intent(MainActivity.this, BlogActivity.class);
            startActivity(i);
        }else if(id == R.id.bartex){
            Intent i = new Intent(MainActivity.this , AnimActivity.class);
            startActivity(i);
        }else if (id == R.id.currencyPage){
            Intent i = new Intent(MainActivity.this , CurrencyConverter.class);
            startActivity(i);
        }else if (id == R.id.TorchPage){
            Intent i = new Intent(MainActivity.this , OccupantActivity.class);
            startActivity(i);
        }else if(id == R.id.cam){
            Intent i = new Intent(MainActivity.this , CameraActivity.class);
            startActivity(i);
        }else if (id == R.id.BMI_PAGE){
            Intent B = new Intent(MainActivity.this , BMIActivity.class);
            startActivity(B);
        }else if (id == R.id.countdown){
            Intent i = new Intent(MainActivity.this , SecondActivity.class);
            startActivity(i);
        }else if (id == R.id.Calc){
            Intent i = new Intent(MainActivity.this , Calculator.class);
            startActivity(i);
        }else if(id == R.id.loveCalculator){
            Intent i = new Intent(MainActivity.this , LoveCalculatorActivity.class);
            startActivity(i);
        }else if (id == R.id.audioRec){
            Intent j = new Intent(MainActivity.this , RecordActivity.class);
            startActivity(j);
        }else if(id == R.id.dice){
            Intent i = new Intent(MainActivity.this , DiceGameActivity.class);
            startActivity(i);
        }

        //we definitely do it
        drawerLayout.closeDrawer(GravityCompat.START) ;
        return true;
    }
}