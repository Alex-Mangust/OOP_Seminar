package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Core.Student;

public class ViewClass implements iGetView {
    boolean exit = false;
    private static String language;

    static {
        language = "Русский";
    }

    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("------------Список студентов------------");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------");
    }

    @Override
    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        if (exit)
            in.close();
        return in.nextLine();
    }

    @Override
    public void exit(boolean exit) {
        this.exit = exit;
    }

    @Override
    public int deleteStudent() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите id студента, которого хотите удалить: ");
        if (exit)
            in.close();
        return in.nextInt();
    }

    @Override
    public String languageView() {
        return language;
    }

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

    @Override
    public String inputMessage() {
        return "Введите команду:";
    }

    @Override
    public void exitMessage() {
        System.out.println("Выход из программы");
    }

    @Override
    public void removeMessage(boolean findStudent) {
        if (findStudent) { // Если студент найден, выводится сообщение о успешном удалении
            System.out.println("Удаление завершено!");
        } else { // Если студента нет в системе, выводится сообщение о том, что студент не найден
            System.out.println("Студент не найден!");
        }
    }

    @Override
    public void onlyLanguageMessage() {
        System.out.println("Программа поддерживает только один язык!");
    }

    @Override
    public void nonimplementedMessage() {
        System.out.println("Функционал для этой команды пока не реализован!");
    }

    @Override
    public void defaultLanguageMessage() {
        System.out.println("Выбран язык по умолчанию - русский");
    }

    @Override
    public void listStudentisEmptyMessage() {
        System.out.println("Список студентов пуст!");
    }

    @Override
    public String choiceLanguageMessage(boolean firstRun) {
        if (firstRun) {
            System.out.print("Выберите язык:");
            return "\n";
        }
        return language;
    }
}
