package Task3;

/** Класс, описывающий куб. Имеет интерфейс VolumetricShape, который является наследником интерфейса Shape */
public class Cube implements VolumetricShape {
    private int edge; // Края куба

    /**
     * Конструктор класса
     * @param edge - края куба
     */
    public Cube(int edge) {
        this.edge = edge;
    }

    /** Переопределенный метод из интерфейса Shape, высчитывающий площадь куба и возвращающий ее*/
    @Override
    public double area() {
        return 6 * edge * edge;
    }

    /** Переопределенный метод из интерфейса VolumetricShape, высчитывающий объем куба и возвращающий его*/
    @Override
    public double volume() {
        return edge * edge * edge;
    }
}