package Domen;

import java.util.Iterator;
import java.util.List;

/** Класс, описывающий итерацию экземпляров класса GroupeStudents */
public class StudentsStreamIterator implements Iterator<GroupeStudents> {
    private int index;
    private List<GroupeStudents> groupeStudents;

    /**
     * Конструктор класса
     * @param groupeStudents - Коллекция list, состоящая из экземпляров класса GroupeStudents
     */
    public StudentsStreamIterator(List<GroupeStudents> groupeStudents) {
        this.groupeStudents = groupeStudents;
        index = 0;
    }

    /** Переопределенный метод, проверяющий не являетсяли текущий экземпляр класса GroupeStudents последним в коллекции List groupeStudents */
    @Override
    public boolean hasNext() {
        return index < groupeStudents.size();
    }

    /** Переопределенный метод, возвращающий экземпляр класса GroupeStudents и делающий переход к следующему экземпляру класса в коллекции List groupeStudents */
    @Override
    public GroupeStudents next() {
        return groupeStudents.get(index++);
    }
}
