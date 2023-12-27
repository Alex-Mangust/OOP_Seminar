package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domen.PersonComparator;
import Domen.Employees.Employee;

/** Класс, описывающий работу сервиса с сотрудниками университета. Имеет интерфейсы iPersonService и IworkerService */
public class EmployeeService implements iPersonService<Employee>, IWorkerService<Employee> {
    private int countEmployee; // Количество сотрудников, с которыми работает текущий сервис
    private List<Employee> employeeList; // Список сотрудников, с которыми работает текущий сервис

    /** Конструктор класса */
    public EmployeeService() {
        employeeList = new ArrayList<>();
    }

    /** Переопределенный метод. Возвращает список сотрудников, с которыми работает текущий сервис */
    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    /** Метод, возвращающий количество сотрудников, с которыми работает текущий сервис */
    public int getCountEmployee() {
        return countEmployee;
    }

    /** Метод, необходимый для добавления сотрудника к текущему сервису */
    public void add(Employee employee) {
        employeeList.add(employee);
        countEmployee++;
    }

    /** Метод, необходимый для создания нового экземпляра класса Employee и добавления его к текущему сервису */
    @Override
    public void create(String name, int age) {
        Employee employee = new Employee(name, age, "Разнорабочий", 30000);
        employeeList.add(employee);
        countEmployee++;
    }
    
    //** Метод, необходимый для сортировки экземпляров класса Employee текущего сервиса */
    public void sortByFamily(){
        PersonComparator<Employee> personComparator = new PersonComparator<Employee>();
        employeeList.sort(personComparator);
    }

    /** Переопределенный метод, необходимый для получения информации о текущем сервисе */
    @Override
    public String toString() {
        String stringEmployeeList = new String();
        int numberRecord = 1;
        for (Employee employee : employeeList) {
            stringEmployeeList += numberRecord + ". " + employee + "\n";
            numberRecord++;
        }
        return String.format("Список работников:\n%s", stringEmployeeList);
    }

    /** Метод, необходимый для выдачи зарплаты сотрудникам, с которыми работает текущий сервис */
    @Override
    public String getSalaryPeoples() {
        String outputLine = new String();
        Collections.sort(employeeList);
        for (Employee employee : employeeList) {
            outputLine += String.format("Работнику %s выплачено %d рублей\n", employee.getName(), employee.getSalary());
        }
        return outputLine;
    }
}
