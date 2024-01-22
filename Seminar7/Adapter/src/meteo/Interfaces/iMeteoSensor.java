package meteo.Interfaces;

import java.time.LocalDateTime;

/** Интефрейс родного датчика */
public interface iMeteoSensor {
        int getId(); // идентификатор датчика
        Float getTemperature(); // температура датчика
        Float getHumidity(); // влажность
        Float getPressure(); // давление
        LocalDateTime getDataTime(); // время чтения данных датчика
}
