package Domen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentsStream implements Iterable<GroupeStudents> {
    private List<GroupeStudents> studentsStreamList;
    private int numberStream;
    
    private static int countStream;
    static {
        countStream = 0;
    }

    public StudentsStream() {
        studentsStreamList = new ArrayList<GroupeStudents>();
        countStream++;
        numberStream = countStream;
    }

    public void add(GroupeStudents groupeStudents) {
        studentsStreamList.add(groupeStudents);
    }

    public String getNumberStream() {
        return String.format("Номер потока %d", numberStream);
    }
    public List<GroupeStudents> getStudentsStreamList() {
        return studentsStreamList;
    }
    @Override
    public Iterator<GroupeStudents> iterator() {
        return new StudentsStreamIterator(studentsStreamList);
    }
    @Override
    public String toString() {
        String groupeString = new String();
        for (GroupeStudents groupeStudents : studentsStreamList) {
            groupeString += groupeStudents.toString();
        }
        return String.format("\nНомер потока: %d, Количество групп: %d\n\n%s", numberStream, studentsStreamList.size(), groupeString);
    }

}
// Переопределить методы ToString классов StudentGroup(выводить идентификатор группы, количество студентов и список студентов) и StudentSteam(выводить номер потока, количество групп и список студентов с указанием идентификатора группы)