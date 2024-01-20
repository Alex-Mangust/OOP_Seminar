package Task1;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee("Alex", new Date(5, 9, 1999) , 100000); // Создаю экземпляр класса Employee
        Accounting accounting = new Accounting(); // Создаю экземпляр класса Accounting
        System.out.println(accounting.calculateNetSalary(employee)); // Вызываю у экземпляра класса Accounting метод для расчета зарплаты для экземпляра класса Employee, который передаю в качестве аргумента для этого метода и печатаю результат в консоль

        // В этой задаче я переписал код, чтобы он соответствовал Single Responsibility Principle (Принципу единственной ответственности). Класс Employee описывает то, что должны делать работники, а класс Accounting описывает то, что должна делать бухгалтерия. Лишние функции, не свойственные им, эти классы не выполняют.
    }
}
