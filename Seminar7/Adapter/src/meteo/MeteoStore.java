package meteo;

import meteo.Interfaces.iMeteoSensor;

public class MeteoStore {
    public boolean save(iMeteoSensor meteoSensor) {
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %f ; humidity - %f ; pressure - %f",
                meteoSensor.getId(),
                meteoSensor.getDataTime(),
                meteoSensor.getTemperature(),
                meteoSensor.getHumidity(),
                meteoSensor.getPressure());
        return true;
    }
}
