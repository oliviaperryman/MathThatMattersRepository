package com.example.olivi.maththatmatters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by olivi on 2016-07-10.
 */
public class GameTemplate extends Activity{

    Button yes1,no1,yes2,no2;
    ImageView img;

    //List of all the images

    Map <Integer, Boolean> images = new HashMap<Integer, Boolean>();

    Chronometer chronometer1,chronometer2;
    Boolean roundStarted,proper,answered1,answered2;

    int p1points,p2points;
    TextView points1, points2;

    ArrayList<ArrayList<Integer>> rounds =new ArrayList<>();

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

        uploadImgs();

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


    /**
     * Upload images
     *
     */
    private void uploadImgs(){
        switch(MainActivity.gameName){
            case "NetCube":
                //Future: Add more images and make it easier to upload
                images.put(R.drawable.proper_cube_net_1_2x2, Boolean.TRUE);
                images.put(R.drawable.proper_cube_net_2_2x2, Boolean.TRUE);
                images.put(R.drawable.proper_cube_net_3_2x2, Boolean.TRUE);
                images.put(R.drawable.not_cube_net_1_2x2, Boolean.FALSE);
                images.put(R.drawable.not_cube_net_2_2x2, Boolean.FALSE);
                images.put(R.drawable.not_cube_net_3_2x2, Boolean.FALSE);
                break;
            case "NetTetra":
                images.put(R.drawable.proper_tetrahedron_net_one, Boolean.TRUE);
                images.put(R.drawable.proper_tetrahedron_net_two, Boolean.TRUE);
                images.put(R.drawable.not_tetrahedron_net_one, Boolean.FALSE);
                images.put(R.drawable.not_tetrahedron_net_two, Boolean.FALSE);
                break;
        }
    }


}
