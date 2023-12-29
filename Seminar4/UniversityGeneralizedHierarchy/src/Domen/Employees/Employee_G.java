package Domen.Employees;

import Domen.iPerson_G;
import Domen.iWorker_G;

/** Класс, описывающий сотрудника университета. Имеет интерфейсы Comparable, iPerson, iWorker */
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
     * @param salary - зарплата сотрудника
     */
    public Employee_G(String name, int age, String specialication, int salary) {
        // super(name, age, salary);
        this.name = name;
        this.age = age;
        this.specialication = specialication;
        this.salary = salary;    
    }

    /** Метод, возвращающий зарплату сотрудника */
    public int getSalary() {
        return salary;
    }

    /** Метод возвращающий специализацию сотрудника */
    public String getSpecialication() {
        return specialication;
    }

    /** Метод возвращает имя сотрудника */
    public String getName() {
        return name;
    }

    /** Метод возвращает возраст сотрдуника */
    public int getAge() {
        return age;
    }

    /** Метод задает зарплату сотрудника */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /** Метод задает специализацию сотрудника */
    public void setSpecialication(String specialication) {
        this.specialication = specialication;
    }

    /** Метод задает имя сотрудника */
    public void setName(String name) {
        this.name = name;
    }

    /** Метод задает возраст сотрудника */
    public void setAge(int age) {
        this.age = age;
    }

    /** Переопределенный метод, необходимы для сравнения экземпляров классов Employee */
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
