package com.isi.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BlogActivity extends AppCompatActivity implements  SearchView.OnQueryTextListener{

    boolean bartShow = true;
    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;

    //variables for searchView
    //listview object
    ListView listView;
    //define array adapter for listView
    ArrayAdapter<String> adapter;
    String[] animalNameList;

    //define arraylist for listview data
    ArrayList<String> mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        setTitle("Blog");

        //this piece of code with the optionselected would take us back to previous page
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //rating bar method and button
        addListenerOnRatingBar();
        addListenerOnButton();

        //declare arraylist in array
        animalNameList = new String[]{"lion" , "tiger" , "dog"};



        //we generate sample data to work on searchbar to get whats in the array
        listView = findViewById(R.id.listView);
        //created new array for song
        ArrayList<String> phones = new ArrayList<>(5);
        //add phones to the array
        phones.add("iphone8");
        phones.add("iphone10");
        phones.add("iphone11");
        phones.add("iphones12");
        phones.add("iphone13");

        ArrayList<String> tablets = new ArrayList<>(4);
        tablets.add("samsung_tablet");
        tablets.add("apple tablets");
        tablets.add("huawei tablets");

        //arraysong
        ArrayList<String> song = new ArrayList<>();
        song.add("samson jackson");
        song.add("micheal jackson");
        song.add("thomson craig");
        song.add("morgan craig");
        song.add("morgan fleet");
        song.add("perry morgan");
        song.add("restore");


        //we add items to othe array
        mylist = new ArrayList<>();
        mylist.add("cat");
        mylist.add("c++");
        mylist.add("c#");
        mylist.add("News");
        mylist.add("music");
        mylist.add("Our Page");
        mylist.add("interview prep with c++");
        mylist.add("data structures with java");
        mylist.add("data could explore");
        mylist.add("our timeline");
        mylist.add("car wash");

        //added array for song
        mylist.addAll(song );
        mylist.addAll(phones);
        mylist.addAll(tablets);

        //to viiew what we have in mylist
        System.out.println(mylist);


        //set adapter to list View andriod layout
        //mylist is our empty array
        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_dropdown_item_1line , mylist);
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(false);


    }


    public void bartClick(View view){
        // WE USE A RELATIVE LAYOUT IN THE SCROLL VIEW TO HAVE PIC ON SAME PLACE
        Log.i("info" , "bart simpson tapped");

        ImageView bartimageView = (ImageView) findViewById(R.id.bartPic);

        ImageView homerimageView = (ImageView) findViewById(R.id.homerTwo);

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
    public boolean onCreateOptionsMenu(Menu menu) {

        //inflate menu with items using menuInflator
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        //initialise menu item search bar with id and take object
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setQueryHint("Search");

        //attach set on query listener

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //if mylist contains query search give us data else not found
                if (mylist.contains(query)) {
                    //set drop do
                    adapter.getFilter().filter(query);

                } else {
                    Toast.makeText(BlogActivity.this, "Not found", Toast.LENGTH_LONG).show();
                }
                return false;
            }



            @Override
            public boolean onQueryTextChange(String newText) {

                //problem with array displaying with it been search
                //but keeps showing whats inside array !!!

                String test = newText;

                adapter.getFilter().filter(test);
                if(TextUtils.isEmpty(test)){
                    listView.setVisibility(View.GONE);

                }else {
                    listView.setVisibility(View.VISIBLE);
                }


                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }



    //rattings
    private void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBarT);
        btnSubmit = (Button) findViewById(R.id.rateButton);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(BlogActivity.this , String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();

                SweetAlertDialog pDialog = new SweetAlertDialog(BlogActivity.this, SweetAlertDialog.SUCCESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("added Star... " + ratingBar.getRating());
                pDialog.setCancelable(true);
                pDialog.show();


            }


        });




    }

    private void addListenerOnRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBarT);
        txtRatingValue = (TextView) findViewById(R.id.myTexooooo);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtRatingValue.setText("You rated this site " + String.valueOf(rating));


            }
        });
    }

    //this takes us back to the home page
    public boolean onOptionsItemSelected(MenuItem item) {
        //takes you bavck to home
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    //it must be there obbligatory
    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(TextUtils.isEmpty(newText)){
            listView.clearTextFilter();
        }else{
            listView.setFilterText(newText);
        }
        return false;
    }
}