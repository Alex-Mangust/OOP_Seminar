package Task2;

/** Класс, описывающий автобус. Является наследником класса Vehicle */
public class Bus extends Vehicle {
    private double allowedSpeed; // Допутимая скорость автобуса
    
    /**
     * Конструктор класса
     * @param maxSpeed - максимальная скорость автобуса
     * @param type - тип
     */
    public Bus(int maxSpeed, String type) {
        super(maxSpeed, type);
        this.allowedSpeed = maxSpeed * 0.6;
    }

    /** Переопределенный метод. Возвращает допустимую скорость автобуса */
    @Override
    public double getAllowedSpeed() {
        return allowedSpeed;
    }
    
}
