import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Student<String, Integer> student1 = new Student<>("Алекс", 24);
        Student<String, Integer> student2 = new Student<>("Анна", 24);
        Student<String, Integer> student3 = new Student<>("Влад", 23);
        
        List<Student<String,Integer>> ListStudent = new ArrayList<>();
        ListStudent.add(student1);
        ListStudent.add(student2);
        ListStudent.add(student3);

        GroupeStudents<String,Integer> group = new GroupeStudents<String,Integer>(5555, ListStudent);
        for (Student<String,Integer> student : group) {
            System.out.println(student);
        } 
    }
}
