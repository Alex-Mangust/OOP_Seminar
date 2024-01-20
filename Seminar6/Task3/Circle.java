package Task3;

// Переписать код в соответствии с Interface Segregation Principle:

/** Класс, описывающий круг. Имеет интерфейс Shape */
public class Circle implements Shape {
    private double radius; // Радиус круга

    /**
     * Конструктор класса
     * @param radius - радиус круга
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /** Переопределенный метод из интерфейса Shape, высчитывающий площадь круга и возвращающий ее*/
    @Override
    public double area() {
        return 2 * 3.14 * radius;
    }
}

// Подсказка: круг не объемная фигура и этому классу не нужен метод volume().
