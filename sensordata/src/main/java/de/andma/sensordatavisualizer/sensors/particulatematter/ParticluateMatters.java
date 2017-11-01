package de.andma.sensordatavisualizer.sensors.particulatematter;

import de.andma.sensordatavisualizer.sensors.AbstractSensorDataList;
import de.andma.sensordatavisualizer.sensors.SensorType;

/**
 * Parses particulate matter data ...
 */

public class ParticluateMatters extends AbstractSensorDataList<ParticulateMatter> {

    public ParticluateMatters() {
        this.sensorType = SensorType.PARTICULATE_MATTER;
    }

    @Override
    protected void add(ParticulateMatter data) {
        super.add(data);
        if ((minValue == -1) || (data.getP1() < minValue)) {
            minValue = data.getP1();
        }
        if ((maxValue == -1) || (data.getP1() > maxValue)) {
            maxValue = data.getP1();
        }
    }

    @Override
    protected ParticulateMatter parseData(String dataEntry) {
        String[] parsedData = dataEntry.split(";");
        float p1 = Float.parseFloat(parsedData[6]);
        float p2 = Float.parseFloat(parsedData[9]);
//        long timestamp = Long.parseLong( parsedData[5]);
        long timestamp = 123l;
        return new ParticulateMatter(p1, p2, timestamp);
    }
}
