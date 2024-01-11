package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Core.Student;
import View.ViewClass;
import View.ViewClassEng;

public class ControllerClass {
    private iGetModel model;
    private iGetView view;
    private List<Student> studentBuffer = new ArrayList<>();

    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    private boolean teestData(List<Student> students) {
        if (students.size() > 0)
            return true;
        else
            return false;
    }

    public void update() {
        // // Модель MVC
        // view.printListStudent(model.getStudents());

        // Модель MVP
        studentBuffer = model.getStudents();
        if (teestData(studentBuffer))
            view.printAllStudents(studentBuffer);
        else if (view.getClass().getSimpleName().equals(ViewClass.class.getSimpleName())) {
            System.out.println("Список студентов пуст!");
        } else if (view.getClass().getSimpleName().equals(ViewClassEng.class.getSimpleName())) {
            System.out.println("The list of students is empty!");
        }
    }

    private void update(List<Student> students) {
        studentBuffer = students;
        if (teestData(studentBuffer))
            view.printAllStudents(studentBuffer);
        else if (view.getClass().getSimpleName().equals(ViewClass.class.getSimpleName())) {
            System.out.println("Список студентов пуст!");
        } else if (view.getClass().getSimpleName().equals(ViewClassEng.class.getSimpleName())) {
            System.out.println("The list of students is empty!");
        }
    }

    public void run() {
        Command com = (Command) Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = new String();
            if (view.getClass().getSimpleName().equals(ViewClass.class.getSimpleName())) {
                command = view.prompt("Введите команду:");
            } else if (view.getClass().getSimpleName().equals(ViewClassEng.class.getSimpleName())) {
                command = view.prompt("Enter the command:");
            }
            try {
                com = Command.valueOf(command.toUpperCase());
                switch (com) {
                    case EXIT:
                        getNewIter = false;
                        view.exit(true);
                        if (view.getClass().getSimpleName().equals(ViewClass.class.getSimpleName())) {
                            System.out.println("Выход из программы");
                        } else if (view.getClass().getSimpleName().equals(ViewClassEng.class.getSimpleName())) {
                            System.out.println("Exit the program");
                        }
                        break;
                    case LIST:
                        update(model.getStudents());
                        break;
                    case DELETE:
                        int studentId = view.deleteStudent();
                        if (model.deleteStudent(studentId)) {
                            if (view.getClass().getSimpleName().equals(ViewClass.class.getSimpleName())) {
                                System.out.println("Удаление завершено!");
                            } else if (view.getClass().getSimpleName().equals(ViewClassEng.class.getSimpleName())) {
                                System.out.println("Removal complete!");
                            }
                        } else {
                            if (view.getClass().getSimpleName().equals(ViewClass.class.getSimpleName())) {
                                System.out.println("Студент не найден!");
                            } else if (view.getClass().getSimpleName().equals(ViewClassEng.class.getSimpleName())) {
                                System.out.println("Student not found!");
                            }
                        }
                        break;
                    default:
                        if (view.getClass().getSimpleName().equals(ViewClass.class.getSimpleName())) {
                            System.out.println("Функционал для этой команды пока не реализован!");
                        } else if (view.getClass().getSimpleName().equals(ViewClassEng.class.getSimpleName())) {
                            System.out.println("The functionality for this command has not yet been implemented!");
                        }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
