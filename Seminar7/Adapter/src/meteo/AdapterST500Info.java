package meteo;

import java.time.LocalDateTime;

import meteo.Interfaces.iMeteoSensor;
import meteo.Interfaces.iSensorTemperature;

public class AdapterST500Info implements iMeteoSensor {

    private iSensorTemperature adapter;

    public AdapterST500Info(iSensorTemperature adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getId() {
        return adapter.identifier();
    }

    @Override
    public Float getTemperature() {
        return (float) adapter.temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDataTime() {
        LocalDateTime dateTime = LocalDateTime.of(adapter.year(), 1, 1, 0, 0);
        dateTime = dateTime.plusDays(adapter.day() - 1);
        dateTime = dateTime.plusSeconds(adapter.second());
        return dateTime;
    }
    
}
