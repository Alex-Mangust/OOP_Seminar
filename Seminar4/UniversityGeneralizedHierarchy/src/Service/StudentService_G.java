package Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import Domen.Person_G;
import Domen.PersonComparator_G;
import Domen.Students.GroupeStudents_G;
import Domen.Students.Student_G;

// import Domen.GroupeStudents;
// import Domen.PersonComparator;
// import Domen.Student;

/**
 * Класс, описывающий работу сервиса со студентами университета. Имеет интерфейс
 * iPersonService
 */
public class StudentService_G implements iPersonService_G<Student_G> {
    private int countStudents; // Количество студентов, с которыми работает текущий сервис
    private List<Student_G> studentsList; // Список студентов, с которыми работает текущий сервис

    /** Конструктор класса. */
    public StudentService_G() {
        studentsList = new ArrayList<>();
    }

    /**
     * Переопределенный метод. Возвращает список студентов, с которыми работает
     * текущий сервис
     */
    @Override
    public List<Student_G> getAll() {
        return studentsList;
    }

    /**
     * Метод, возвращающий количество студентов, с которыми работает текущий сервис
     */
    public int getCountStudents() {
        return countStudents;
    }

    /** Метод, необходимый для добавления студентов к текущему сервису */
    public void add(Person_G<Student_G> student) {
        studentsList.add(student.getPerson());
        countStudents++;
    }

    /** Метод, необходимый для добавления групп студентов к текущему сервису */
    public void add(GroupeStudents_G groupeStudents) {
        for (Student_G student : groupeStudents) {
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
    public static StudentService_G merge(StudentService_G... service) {
        Set<StudentService_G> setService = new LinkedHashSet<>(Arrays.asList(service));
        StudentService_G newService = new StudentService_G();
        for (StudentService_G studentService : setService) {
            for (Student_G student : studentService.getAll()) {
                Person_G<Student_G> person = new Person_G<>(student);
                newService.add(person);
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
        Student_G student = new Student_G(name, age);
        studentsList.add(student);
        countStudents++;
    }

    /**
     * Метод, необходимый для сортировки экземпляров класса Student текущего сервиса
     */
    public void sortByFamily() {
        PersonComparator_G<Person_G<Student_G>> personComparator = new PersonComparator_G<>();
        Comparator<Student_G> studentComparator = (e1, e2) -> personComparator.compare(new Person_G<>(e1), new Person_G<>(e2));
        studentsList.sort(studentComparator);
    }

    /**
     * Переопределенный метод, необходимый для получения информации о текущем
     * сервисе
     */
    @Override
    public String toString() {
        String stringStudentList = new String();
        int numberRecord = 1;
        for (Student_G student : studentsList) {
            stringStudentList += numberRecord + ". " + student + "\n";
            numberRecord++;
        }
        return String.format("Список учеников:\n%s", stringStudentList);
    }
}
