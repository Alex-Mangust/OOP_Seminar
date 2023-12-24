package Domen;

import java.util.Iterator;
import java.util.List;

public class StudentsStreamIterator implements Iterator<GroupeStudents> {
    private int count;
    private List<GroupeStudents> groupeStudents;
    public StudentsStreamIterator(List<GroupeStudents> groupeStudents) {
        this.groupeStudents = groupeStudents;
        count = 0;
    }
    @Override
    public boolean hasNext() {
        return count < groupeStudents.size();
    }
    @Override
    public GroupeStudents next() {
        return groupeStudents.get(count++);
    }
}
