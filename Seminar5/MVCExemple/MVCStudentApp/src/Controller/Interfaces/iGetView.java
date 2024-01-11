package Controller.Interfaces;

import java.util.List;

import Model.Core.Student;

public interface iGetView {
    void printAllStudents(List<Student> students);

    String prompt(String string);
    void exit(boolean exit);
}
