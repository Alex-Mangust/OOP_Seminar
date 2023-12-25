package Domen.Teachers;

import java.util.Iterator;
import java.util.List;

import Domen.GroupeInUniversity;

public class GroupeTeachers extends GroupeInUniversity implements Iterable<Teacher>, Comparable<GroupeTeachers>{
    private List<Teacher> teachers;

    /**
     * Конструктор класса
     * @param teachers - список учителей
     */
    public GroupeTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    /** Метод возвращает список преподавателей */
    @Override
    public List<Teacher> getGroupe() {
        return teachers;
    }

    /** Метод задает список преподавателей */
    public void setStudents(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        String stringTeachers = new String(); // Пустая строка, необходимая для записи информации о преподавателях
        int numberRecord = 1; // Номер записи - Каждый преподаватель выводится на новой строке со своим номером
        for (Teacher teacher : teachers) {
            stringTeachers += numberRecord + ". " + teacher.toString() + "\n";
            numberRecord++;
        }
        return String.format("Кол-во преподавателей: %d\n%s\n", teachers.size(), stringTeachers);
    }

    /** Переопределенный метод, необходимый для того чтобы производить итерацию с экземпляром класса GroupeTeachers  */
    @Override
    public Iterator<Teacher> iterator() {
        return new TeacherIterator(teachers);
    }

    /** Переопределенный метод, необходимый для сравнения экземплярами класса GroupeTeachers */
    @Override
    public int compareTo(GroupeTeachers o) {
        if (this.teachers.size() < o.teachers.size()) return 1;
        else if (this.teachers.size() > o.teachers.size()) return -1;
        else return 0;
    }    
}
