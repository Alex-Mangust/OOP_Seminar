package Domen;

import java.util.Iterator;
import java.util.List;


public class GroupeStudents implements Iterable<Student> {
    private int numberGroupe;
    List<Student> students;
    public GroupeStudents(int numberGroupe, List<Student> students) {
        this.numberGroupe = numberGroupe;
        this.students = students;
    }

    public int getNumberGroupe() {
        return numberGroupe;
    }
    public void setNumberGroupe(int numberGroupe) {
        this.numberGroupe = numberGroupe;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("Id группы %d", getNumberGroupe());
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIerator(students);
    }

    
    
}
