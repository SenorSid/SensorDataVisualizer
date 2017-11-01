package de.andma.sensordatavisualizer.sensors;

/**
 * Created by Sid on 01.11.2017.
 */

public enum SensorType {
    PARTICULATE_MATTER("SDS011"),
    HUMIDITY("DHT22");

    private String type;
    private SensorType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
