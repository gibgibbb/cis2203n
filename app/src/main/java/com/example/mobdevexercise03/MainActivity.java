package com.example.mobdevexercise03;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate method started");

        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSendMessage = findViewById(R.id.btnSendMessage);
        Button btnShareMessage = findViewById(R.id.btnShareMessage);

        btnSendMessage.setOnClickListener(v -> {
            String message = etMessage.getText().toString();
            if(!message.isEmpty()){
                Log.i(TAG, "user clicked the send message button");

                Intent explicitIntent = new Intent(this, EchoActivity.class);
                explicitIntent.putExtra("message", message);
                startActivity(explicitIntent);
            } else {
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show();
            }
        });

        btnShareMessage.setOnClickListener(v -> {
           String message = etMessage.getText().toString().trim();

           if(!message.isEmpty()){
               Log.i(TAG, "user clicked the share message button");

               Intent implicitIntent = new Intent(Intent.ACTION_SEND);
               implicitIntent.setType("text/plain");
               implicitIntent.putExtra(Intent.EXTRA_TEXT, message);
               startActivity(Intent.createChooser(implicitIntent, "Share message via..."));
           } else {
               Toast.makeText(this, "Please enter a message to share", Toast.LENGTH_SHORT).show();
           }
        });
    }
}