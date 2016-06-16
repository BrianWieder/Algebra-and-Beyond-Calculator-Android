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

public class QuadraticActivity extends AppCompatActivity {

    EditText x2;
    EditText x;
    EditText constant;
    Button calculate;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        x2 = (EditText) findViewById(R.id.x2Quad);
        x = (EditText) findViewById(R.id.xQuad);
        constant = (EditText) findViewById(R.id.constQuad);
        calculate = (Button) findViewById(R.id.calcBtnQuad);
        result = (TextView) findViewById(R.id.resultLblQuad);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x2String = x2.getText().toString();
                String xString = x.getText().toString();
                String constString = constant.getText().toString();

                if(!x2String.isEmpty() && x2String != null && !xString.isEmpty() && xString != null && !constString.isEmpty() && constString != null){
                    try {
                        double x2Double = Double.parseDouble(x2.getText().toString());
                        double xDouble = Double.parseDouble(x.getText().toString());
                        double constantDouble = Double.parseDouble(constant.getText().toString());

                        result.setText(Functions.QuadraticFormula(x2Double, xDouble, constantDouble));

                    } catch (NumberFormatException e) {
                        AlertDialog.Builder errorDialog = new AlertDialog.Builder(QuadraticActivity.this);
                        errorDialog.setTitle("Incompatible numbers");
                        errorDialog.setMessage("Please enter compatible numbers");
                        errorDialog.setCancelable(false);
                        errorDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent main = new Intent(QuadraticActivity.this, MainActivity.class);
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
