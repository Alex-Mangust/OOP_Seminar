package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Domen.Person_G;
import Domen.PersonComparator_G;
import Domen.Teachers.Teacher_G;

/** Класс, описывающий работу сервиса с преподавателями университета. Имеет интерфейсы iPersonService и IworkerService */
public class TeacherService_G implements iPersonService_G<Teacher_G>, iWorkerService_G<Teacher_G> {
    private int countTeachers; // Количество преподавателей, с которыми работает текущий сервис
    private List<Teacher_G> teachersList; // Список преподавателей, с которыми работает текущий сервис

    /** Конструктор класса */
    public TeacherService_G() {
        teachersList = new ArrayList<>();
    }

    /** Переопределенный метод. Возвращает список преподавателей, с которыми работает текущий сервис */
    @Override
    public List<Teacher_G> getAll() {
        return teachersList;
    }

    /** Метод, возвращающий количество преподавателей, с которыми работает текущий сервис */
    public int getCountTeachers() {
        return countTeachers;
    }

    /** Метод, необходимый для добавления преподавателя к текущему сервису */
    public void add(Person_G<Teacher_G> person) {
        if (Teacher_G.class.isAssignableFrom(person.getPerson().getClass())) {
            teachersList.add((Teacher_G)person.getPerson());
            countTeachers++;
        }
    }

    
    /** Метод, необходимый для создания нового экземпляра класса Teacher и добавления его к текущему сервису */
    @Override
    public void create(String name, int age) {
        Teacher_G teacher = new Teacher_G(name, age, "Доцент", 60000);
        teachersList.add(teacher);
        countTeachers++;
    }

    //** Метод, необходимый для сортировки экземпляров класса Teacher текущего сервиса */
    public void sortByFamily(){
        PersonComparator_G<Person_G<Teacher_G>> personComparator = new PersonComparator_G<>();
        Comparator<Teacher_G> teacherComparator = (e1, e2) -> personComparator.compare(new Person_G<>(e1), new Person_G<>(e2));
        teachersList.sort(teacherComparator);
    }

    /** Переопределенный метод, необходимый для получения информации о текущем сервисе */
    @Override
    public String toString() {
        String stringTeachersList = new String();
        int numberRecord = 1;
        for (Teacher_G teacher : teachersList) {
            stringTeachersList += numberRecord + ". " + teacher + "\n";
            numberRecord++;
        }
        return String.format("Список преподавателей:\n%s", stringTeachersList);
    }

    /** Метод, необходимый для выдачи зарплаты преподавателям, с которыми работает текущий сервис */
    public String getSalaryPeoples(){
        String outputLine = new String();
        Collections.sort(teachersList);
        for (Teacher_G teacher : teachersList) {
            outputLine += String.format("Преподователю %s выплачено %d рублей\n", teacher.getName(), teacher.getSalary());
        }
        return outputLine;
    }
    
}
