package Domen.Employees;

import java.util.Iterator;
import java.util.List;

import Domen.GroupeInUniversity;

public class GroupeEmployees extends GroupeInUniversity implements Iterable<Employee>, Comparable<GroupeEmployees>{
    private List<Employee> employees;

    /**
     * Конструктор класса
     * @param employees - список учителей
     */
    public GroupeEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /** Метод возвращает список преподавателей */
    @Override
    public List<Employee> getGroupe() {
        return employees;
    }

    /** Метод задает список преподавателей */
    public void setStudents(List<Employee> employees) {
        this.employees = employees;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        String stringTeachers = new String(); // Пустая строка, необходимая для записи информации о преподавателях
        int numberRecord = 1; // Номер записи - Каждый преподаватель выводится на новой строке со своим номером
        for (Employee employees : employees) {
            stringTeachers += numberRecord + ". " + employees.toString() + "\n";
            numberRecord++;
        }
        return String.format("Кол-во преподавателей: %d\n%s\n", employees.size(), stringTeachers);
    }

    /** Переопределенный метод, необходимый для того чтобы производить итерацию с экземпляром класса GroupeTeachers  */
    @Override
    public Iterator<Employee> iterator() {
        return new EmployeesIterator(employees);
    }
    /** Переопределенный метод, необходимый для сравнения экземплярами класса GroupeTeachers */
    @Override
    public int compareTo(GroupeEmployees o) {
        if (this.employees.size() < o.employees.size()) return 1;
        else if (this.employees.size() > o.employees.size()) return -1;
        else return 0;
    }    
}
