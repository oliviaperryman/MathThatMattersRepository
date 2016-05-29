package com.example.olivi.maththatmatters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by olivi on 2016-05-28.
 */
public class NetGame extends Activity {

    Button yes1,no1,yes2,no2;
    int[] properCubes,notCubes, properTetra, notTetra, properOcta, notOcta;
    ImageView img;
    Chronometer chronometer1,chronometer2;
    Boolean roundStarted,proper,answered1,answered2;
    int p1points,p2points;
    TextView points1, points2;

    int[] cubeRounds,tetrahedronRounds,octagonRounds;
    int currentRound;
    String currentShape;


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

        properCubes = new int[3];
        properCubes[0] = R.drawable.proper_cube_net_1_2x2;
        properCubes[1] = R.drawable.proper_cube_net_2_2x2;
        properCubes[2] = R.drawable.proper_cube_net_3_2x2;

        notCubes = new int[3];
        notCubes[0] = R.drawable.not_cube_net_1_2x2;
        notCubes[1] = R.drawable.not_cube_net_2_2x2;
        notCubes[2] = R.drawable.not_cube_net_3_2x2;

        properTetra = new int[2];
        properTetra[0] = R.drawable.proper_tetrahedron_net_one;
        properTetra[1] = R.drawable.proper_tetrahedron_net_two;

        notTetra = new int[2];
        notTetra[0] = R.drawable.not_tetrahedron_net_one;
        notTetra[1] = R.drawable.not_tetrahedron_net_two;

        properOcta = new int[3];
        properOcta[0] = R.drawable.proper_octahedron_net_1;
        properOcta[1] = R.drawable.proper_octahedron_net_2;
        properOcta[2] = R.drawable.proper_octahedron_net_3;

        notOcta = new int[3];
        notOcta[0] = R.drawable.not_octahedron_net_1;
        notOcta[1] = R.drawable.not_octahedron_net_2;
        notOcta[2] = R.drawable.not_octahedron_net_3;


        img.setImageResource(properCubes[0]);


        ImageView cube = new ImageView(this);
        cube.setImageResource(R.drawable.cube);

        AlertDialog.Builder builder2 =
                new AlertDialog.Builder(this).
                        setMessage("Welcome to Cube Stage! Press ok to start playing").
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //countdown();
                                currentShape = "cube";
                                playCubes();
                            }
                        }).
                        setView(cube);
        builder2.create().show();

        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.julia);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this).
                        setMessage("Hi! My name is Julia Bowman Robinson. I am a Mathemetician and taught as a professor at Berkley University. " +
                                "I was the first female Mathemetician to be elected into the National Academy of Sciences. This game is a geometry game " +
                                "to help learn nets of 3D shapes. Use your knowledge of faces, edges and vertices to be the quickest to answer whether" +
                                " the net can be folded into a cube, tetrahedron or octahedron.").
                        setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setView(image);
        builder.create().show();




    }

    public void countdown(){

        AlertDialog.Builder alertDialogBuilder3 = new AlertDialog.Builder(this);


        // set title
        alertDialogBuilder3.setTitle("3");
        // set dialog message
        alertDialogBuilder3.setMessage("3").setCancelable(false);
        // create alert dialog
        final AlertDialog alertDialog3 = alertDialogBuilder3.create();
        // show it
        alertDialog3.show();

        // Execute some code after 2 seconds have passed
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                alertDialog3.dismiss();
                AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(getApplicationContext());
                // set title
                alertDialogBuilder2.setTitle("2");
                // set dialog message
                alertDialogBuilder2.setMessage("2").setCancelable(false);
                // create alert dialog
                final AlertDialog alertDialog2 = alertDialogBuilder2.create();
                // show it
                alertDialog2.show();

                for (int i = 3; i > 1; i--) {

                    // Execute some code after 2 seconds have passed
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            alertDialog2.dismiss();
                            AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(getApplicationContext());
                            // set title
                            alertDialogBuilder1.setTitle("1");
                            // set dialog message
                            alertDialogBuilder1.setMessage("1").setCancelable(false);
                            // create alert dialog
                            final AlertDialog alertDialog1 = alertDialogBuilder1.create();
                            // show it
                            alertDialog1.show();


                            // Execute some code after 2 seconds have passed
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    alertDialog1.dismiss();
                                }
                            }, 1000);
                        }
                    }, 1000);
                }
            }
        }, 1000);



        AlertDialog.Builder alertDialogBuilder1 = new AlertDialog.Builder(this);
        // set title
        alertDialogBuilder1.setTitle("1");
        // set dialog message
        alertDialogBuilder1.setMessage("1").setCancelable(false);
        // create alert dialog
        final AlertDialog alertDialog1 = alertDialogBuilder1.create();
        // show it
        alertDialog1.show();


            // Execute some code after 2 seconds have passed
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog1.dismiss();
                }
            }, 1000);
        }


    public void reset(){
        roundStarted = false;
        proper = false;
        answered1 = false;
        answered2 = false;
        currentRound = 0;
    }

    public synchronized void playCubes(){
        //
        cubeRounds = new int[6];
        for (int i = 0; i < cubeRounds.length; i++){
            cubeRounds[i] = i;
        }
        shuffleArray(cubeRounds);

        playCubeRound(cubeRounds[currentRound]);



/*
        for (int i = 0; i < rounds.length; i++) {

            roundStarted = true;
            chronometer1.setBase(SystemClock.elapsedRealtime());
            chronometer1.start();
            chronometer2.setBase(SystemClock.elapsedRealtime());
            chronometer2.start();

            //0,1,2 are for proper cubes
            if (i < 3) {
                img.setImageResource(properCubes[i]);
                proper = true;
            } else {
                img.setImageResource(notCubes[i - 3]);
                proper = false;
            }

            while (!(answered1 && answered2)) {
                try {
                    wait();
                } catch (InterruptedException e) {

                }
            }
            //Both have answered
            points1.setText(p1points);
            points2.setText(p2points);
        }*/
    }

    public synchronized void playTetrahedron() {
        //
        tetrahedronRounds = new int[4];
        for (int i = 0; i < tetrahedronRounds.length; i++) {
            tetrahedronRounds[i] = i;
        }
        shuffleArray(tetrahedronRounds);

        playTetraRound(tetrahedronRounds[currentRound]);
    }

    public synchronized void playOctagon() {
        octagonRounds = new int[6];
        for (int i = 0; i < octagonRounds.length; i++) {
            octagonRounds[i] = i;
        }
        shuffleArray(octagonRounds);

        playOctaRound(octagonRounds[currentRound]);
    }

    public void playCubeRound(int n){
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


        //0,1,2 are for proper cubes
        if (i < 3) {
            img.setImageResource(properCubes[i]);
            proper = true;
        } else {
            img.setImageResource(notCubes[i - 3]);
            proper = false;
        }
    }

    public void playTetraRound(int n){
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


        //0,1,2 are for proper cubes
        if (i < 2) {
            img.setImageResource(properTetra[i]);
            proper = true;
        } else {
            img.setImageResource(notTetra[i - 2]);
            proper = false;
        }
    }

    public void playOctaRound(int n){
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


        //0,1,2 are for proper cubes
        if (i < 3) {
            img.setImageResource(properOcta[i]);
            proper = true;
        } else {
            img.setImageResource(notOcta[i - 3]);
            proper = false;
        }
    }

    public void nextCubeRound(){
        //Both have answered
        points1.setText("" + p1points);
        points2.setText("" + p2points);
        currentRound ++;
        if(currentRound < cubeRounds.length){
            playCubeRound(cubeRounds[currentRound]);

        }
        else{
            ImageView tetra = new ImageView(this);
            tetra.setImageResource(R.drawable.tetrahedron);

            AlertDialog.Builder builder2 =
                    new AlertDialog.Builder(this).
                            setMessage("You finished the Cube Stage! Let's move on to Tetrahedrons.").
                            setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    reset();
                                    currentShape = "tetrahedron";
                                    playTetrahedron();
                                }
                            }).
                            setView(tetra);
            builder2.create().show();
        }
    }

    public void nextTetraRound(){
        //Both have answered
        points1.setText("" + p1points);
        points2.setText("" + p2points);
        currentRound ++;
        if(currentRound < tetrahedronRounds.length){
            playTetraRound(tetrahedronRounds[currentRound]);

        }else{
            ImageView octa = new ImageView(this);
            octa.setImageResource(R.drawable.octahedron);

            AlertDialog.Builder builder2 =
                    new AlertDialog.Builder(this).
                            setMessage("You finished the Tetrahedron Stage! Let's move on to Octahedrons.").
                            setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    reset();
                                    currentShape = "octagon";
                                    playOctagon();
                                }
                            }).
                            setView(octa);
            builder2.create().show();
        }
    }

    public void nextOctaRound(){
        //Both have answered
        points1.setText("" + p1points);
        points2.setText("" + p2points);
        currentRound ++;
        if(currentRound < octagonRounds.length){
            playOctaRound(octagonRounds[currentRound]);

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You finished the Octahedron Stage! Congratulations you have done all the shapes.")
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
                yes1.setBackgroundColor(Color.DKGRAY);
            }
            else{
                yes1.setBackgroundColor(Color.DKGRAY);
            }
            //notifyAll();
            if(answered2){
                //both answered
                //show correct answer
                if(proper){
                    yes1.setBackgroundColor(Color.GREEN);
                    yes2.setBackgroundColor(Color.GREEN);
                }else{
                    no1.setBackgroundColor(Color.GREEN);
                    no2.setBackgroundColor(Color.GREEN);
                }

                //pause for a second

                // Execute some code after 2 seconds have passed
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //next round
                        switch (currentShape) {
                            case "cube":
                                nextCubeRound();
                                break;
                            case "tetrahedron":
                                nextTetraRound();
                                break;
                            case "octagon":
                                nextOctaRound();
                                break;
                        }
                    }
                }, 1000);


            }
        }
    }

    public synchronized void no1Click(View v){
        if (roundStarted){
            chronometer1.stop();
            answered1 = true;
            if(proper){
                //incorrect
                no1.setBackgroundColor(Color.DKGRAY);
            }
            else{
                p1points ++;
                no1.setBackgroundColor(Color.DKGRAY);
            }
            //notifyAll();
            if(answered2){
                //both answered
                //show correct answer
                if(proper){
                    yes1.setBackgroundColor(Color.GREEN);
                    yes2.setBackgroundColor(Color.GREEN);
                }else{
                    no1.setBackgroundColor(Color.GREEN);
                    no2.setBackgroundColor(Color.GREEN);
                }

                //pause for a second

                // Execute some code after 2 seconds have passed
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (currentShape) {
                            case "cube":
                                nextCubeRound();
                                break;
                            case "tetrahedron":
                                nextTetraRound();
                                break;
                            case "octagon":
                                nextOctaRound();
                                break;
                        }
                    }
                }, 1000);

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
                yes2.setBackgroundColor(Color.DKGRAY);
            }
            else{
                yes2.setBackgroundColor(Color.DKGRAY);
            }
            //notifyAll();
            if(answered1){
                //both answered
                //show correct answer
                if(proper){
                    yes1.setBackgroundColor(Color.GREEN);
                    yes2.setBackgroundColor(Color.GREEN);
                }else{
                    no1.setBackgroundColor(Color.GREEN);
                    no2.setBackgroundColor(Color.GREEN);
                }

                //pause for a second

                // Execute some code after 2 seconds have passed
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (currentShape) {
                            case "cube":
                                nextCubeRound();
                                break;
                            case "tetrahedron":
                                nextTetraRound();
                                break;
                            case "octagon":
                                nextOctaRound();
                                break;
                        }
                    }
                }, 1000);

            }
        }

    }

    public synchronized void no2Click(View v){
        if (roundStarted){
            chronometer2.stop();
            answered2 = true;
            if(proper){
                //incorrect
                no2.setBackgroundColor(Color.DKGRAY);
            }
            else{
                p2points ++;
                no2.setBackgroundColor(Color.DKGRAY);
            }
            //notifyAll();
            if(answered1){
                //both answered
                //show correct answer
                if(proper){
                    yes1.setBackgroundColor(Color.GREEN);
                    yes2.setBackgroundColor(Color.GREEN);
                }else{
                    no1.setBackgroundColor(Color.GREEN);
                    no2.setBackgroundColor(Color.GREEN);
                }

                //pause for a second

                // Execute some code after 2 seconds have passed
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switch (currentShape) {
                            case "cube":
                                nextCubeRound();
                                break;
                            case "tetrahedron":
                                nextTetraRound();
                                break;
                            case "octagon":
                                nextOctaRound();
                                break;
                        }
                    }
                }, 1000);

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
