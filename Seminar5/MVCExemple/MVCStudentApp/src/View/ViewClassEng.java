package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Core.Student;

/**
 * Класс, описывающий поведения пользовательского интерфейса на английском.
 * Имеет интерфейс iGetView
 * */
public class ViewClassEng implements iGetView {
    boolean exit = false; // Поле, обозначающее продолжение работы программы (Добавил для того, чтобы закрыть Scanner)
    private static String language; // Статическое поле, хранящее в себе язык пользовательского интерфейса

    static {
        language = "English";
    }

    /**
     * Переопределенный метод, печатающий список студентов
     * @param students - список студентов
     * */
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("------------Students list------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Переопределенный метод, необходимый для запроса у пользователя команды и возвращения его ввода
     * @param msg - сообщение о запросе ввода
     * */
    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        if (exit)
            in.close();
        return in.nextLine();
    }

    /**
     * Переопределенный метод, необходимый для проверки завершения программы
     * */
    @Override
    public void exit(boolean exit) {
        this.exit = exit;
    }

    /**
     * Переопределенный метод, необходимый для запроса у пользователя id студента для удаления и возвращения его ввода
     */
    @Override
    public int deleteStudent() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the id of the student you want to delete: ");
        if (exit)
            in.close();
        return in.nextInt();
    }

    /**
     * Переопределенный метод, необходимый для возвращения текущего языка отображения
     */
    @Override
    public String languageView() {
        return language;
    }

    /**
     * Переопределенный метод, необходимый для запроса у пользователя предпочитаемого им языка пользовательского интерфейса и возвращающения его ввода 
     */
    @Override
    public int choiceLanguage() {
        Scanner choiceLanguageScanner = new Scanner(System.in);
        try {
            int choice = choiceLanguageScanner.nextInt();
            if (exit)
                choiceLanguageScanner.close();
            return choice;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Переопределенный метод, необходимый для возвращающения введенной пользователем команды
     * */
    @Override
    public String inputMessage() {
        return "Enter the command:";
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения о завершении команды
     */
    @Override
    public void exitMessage() {
        System.out.println("Exit the program");
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения о результате команады по удалению студента
     */
    @Override
    public void removeMessage(boolean findStudent) {
        if (findStudent) { // Если студент найден, выводится сообщение о успешном удалении
            System.out.println("Removal complete!");
        } else { // Если студента нет в системе, выводится сообщение о том, что студент не найден
            System.out.println("Student not found!");
        }
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения в случае, если программа поддерживает только один язык.
     */
    @Override
    public void onlyLanguageMessage() {
        System.out.println("The program only supports one language!");
    }

    /**
     * Переопределенный метод, необходимый для вызова сообщения о попытки задействия нериализованного функционала
     */
    @Override
    public void nonimplementedMessage() {
        System.out.println("The functionality for this command has not yet been implemented!");
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения о выбранном по умолчанию языке, если пользователь не сделал свой выбор
     */
    @Override
    public void defaultLanguageMessage() {
        System.out.println("Invalid input! Default language selected - english");
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения в случае, если список студентов пуст
     */
    @Override
    public void listStudentisEmptyMessage() {
        System.out.println("The list of students is empty!");
    }

    /**
     * Переопределенный метод, необходимый для выбора пользовательского интерфейса
     */
    @Override
    public String choiceLanguageMessage(boolean firstRun) {
        if (firstRun) {
            System.out.print("Select a language:");
            return "\n";
        }
        return language;
    }

}
