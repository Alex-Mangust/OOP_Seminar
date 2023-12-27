package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domen.PersonComparator;
import Domen.Teachers.Teacher;

/** Класс, описывающий работу сервиса с преподавателями университета. Имеет интерфейсы iPersonService и IworkerService */
public class TeacherService implements iPersonService<Teacher>, IWorkerService<Teacher> {
    private int countTeachers; // Количество преподавателей, с которыми работает текущий сервис
    private List<Teacher> teachersList; // Список преподавателей, с которыми работает текущий сервис

    /** Конструктор класса */
    public TeacherService() {
        teachersList = new ArrayList<>();
    }

    /** Переопределенный метод. Возвращает список преподавателей, с которыми работает текущий сервис */
    @Override
    public List<Teacher> getAll() {
        return teachersList;
    }

    /** Метод, возвращающий количество преподавателей, с которыми работает текущий сервис */
    public int getCountTeachers() {
        return countTeachers;
    }

    /** Метод, необходимый для добавления преподавателя к текущему сервису */
    public void add(Teacher teacher) {
        teachersList.add(teacher);
        countTeachers++;
    }

    
    /** Метод, необходимый для создания нового экземпляра класса Teacher и добавления его к текущему сервису */
    @Override
    public void create(String name, int age) {
        Teacher teacher = new Teacher(name, age, "Доцент", 60000);
        teachersList.add(teacher);
        countTeachers++;
    }

    //** Метод, необходимый для сортировки экземпляров класса Teacher текущего сервиса */
    public void sortByFamily(){
        PersonComparator<Teacher> personComparator = new PersonComparator<Teacher>();
        teachersList.sort(personComparator);
    }

    /** Переопределенный метод, необходимый для получения информации о текущем сервисе */
    @Override
    public String toString() {
        String stringTeachersList = new String();
        int numberRecord = 1;
        for (Teacher teacher : teachersList) {
            stringTeachersList += numberRecord + ". " + teacher + "\n";
            numberRecord++;
        }
        return String.format("Список преподавателей:\n%s", stringTeachersList);
    }

    /** Метод, необходимый для выдачи зарплаты преподавателям, с которыми работает текущий сервис */
    public String getSalaryPeoples(){
        String outputLine = new String();
        Collections.sort(teachersList);
        for (Teacher teacher : teachersList) {
            outputLine += String.format("Преподователю %s выплачено %d рублей\n", teacher.getName(), teacher.getSalary());
        }
        return outputLine;
    }
    
}
