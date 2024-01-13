package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassFile implements iGetModel {
    private String fileName;

    public ModelClassFile(String fileName) {
        this.fileName = fileName;

        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            try (BufferedReader reader = new BufferedReader(fr)) {
                String line = reader.readLine();
                while (line != null) {
                    String[] param = line.split(" ");
                    Student pers = new Student(param[0], Integer.parseInt(param[1]), Integer.parseInt(param[2]));
                    students.add(pers);
                    line = reader.readLine();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }

    public void saveAllStudentToFile(List<Student> students) {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            for (Student pers : students) {
                fw.write(pers.getName() + " " + pers.getAge() + " " + pers.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addAllStudentToFile(List<Student> students) {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            for (Student pers : students) {
                fw.write(pers.getName() + " " + pers.getAge() + " " + pers.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        boolean successfulDeletion = false;
        List<Student> students = new ArrayList<Student>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            try (BufferedReader reader = new BufferedReader(fr)) {
                String line = reader.readLine();
                while (line != null) {
                    String[] param = line.split(" ");
                    Student pers = new Student(param[0], Integer.parseInt(param[1]), Integer.parseInt(param[2]));
                    students.add(pers);
                    line = reader.readLine();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Integer idRemove = null;
        int idFind = 0;
        for (Student student : students) {
            if (student.getId() == id) {
                successfulDeletion = true;
                idRemove = idFind;
            }
            idFind++;
        }
        if (idRemove != null)
            students.remove(students.get(idRemove));
        try (FileWriter fw = new FileWriter(fileName, false)) {
            for (Student pers : students) {
                fw.write(pers.getName() + " " + pers.getAge() + " " + pers.getId());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return successfulDeletion;
    }

    @Override
    public void add(List<Student> newStudents) {
        addAllStudentToFile(newStudents);
    }

    @Override
    public void add(Student newStudent) {
        List<Student> newStudents = new ArrayList<>();
        newStudents.add(newStudent);
        this.add(newStudents);
    }

    @Override
    public void add(Student... newStudents) {
        for (Student student : newStudents) {
            this.add(student);
        }
    }
}