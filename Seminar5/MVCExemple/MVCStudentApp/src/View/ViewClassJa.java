package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Core.Student;

public class ViewClassJa implements iGetView {
    boolean exit = false;
    private static String language;

    static {
        language = "Japanese";
    }

    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("----------------学生名簿----------------");
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
        System.out.print("削除したい生徒のIDを入力してください: ");
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
        return "コマンドを入力してください:";
    }

    @Override
    public void exitMessage() {
        System.out.println("プログラムを終了する");
    }

    @Override
    public void removeMessage(boolean findStudent) {
        if (findStudent) { // Если студент найден, выводится сообщение о успешном удалении
            System.out.println("削除完了!");
        } else { // Если студента нет в системе, выводится сообщение о том, что студент не найден
            System.out.println("学生が見つかりません!");
        }
    }

    @Override
    public void onlyLanguageMessage() {
        System.out.println("プログラムは 1 つの言語のみをサポートします!");
    }

    @Override
    public void nonimplementedMessage() {
        System.out.println("このコマンドの機能はまだ実装されていません!");
    }

    @Override
    public void defaultLanguageMessage() {
        System.out.println("デフォルトの言語が選択されました - 日本語");
    }

    @Override
    public void listStudentisEmptyMessage() {
        System.out.println("学生リストが空です!");
    }

    @Override
    public String choiceLanguageMessage(boolean firstRun) {
        if (firstRun) {
            System.out.print("言語を選択:");
            return "\n";
        }
        return language;
    }
}
