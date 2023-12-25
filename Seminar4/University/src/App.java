import java.util.ArrayList;
import java.util.List;

import Controler.AccountControler;
import Domen.PersonComparator;
import Domen.Employees.Employee;
import Domen.Students.GroupeStudents;
import Domen.Students.Student;
import Domen.Students.StudentsStream;
import Domen.Teachers.Teacher;
import Service.TeacherService;

public class App {
    public static void main(String[] args) throws Exception {
        // Инициализирую экземпляры классов Student
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

        // Создаю коллекции List с экземплярами класса Student
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();
        List<Student> students4 = new ArrayList<>();
        List<Student> students5 = new ArrayList<>();

        // Добавляю экземпляры класса Student в коллекции List
        students1.add(student3);
        students1.add(student2);
        students1.add(student4);
        students1.add(student11);
        students1.add(student9);
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

        students5.add(student10);
        students5.add(student22);
        students5.add(student21);

        // Инициализирую экземпляры класса GroupeStudents и передаю, в качестве аргументов, номера групп и коллекции List, состоящии из экземпляров класса Student
        GroupeStudents studentsGroupe1 = new GroupeStudents(5281, students1);
        GroupeStudents studentsGroupe2 = new GroupeStudents(5098, students2);
        GroupeStudents studentsGroupe3 = new GroupeStudents(5703, students3);
        GroupeStudents studentsGroupe4 = new GroupeStudents(5476, students4);
        GroupeStudents studentsGroupe5 = new GroupeStudents(5026, students5);

        // Вывожу в консоль всех студентов из 1 группы 
        // for (Student student : studentsGroupe1) {
        //     System.out.println(student);
        // }

        // Collections.sort(studentsGroupe1.getStudents());
        // System.out.println();
        // for (Student student : studentsGroupe1) {
        //     System.out.println(student);
        // }

        // Инициализирую экземпляр класса StudentStream (студенческий поток)
        StudentsStream studentsStream = new StudentsStream();
        // Добавляю в экземпляр класса StudentStream экземпляры класса GroupeStudents (группы студентов)
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
        // Collections.sort((List<GroupeStudents>) studentsStream.getStudentsStreamList());  // Сортирую группы
        // for (GroupeStudents groupe : studentsStream) {
        //     Collections.sort((List<Student>) groupe.getStudents());  // Сортирую студентов в каждой группе
        //     System.out.println(groupe);
        //     System.out.println();
        // }

        
        // Вывод c переопределением toString для класса GroupeStudents и StudentsStream
        // System.out.println("Группы не отсортированны");
        // System.out.print(studentsStream); // Вывожу список групп студенческого потока

        // Collections.sort((List<GroupeStudents>) studentsStream.getStudentsStreamList()); // Сортирую группы в студенческом потоке
        // for (GroupeStudents groupe : studentsStream.getStudentsStreamList()) {
        //     Collections.sort((List<Student>) groupe.getStudents());  // Сортирую студентов в каждой группе
        // }
        // System.out.println("Группы отсортированны по количеству студентов и идентификатору группы (по убыванию)");
        // System.out.println("Сами студенты в группах отсортированы по возрасту и идентификатору (по возрастанию)");
        // System.out.print(studentsStream); // Вывожу список групп студенческого потока


        // Добавляю второй поток
        // List<StudentsStream> university = new ArrayList<StudentsStream>(); // Создаю коллекцию List с экземплярами класса StudentStream
        // university.add(studentsStream); // Добавляю в коллекцию первый поток
        // StudentsStream studentsStream2 = new StudentsStream(); // Инициализирую экземпляр класса StudentsStream (Создаю второй поток)
        // Student student1G2 = new Student("Алена", 20);  // Инициализирую экземпляры класса Student
        // Student student2G2 = new Student("Кирилл", 22);
        // Student student3G2 = new Student("Руслан", 20);
        // Student student4G2 = new Student("Олеся", 22);

        // List<Student> students1G2 = new ArrayList<>();  // Инициализирую коллекцию List из экземпляров класса Student
        // students1G2.add(student1G2); // Добавляю в коллекцию студентов
        // students1G2.add(student2G2);
        // students1G2.add(student3G2);
        // students1G2.add(student4G2);
        // GroupeStudents groupeStudents6 = new GroupeStudents(9821, students1G2); // Инициализирую экземпляр класса GroupeStudents и передаю, в качестве аргументов, номер группы и коллекцию List, состоящую из экземпляров класса Student
        // studentsStream2.add(groupeStudents6); // Добавляю во второй поток группу
        // university.add(studentsStream2); // Добавляю в коллекцию university второй поток
        // Collections.sort((List<GroupeStudents>) studentsStream.getStudentsStreamList()); // Сортирую первый поток
        // Collections.sort((List<GroupeStudents>) studentsStream2.getStudentsStreamList()); // Сортирую второй поток
        // for (StudentsStream stream : university) {
        //     for (GroupeStudents groupe : stream.getStudentsStreamList()) {
        //         Collections.sort((List<Student>) groupe.getStudents());  // Сортирую студентов в каждой группе
        //     }
        //     System.out.println(stream); // Вывожу информацию о каждом потоке
        // }

        Teacher teacher = new Teacher("Галина", 50, "Доцент");
        Teacher teacher2 = new Teacher("Валентина", 55, "Кандидат наук");
        Teacher teacher3 = new Teacher("Мария", 55, "Доктор наук");
        Teacher teacher4 = new Teacher("Елена", 36, "Доцент");
        Employee employee = new Employee("Виталий", 32, "Разнорабочий");
        System.out.println(new PersonComparator<Teacher>().compare(teacher, teacher2));
        System.out.println(new PersonComparator<Student>().compare(student21, student22));
        // AccountControler controler = new AccountControler();
        AccountControler.paySalary(teacher, 40000);
        AccountControler.paySalary(employee, 40000);
        System.out.println();
        TeacherService teachers = new TeacherService();
        teachers.add(teacher);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        System.out.println(teachers);
        teachers.sortByFamily();
        System.out.println(teachers);
        System.out.println();
        System.out.println(studentsGroupe1);
        
        System.out.println(AccountControler.averageAge(studentsGroupe1));
    }
}