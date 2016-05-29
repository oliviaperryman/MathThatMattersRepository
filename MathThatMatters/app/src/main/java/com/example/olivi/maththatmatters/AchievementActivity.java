package com.example.olivi.maththatmatters;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by olivi on 2016-05-29.
 */
public class AchievementActivity extends Activity{

    ListView list;
    String[] trophy = {
            "Speedy",
            "Perfectionist",
            "Net Master"
    } ;


    Integer[] imageId = {
            R.drawable.trophy_black,
            R.drawable.trophy_black,
            R.drawable.trophy_black

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievements_layout);


        if (MainActivity.speedy) {
            imageId[0] = R.drawable.trophy_speed;
        }
        if (MainActivity.perfectionist) {
            imageId[1] = R.drawable.trophy_all;
        }
        if (MainActivity.netmaster) {
            imageId[2] = R.drawable.trophy_net;
        }

        CustomList adapter = new
                CustomList(AchievementActivity.this, trophy, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(AchievementActivity.this, "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                switch (trophy[+position]) {
                    case ("Speedy"):
                        Toast toast = Toast.makeText(getApplicationContext(), "Finish the measurement game in under 5 minutes", Toast.LENGTH_LONG);
                        toast.show();
                        break;
                    case ("Perfectionist"):
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Finish the measurement game with no mistakes", Toast.LENGTH_LONG);
                        toast2.show();
                        break;
                    case ("Net Master"):
                        Toast toast3 = Toast.makeText(getApplicationContext(), "Finish the net game", Toast.LENGTH_LONG);
                        toast3.show();
                        break;
                }

            }
        });

    }


}
