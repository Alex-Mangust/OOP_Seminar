import meteo.AdapterST500Info;
import meteo.MeteoStore;
import meteo.Interfaces.iMeteoSensor;
import meteo.Sensors.MS200;
import meteo.Sensors.ST500Info;

public class App {
    public static void main(String[] args) throws Exception {
        MeteoStore meteoDB = new MeteoStore();
        iMeteoSensor meteoSensor = new MS200(1);

        AdapterST500Info adapter = new AdapterST500Info(new ST500Info().getData());

        meteoDB.save(adapter);
    }
}
