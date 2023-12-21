import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domen.GroupeStudents;
import Domen.Student;

public class App {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student("Иван", 21);
        Student student2 = new Student("Анна", 23);
        Student student3 = new Student("Константин", 20);
        Student student4 = new Student("Сергей", 22);
        Student student5 = new Student("Ольга", 23);
        Student student6 = new Student("Михаил", 21);

        List<Student> students = new ArrayList<>();
        students.add(student3);
        students.add(student2);
        students.add(student6);
        students.add(student4);
        students.add(student5);
        students.add(student1);

        GroupeStudents studentsGrope = new GroupeStudents(5281, students);
        
        for (Student student : studentsGrope) {
            System.out.println(student);
        }

        Collections.sort(studentsGrope.getStudents());
        System.out.println();
        for (Student student : studentsGrope) {
            System.out.println(student);
        }
    }
}
