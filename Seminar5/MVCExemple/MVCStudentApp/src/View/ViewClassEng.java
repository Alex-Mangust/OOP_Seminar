package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Core.Student;

public class ViewClassEng implements iGetView {
    boolean exit = false;
    private static String language;

    static {
        language = "English";
    }

    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("------------Students list------------");
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
        System.out.print("Enter the id of the student you want to delete: ");
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
        return "Enter the command:";
    }

    @Override
    public void exitMessage() {
        System.out.println("Exit the program");
    }

    @Override
    public void removeMessage(boolean findStudent) {
        if (findStudent) { // Если студент найден, выводится сообщение о успешном удалении
            System.out.println("Removal complete!");
        } else { // Если студента нет в системе, выводится сообщение о том, что студент не найден
            System.out.println("Student not found!");
        }
    }

    @Override
    public void onlyLanguageMessage() {
        System.out.println("The program only supports one language!");
    }

    @Override
    public void nonimplementedMessage() {
        System.out.println("The functionality for this command has not yet been implemented!");
    }

    @Override
    public void defaultLanguageMessage() {
        System.out.println("Default language selected - english");
    }

    @Override
    public void listStudentisEmptyMessage() {
        System.out.println("The list of students is empty!");
    }

    @Override
    public String choiceLanguageMessage(boolean firstRun) {
        if (firstRun) {
            System.out.print("Select a language:");
            return "\n";
        }
        return language;
    }

}
