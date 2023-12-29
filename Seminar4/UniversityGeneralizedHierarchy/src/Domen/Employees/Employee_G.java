package Domen.Employees;

import Domen.iPerson_G;
import Domen.iWorker_G;

/** Класс, описывающий сотрудника университета. Является наследником класса Worker */
public class Employee_G implements Comparable<Employee_G>, iPerson_G, iWorker_G {
    private String specialication;
    private String name;
    private int age;
    private int salary;

    /**
     * Конструктор класса
     * @param name - имя сотрудника
     * @param age - возраст сотрудника
     * @param specialication - специализация сотрудника
     */
    public Employee_G(String name, int age, String specialication, int salary) {
        // super(name, age, salary);
        this.name = name;
        this.age = age;
        this.specialication = specialication;
        this.salary = salary;    
    }

    /** Метод, возвращающий зарпалту работника */
    public int getSalary() {
        return salary;
    }

    /** Метод возвращающий специализацию сотрудника */
    public String getSpecialication() {
        return specialication;
    }

    /** Метод возвращает имя */
    public String getName() {
        return name;
    }

    
    /** Метод возвращает возраст */
    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSpecialication(String specialication) {
        this.specialication = specialication;
    }

    /** Метод задает имя */
    public void setName(String name) {
        this.name = name;
    }

    /** Метод задает возраст */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee_G o) {
        if (this.getSalary() > o.getSalary()) return -1;
        else if (this.getSalary() < o.getSalary()) return 1;
        if (this.getAge() < o.getAge()) return -1;
        else if (this.getAge() > o.getAge()) return 1;
        return 0;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return String.format("\"Имя - %s; Возраст: %d; Специализация: %s; Зарплата: %d",getName(), getAge(), getSpecialication(), getSalary());
    }
}
