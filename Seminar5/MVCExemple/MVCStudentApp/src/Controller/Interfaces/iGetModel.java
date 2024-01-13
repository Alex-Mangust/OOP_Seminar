package Controller.Interfaces;

import java.util.List;

import Model.Core.Student;

public interface iGetModel {
    public List<Student> getStudents();
    public boolean deleteStudent(int id);
    public void add(Student newStudent);
    public void add(List<Student> newStudents);
}
