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
    

}
