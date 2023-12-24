package Domen;

import java.util.Iterator;
import java.util.List;

public class StudentIerator implements Iterator<Student>{
    private int count;
    private List<Student> students;
    public StudentIerator(List<Student> students) {
        this.students = students;
        count = 0;
    }

    @Override
    public boolean hasNext() {
        return count < students.size();
    }
    @Override
    public Student next() {
        return students.get(count++);
    }
    
    
}
