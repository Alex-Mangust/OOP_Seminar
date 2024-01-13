import java.util.ArrayList;
import java.util.List;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClassFile;
import Model.ModelClassHash;
import Model.ModelClassList;
import Model.Core.Student;
import View.ViewClass;
import View.ViewClassEng;

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

        // Создаю коллекцию List с экземплярами класса Student
        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();
        List<Student> students3 = new ArrayList<>();

        // Добавляю экземпляры класса Student в коллекцию List
        students1.add(student3);
        students1.add(student2);
        students1.add(student4);
        students1.add(student11);
        students1.add(student9);
        students1.add(student5);
        students1.add(student1);

        students2.add(student7);
        students2.add(student16);
        students2.add(student19);
        students2.add(student17);
        students2.add(student20);
        students2.add(student8);
        students2.add(student13);

        students3.add(student14);
        students3.add(student18);
        students3.add(student15);
        students3.add(student12);
        students3.add(student6);
        students3.add(student10);
        students3.add(student22);
        students3.add(student21);

        iGetModel modelList = new ModelClassList(students1);
        ModelClassFile modelFile = new ModelClassFile("Seminar5\\MVCExemple\\MVCStudentApp\\file\\StudentDB.csv");
        modelFile.saveAllStudentToFile(students3);
        iGetModel modelHash = new ModelClassHash(students2);

        List<iGetModel> allModels = new ArrayList<>();
        allModels.add(modelList);
        allModels.add(modelHash);
        allModels.add(modelFile);

        iGetView viewSimple = new ViewClass();
        iGetView viewSimpleEng = new ViewClassEng();


        ControllerClass controller = new ControllerClass(allModels, viewSimple, viewSimpleEng);
        controller.run();

    }
}
