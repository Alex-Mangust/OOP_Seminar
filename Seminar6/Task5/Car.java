package Task5;

// 5) Переписать код в соответствии с Dependency Inversion Principle:

/** Класс, описывающий машину */
public class Car {
    private Engine engine; // Топливо для машины

    /**
     * Конструктор класса
     * @param engine - топливо
     */
    public Car(Engine engine) {
        this.engine = engine;
    }

    /** Метод для вывода сообщения о том, на каком топливе работает двигатель машины */
    public void start() {
        this.engine.start();
    }
}
// Разорвать зависимость классов Car и PetrolEngine. У машины же может быть
// DieselEngine.