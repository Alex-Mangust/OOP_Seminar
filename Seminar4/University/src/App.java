import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Controler.AccountControler;
import Domen.PersonComparator;
import Domen.Employees.Employee;
import Domen.Students.GroupeStudents;
import Domen.Students.Student;
import Domen.Students.StudentsStream;
import Domen.Teachers.Teacher;
import Service.EmployeeService;
import Service.StudentService;
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

        // Collections.sort(studentsGroupe1.getGroupe());
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
        //     Collections.sort((List<Student>) groupe.getGroupe());  // Сортирую студентов в каждой группе
        //     System.out.println(groupe);
        //     System.out.println();
        // }

        
        // Вывод c переопределением toString для класса GroupeStudents и StudentsStream
        // System.out.println("Группы не отсортированны");
        // System.out.print(studentsStream); // Вывожу список групп студенческого потока

        // Collections.sort((List<GroupeStudents>) studentsStream.getStudentsStreamList()); // Сортирую группы в студенческом потоке
        // for (GroupeStudents groupe : studentsStream.getStudentsStreamList()) {
        //     Collections.sort((List<Student>) groupe.getGroupe());  // Сортирую студентов в каждой группе
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
        //         Collections.sort((List<Student>) groupe.getGroupe());  // Сортирую студентов в каждой группе
        //     }
        //     System.out.println(stream); // Вывожу информацию о каждом потоке
        // }

        
        // Инициализирую экземпляры классов StudentService
        StudentService groupe1Servise = new StudentService();
        StudentService groupe2Servise = new StudentService();
        StudentService groupe3Servise = new StudentService();
        StudentService groupe4Servise = new StudentService();
        StudentService groupe5Servise = new StudentService();
        
        // Добавляю в сервисы группы студентов
        groupe1Servise.add(studentsGroupe1);
        groupe2Servise.add(studentsGroupe2);
        groupe3Servise.add(studentsGroupe3);
        groupe4Servise.add(studentsGroupe4);
        groupe5Servise.add(studentsGroupe5);


        // Инициализирую экземпляры классов Teacher
        Teacher teacher = new Teacher("Галина", 50, "Доцент", 65000);
        Teacher teacher2 = new Teacher("Валентина", 55, "Кандидат наук", 80000 );
        Teacher teacher3 = new Teacher("Мария", 55, "Доктор наук", 90000);
        Teacher teacher4 = new Teacher("Елена", 36, "Доцент", 60000);
        
        // Инициализирую экземпляры классов Employee
        Employee employee = new Employee("Виталий", 32, "Разнорабочий", 35000);
        Employee employee2 = new Employee("Михаил", 45, "Охранник", 40000);
        Employee employee3 = new Employee("Галина", 62, "Вахтер", 20000);

        // System.out.println();
        // System.out.println(new PersonComparator<Teacher>().compare(teacher, teacher2)); // Сравниваю экземпляры класса Teacher с помощью метода экземпляра обобщенного класса PersonComparator
        // System.out.println(new PersonComparator<Student>().compare(student21, student22)); // Сравниваю экземпляры класса Student с помощью метода экземпляра обобщенного класса PersonComparator
        // System.out.println();
        
        // Вызываю статический метод paySalary класса AccountControler для выдачи указанному экземпляру класса Teacher указанной суммы
        AccountControler.paySalary(teacher, 40000);

        // Вызываю статический метод paySalary класса AccountControler для выдачи указанному экземпляру класса Employee указанной суммы
        AccountControler.paySalary(employee, 40000);
        System.out.println();
        
        /** Инициализирую экземпляр класса TeacherService */
        TeacherService teachers = new TeacherService();

        /** Добавляю в сервис teachers преподавателей */
        teachers.add(teacher);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        
        /** Инициализирую экземпляр класса EmployeeService */
        EmployeeService employees = new EmployeeService();

        /** Добавляю в сервис emploees сотрудников */
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
        
        System.out.println(teachers); // Вывожу в консоль информацию о всех преподавателях, с которыми работает сервис teachers
        teachers.sortByFamily(); // Сортирую преподавателей, с которыми работает сервис teachers
        System.out.println("Отсортированный"); 
        System.out.println(teachers); // Вывожу в консоль информацию о всех преподавателях, с которыми работает сервис teachers в отсортированном виде 

        System.out.print(employees); // Вывожу в консоль информацию о сотрудниках, с которыми работает сервис employees

        // Вывожу в консоль средний возраст сотрудников, с которыми работает сервис employees
        System.out.println(String.format("Средний возраст: %f", AccountControler.averageAge(employees)));
        System.out.println();

        AccountControler.paySalary(teachers); // Выдаю зарплату всем преподавателям, с которыми работает сервис teachers
        
        // Инициализирую новый экземпляр класса StudentService и вызываю метод merge, который сливает друг с другом сервисы работы со всеми группами студентов (в качестве последних двух агрументов приведен один и тот же сервис, для демонстрации того, что не проходит дублирование)
        StudentService twoGroups = StudentService.merge(groupe1Servise, groupe2Servise, groupe3Servise, groupe4Servise, groupe5Servise, groupe5Servise);
        System.out.println(twoGroups); // Вывожу в консоль информацию о новом сервисе
    }
}