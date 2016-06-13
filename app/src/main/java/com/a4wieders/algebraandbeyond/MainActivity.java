package com.a4wieders.algebraandbeyond;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button PolyBtn = (Button) findViewById(R.id.PolyBtn);
        Button TriBtn = (Button) findViewById(R.id.TriBtn);
        Button QuadBtn = (Button) findViewById(R.id.QuadBtn);
        Button BioBtn = (Button) findViewById(R.id.BioBtn);

        PolyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent polyIntent = new Intent(MainActivity.this, PolynomialActivity.class);
                startActivity(polyIntent);
            }
        });
        BioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent binoIntent = new Intent(MainActivity.this, BinomialActivity.class);
                startActivity(binoIntent);
            }
        });
    }
}
