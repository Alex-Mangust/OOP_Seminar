package Model;

import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassList implements iGetModel {
    private List<Student> students;

    public ModelClassList(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean successfulDeletion = false;
        Integer idRemove = null;
        int idFind = 0;
        for (Student student : students) {
            if (student.getId() == id) {
                successfulDeletion = true;
                idRemove = idFind;    
            }
            idFind++;
        }
        if (idRemove != null) students.remove(students.get(idRemove));
        return successfulDeletion;
    }

    @Override
    public void add(List<Student> newStudents) {
        for (Student student : newStudents) {
            students.add(student);
        }
    }

    @Override
    public void add(Student newStudent) {
        students.add(newStudent);
    }

    @Override
    public void add(Student... newStudents) {
        for (Student student : newStudents) {
            this.add(student);
        }
    }

}
