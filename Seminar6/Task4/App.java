
public class App {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(); // Создаю экземпляр класса Rectangle
        rectangle.setSide(2, 3); // Задаю стороны для экземпляра класса
        System.out.println(rectangle.area()); // Вывожу площадь экземпляра класса

        Rectangle square = new Square(); // Создаю экземпляр класса Square
        square.setSide(2, 3); // Задаю стороны для экземпляра класса
        System.out.println(square.area()); // Вывожу площадь экземпляра класса

        // В этой задаче я переписал код так, чтобы он соответствовал Liskov Substitution Principle (принципу подстановки Барбары Лисков). Экземпляры базового класса должны быть заменяемые экземплярами классов наследников без изменения корректности программы. Экземпляр класса Square спокойно заменяет экземпляр класса Rectanglee, не нарушая при этом логику программы и не заставляя переписывать код.
    }
}
