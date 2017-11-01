package de.andma.sensordatavisualizer;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import de.andma.sensordatavisualizer.sensors.particulatematter.ParticluateMatters;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitNetwork().build();
        StrictMode.setThreadPolicy(policy);

        ActionBar ab = this.getActionBar();
        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean parentSuccess = super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_options_fragment, menu);
        return parentSuccess;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings_perfScreen) {
            startActivity(new Intent(this, SettingSensorDataActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
