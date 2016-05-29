package com.example.olivi.maththatmatters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    public static boolean speedy, perfectionist, netmaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button geoButton = (Button) findViewById(R.id.button_geometry);

        MainActivity.speedy = false;
        MainActivity.perfectionist = false;
        MainActivity.netmaster = false;

        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.adaedit);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setMessage("Hi! My name's Ada Lovelace and I was a mathematician and writer in the 18th century. " +
                                "I wrote the world's first algorithm and am often regarded as the first computer programmer. " +
                                "As you can see, women have played a major role in Science, Technology, Engineering and Math. " +
                                "This game was created by an all female development team. Throughout the game, you'll hear from " +
                                "significant women throughout history.").
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setView(image);
        builder.create().show();

    }

    public void geoClicked(View v) {
        startActivity(new Intent(this, GeometryActivity.class));
    }

    public void measurementClicked(View v) {
        startActivity(new Intent(this, MeasurementActivity.class));
    }

    public void probabilityClicked(View v) {

    }

    public void achievementsClicked(View v) {
        startActivity(new Intent(this, AchievementActivity.class));
    }

}