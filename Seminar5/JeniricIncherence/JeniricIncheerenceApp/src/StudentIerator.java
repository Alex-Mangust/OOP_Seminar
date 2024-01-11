import java.util.Iterator;
import java.util.List;

/** Класс, описывающий итерацию экземпляров класса Student */
public class StudentIerator<T extends Comparable<T>,V> implements Iterator<Student<T,V>>{
    private int index;
    private List<Student<T,V>> students;

    /**
     * Конструктор класса
     * @param students - Коллекция list, состоящая из экземпляров класса Student
     */
    public StudentIerator(List<Student<T,V>> students) {
        this.students = students;
        index = 0;
    }

    /** Переопределенный метод, проверяющий не являетсяли текущий экземпляр класса Student последним в коллекции List students */
    @Override
    public boolean hasNext() {
        return index < students.size();
    }

    /** Переопределенный метод, возвращающий экземпляр класса Student и делающий переход к следующему экземпляру класса в коллекции List students */
    @Override
    public Student<T,V> next() {
        return students.get(index++);
    }
    
}
