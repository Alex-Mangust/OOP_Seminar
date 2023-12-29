package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Domen.Person_G;
import Domen.PersonComparator_G;
import Domen.Employees.Employee_G;

/** Класс, описывающий работу сервиса с сотрудниками университета. Имеет интерфейсы iPersonService и IworkerService */
public class EmployeeService_G implements iPersonService_G<Employee_G>, iWorkerService_G<Employee_G> {
    private int countEmployee; // Количество сотрудников, с которыми работает текущий сервис
    private List<Employee_G> employeeList; // Список сотрудников, с которыми работает текущий сервис

    /** Конструктор класса */
    public EmployeeService_G() {
        employeeList = new ArrayList<>();
    }

    /** Переопределенный метод. Возвращает список сотрудников, с которыми работает текущий сервис */
    @Override
    public List<Employee_G> getAll() {
        return employeeList;
    }

    /** Метод, возвращающий количество сотрудников, с которыми работает текущий сервис */
    public int getCountEmployee() {
        return countEmployee;
    }

    /** Метод, необходимый для добавления сотрудника к текущему сервису */
    public void add(Person_G<Employee_G> person) {        
        if (Employee_G.class.isAssignableFrom(person.getPerson().getClass())) {
            employeeList.add((Employee_G)person.getPerson());
            countEmployee++;
        }
    }

    /** Метод, необходимый для создания нового экземпляра класса Employee и добавления его к текущему сервису */
    @Override
    public void create(String name, int age) {
        Employee_G employee = new Employee_G(name, age, "Разнорабочий", 30000);
        employeeList.add(employee);
        countEmployee++;
    }
    
    //** Метод, необходимый для сортировки экземпляров класса Employee текущего сервиса */
    public void sortByFamily(){
        PersonComparator_G<Person_G<Employee_G>> personComparator = new PersonComparator_G<>();
        Comparator<Employee_G> employeeComparator = (e1, e2) -> personComparator.compare(new Person_G<>(e1), new Person_G<>(e2));
        employeeList.sort(employeeComparator);
    }

    /** Переопределенный метод, необходимый для получения информации о текущем сервисе */
    @Override
    public String toString() {
        String stringEmployeeList = new String();
        int numberRecord = 1;
        for (Employee_G employee : employeeList) {
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
        for (Employee_G employee : employeeList) {
            outputLine += String.format("Работнику %s выплачено %d рублей\n", employee.getName(), employee.getSalary());
        }
        return outputLine;
    }
}
