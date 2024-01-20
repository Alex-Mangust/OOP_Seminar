// 4) Переписать код в соответствии с Liskov Substitution Principle:
/** Класс, описывающий прямоугольник */
public class Rectangle {
    protected int width; // Ширина прямоугольника
    protected int height; // Высота прямоугольника

    /**
     * Метод, который задает стороны прямоугольника
     * @param width - ширина
     * @param height - высота
     */
    public void setSide(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /** Метод, для вычисления площади */
    public int area() {
        return this.width * this.height;
    }
}

