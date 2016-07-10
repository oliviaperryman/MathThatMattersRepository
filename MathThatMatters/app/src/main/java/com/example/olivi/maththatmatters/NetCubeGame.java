package com.example.olivi.maththatmatters;

import android.os.Bundle;

import java.util.Map;

/**
 * Created by olivi on 2016-07-10.
 */
public class NetCubeGame extends GameTemplate{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Future: Add more images and make it easier to upload
        super.images.put(R.drawable.proper_cube_net_1_2x2, Boolean.TRUE);
        super.images.put(R.drawable.proper_cube_net_2_2x2, Boolean.TRUE);
        super.images.put(R.drawable.proper_cube_net_3_2x2, Boolean.TRUE);
        super.images.put(R.drawable.not_cube_net_1_2x2, Boolean.FALSE);
        super.images.put(R.drawable.not_cube_net_2_2x2, Boolean.FALSE);
        super.images.put(R.drawable.not_cube_net_3_2x2, Boolean.FALSE);

        img.setImageResource(R.drawable.proper_cube_net_1_2x2);


    }
}
