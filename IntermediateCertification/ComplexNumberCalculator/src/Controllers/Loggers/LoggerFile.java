package Controllers.Loggers;

import java.io.FileWriter;

import Controllers.Interfaces.iLoggerFile;


public class LoggerFile implements iLoggerFile {

    /** Переопределенный метод, необходимый для сохраниния сообщений, событий или информации о выполнении программы в файл */
    @Override
    public void log(String line) {
        try (FileWriter fw = new FileWriter("Logger.txt", true)){ // Создается экземпляр класса FileWriter для записи в файл. В качестве аргумента передается путь к файлу и указывается, что файл открывается в режиме дополнения (append: true)
            fw.write(line); // Записывается строка в файл
            fw.append('\n'); // В конец добавляется символ перехода на новую строку
            fw.flush(); // Происходит сброс буффера
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Переопределенный метод, необходимый для перезаписи файла (При каждом новом запуске программы файл должен очищаться) */
    @Override
    public void rewrite() {
        try (FileWriter fw = new FileWriter("Logger.txt", false)){ // Создается экземпляр класса FileWriter для записи в файл. В качестве аргумента передается путь к файлу и указывается, что файл открывается в режиме перезаписи (append: false)
            fw.write(""); // Записывается пустая строка в файл
            fw.flush(); // Происходит сброс буффера
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
