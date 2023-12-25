package Domen.Teachers;

import java.util.Iterator;
import java.util.List;

public class TeacherIterator implements Iterator<Teacher> {
    private int index;
    private List<Teacher> teachers;

    /**
     * Конструктор класса
     * @param teachers - Коллекция list, состоящая из экземпляров класса Teacher
     */
    public TeacherIterator(List<Teacher> teachers) {
        this.teachers = teachers;
        index = 0;
    }

    /** Переопределенный метод, проверяющий не являетсяли текущий экземпляр класса Teacher последним в коллекции List teachers */
    @Override
    public boolean hasNext() {
        return index < teachers.size();
    }

    /** Переопределенный метод, возвращающий экземпляр класса Teacher и делающий переход к следующему экземпляру класса в коллекции List teachers */
    @Override
    public Teacher next() {
        return teachers.get(index++);
    }
}
