import java.util.ArrayList;
import java.util.HashMap;
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
import View.ViewClassJa;

public class App {
    public static void main(String[] args) throws Exception {
        // Создаю экземпляры класса Student
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
        
        // Создаю коллекцию HashMap с экземплярами класса Student и с ключами типа Integer
        HashMap<Integer, Student> students3 = new HashMap<>();

        // Добавляю экземпляры класса Student в коллекцию List
        students1.add(student3);
        students1.add(student2);
        students1.add(student4);
        students1.add(student11);
        students1.add(student9);
        students1.add(student5);
        students1.add(student1);

        // Добавляю экземпляры класса Student в коллекцию List
        students2.add(student14);
        students2.add(student18);
        students2.add(student15);
        students2.add(student12);
        students2.add(student6);
        students2.add(student10);
        students2.add(student22);
        students2.add(student21);

        // Добавляю экземпляры класса Student и ключи, которыми являются id экземпляров класса, в коллекцию HashMap 
        students3.put(student7.getId(), student7);
        students3.put(student16.getId(), student16);
        students3.put(student19.getId(), student19);
        students3.put(student17.getId(), student17);
        students3.put(student20.getId(), student20);
        students3.put(student8.getId(), student8);
        students3.put(student13.getId(), student13);
        
        // Инициализирую модели
        iGetModel modelList = new ModelClassList(students1);
        iGetModel modelFile = new ModelClassFile("file\\StudentDB.csv");
        ((ModelClassFile)modelFile).saveAllStudentToFile(students2); // Метод, необходимый для перезаписи файла со студентами, с которым работает модель modelFile
        iGetModel modelHash = new ModelClassHash(students3);

        // Создаю коллекцию List с моделями
        List<iGetModel> allModels = new ArrayList<>();
        
        // Добавляю модели в коллекцию List
        allModels.add(modelList);
        allModels.add(modelHash);
        allModels.add(modelFile);

        // Инициализирую пользовательские интерфейсы
        iGetView viewSimple = new ViewClass();
        iGetView viewSimpleEng = new ViewClassEng();
        iGetView viewSimpleJa = new ViewClassJa();

        // Создаю коллекцию List с пользовательскими интерфейсами
        List<iGetView> allViews = new ArrayList<>();

        // Добавляю пользовательские интерфейсы в коллекцию List
        allViews.add(viewSimple);
        allViews.add(viewSimpleEng);
        allViews.add(viewSimpleJa);

        // Создаю экземпляр класса ControllerClass
        ControllerClass controller = new ControllerClass(allModels, allViews);

        // Вызываю функцию run для запуска программы
        controller.run();

    }
}
