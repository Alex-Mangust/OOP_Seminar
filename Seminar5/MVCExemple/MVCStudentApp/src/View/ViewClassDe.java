package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Core.Student;

public class ViewClassDe implements iGetView {
    private boolean exit = false;
    private static String language;

    static {
        language = "Deutsch";
    }

    /**
     * Переопределенный метод, печатающий список студентов
     * @param students - список студентов
     * */
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("-------------Studentenliste-------------");
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
        System.out.print("Geben Sie die ID des Schülers ein, den Sie löschen möchten: ");
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
        return "Geben Sie den Befehl ein:";
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения о завершении команды
     */
    @Override
    public void exitMessage() {
        System.out.println("Beenden Sie das Programm");
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения о результате команады по удалению студента
     */
    @Override
    public void removeMessage(boolean findStudent) {
        if (findStudent) { // Если студент найден, выводится сообщение о успешном удалении
            System.out.println("Entfernung abgeschlossen!");
        } else { // Если студента нет в системе, выводится сообщение о том, что студент не найден
            System.out.println("Student nicht gefunden!");
        }
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения в случае, если программа поддерживает только один язык.
     */
    @Override
    public void onlyLanguageMessage() {
        System.out.println("Das Programm unterstützt nur eine Sprache!");
    }

    /**
     * Переопределенный метод, необходимый для вызова сообщения о попытки задействия нериализованного функционала
     */
    @Override
    public void nonimplementedMessage() {
        System.out.println("Die Funktionalität für diesen Befehl wurde noch nicht implementiert!");
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения о выбранном по умолчанию языке, если пользователь не сделал свой выбор
     */
    @Override
    public void defaultLanguageMessage() {
        System.out.println("Ungültige Eingabe! Die Standardsprache ist Russisch");
    }

    /**
     * Переопределенный метод, необходимый для вывода сообщения в случае, если список студентов пуст
     */
    @Override
    public void listStudentisEmptyMessage() {
        System.out.println("Die Studentenliste ist leer!");
    }

    /**
     * Переопределенный метод, необходимый для выбора пользовательского интерфейса
     */
    @Override
    public String choiceLanguageMessage(boolean firstRun) {
        if (firstRun) {
            System.out.print("Sprache wählen:");
            return "\n";
        }
        return language;
    }
}
