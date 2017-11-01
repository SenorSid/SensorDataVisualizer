package de.andma.sensordatavisualizer.sensors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Created by Sid on 01.11.2017.
 */

public abstract class AbstractSensorDataList<T> {
    protected static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.GERMANY);
    protected float minValue = -1;
    protected float maxValue = -1;

    protected SensorType sensorType;

    private List<T> sensorData = new ArrayList<>();

    protected void add(T data) {
        sensorData.add(data);
    }

    protected abstract T parseData(String dataEntry);

    public AbstractSensorDataList read(int sensorId, Date... days) throws URISyntaxException, IOException {
        for (Date day : days) {
            String formattedDate = dateFormat.format(day);
            // TODO Read base url and sensor id from config
            URL oracle = new URL("http://archive.luftdaten.info/" + formattedDate + "/" + formattedDate + "_" + sensorType.getType().toLowerCase() + "_sensor_" + sensorId + ".csv");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            boolean isHeading = true;
            while ((inputLine = in.readLine()) != null) {
                if (isHeading) {
                    isHeading = false;
                    continue;
                }
                add(parseData(inputLine));
            }

            in.close();
        }
        return this;
    }

    public float getMinValue() {
        return minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public List<T> getSensorData() {
        return sensorData;
    }
}
