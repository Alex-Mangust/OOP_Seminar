package Task2;

/** Абстрактный класс, описывающий транспортное средство */
public abstract class Vehicle {
    int maxSpeed; // Максимальная скорость
    String type; // Тип транспортного средства

    /**
     * Конструктор класса
     * @param maxSpeed - максимальная скорость транспортного средства
     * @param type - тип транспортного средства
     */
    public Vehicle(int maxSpeed, String type) {
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    /** Метод, возвращающий максимальную скорость транспортного средства */
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    /** Метод, возвращающий тип транспортного средства */
    public String getType() {
        return this.type;
    }

    /** Метод, возвращающий допустимую скорость транспортного средства (Здесь указан для того, чтобы переопределить его в классах наследниках) */
    public double getAllowedSpeed() {
        return 0;
    }
}