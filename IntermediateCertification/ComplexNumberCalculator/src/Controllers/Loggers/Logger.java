package Controllers.Loggers;

import Controllers.Interfaces.iLogger;

/** Класс, описывающий способ записи сообщений, событий или информации о выполнении программы */
public class Logger implements iLogger {

    /** Переопределенный метод, для вывода в консоль сообщений, событий или информации о выполнении программы */
    @Override
    public void log(String line) {
        System.out.println(line);
    }
    
}
