package com.isi.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import java.util.Random;

public class DiceGameActivity extends AppCompatActivity {

    public static Button button,button2;
    public static TextView textView;
    public static ImageView img1 ,img2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_game);
        setTitle("Dice");

        //create array to get dice images
        final int dice[] ={R.drawable.one , R.drawable.two , R.drawable.three , R.drawable.four , R.drawable.five , R.drawable.six};

        //linking the row from its id
        button = findViewById(R.id.btVar1);
        button2 = findViewById(R.id.nextBut);


        //linking the result textview from its id
        textView = findViewById(R.id.tvVar1);

        //linking both the imageView of the dice images from its id..
        img1 = findViewById(R.id.ivVar1);
        img2 = findViewById(R.id.ivVar2);

        //this button shou
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DiceGameActivity.this , SecondActivity.class );
                startActivity(i);
            }
        });

        //call on the click function
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //generate two random numbers
                //using function

                Random random = new Random();
                int num1 = random.nextInt(6);
                Random random1 = new Random();
                int num2 = random1.nextInt(6);

                //if the biggernumber wil be displayes in the text vie

                if (num1 > num2) {
                    textView.setText("WINNER : Player 1");
                } else if (num2 > num1) {
                    textView.setText("WINNER : Player 2");
                } else {
                    textView.setText("RESULT : Draw");
                }
                // set the images from the array by the index
                // position of the numbers generated
                img1.setImageResource(dice[num1]);
                img2.setImageResource(dice[num2]);
            }
        });

    }



}