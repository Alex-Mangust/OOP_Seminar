package Domen.Students;

import java.util.Iterator;
import java.util.List;

/** Класс, описывающий группу студентов. Имеет интерфейсы Iterable и Comparable */
public class GroupeStudents implements Iterable<Student>, Comparable<GroupeStudents> {
    private int numberGroupe;
    private List<Student> students;

    /**
     * Конструктор класса
     * @param numberGroupe - номер группы
     * @param students - список студентов
     */
    public GroupeStudents(int numberGroupe, List<Student> students) {
        this.numberGroupe = numberGroupe;
        this.students = students;
    }

    /** Метод возвращает номер группы */
    public int getNumberGroupe() {
        return numberGroupe;
    }

    /** Метод задает номер группы */
    public void setNumberGroupe(int numberGroupe) {
        this.numberGroupe = numberGroupe;
    }

    /** Метод возвращает список студентов */
    public List<Student> getGroupe() {
        return students;
    }

    /** Метод задает список студентов */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        String stringStudents = new String(); // Пустая строка, необходимая для записи информации о студентах
        int numberRecord = 1; // Номер записи - Каждый студент выводится на новой строке со своим номером
        for (Student student : students) {
            stringStudents += numberRecord + ". " + student.toString() + "\n";
            numberRecord++;
        }
        return String.format("Id группы: %d, Кол-во студентов: %d\n%s\n", getNumberGroupe(), students.size(), stringStudents);
    }

    /** Переопределенный метод, необходимый для того чтобы производить итерацию с экземпляром класса GroupeStudent  */
    @Override
    public Iterator<Student> iterator() {
        return new StudentIerator(students);
    }

    /** Переопределенный метод, необходимый для сравнения экземпляров класса GroupeStudent */
    @Override
    public int compareTo(GroupeStudents o) {
        if (this.students.size() < o.students.size()) return 1;
        else if (this.students.size() > o.students.size()) return -1;
        if (this.numberGroupe < o.numberGroupe) return 1;
        else if (this.numberGroupe > o.numberGroupe) return -1;
        else return 0;
    }    
    
}
