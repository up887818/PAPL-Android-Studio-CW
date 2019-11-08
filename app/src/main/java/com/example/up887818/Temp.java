package com.example.up887818;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class Temp extends AppCompatActivity {

    //Todo: Activity closes immediately after loading. Error in code somewhere??

    ExtraMethods a = new ExtraMethods(Temp.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView goodMorning = findViewById(R.id.textView2);

        setContentView(R.layout.activity_temp);

        //Todo: Create All Task Activities

        //This shuffles the order in which hygiene/customer tasks are given out.
        //Working as of 07/11/19
        Integer[] hygieneOrder = new Integer[]{0, 1, 2, 3, 4};
        Collections.shuffle(Arrays.asList(hygieneOrder));
        Class[] hygiene = new Class[]{HygieneActivity0.class,
                HygieneActivity1.class, HygieneActivity2.class,
                HygieneActivity3.class, HygieneActivity4.class};

        Integer[] customerOrder = new Integer[]{0, 1, 2, 3, 4};
        Collections.shuffle(Arrays.asList(customerOrder));
        Class[] customer = new Class[]{CustomerActivity0.class,
                CustomerActivity1.class, CustomerActivity2.class,
                CustomerActivity3.class, CustomerActivity4.class};

        String introMessage;

        //Setting up the response to the yes/no button.
        Button yesButton = findViewById(R.id.yesButton);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: Once Activities set up, make so sends to next hygiene task.
                ;
            }
        });

        Button noButton = findViewById(R.id.noButton);
        noButton.setOnClickListener(new View.OnClickListener() {
            int refusals = 0;
            public void onClick(View v) {
                refusals++;
                if (refusals == 2){
                    String reason = "You refused to show up to work twice!";
                    a.getFired(reason);
                }
                else{
                    TextView goodMorning = findViewById(R.id.textView2);
                    goodMorning.setText("Scott has requested that you go to work. If you refuse again you will be fired!");
                }
            }
        });

        for (int i=0; i<5; i++){
            introMessage = String.format("Day %d! Good morning. Are you going to work today?",i++);
            goodMorning.setText(introMessage);

            //Todo: (Ask Nad??) Wait until either button is pressed
        }

    }
}
