package Task5;

/** Класс, описывающий дизельное топливо. Является наследником класса Engine */
public class DieselEngine extends Engine {

    /** Переопределенный метод для вывода сообщения о том, что двигатель машины работает на дизеле */
    public void start() {
        System.out.println("Двигатель машины работает на дизеле.");
    }
}
