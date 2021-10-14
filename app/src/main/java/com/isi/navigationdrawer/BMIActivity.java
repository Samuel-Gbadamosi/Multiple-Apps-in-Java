package com.isi.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.icu.text.DecimalFormat;



public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        setTitle("BMI CALCULATOR");
        myButtonListenerMethod();
    }
    public void myButtonListenerMethod() {

        Button button = (Button) findViewById(R.id.buttonBmi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //heighttext
                final EditText heightText = (EditText) findViewById(R.id.heightInput);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);
                  //weighttext
                final EditText weightText = (EditText) findViewById(R.id.weightInput);
                String weightStr = weightText.getText().toString();

                //we declare the weight variable here
                double weight =Double.parseDouble(weightStr);
                double BMI = (weight) / (height * height);
                DecimalFormat df = new DecimalFormat("#.#");
                Double BMI_trimmed = Double.parseDouble(df.format(BMI));
                final  EditText BMIResult = (EditText) findViewById(R.id.BMIresult);
                BMIResult.setText(Double.toString(BMI));
                String BMI_cAT;

                if(BMI < 15){
                    BMI_cAT = "Very severly underweight and that sucks!!";
                }else if (BMI < 16){
                    BMI_cAT = "Severly underweight kinda bad bad";
                }else if (BMI < 18.5){
                    BMI_cAT = "Underweight"; //30 35 40
                }else if (BMI < 25){
                    BMI_cAT = "Normal Great!!";
                }else if(BMI > 30){
                    BMI_cAT = "Overweight";
                }else if (BMI < 35) {
                    BMI_cAT = "Obese Class 1 – Moderately Obese";
                }
                else if (BMI < 38){
                    BMI_cAT = "Obese Class 1.2 - Slightly Obese";
                }else if (BMI < 40) {
                    BMI_cAT = "Obese Class 2 – severly Obese";
                }else if (BMI < 41){
                    BMI_cAT = "Obese Class 3 - severly obes";
                }else{
                    BMI_cAT = "Obese Class 3 - very very Obese";
                    final TextView BMICategory = (TextView)
                            findViewById(R.id.BMI_cATERGORY);
                    BMICategory.setText(BMI_cAT);
                }

            }
        });

    }



}