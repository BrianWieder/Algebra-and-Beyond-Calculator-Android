package com.a4wieders.algebraandbeyond;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TrinomialActivity extends AppCompatActivity {

    EditText x2;
    EditText x;
    EditText constant;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trinomial);

        x2 = (EditText) findViewById(R.id.x2Tri);
        x = (EditText) findViewById(R.id.xTri);
        constant = (EditText) findViewById(R.id.constTri);
        calculate = (Button) findViewById(R.id.calcTri);
        result = (TextView) findViewById(R.id.resultTri);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double x2Double = Double.parseDouble(x2.getText().toString());
                    double xDouble = Double.parseDouble(x.getText().toString());
                    double constantDouble = Double.parseDouble(constant.getText().toString());

                    result.setText(Functions.findStuff(x2Double, xDouble, constantDouble));

                } catch (NumberFormatException e) {
                    AlertDialog.Builder errorDialog = new AlertDialog.Builder(TrinomialActivity.this);
                    errorDialog.setTitle("Incompatible numbers");
                    errorDialog.setMessage("Please enter compatible numbers");
                    errorDialog.setCancelable(false);
                    errorDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent main = new Intent(TrinomialActivity.this, MainActivity.class);
                            startActivity(main);
                        }
                    });

                    AlertDialog error = errorDialog.create();
                    error.show();
                }
            }
        });
    }
}
