package com.a4wieders.algebraandbeyond;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.EGLDisplay;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PolynomialActivity extends AppCompatActivity {

    EditText x3;
    EditText x2;
    EditText x;
    EditText constant;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polynomial);

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        x3 = (EditText) findViewById(R.id.x3TextView);
        x2 = (EditText) findViewById(R.id.x2TextView);
        x = (EditText) findViewById(R.id.xTextView);
        constant = (EditText) findViewById(R.id.constantTextView);
        calculate = (Button) findViewById(R.id.calculateBtn);
        result = (TextView) findViewById(R.id.resultTextView);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String x3String = x3.getText().toString();
                String x2String = x2.getText().toString();
                String xString = x.getText().toString();
                String constantString = constant.getText().toString();

                if (!x3String.isEmpty() && x3String != null && !x2String.isEmpty() && x2String != null && !xString.isEmpty() && xString != null && !constantString.isEmpty() && constantString != null) {
                    try {
                        double x3Double = Double.parseDouble(x3.getText().toString());
                        double x2Double = Double.parseDouble(x2.getText().toString());
                        double xDouble = Double.parseDouble(x.getText().toString());
                        double constantDouble = Double.parseDouble(constant.getText().toString());

                        result.setText(Functions.GCF(x2Double, xDouble, x3Double, constantDouble));

                    } catch (NumberFormatException e) {
                        AlertDialog.Builder errorDialog = new AlertDialog.Builder(PolynomialActivity.this);
                        errorDialog.setTitle("Incompatible numbers");
                        errorDialog.setMessage("Please enter compatible numbers");
                        errorDialog.setCancelable(false);
                        errorDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent main = new Intent(PolynomialActivity.this, MainActivity.class);
                                startActivity(main);
                            }
                        });

                        AlertDialog error = errorDialog.create();
                        error.show();
                    }
                }

            }
        });

    }
}
