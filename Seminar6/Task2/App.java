package Task2;

public class App {
    public static void main(String[] args) {
        Vehicle bus = new Bus(100, "Автобус"); // Создаю экземпляр класса Bus
        Vehicle car = new Car(100, "Машина"); // Создаю экземпляр класса Car
        SpeedCalculation speedCalculation = new SpeedCalculation(); // Создаю экземпляр класса SpeedCalculation
        System.out.println(speedCalculation.calculateAllowedSpeed(bus)); // Вызываю у экземпляра класса SpeddCalculation метод, который расчитывает допустимую скорость для экземпляра класса Bus
        System.out.println(speedCalculation.calculateAllowedSpeed(car)); // Вызываю у экземпляра класса SpeddCalculation метод, который расчитывает допустимую скорость для экземпляра класса Car

        // В этой задаче я переписал код так, чтобы он соответствовал Open-Closed Principle (Принципу открытости/закрытости). Метод calculateAllowedSpeed в классе SpeedCalculation закрыт для модификаций, но открыт для расширения. Не важно, какое транспортное средство будет обрабатывать этот метод, пока класс, описывающий это транспортное средство, является наследником класса Vehicle, расчет допустимой скорости будет высчитываться согласно логике, описанной в классе этого транспортного средства.
    }
}
