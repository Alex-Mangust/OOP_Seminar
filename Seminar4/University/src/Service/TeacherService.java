package Service;

import java.util.ArrayList;
import java.util.List;

import Domen.PersonComparator;
import Domen.Teachers.GroupeTeachers;
import Domen.Teachers.Teacher;

public class TeacherService implements iPersonService<Teacher> {
    private int countTeachers;
    private List<Teacher> teachersList;

    public TeacherService() {
        teachersList = new ArrayList<>();
    }
    @Override
    public List<Teacher> getAll() {
        return teachersList;
    }
    public int getCountTeachers() {
        return countTeachers;
    }
    public void add(Teacher teacher) {
        teachersList.add(teacher);
        countTeachers++;
    }
    public void add(GroupeTeachers groupeTeachers) {
        for (Teacher teacher : groupeTeachers) {
            teachersList.add(teacher);
            countTeachers++;
        }
    }

    @Override
    public void create(String name, int age) {
        Teacher teacher = new Teacher(name, age, "Доцент");
        teachersList.add(teacher);
        countTeachers++;
    }
    public void sortByFamily(){
        PersonComparator<Teacher> personComparator = new PersonComparator<Teacher>();
        teachersList.sort(personComparator);
    }
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
}
