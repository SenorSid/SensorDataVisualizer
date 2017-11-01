package de.andma.sensordatavisualizer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import de.andma.sensordatavisualizer.sensors.particulatematter.ParticluateMatters;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
            StrictMode.setThreadPolicy(policy);
        }

        // TODO remove ugly test code :D
//        Calendar calendar = Calendar.getInstance(Locale.GERMANY);
//        calendar.set(2017, 9, 31);
//        try {
//            ParticluateMatters particluateMatters = new ParticluateMatters();
//            particluateMatters.read(5837, calendar.getTime());
//            calendar.add(Calendar.DAY_OF_YEAR, -1);
//            particluateMatters.read(5837, calendar.getTime());
//            calendar.add(Calendar.DAY_OF_YEAR, -1);
//            particluateMatters.read(5837, calendar.getTime());
//            System.out.println(particluateMatters.getMinValue() + " - " + particluateMatters.getMaxValue());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
