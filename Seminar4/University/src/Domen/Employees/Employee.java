package Domen.Employees;

import Domen.Worker;

/** Класс, описывающий сотрудника университета. Является наследником класса Worker */
public class Employee extends Worker {
    private String specialication;

    /**
     * Конструктор класса
     * @param name - имя сотрудника
     * @param age - возраст сотрудника
     * @param specialication - специализация сотрудника
     */
    public Employee(String name, int age, String specialication, int salary) {
        super(name, age, salary);
        this.specialication = specialication;
    }

    /** Метод возвращающий специализацию сотрудника */
    public String getSpecialication() {
        return specialication;
    }
    
}
