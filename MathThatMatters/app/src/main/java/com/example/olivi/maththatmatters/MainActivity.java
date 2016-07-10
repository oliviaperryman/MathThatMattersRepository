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

    //Static variables for trophies because every activity needs access to them and they are the same across the app
    //Future: save to file, so don't get reset and use list not individual names
    public static boolean speedy, perfectionist, netmaster;
    public static String gameName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all achievements to false
        //Future: will be kept track of in file (Should have reset button)
        MainActivity.speedy = false;
        MainActivity.perfectionist = false;
        MainActivity.netmaster = false;

        //Getting path to image for tutorial popup
        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.adaedit);

        //The popup tutorial
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setMessage(R.string.tutorial_main).
                        setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setView(image);
        builder.create().show();
    }

    /**
     * Controls what happens when geometry button is clicked
     * Open the new activity for geometry screen
     * @param v
     */
    public void geoClicked(View v) {
        startActivity(new Intent(this, GeometryActivity.class));
    }

    public void measurementClicked(View v) {
        startActivity(new Intent(this, MeasurementActivity.class));
    }

    public void probabilityClicked(View v) {

    }

    //Future: Add other strands of math

    public void achievementsClicked(View v) {
        startActivity(new Intent(this, AchievementActivity.class));
    }

}