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
        Student student19 = new Student("Алёна", 20);
        Student student20 = new Student("Кирилл", 22);
        Student student21 = new Student("Руслан", 20);
        Student student22 = new Student("Олеся", 22);

        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();
        List<Student> students4 = new ArrayList<>();
        List<Student> students5 = new ArrayList<>();

        students1.add(student3);
        students1.add(student2);
        students1.add(student4);
        students1.add(student11);
        students1.add(student10);
        students1.add(student5);

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

        students4.add(student15);
        students4.add(student12);
        students4.add(student6);

        students5.add(student9);
        students5.add(student22);
        students5.add(student21);

        GroupeStudents studentsGroupe1 = new GroupeStudents(5281, students1);
        GroupeStudents studentsGroupe2 = new GroupeStudents(5098, students2);
        GroupeStudents studentsGroupe3 = new GroupeStudents(5703, students3);
        GroupeStudents studentsGroupe4 = new GroupeStudents(5476, students4);
        GroupeStudents studentsGroupe5 = new GroupeStudents(5026, students5);

        for (Student student : studentsGroupe1) {
            System.out.println(student);
        }

        // Collections.sort(studentsGroupe1.getStudents());
        // System.out.println();
        // for (Student student : studentsGroupe1) {
        //     System.out.println(student);
        // }

        StudentsStream studentsStream = new StudentsStream();
        studentsStream.add(studentsGroupe1);
        studentsStream.add(studentsGroupe4);
        studentsStream.add(studentsGroupe2);
        studentsStream.add(studentsGroupe5);
        studentsStream.add(studentsGroupe3);
        

        // Вывод c переопределением toString для класса GroupeStudents
        // System.out.println("Группы не отсортированны");
        // System.out.println(studentsStream.getNumberStream() + "\n");
        // for (GroupeStudents groupe : studentsStream) {
        //     System.out.println(groupe);
        //     System.out.println();
        // }
        // System.out.println();

        // System.out.println("Группы отсортированны по количеству студентов и идентификатору группы (по убыванию)");
        // System.out.println("Сами студенты в группах отсортированы по возрасту и идентификатору (по возрастанию)");
        // System.out.println(studentsStream.getNumberStream() + "\n");
        
        // for (GroupeStudents groupe : studentsStream) {
        //     Collections.sort((List<Student>) groupe.getStudents()); 
        //     System.out.println(groupe);
        //     System.out.println();
        // }

        
        // Вывод c переопределением toString для класса GroupeStudents и StudentsStream
        // System.out.println("Группы не отсортированны");
        // System.out.print(studentsStream);
        // Collections.sort((List<GroupeStudents>) studentsStream.getStudentsStreamList());
        // for (GroupeStudents groupe : studentsStream.getStudentsStreamList()) {
        //     Collections.sort((List<Student>) groupe.getStudents()); 
        // }
        // System.out.println("Группы отсортированны по количеству студентов и идентификатору группы (по убыванию)");
        // System.out.println("Сами студенты в группах отсортированы по возрасту и идентификатору (по возрастанию)");
        // System.out.print(studentsStream);


        // Добавляю второй поток
        // List<StudentsStream> university = new ArrayList<StudentsStream>();
        // university.add(studentsStream);
        // StudentsStream studentsStream2 = new StudentsStream();
        // Student student1G2 = new Student("Алена", 20);
        // Student student2G2 = new Student("Кирилл", 22);
        // Student student3G2 = new Student("Руслан", 20);
        // Student student4G2 = new Student("Олеся", 22);

        // List<Student> students1G2 = new ArrayList<>();
        // students1G2.add(student1G2);
        // students1G2.add(student2G2);
        // students1G2.add(student3G2);
        // students1G2.add(student4G2);
        // GroupeStudents groupeStudents6 = new GroupeStudents(9821, students1G2);
        // studentsStream2.add(groupeStudents6);
        // university.add(studentsStream2);
        // Collections.sort((List<GroupeStudents>) studentsStream.getStudentsStreamList());
        // Collections.sort((List<GroupeStudents>) studentsStream2.getStudentsStreamList());
        // for (StudentsStream stream : university) {
        //     for (GroupeStudents groupe : stream.getStudentsStreamList()) {
        //         Collections.sort((List<Student>) groupe.getStudents()); 
        //     }
        //     System.out.println(stream);
        // }
    }
}