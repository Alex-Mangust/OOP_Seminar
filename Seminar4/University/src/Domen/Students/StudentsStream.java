package Domen.Students;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Класс, описывающий студенческий поток. Имеет интерфейс Iterable */
public class StudentsStream implements Iterable<GroupeStudents> {
    private List<GroupeStudents> studentsStreamList;
    private int numberStream;
    
    private static int countStream;
    static {
        countStream = 0;
    }

    /**
     * Конструктор класса
     * При инициализации экземпляра класса инициализирует новую коллекцию - поток студентов
     */
    public StudentsStream() {
        studentsStreamList = new ArrayList<GroupeStudents>();
        countStream++; // Количество студенческих потоков увеличивается на 1
        numberStream = countStream; // Студенческому потоку присваивается номер
    }

    /**
     * Метод, добавляющий группы студентов в поток
     * @param groupeStudents - группа студентов
     */
    public void add(GroupeStudents groupeStudents) {
        studentsStreamList.add(groupeStudents);
    }

    /** Метод, возвращающий номер потока */
    public String getNumberStream() {
        return String.format("Номер потока %d", numberStream);
    }

    /** Метод, возвращающий колекцию List с группами студентов */
    public List<GroupeStudents> getStudentsStreamList() {
        return studentsStreamList;
    }

    /** Переопределенный метод, необходимый для того чтобы производить итерацию с экземпляром класса StudentStream  */
    @Override
    public Iterator<GroupeStudents> iterator() {
        return new StudentsStreamIterator(studentsStreamList);
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        String groupeString = new String();
        for (GroupeStudents groupeStudents : studentsStreamList) {
            groupeString += groupeStudents.toString();
        }
        return String.format("\nНомер потока: %d, Количество групп: %d\n\n%s", numberStream, studentsStreamList.size(), groupeString);
    }

}