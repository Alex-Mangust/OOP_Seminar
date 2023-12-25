package Domen.Employees;

import java.util.Iterator;
import java.util.List;

public class EmployeesIterator implements Iterator<Employee> {
    private int index;
    private List<Employee> employees;

    /**
     * Конструктор класса
     * @param employees - Коллекция list, состоящая из экземпляров класса Employee
     */
    public EmployeesIterator(List<Employee> employees) {
        this.employees = employees;
        index = 0;
    }

    /**
     * Переопределенный метод, проверяющий не являетсяли текущий экземпляр класса Employee последним в коллекции List employees
     */
    @Override
    public boolean hasNext() {
        return index < employees.size();
    }

    /**
     * Переопределенный метод, возвращающий экземпляр класса Teacher и делающий переход к следующему экземпляру класса в коллекции List teachers
     */
    @Override
    public Employee next() {
        return employees.get(index++);
    }
}
