import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domen.GroupeStudents;
import Domen.Student;
import Domen.StudentsStream;

public class App {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student("Иван", 21);
        Student student2 = new Student("Анна", 23);
        Student student3 = new Student("Константин", 20);
        Student student4 = new Student("Сергей", 22);
        Student student5 = new Student("Ольга", 23);
        Student student6 = new Student("Михаил", 21);
        Student student7 = new Student("Мария", 20);
        Student student8 = new Student("Алексей", 23);
        Student student9 = new Student("Александра", 21);
        Student student10 = new Student("Александр", 20);

        Student student11 = new Student("Елена", 23);
        Student student12 = new Student("Глеб", 22);
        Student student13 = new Student("Егор", 21);
        Student student14 = new Student("Анастасия", 20);
        Student student15 = new Student("Ульяна", 23);
        Student student16 = new Student("Денис", 20);
        Student student17 = new Student("Илья", 22);
        Student student18 = new Student("Наталья", 21);
        Student student19 = new Student("Алена", 20);
        Student student20 = new Student("Кирилл", 22);

        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();
        List<Student> students4 = new ArrayList<>();

        students1.add(student3);
        students1.add(student2);
        students1.add(student4);
        students1.add(student11);
        students1.add(student15);
        students1.add(student9);

        students2.add(student5);
        students2.add(student1);
        students2.add(student7);
        students2.add(student16);
        students2.add(student19);
        students2.add(student17);
        students2.add(student20);

        students3.add(student8);
        students3.add(student13);
        students3.add(student14);
        students3.add(student18);

        students4.add(student10);
        students4.add(student12);
        students4.add(student6);

        GroupeStudents studentsGrope1 = new GroupeStudents(5281, students1);
        GroupeStudents studentsGrope2 = new GroupeStudents(5098, students2);
        GroupeStudents studentsGrope3 = new GroupeStudents(5703, students3);
        GroupeStudents studentsGrope4 = new GroupeStudents(5476, students4);

        // for (Student student : studentsGrope1) {
        //     System.out.println(student);
        // }

        // Collections.sort(studentsGrope1.getStudents());
        // System.out.println();
        // for (Student student : studentsGrope1) {
        //     System.out.println(student);
        // }

        StudentsStream studentsStream = new StudentsStream();
        studentsStream.add(studentsGrope1);
        studentsStream.add(studentsGrope4);
        studentsStream.add(studentsGrope2);
        studentsStream.add(studentsGrope3);
        
        System.out.println("Группы не отсортированны");
        System.out.println(studentsStream.getNumberStream() + "\n");
        for (GroupeStudents groupe : studentsStream) {
            System.out.println(groupe);
            int numberRecord = 1;
            for (Student student : groupe) {
                System.out.println(numberRecord + ". " + student);
                numberRecord++;
            }
            numberRecord = 1;
            System.out.println();
        }
        System.out.println();
        System.out.println("Группы отсортированны по количеству студентов (по убыванию)");
        System.out.println(studentsStream.getNumberStream() + "\n");
        Collections.sort((List<GroupeStudents>) studentsStream.getStudentsStreamList());
        for (GroupeStudents groupe : studentsStream) {
            System.out.println(groupe);
            int numberRecord = 1;
            for (Student student : groupe) {
                System.out.println(numberRecord + ". " + student);
                numberRecord++;
            }
            numberRecord = 1;
            System.out.println();
        }
        
        
    }
}
