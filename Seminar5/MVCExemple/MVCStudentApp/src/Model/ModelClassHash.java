package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassHash implements iGetModel {
    private HashMap<Integer, Student> students;
    private static int number;

    static {
        number = 0;
    }

    public ModelClassHash(List<Student> students) {
        this.students = new HashMap<>();
        for (Student student : students) {
            this.students.put(student.getId(), student);
        }
    }

    public List<Student> getStudents() {
        List<Student> studentsList = new ArrayList<>();
        for (Student student : students.values()) {
            studentsList.add(student);
        }
        return studentsList;
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean successfulDeletion = false;
        Integer keyRemove = null;
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            if (entry.getValue().getId() == id) {
                keyRemove = entry.getKey();
                successfulDeletion = true;
            }
        }
        if (keyRemove != null) students.remove(keyRemove);
        return successfulDeletion;
    }

    @Override
    public void add(Student newStudent) {
        students.put(newStudent.getId(), newStudent);
    }

    @Override
    public void add(List<Student> newStudents) {
        for (Student student : newStudents) {
            students.put(student.getId(), student);
        }
    }

}
