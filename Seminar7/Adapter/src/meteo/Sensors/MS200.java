package meteo.Sensors;

import java.time.LocalDateTime;

import meteo.Interfaces.iMeteoSensor;

/** Родной датчик системы */
public class MS200 implements iMeteoSensor {
    private int id;

    public MS200(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Float getTemperature() {
        return (float) 20;
    }

    @Override
    public Float getHumidity() {
        return (float) 60;
    }

    @Override
    public Float getPressure() {
        return (float) 752.4;
    }

    @Override
    public LocalDateTime getDataTime() {
        return LocalDateTime.now();
    }
    
}
