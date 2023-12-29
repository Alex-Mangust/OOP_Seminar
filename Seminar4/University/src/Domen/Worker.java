package Domen;

/** Класс, описывающий работника университета (преподаватель или сотрудник). Является наследником класса Person. Имеет интерфейс Comparable */
public class Worker extends Person implements Comparable<Worker> {
    private int salary;
    /**
     * Конструктор класса
     * @param name - имя работника
     * @param age - возраст работника
     * @param salary - зарплата работника
     */
    public Worker(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }

    /** Метод, возвращающий зарплату работника */
    public int getSalary() {
        return salary;
    }

    /** Переопределенный метод, необходимый для сравнения экземпляров класса Worker */
    @Override
    public int compareTo(Worker o) {
        if (this.getSalary() > o.getSalary()) return -1;
        else if (this.getSalary() < o.getSalary()) return 1;
        if (super.getAge() < o.getAge()) return -1;
        else if (super.getAge() > o.getAge()) return 1;
        return 0;
    }
    
}
