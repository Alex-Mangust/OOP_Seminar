package Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import Domen.PersonComparator;
import Domen.Students.GroupeStudents;
import Domen.Students.Student;

/**
 * Класс, описывающий работу сервиса со студентами университета. Имеет интерфейс
 * iPersonService
 */
public class StudentService implements iPersonService<Student> {
    private int countStudents; // Количество студентов, с которыми работает текущий сервис
    private List<Student> studentsList; // Список студентов, с которыми работает текущий сервис

    /** Конструктор класса. */
    public StudentService() {
        studentsList = new ArrayList<>();
    }

    /**
     * Переопределенный метод. Возвращает список студентов, с которыми работает
     * текущий сервис
     */
    @Override
    public List<Student> getAll() {
        return studentsList;
    }

    /**
     * Метод, возвращающий количество студентов, с которыми работает текущий сервис
     */
    public int getCountStudents() {
        return countStudents;
    }

    /** Метод, необходимый для добавления студентов к текущему сервису */
    public void add(Student student) {
        studentsList.add(student);
        countStudents++;
    }

    /** Метод, необходимый для добавления групп студентов к текущему сервису */
    public void add(GroupeStudents groupeStudents) {
        for (Student student : groupeStudents) {
            studentsList.add(student);
            countStudents++;
        }
    }

    /**
     * Статический метод, объеденяющий сервисы работы со студентами в один новый
     * сервис.
     * @param service массив сервисов студентов
     * @return объединенный сервис студентов
     * (Дублирующие сервисы в слиянии не учитываются)
     */
    public static StudentService merge(StudentService... service) {
        Set<StudentService> setService = new LinkedHashSet<>(Arrays.asList(service));
        StudentService newService = new StudentService();
        for (StudentService studentService : setService) {
            for (Student student : studentService.getAll()) {
                newService.add(student);
            }
        }
        return newService;
    }

    /**
     * Метод, необходимый для создания нового экземпляра класса Student и добавления
     * его к текущему сервису
     */
    @Override
    public void create(String name, int age) {
        Student student = new Student(name, age);
        studentsList.add(student);
        countStudents++;
    }

    /**
     * Метод, необходимый для сортировки экземпляров класса Student текущего сервиса
     */
    public void sortByFamily() {
        PersonComparator<Student> personComparator = new PersonComparator<Student>();
        studentsList.sort(personComparator);
    }

    @Override
    public String toString() {
        String stringStudentList = new String();
        int numberRecord = 1;
        for (Student student : studentsList) {
            stringStudentList += numberRecord + ". " + student + "\n";
            numberRecord++;
        }
        return String.format("Список учеников:\n%s", stringStudentList);
    }
}
