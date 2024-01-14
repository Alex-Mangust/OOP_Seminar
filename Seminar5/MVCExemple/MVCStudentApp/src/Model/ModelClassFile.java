package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

/**
 * Класс описывающий поведения модели работы с файлом, в котором записаны
 * студенты. Имеет интерфейс iGetModel
 */
public class ModelClassFile implements iGetModel {
    private String fileName; // Название файла или путь к файлу

    /**
     * Конструктор класса
     * 
     * @param fileName - Название файла или путь к файлу
     */
    public ModelClassFile(String fileName) {
        this.fileName = fileName;

        try (FileWriter fw = new FileWriter(fileName, true)) { // Создаю экземпляр класса FileWriter для записи в файл. В качестве аргумента передаю путь к файлу и указываю, что открываю файл в режиме дополнения (append: true)
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /** Переопределенный метод, возвращает список студентов */
    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>(); // Создается список, в котором будут храниться студенты из файла
        try {
            File file = new File(fileName); // Создается экземпляр класса file, который представляет собой абстракцию файла
            FileReader fr = new FileReader(file); // Создается экземпляр класса FileReader, для чтения файла
            try (BufferedReader reader = new BufferedReader(fr)) { // Создается экземпляр класса BufferedReader для более эффективного способо чтения текста из FileReader. Он считывает текст блоками, а не по одному символу.
                String line = reader.readLine(); // Считывается одна строка текста и записывается в переменную line
                while (line != null) {
                    String[] param = line.split(" "); // Создается массив String, в который добавляется элементы из line (элементы определяются по пробелу между словами)
                    Student pers = new Student(param[0], Integer.parseInt(param[1]), Integer.parseInt(param[2])); // Создается новый экземпляр класса Student. Нулевой элемент массива - имя, первый элемент массива - возраст, второй элемент массива - id
                    students.add(pers); // Студент добавляется в список студентов
                    line = reader.readLine(); // В переменную line записывается следующая строка
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students; // Возвращается список студентов
    }

    /**
     * Метод, записывающий студентов в файл (Полностью перезаписывает файл)
     * 
     * @param students - список студентов
     */
    public void saveAllStudentToFile(List<Student> students) {
        try (FileWriter fw = new FileWriter(fileName, false)) { // Создаю экземпляр класса FileWriter для записи в файл. В качестве аргумента передаю путь к файлу и указываю, что открываю файл в режиме перезаписи (append: false)
            for (Student pers : students) {
                fw.write(pers.getName() + " " + pers.getAge() + " " + pers.getId()); // Записывается строка в файл (имя студента, возраст, id через пробел)
                fw.append('\n'); // В конец добавляется символ перехода на новую строку
            }
            fw.flush(); // Происходит сброс буффера
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод, записывающий студентов в файл (Дописывает новые значения, не удаляя
     * старые)
     * 
     * @param students - список студентов
     */
    private void addAllStudentToFile(List<Student> students) {
        try (FileWriter fw = new FileWriter(fileName, true)) { // Создаю экземпляр класса FileWriter для записи в файл. В качестве аргумента передаю путь к файлу и указываю, что открываю файл в режиме дополнения (append: true)
            for (Student pers : students) {
                fw.write(pers.getName() + " " + pers.getAge() + " " + pers.getId()); // Записывается строка в файл (имя студента, возраст, id через пробел)
                fw.append('\n'); // В конец добавляется символ перехода на новую строку
            }
            fw.flush(); // Происходит сброс буффера
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Переопределенный метод, необходимый для удаления студента из файла
     * 
     * @param id - id студента, которого необходимо удалить
     * Возвращает true, если студент найден и false, если нет.
     */
    @Override
    public boolean deleteStudent(int id) {
        boolean successfulDeletion = false; // Переменная, отвечающая за успешное удаление
        List<Student> students = getStudents(); // Получаю список студентов
        int idFind = 0; // Переменная, в которой будет храниться id найденного студента для удаления 
        for (Student student : students) {
            if (student.getId() == id) {
                successfulDeletion = true;
                break; // Если студент найден, цикл завершается досрочно.
            }
            idFind++;
        }
        if (successfulDeletion)
            students.remove(students.get(idFind)); // Происходит удаление
        saveAllStudentToFile(students); // Происходит перезапись файла
        return successfulDeletion;
    }

    /** 
     * Переопределенный метод, добавляющий список студентов
     * @param newStudents - список новых студентов
     */
    @Override
    public void add(List<Student> newStudents) {
        addAllStudentToFile(newStudents);
    }

    /** 
     * Переопределенный метод, добавляющий одного студента
     * @param newStudent - новый студент
     */
    @Override
    public void add(Student newStudent) {
        List<Student> newStudents = new ArrayList<>();
        newStudents.add(newStudent);
        this.add(newStudents);
    }

    /** 
     * Переопределенный метод, добавляющий произвольное количество студентов
     * @param newStudents - новые студенты
    */
    @Override
    public void add(Student... newStudents) {
        for (Student student : newStudents) {
            this.add(student);
        }
    }
}