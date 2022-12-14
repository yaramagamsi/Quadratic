package com.example.quadratic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etA , etB ,etC;
    private ImageView img;
    private Button Calc;
    private TextView x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectComponents();
    }

    private void connectComponents() {

        etA = findViewById(R.id.etAMain);
        etB = findViewById(R.id.etBMain);
        etC = findViewById(R.id.etCMain);
        img = findViewById(R.id.ivMain);
        Calc = findViewById(R.id.btnCalcMain);
        x1 = findViewById(R.id.tvX1);
        x2 = findViewById(R.id.tvX2);
    }


    @SuppressLint("SetTextI18n")
    public void Calculate(View view) {

        String A = etA.getText().toString();
        String B = etB.getText().toString();
        String C = etC.getText().toString();


        if (A.trim().isEmpty() || B.trim().isEmpty() || C.trim().isEmpty()){

            Toast.makeText(this, "there is an empty field", Toast.LENGTH_LONG).show();
        }

        double a = Double.parseDouble(A);
        double b = Double.parseDouble(B);
        double c = Double.parseDouble(C);
        double d = ((b*b)-(4*a*c));



        if (d > 0){
            img.setImageResource(R.drawable.imgtwo);
            x1.setText("x1 = " + ((-b + Math.sqrt(d)) / (2*a)));
            x2.setText("x2 = " + ((-b - Math.sqrt(d)) / (2*a)));
        }

        if (d == 0){
            img.setImageResource(R.drawable.imgone);
            x1.setText("x1 = " + ((-b + Math.sqrt(d)) / (2*a)));

        }

        if (d < 0){
            img.setImageResource(R.drawable.imgzero);
        }






    }
}