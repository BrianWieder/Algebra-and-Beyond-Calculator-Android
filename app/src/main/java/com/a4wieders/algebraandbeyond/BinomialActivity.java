package com.a4wieders.algebraandbeyond;

import android.content.DialogInterface;
import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BinomialActivity extends AppCompatActivity {

    EditText x2TextField;
    EditText constTextField;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binomial);

        x2TextField = (EditText) findViewById(R.id.x2Bin);
        constTextField = (EditText) findViewById(R.id.constantBin);
        Button calcBtn = (Button) findViewById(R.id.calcBtnBin);
        result = (TextView) findViewById(R.id.resultBin);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String x2String = x2TextField.getText().toString();
                String constantString = constTextField.getText().toString();

                if (!x2String.isEmpty() && x2String != null && !constantString.isEmpty() && constantString != null) {
                    try {

                        double  x2Double = Double.parseDouble(x2String);
                        double constDouble = Double.parseDouble(constantString);

                        result.setText(Functions.BinomialFactoring(x2Double, constDouble));

                    } catch (NumberFormatException e) {
                        AlertDialog.Builder errorDialog = new AlertDialog.Builder(BinomialActivity.this);
                        errorDialog.setTitle("Incompatible numbers");
                        errorDialog.setMessage("Please enter compatible numbers");
                        errorDialog.setCancelable(false);
                        errorDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent main = new Intent(BinomialActivity.this, MainActivity.class);
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
