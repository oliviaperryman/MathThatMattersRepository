package com.example.olivi.maththatmatters;

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

        Button geoButton = (Button) findViewById(R.id.button_geometry);
    }

    public void geoClicked(View v){
        startActivity(new Intent(this, GeometryActivity.class));
    }
}
