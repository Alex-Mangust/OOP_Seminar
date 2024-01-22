package Controllers.Interfaces;

/**
 * Интерфейс, объявляющий способ записи сообщений, событий или информации о выполнении программы в файл.
 * Является наследником интерфейса iLogger
 */
public interface iLoggerFile extends iLogger {
    public void rewrite(); // Объявленный метод, необходимый для перезаписи файла
}
