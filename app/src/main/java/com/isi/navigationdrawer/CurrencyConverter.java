package com.isi.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class CurrencyConverter extends AppCompatActivity {

    public  static void addNumbers(int a, int  b){
        int sum;

        sum = a + b ;
        System.out.println(sum);


    }

    //the testcon
    public void testcon(View view){

        //the edittext
        EditText editText = (EditText) findViewById(R.id.amountBtn);

        //we get the amount from edittEXT
        String amountinPounds = editText.getText().toString();

        //WE EXCHANGE THE AMOUNT IN  DOUBLE TO GET AMOUNTINPOUNDS
        double amountInPoundsDouble = Double.parseDouble(amountinPounds);

        //WE DO THE CALCULATION HERE
        double amountinDollarsDouble = amountInPoundsDouble * 1.38;

        //WE SAVE THE CALCULATION IN A STRING
        String amountinDollarsString = Double.toString(amountinDollarsDouble);

        //display this in the log
        Log.i("amount in dollars" , amountinDollarsString);

        //add a textview ti display the amount converted
        TextView res = (TextView) findViewById(R.id.resres);

        //here we get the result of what we converted and display on screen


        res.setText("The amount converted is " + "$"+ amountinDollarsString );



        Log.i("info", editText.getText().toString());

        Button btncon = (Button) findViewById(R.id.converter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);

        setTitle("Currency Page");

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