package Service;

import java.util.ArrayList;
import java.util.List;

import Domen.PersonComparator;
import Domen.Employees.Employee;

public class EmployeeService implements iPersonService<Employee> {
    private int countEmployee;
    private List<Employee> employeeList;

    public EmployeeService() {
        employeeList = new ArrayList<>();
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }
    public int getCountEmployee() {
        return countEmployee;
    }

    public void add(Employee employee) {
        employeeList.add(employee);
        countEmployee++;
    }

    @Override
    public void create(String name, int age) {
        Employee employee = new Employee(name, age, "Разнорабочий");
        employeeList.add(employee);
        countEmployee++;
    }
    
    public void sortByFamily(){
        PersonComparator<Employee> personComparator = new PersonComparator<Employee>();
        employeeList.sort(personComparator);
    }

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
}
