package com.example.olivi.maththatmatters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by olivi on 2016-05-29.
 */
public class MeasurementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measurement_layout);
        Button netButton = (Button) findViewById(R.id.button_net);

    }

    public void measurementClicked(View v){
        startActivity(new Intent(this, MeasurementGame.class));
    }

}
