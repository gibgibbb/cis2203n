package com.example.mobdevmockmidterm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Logcat setup
    public static final String TAG = "CalcDebug";

    //UI Elements
    private TextView tvDisplay;

    //State Vars
    private double operandA = Double.NaN;
    private double operandB = Double.NaN;
    private String currentOperator = "";
    private Boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);

        setupNumberButtons();
        setupOperatorButtons();
        setupActionButtons();
    }

    private void setupNumberButtons(){
        int[] numberIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot
        };

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            String buttonText = button.getText().toString();

            Log.d(TAG, "Number button clicked: " + buttonText);

            // If we just pressed an operator or equals, start a new number
            if (isNewInput) {
                tvDisplay.setText("");
                isNewInput = false;
            } else {
                // Otherwise, append the number to the current string
                tvDisplay.append(buttonText);
            }
        };
        for(int id : numberIds){
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setupOperatorButtons() {
        int[] operatorIds = {
                R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        };

        View.OnClickListener listener = view -> {
            Button button = (Button) view;
            String op = button.getText().toString();

            Log.d(TAG, "Operator button clicked: " + op);

            try {
                operandA = Double.parseDouble(tvDisplay.getText().toString());
            } catch(NumberFormatException e) {
                Log.e(TAG, "Error parsing operandA", e);
            }

            currentOperator = op;
            isNewInput = true;
        };

        for (int id : operatorIds) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setupActionButtons() {
        // Equals button logic
        findViewById(R.id.btnEquals).setOnClickListener(view -> {
            Log.d(TAG, "Equal Buttons Clicked");
            if(currentOperator.isEmpty() || Double.isNaN(operandA)) return;

            try {
                operandB = Double.parseDouble(tvDisplay.getText().toString());
            } catch (NumberFormatException e){
                Log.e(TAG, "Error parsing operandB", e);
                return;
            }

            Log.i(TAG, "Calculating: " + operandA + " " + currentOperator + " " + operandB);
            double result = 0;

            switch (currentOperator){
                case "+": result = operandA + operandB; break;
                case "-": result = operandA - operandB; break;
                case "*": result = operandA * operandB; break;
                case "÷":
                    // Explicit Zero Division Handling
                    if (operandB == 0){
                        tvDisplay.setText("Error");
                        Log.e(TAG, "Zero division not allowed");
                        // Prevents further calculations
                        operandA = Double.NaN;
                        currentOperator = "";
                        isNewInput = true;
                        return;
                    }
                    result = operandA / operandB;
                    break;
            }
            String resultStr = (result % 1 == 0) ? String.valueOf((long) result) : String.valueOf(result);
            tvDisplay.setText(resultStr);

            // Reset state for the next calculation
            currentOperator = "";
            isNewInput = true;
            Log.i(TAG, "Result: " + resultStr);
        });

        findViewById(R.id.btnClear).setOnClickListener(view -> {
            Log.d(TAG, "Clear Button Clicked");
            tvDisplay.setText("0");
            operandA = Double.NaN;
            operandB = Double.NaN;
            currentOperator = "";
            isNewInput = true;
        });

        findViewById(R.id.btnCustom).setOnClickListener(view -> {
            Log.d(TAG, "Custom Button Clicked");

            try {
                // Get the current number on the screen
                double currentValue = Double.parseDouble(tvDisplay.getText().toString());
                double result = currentValue * 0.31;

                String resultStr = (result % 1 == 0) ? String.valueOf((long) result) : String.valueOf(result);
                tvDisplay.setText(resultStr);

                operandA = result;
                currentOperator = "";
                isNewInput = true;
            } catch (NumberFormatException e) {
                Log.e(TAG, "Error applying custom operation");
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        // This saves the UI text and all state variables
        outState.putString("tvDisplay", tvDisplay.getText().toString());
        outState.putString("currentOperator", currentOperator);
        outState.putDouble("operandA", operandA);
        outState.putDouble("operandB", operandB);
        outState.putBoolean("isNewInput", isNewInput);

        Log.d(TAG, "Saved Instance");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        tvDisplay.setText(savedInstanceState.getString("tvDisplay", "0"));
        operandA = savedInstanceState.getDouble("operandA", Double.NaN);
        operandB = savedInstanceState.getDouble("operandB", Double.NaN);
        currentOperator = savedInstanceState.getString("currentOperator", "");
        isNewInput = savedInstanceState.getBoolean("isNewInput", true);

        Log.d(TAG, "State restored");
    }
}
