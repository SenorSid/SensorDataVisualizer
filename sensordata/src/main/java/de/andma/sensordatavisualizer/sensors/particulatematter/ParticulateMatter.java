package de.andma.sensordatavisualizer.sensors.particulatematter;

import de.andma.sensordatavisualizer.sensors.AbstractSensorData;

/**
 * Created by Sid on 01.11.2017.
 */

public class ParticulateMatter extends AbstractSensorData {
    float p1;
    float p2;
    long timestamp;

    public ParticulateMatter(float p1, float p2, long timestamp) {
        this.p1 = p1;
        this.p2 = p2;
        this.timestamp = timestamp;
    }

    public float getP1() {
        return p1;
    }

    public float getP2() {
        return p2;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
