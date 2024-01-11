package View;

import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetView;
import Model.Core.Student;

public class ViewClassEng implements iGetView {
    boolean exit = false;

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
        if (exit) in.close();
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
        if (exit) in.close();
        return in.nextInt();
    }
}

