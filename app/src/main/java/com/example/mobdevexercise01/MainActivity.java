package com.example.mobdevexercise01;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;
    private TextView counterDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 22104031");
        }

        counterDisplay = findViewById(R.id.btnCount);
        if (counterDisplay != null) {
            counterDisplay.setText(String.valueOf(mCounter));
        }

        counterDisplay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                if (counterDisplay != null) {
                    counterDisplay.setText(String.valueOf(mCounter));
                }
            }
        });

        Button myButton = findViewById(R.id.btnChangeName);
        final TextView myTextView = findViewById(R.id.tvDepartment);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText("Ms. Angie");
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", mCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt("COUNT_KEY");
        if (counterDisplay != null) {
            counterDisplay.setText(String.valueOf(mCounter));
        }
    }
}