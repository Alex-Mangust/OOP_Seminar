package Service;

import java.util.ArrayList;
import java.util.List;

import Domen.PersonComparator;
import Domen.Students.GroupeStudents;
import Domen.Students.Student;

// import Domen.GroupeStudents;
// import Domen.PersonComparator;
// import Domen.Student;

public class StudentService implements iPersonService<Student>{
    private int countStudents;
    private List<Student> studentsList;

    public StudentService() {
        studentsList = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return studentsList;
    }

    public int getCountStudents() {
        return countStudents;
    }

    public void add(Student student) {
        studentsList.add(student);
        countStudents++;
    }

    public void add(GroupeStudents groupeStudents) {
        for (Student student : groupeStudents) {
            studentsList.add(student);
            countStudents++;
        }
    }

    @Override
    public void create(String name, int age) {
        Student student = new Student(name, age);
        studentsList.add(student);
        countStudents++;
    }

    public void sortByFamily(){
        PersonComparator<Student> personComparator = new PersonComparator<Student>();
        studentsList.sort(personComparator);
    }
    
    @Override
    public String toString() {
        String stringStudentList = new String();
        int numberRecord = 1;
        for (Student student : studentsList) {
            stringStudentList += numberRecord + ". " + student + "\n";
            numberRecord++;
        }
        return String.format("Список учеников:\n%s", stringStudentList);
    }
}
