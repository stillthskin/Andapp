package com.example.ztax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tabnavi extends AppCompatActivity {
Button bmibtn;
EditText agein;
EditText heightin;
EditText weightin;
TextView outText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabnavi);
        agein = findViewById(R.id.bmiage);
        heightin = findViewById(R.id.bmiheight);
        weightin = findViewById(R.id.bmiweight);
        outText = findViewById(R.id.bmiout);
        bmibtn = findViewById(R.id.bmibutton);

        bmibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = agein.getText().toString();
                String height = heightin.getText().toString()+"f";
                String weight = weightin.getText().toString();
                System.out.println(age+"..."+height);
                setBmi(age,height,weight,outText);
            }
        });

    }
    private  void setBmi(String age,String height, String weight, TextView outText){

        try {
            int ageint = Integer.parseInt(age);
            float heightint =Float.parseFloat(height);
            int weightint = Integer.parseInt(weight);
            System.out.println("Age: "+ageint+"Height: " +heightint+"Weit: "+weightint);
            float bmi = (float) weightint / (heightint * heightint);
            bmi = Math.round(bmi);
            System.out.println(bmi);
            if (bmi < 18.5) {
                String feed = "Your BMI is : "+bmi+ " Underweight";
                outText.setText(feed);
                //System.out.println("Underweight");
            } else if (bmi >= 18.5 && bmi < 25) {
                String feed = bmi+ " Normal Weight";
                outText.setText(feed);
                //System.out.println("Normal weight");
            } else if (bmi >= 25 && bmi < 30) {
                String feed = bmi+ " Overweight";
                outText.setText(feed);
                //System.out.println("Overweight");
            } else {
                String feed = bmi+ " Obese";
                outText.setText(feed);
                //System.out.println("Obese");
            }
        }
        catch (Exception e) {
            Toast.makeText(this, "Invalid input: " +e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}