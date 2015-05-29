package com.example.simplecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText mNumber1;
    private EditText mNumber2;
    private Spinner mOperator;
    private Button mCalculate;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumber1 = (EditText) findViewById(R.id.number1);
        mNumber2 = (EditText) findViewById(R.id.number2);
        mOperator = (Spinner) findViewById(R.id.operator);
        mCalculate = (Button) findViewById(R.id.calculate);
        mResult = (TextView) findViewById(R.id.result);

        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float number1 = mNumber1.getText().toString().equals("") ? 0 : Float.valueOf(mNumber1.getText().toString());
                float number2 = mNumber2.getText().toString().equals("") ? 0 : Float.valueOf(mNumber2.getText().toString());
                float result;

                String selectedItem = mOperator.getSelectedItem().toString();
                if (selectedItem.equals("+")) {
                    result = number1 + number2;
                } else if (selectedItem.equals("-")) {
                    result = number1 - number2;
                } else if (selectedItem.equals("x")) {
                    result = number1 * number2;
                } else {
                    result = number1 / number2;
                }
                mResult.setText(Float.toString(result));
            }
        });

    }
}
