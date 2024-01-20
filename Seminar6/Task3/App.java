package Task3;

public class App {
    public static void main(String[] args) {
        Circle circle = new Circle(12); // Создаю экземпляр класса Circle
        System.out.println(circle.area()); // Вывожу в консоль площадь circle
        System.out.println();
        Cube cube = new Cube(12); // Создаю экземпляр класса Cube
        System.out.println(cube.area()); // Вывожу в консоль площадь cube
        System.out.println(cube.volume()); // Вывожу в консоль объем cube

        // В этой задаче я переписал код так, чтобы он соответствовал Interface Segregation Principle (принципу разделения интерфейса). Я создал дополнительный интерфейс VolumetricShape (объемная фигура), который стал наследником интерфейса Shape и объявил в нем метод для вычисления объема фигуры.
        // Таким образом не объемная фигура circle имплементирует интерфейс Shape и не имеет метода для вычисления объема, который ей не нужен, а объемная фигура cube имплементирует наследник интерфейса Shape - VolumetricShape и имеет как метод для вычисления объема, объявленный в интерфейсе VolumetricShape, так и метод для вычисления площади, объявленный в интерфейсе-родителе.
    }
    
}
