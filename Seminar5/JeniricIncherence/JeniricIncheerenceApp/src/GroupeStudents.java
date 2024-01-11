

import java.util.Iterator;
import java.util.List;

/** Класс, описывающий группу студентов. Имеет интерфейсы Iterable и Comparable */
public class GroupeStudents<T extends Comparable<T>,V> implements Iterable<Student<T,V>>, Comparable<GroupeStudents<T,V>> {
    private V numberGroupe;
    private List<Student<T,V>> students;

    /**
     * Конструктор класса
     * @param numberGroupe - номер группы
     * @param students - список студентов
     */
    public GroupeStudents(V numberGroupe, List<Student<T,V>> students) {
        this.numberGroupe = numberGroupe;
        this.students = students;
    }

    /** Метод возвращает номер группы */
    public V getNumberGroupe() {
        return numberGroupe;
    }

    /** Метод задает номер группы */
    public void setNumberGroupe(V numberGroupe) {
        this.numberGroupe = numberGroupe;
    }

    /** Метод возвращает список студентов */
    public List<Student<T,V>> getGroupe() {
        return students;
    }

    /** Метод задает список студентов */
    public void setStudents(List<Student<T,V>> students) {
        this.students = students;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        String stringStudents = new String(); // Пустая строка, необходимая для записи информации о студентах
        int numberRecord = 1; // Номер записи - Каждый студент выводится на новой строке со своим номером
        for (Student<T,V> student : students) {
            stringStudents += numberRecord + ". " + student.toString() + "\n";
            numberRecord++;
        }
        return String.format("Id группы: %d, Кол-во студентов: %d\n%s\n", getNumberGroupe(), students.size(), stringStudents);
    }

    /** Переопределенный метод, необходимый для того чтобы производить итерацию с экземпляром класса GroupeStudent  */
    @Override
    public Iterator<Student<T,V>> iterator() {
        return new StudentIerator<T,V>(students);
    }

    /** Переопределенный метод, необходимый для сравнения экземпляров класса GroupeStudent */
    @Override
    public int compareTo(GroupeStudents<T,V> o) {
        if (this.students.size() < o.students.size()) return 1;
        else if (this.students.size() > o.students.size()) return -1;
        // if (this.numberGroupe < o.numberGroupe) return 1;
        // else if (this.numberGroupe > o.numberGroupe) return -1;
        else return 0;
    }    
    
}
