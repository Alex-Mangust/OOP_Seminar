package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Core.Student;

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
        else
            System.out.println("Список студентов пуст!");
    }

    private void update(List<Student> students) {
        studentBuffer = students;
        if (teestData(studentBuffer))
            view.printAllStudents(studentBuffer);
        else
            System.out.println("Список студентов пуст!");
    }

    public void run() {
        Command com = (Command) Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = view.prompt("Введите команду:");
            try {
                com = Command.valueOf(command.toUpperCase());
                switch (com) {
                    case EXIT:
                        getNewIter = false;
                        view.exit(true);
                        System.out.println("Выход из программы");
                        break;
                    case LIST:
                        update(model.getStudents());
                        break;
                    default:
                        System.out.println("Функционал для этой команды пока не реализован!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
