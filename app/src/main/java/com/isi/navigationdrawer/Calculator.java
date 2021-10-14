package com.isi.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//a simple brief calculator
public class Calculator extends AppCompatActivity {

    private EditText opr1;
    private EditText opr2;
    private Button btnadd;
    private Button btnsub;
    private Button btnmul;
    private Button btndiv;
    private Button btnclr;
    private TextView txtresult;
    private TextView lizard;
    private ImageView lizardpic;
    private ImageView lizad2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setTitle("Calculator");
        opr1 = (EditText) findViewById(R.id.editOp1);
        opr2 = (EditText) findViewById(R.id.editOp2);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub  = (Button) findViewById(R.id.btnsub);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv =  (Button) findViewById(R.id.btndiv);
        btnclr = (Button) findViewById(R.id.btnclr);
        txtresult = (TextView) findViewById(R.id.result);
        lizard = (TextView) findViewById(R.id.lizardMessage);
        lizardpic = (ImageView) findViewById(R.id.lizardImage);
        lizad2 = (ImageView) findViewById(R.id.lizardtwo);

        //addition
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((opr1.getText().length() > 0) && (opr2.getText().length() > 0))
                {
                    double oper1 = Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 + oper2;
                    txtresult.setText(Double.toString(result));
                    lizard.setText("Hey Buddy Your Result is " + result + "  Great Job");
                    lizardpic.setVisibility(View.VISIBLE);
                    lizad2.setVisibility(View.INVISIBLE);

                }else {
                    Toast toast= Toast.makeText(Calculator.this,"Enter The Required Numbers",Toast.LENGTH_LONG);
                    toast.show();
                    lizardpic.setVisibility(View.INVISIBLE);
                    lizad2.setVisibility(View.VISIBLE);
                    lizard.setText("Nigga insert the Required Numbers shshshs..");
                }
            }
        });
        //subtraction
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((opr1.getText().length() > 0) && (opr2.getText().length() >0)){

                    double oper1 = Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 - oper2;
                    txtresult.setText(Double.toString(result));
                    lizard.setText("Hey Buddy Your Result is " + result + "  Great Job");
                    lizardpic.setVisibility(View.VISIBLE);
                    lizad2.setVisibility(View.INVISIBLE);
                }else{
                    Toast toast =Toast.makeText(Calculator.this , "Enter the Required Numbers", Toast.LENGTH_LONG);
                    toast.show();
                    lizardpic.setVisibility(View.INVISIBLE);
                    lizad2.setVisibility(View.VISIBLE);
                    lizard.setText("Nigga insert the Required Numbers shshshs..");
                }
            }
        });
        //multiplication
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((opr1.getText().length() > 0) && (opr2.getText().length() > 0)){
                    double oper1 =  Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 * oper2;
                    txtresult.setText(Double.toString(result));
                    lizard.setText("Hey Buddy Your Result is " + result + "  Great Job");
                    lizardpic.setVisibility(View.VISIBLE);
                    lizad2.setVisibility(View.INVISIBLE);
                }else {
                    Toast toast = Toast.makeText(Calculator.this, "Enter the Required Numbers", Toast.LENGTH_LONG);
                    toast.show();
                    lizardpic.setVisibility(View.INVISIBLE);
                    lizad2.setVisibility(View.VISIBLE);
                    lizard.setText("Nigga insert the Required Numbers shshshs..");
                }
            }
        });
        //division
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((opr1.getText().length() > 0) && (opr2.getText().length() > 0)){
                    double oper1 = Double.parseDouble(opr1.getText().toString());
                    double oper2 = Double.parseDouble(opr2.getText().toString());
                    double result = oper1 / oper2;
                    txtresult.setText(Double.toString(result));
                    lizard.setText("Hey Buddy Your Result is " + result + "  Great Job");
                    lizardpic.setVisibility(View.VISIBLE);
                    lizad2.setVisibility(View.INVISIBLE);
                }else{
                    Toast toast = Toast.makeText(Calculator.this , "Enter the Required Numbers" , Toast.LENGTH_LONG);
                    toast.show();
                    lizardpic.setVisibility(View.INVISIBLE);
                    lizad2.setVisibility(View.VISIBLE);
                    lizard.setText("Nigga insert the Required Numbers shshshs..");
                }
            }
        });
        // Reset Feilds
        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr1.setText("");
                opr2.setText("");
                txtresult.setText("0.00");
                opr1.requestFocus();
            }
        });



    }
}