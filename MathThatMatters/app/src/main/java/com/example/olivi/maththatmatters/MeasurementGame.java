package com.example.olivi.maththatmatters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by olivi on 2016-05-28.
 */
public class MeasurementGame extends Activity {
    Button yes1,no1,yes2,no2;
    int[] properShapes,notShapes;
    ImageView img;
    Chronometer chronometer1,chronometer2;
    Boolean roundStarted,proper,answered1,answered2;
    int p1points,p2points;
    TextView points1, points2;

    int[] rounds;
    int currentRound;
    //String currentShape;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_game);

        reset();
        p1points = 0;
        p2points = 0;

        yes1 =  (Button)findViewById(R.id.yes1);
        no1 =  (Button)findViewById(R.id.no1);
        yes2 =  (Button)findViewById(R.id.yes2);
        no2 =  (Button)findViewById(R.id.no2);

        points1 = (TextView) findViewById(R.id.points1);
        points2 = (TextView) findViewById(R.id.points2);

        chronometer1 = (Chronometer) findViewById(R.id.chronometer);
        chronometer2 = (Chronometer) findViewById(R.id.chronometer2);


        img = (ImageView) findViewById(R.id.netImg);

        properShapes = new int[1];
        properShapes[0] = R.drawable.proper_measurment_3;


        notShapes = new int[2];
        notShapes[0] = R.drawable.not_measurment_2;
        notShapes[1] = R.drawable.not_measurment_1;


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Welcome to Classifying Shapes Game! Press ok to start playing")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        playShapes();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


    }

    public void reset(){
        roundStarted = false;
        proper = false;
        answered1 = false;
        answered2 = false;
        currentRound = 0;
    }

    public synchronized void playShapes() {
        //
        rounds = new int[3];
        for (int i = 0; i < rounds.length; i++) {
            rounds[i] = i;
        }
        shuffleArray(rounds);

        playRound(rounds[currentRound]);
    }

    public void playRound(int n){
        roundStarted = true;
        chronometer1.setBase(SystemClock.elapsedRealtime());
        chronometer1.start();
        chronometer2.setBase(SystemClock.elapsedRealtime());
        chronometer2.start();

        yes1.setBackgroundColor(Color.GRAY);
        no1.setBackgroundColor(Color.GRAY);
        yes2.setBackgroundColor(Color.GRAY);
        no2.setBackgroundColor(Color.GRAY);

        answered1 = false;
        answered2 =false;

        int i = n;

        if (i < 1) {
            img.setImageResource(properShapes[i]);
            proper = true;
        } else {
            img.setImageResource(notShapes[i - 1]);
            proper = false;
        }
    }

    public void nextRound(){
        //Both have answered
        points1.setText("" + p1points);
        points2.setText("" + p2points);
        currentRound ++;
        if(currentRound < rounds.length){
            playRound(rounds[currentRound]);

        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Congratulations! You finished the Classification Game.")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    public synchronized void yes1Click(View v){
        if (roundStarted){
            chronometer1.stop();
            answered1 = true;
            if(proper){
                //correct
                p1points ++;
                yes1.setBackgroundColor(Color.GREEN);
            }
            else{
                yes1.setBackgroundColor(Color.RED);
            }
            //notifyAll();
            if(answered2){
                //both answered
                nextRound();
            }
        }
    }

    public synchronized void no1Click(View v){
        if (roundStarted){
            chronometer1.stop();
            answered1 = true;
            if(proper){
                //incorrect
                no1.setBackgroundColor(Color.RED);
            }
            else{
                p1points ++;
                no1.setBackgroundColor(Color.GREEN);
            }
            //notifyAll();
            if(answered2){
                //both answered
                nextRound();
            }
        }
    }

    public synchronized void yes2Click(View v){
        if (roundStarted){
            chronometer2.stop();
            answered2 = true;
            if(proper){
                //correct
                p2points ++;
                yes2.setBackgroundColor(Color.GREEN);
            }
            else{
                yes2.setBackgroundColor(Color.RED);
            }
            //notifyAll();
            if(answered1){
                //both answered
                nextRound();
            }
        }

    }

    public synchronized void no2Click(View v){
        if (roundStarted){
            chronometer2.stop();
            answered2 = true;
            if(proper){
                //incorrect
                no2.setBackgroundColor(Color.RED);
            }
            else{
                p2points ++;
                no2.setBackgroundColor(Color.GREEN);
            }
            //notifyAll();
            if(answered1){
                nextRound();
            }
        }
    }

    //helper function
    // Implementing Fisher–Yates shuffle
    //from: http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}

