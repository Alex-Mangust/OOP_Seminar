package Task2;


// 2) Переписать код SpeedCalculation в соответствии с Open-Closed Principle:

/** Класс, описывающий калькулятор скорости */
public class SpeedCalculation {
    /**
     * Метод, который расчитывает допустимую скорость для транспортного средства
     * @param vehicle - транспортное средство (Экземпляр класса Vehicle)
     * @return - возвращает допустимую скорость для транспортного средства
     */
    public double calculateAllowedSpeed(Vehicle vehicle) {
        return vehicle.getAllowedSpeed();
    }
}

// Подсказка: создайте два дополнительных класса Car и Bus(наследников Vehicle),
// напишите метод calculateAllowedSpeed(). Использование этого метода позволит
// сделать класс SpeedCalculation соответствующим OCP