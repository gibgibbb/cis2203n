package com.example.mobdevexercise03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EchoActivity extends AppCompatActivity {

    private static final String TAG = "EchoActivity";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        Log.d(TAG, "EchoActivity onCreate method started");
        TextView txtEcho = findViewById(R.id.txtEcho);

        Intent receivedIntent = getIntent();
        String passedMessage = receivedIntent.getStringExtra("message");

        if(passedMessage != null){
            Log.i(TAG, "passed message: " + passedMessage);
            txtEcho.setText(passedMessage);
        } else {
            Log.e(TAG, "passed message is null");
            txtEcho.setText("No message passed");
        }
    }
}