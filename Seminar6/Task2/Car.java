package Task2;

/** Класс, описывающий машину. Является наследником класса Vehicle */
public class Car extends Vehicle {
    private double allowedSpeed; // Допутимая скорость машины

    /**
     * Конструктор класса
     * @param maxSpeed - максимальная скорость машины
     * @param type - тип
     */
    public Car(int maxSpeed, String type) {
        super(maxSpeed, type);
        this.allowedSpeed = maxSpeed * 0.8;
    }
    
    /** Переопределенный метод. Возвращает допустимую скорость машины */
    @Override
    public double getAllowedSpeed() {
        return allowedSpeed;
    }

    
}
