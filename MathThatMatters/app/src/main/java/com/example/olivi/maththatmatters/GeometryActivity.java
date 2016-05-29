package com.example.olivi.maththatmatters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by olivi on 2016-05-28.
 */
public class GeometryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometry_activity);
        Button netButton = (Button) findViewById(R.id.button_net);

    }

    public void netClicked(View v){
        startActivity(new Intent(this, NetGame.class));
    }

    public void classificationClicked(View v){
        startActivity(new Intent(this, ClassificationGame.class));
    }
    public void measurementClicked(View v){
        startActivity(new Intent(this, MeasurementGame.class));
    }

}
