import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Controler.AccountControler_G;
import Domen.Person_G;
import Domen.PersonComparator_G;
import Domen.Employees.Employee_G;
import Domen.Students.GroupeStudents_G;
import Domen.Students.Student_G;
import Domen.Students.StudentsStream_G;
import Domen.Teachers.Teacher_G;
import Service.EmployeeService_G;
import Service.StudentService_G;
import Service.TeacherService_G;

public class App {
    public static void main(String[] args) throws Exception {
        // Инициализирую экземпляры классов Person с параметром типа Student
        Person_G<Student_G> student1 = new Person_G<>(new Student_G("Иван", 21));
        Person_G<Student_G> student2 = new Person_G<>(new Student_G("Анна", 23));
        Person_G<Student_G> student3 = new Person_G<>(new Student_G("Константин", 20));
        Person_G<Student_G> student4 = new Person_G<>(new Student_G("Сергей", 22));
        Person_G<Student_G> student5 = new Person_G<>(new Student_G("Ольга", 23));
        Person_G<Student_G> student6 = new Person_G<>(new Student_G("Михаил", 21));
        Person_G<Student_G> student7 = new Person_G<>(new Student_G("Мария", 20));
        Person_G<Student_G> student8 = new Person_G<>(new Student_G("Алексей", 23));
        Person_G<Student_G> student9 = new Person_G<>(new Student_G("Александра", 21));
        Person_G<Student_G> student10 = new Person_G<>(new Student_G("Александр", 20));
        Person_G<Student_G> student11 = new Person_G<>(new Student_G("Елена", 23));
        Person_G<Student_G> student12 = new Person_G<>(new Student_G("Глеб", 22));
        Person_G<Student_G> student13 = new Person_G<>(new Student_G("Егор", 21));
        Person_G<Student_G> student14 = new Person_G<>(new Student_G("Анастасия", 20));
        Person_G<Student_G> student15 = new Person_G<>(new Student_G("Ульяна", 23));
        Person_G<Student_G> student16 = new Person_G<>(new Student_G("Денис", 20));
        Person_G<Student_G> student17 = new Person_G<>(new Student_G("Илья", 22));
        Person_G<Student_G> student18 = new Person_G<>(new Student_G("Наталья", 21));
        Person_G<Student_G> student19 = new Person_G<>(new Student_G("Алёна", 20));
        Person_G<Student_G> student20 = new Person_G<>(new Student_G("Кирилл", 22));
        Person_G<Student_G> student21 = new Person_G<>(new Student_G("Руслан", 20));
        Person_G<Student_G> student22 = new Person_G<>(new Student_G("Олеся", 22));

        // Создаю коллекции List с экземплярами класса Person, имеющих параметр типа Student
        List<Person_G<Student_G>> students1 = new ArrayList<>();
        List<Person_G<Student_G>> students2 = new ArrayList<>();
        List<Person_G<Student_G>> students3 = new ArrayList<>();
        List<Person_G<Student_G>> students4 = new ArrayList<>();
        List<Person_G<Student_G>> students5 = new ArrayList<>();

        // Добавляю экземпляры класса Person, имеющие параметры типа Student в коллекции List
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

        // Инициализирую экземпляры класса GroupeStudents и передаю, в качестве аргументов, номера групп и коллекции List, состоящии из экземпляров класса Person, имеющих параметр типа Student
        GroupeStudents_G studentsGroupe1 = new GroupeStudents_G(5281, students1);
        GroupeStudents_G studentsGroupe2 = new GroupeStudents_G(5098, students2);
        GroupeStudents_G studentsGroupe3 = new GroupeStudents_G(5703, students3);
        GroupeStudents_G studentsGroupe4 = new GroupeStudents_G(5476, students4);
        GroupeStudents_G studentsGroupe5 = new GroupeStudents_G(5026, students5);

        // Вывожу в консоль всех студентов из 1 группы 
        // for (Student_G student : studentsGroupe1) {
        //     System.out.println(student);
        // }

        // Collections.sort(studentsGroupe1.getGroupe()); // Сортирую студентов по возрасту и id
        // System.out.println();
        // for (Student_G student : studentsGroupe1) {
        //     System.out.println(student);
        // }

        // Инициализирую экземпляр класса StudentStream (студенческий поток)
        StudentsStream_G studentsStream = new StudentsStream_G();
        // Добавляю в экземпляр класса StudentStream экземпляры класса GroupeStudents (группы студентов)
        studentsStream.add(studentsGroupe1);
        studentsStream.add(studentsGroupe4);
        studentsStream.add(studentsGroupe2);
        studentsStream.add(studentsGroupe5);
        studentsStream.add(studentsGroupe3);
        

        // Вывод c переопределением toString для класса GroupeStudents
        // System.out.println("Группы не отсортированны");
        // System.out.println(studentsStream.getNumberStream() + "\n");
        // for (GroupeStudents_G groupe : studentsStream) {
        //     System.out.println(groupe); 
        // }
        // System.out.println();

        // System.out.println("Группы отсортированны по количеству студентов и идентификатору группы (по убыванию)");
        // System.out.println("Сами студенты в группах отсортированы по возрасту и идентификатору (по возрастанию)");
        // System.out.println(studentsStream.getNumberStream() + "\n");
        // Collections.sort((List<GroupeStudents_G>) studentsStream.getStudentsStreamList());  // Сортирую группы
        // for (GroupeStudents_G groupe : studentsStream) {
        //     Collections.sort((List<Student_G>) groupe.getGroupe());  // Сортирую студентов в каждой группе
        //     System.out.println(groupe);
        //     System.out.println();
        // }

        
        // Вывод c переопределением toString для класса GroupeStudents и StudentsStream
        // System.out.println("Группы не отсортированны");
        // System.out.print(studentsStream); // Вывожу список групп студенческого потока

        // Collections.sort((List<GroupeStudents_G>) studentsStream.getStudentsStreamList()); // Сортирую группы в студенческом потоке
        // for (GroupeStudents_G groupe : studentsStream.getStudentsStreamList()) {
        //     Collections.sort((List<Student_G>) groupe.getGroupe());  // Сортирую студентов в каждой группе
        // }
        // System.out.println("Группы отсортированны по количеству студентов и идентификатору группы (по убыванию)");
        // System.out.println("Сами студенты в группах отсортированы по возрасту и идентификатору (по возрастанию)");
        // System.out.print(studentsStream); // Вывожу список групп студенческого потока


        // Добавляю второй поток
        // List<StudentsStream_G> university = new ArrayList<StudentsStream_G>(); // Создаю коллекцию List с экземплярами класса StudentStream
        // university.add(studentsStream); // Добавляю в коллекцию первый поток
        // StudentsStream_G studentsStream2 = new StudentsStream_G(); // Инициализирую экземпляр класса StudentsStream (Создаю второй поток)
        // Person_G<Student_G> student1G2 = new Person_G<>(new Student_G("Алена", 20));  // Инициализирую экземпляры класса Person с параметром типа Student
        // Person_G<Student_G> student2G2 = new Person_G<>(new Student_G("Кирилл", 22));
        // Person_G<Student_G> student3G2 = new Person_G<>(new Student_G("Руслан", 20));
        // Person_G<Student_G> student4G2 = new Person_G<>(new Student_G("Олеся", 22));

        // List<Person_G<Student_G>> students1G2 = new ArrayList<>();  // Инициализирую коллекцию List из экземпляров класса Person, которые имеют параметры типа Student
        // students1G2.add(student1G2); // Добавляю в коллекцию студентов
        // students1G2.add(student2G2);
        // students1G2.add(student3G2);
        // students1G2.add(student4G2);
        // GroupeStudents_G groupeStudents6 = new GroupeStudents_G(9821, students1G2); // Инициализирую экземпляр класса GroupeStudents и передаю, в качестве аргументов, номер группы и коллекцию List, состоящую из экземпляров класса Person, которые имеют параметры типа Student
        // studentsStream2.add(groupeStudents6); // Добавляю во второй поток группу
        // university.add(studentsStream2); // Добавляю в коллекцию university второй поток
        // Collections.sort((List<GroupeStudents_G>) studentsStream.getStudentsStreamList()); // Сортирую первый поток
        // Collections.sort((List<GroupeStudents_G>) studentsStream2.getStudentsStreamList()); // Сортирую второй поток
        // for (StudentsStream_G stream : university) {
        //     for (GroupeStudents_G groupe : stream.getStudentsStreamList()) {
        //         Collections.sort((List<Student_G>) groupe.getGroupe());  // Сортирую студентов в каждой группе
        //     }
        //     System.out.println(stream); // Вывожу информацию о каждом потоке
        // }

        
        // Инициализирую экземпляры классов StudentService
        StudentService_G groupe1Servise = new StudentService_G();
        StudentService_G groupe2Servise = new StudentService_G();
        StudentService_G groupe3Servise = new StudentService_G();
        StudentService_G groupe4Servise = new StudentService_G();
        StudentService_G groupe5Servise = new StudentService_G();
        
        // Добавляю в сервисы группы студентов
        groupe1Servise.add(studentsGroupe1);
        groupe2Servise.add(studentsGroupe2);
        groupe3Servise.add(studentsGroupe3);
        groupe4Servise.add(studentsGroupe4);
        groupe5Servise.add(studentsGroupe5);


        // Инициализирую экземпляры классов Person с параметром типа Teacher
        Person_G<Teacher_G> teacher1 = new Person_G<>(new Teacher_G("Галина", 50, "Доцент", 65000));
        Person_G<Teacher_G> teacher2 = new Person_G<>(new Teacher_G("Валентина", 55, "Кандидат наук", 80000));
        Person_G<Teacher_G> teacher3 = new Person_G<>(new Teacher_G("Мария", 55, "Доктор наук", 90000));
        Person_G<Teacher_G> teacher4 = new Person_G<>(new Teacher_G("Елена", 36, "Доцент", 60000));
        
        // Инициализирую экземпляры классов Person с параметром типа Employee
        Person_G<Employee_G> employee1 = new Person_G<>(new Employee_G("Виталий", 32, "Разнорабочий", 35000));
        Person_G<Employee_G> employee2 = new Person_G<>(new Employee_G("Михаил", 45, "Охранник", 40000));
        Person_G<Employee_G> employee3 = new Person_G<>(new Employee_G("Галина", 62, "Вахтер", 20000));

        System.out.println();
        System.out.println(new PersonComparator_G<Person_G<Teacher_G>>().compare(teacher1, teacher2)); // Сравниваю экземпляры класса Person, которые имеют парамер типа Teacher, с помощью метода экземпляра обобщенного класса PersonComparator
        System.out.println(new PersonComparator_G<Person_G<Student_G>>().compare(student21, student22)); // Сравниваю экземпляры класса Person, которые имеют парамер типа Student, с помощью метода экземпляра обобщенного класса PersonComparator
        System.out.println();
        
        /** Вызываю статический метод paySalary класса AccountControler для выдачи указанному экземпляру класса Person, который имеет параметр типа Teacher указанной суммы */
        AccountControler_G.paySalary(teacher1, 40000);

        /** Вызываю статический метод paySalary класса AccountControler для выдачи указанному экземпляру класса Person, который имеет параметр типа Employee указанной суммы */
        AccountControler_G.paySalary(employee1, 40000);
        System.out.println();
        
        /** Инициализирую экземпляр класса TeacherService */
        TeacherService_G teachers = new TeacherService_G();

        /** Добавляю в сервис teachers преподавателей */
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);
        teachers.add(teacher4);
        
        /** Инициализирую экземпляр класса EmployeeService */
        EmployeeService_G employees = new EmployeeService_G();

        /** Добавляю в сервис emploees сотрудников */
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        
        System.out.println(teachers); // Вывожу в консоль информацию о всех преподавателях, с которыми работает сервис teachers
        teachers.sortByFamily(); // Сортирую преподавателей, с которыми работает сервис teachers
        System.out.println("Отсортированный"); 
        System.out.println(teachers); // Вывожу в консоль информацию о всех преподавателях, с которыми работает сервис teachers в отсортированном виде 

        System.out.print(employees); // Вывожу в консоль информацию о сотрудниках, с которыми работает сервис employees

        // Вывожу в консоль средний возраст сотрудников, с которыми работает сервис employees
        System.out.println(String.format("Средний возраст: %f", AccountControler_G.averageAge(employees)));
        System.out.println();

        AccountControler_G.paySalary(teachers); // Выдаю зарплату всем преподавателям, с которыми работает сервис teachers
        
        // Инициализирую новый экземпляр класса StudentService и вызываю метод merge, который сливает вместе сервисы работы со всеми группами студентов (в качестве последних двух агрументов приведен один и тот же сервис, для демонстрации того, что не проходит дублирование)
        StudentService_G twoGroups = StudentService_G.merge(groupe1Servise, groupe2Servise, groupe3Servise, groupe4Servise, groupe5Servise, groupe5Servise);
        System.out.println(twoGroups); // Вывожу в консоль информацию о новом сервисе
    }
}