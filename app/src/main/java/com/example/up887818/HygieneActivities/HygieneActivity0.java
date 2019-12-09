package com.example.up887818.HygieneActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.up887818.ExtraMethods;
import com.example.up887818.R;

public class HygieneActivity0 extends AppCompatActivity {

    ExtraMethods extra;

    FrameLayout bg;

    TextView title, description;

    Button yesButton, noButton;

    Boolean finished, fatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        extra = new ExtraMethods(this, HygieneActivity0.this);

        bg = findViewById(R.id.bg);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);

        String[] activityStrings = getResources().getStringArray(R.array.hygieneactivity0);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finished){
                    finish();
                }
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fatal) {
                    //Get fired
                    String reason = "Someone slipped and hurt themselves! You are a liability.";
                    extra.getFired(reason);
                } else {
                    //Go back to previous activity
                    finish();
                }
            }
        });

        title.setText("Activity 1: Kitchen floor");

        finished = false;
        fatal = false;

        bg.setBackgroundResource(R.drawable.kitchen_dirty);
        description.setText(activityStrings[0]);
    }
}
