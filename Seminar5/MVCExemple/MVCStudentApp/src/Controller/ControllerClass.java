package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Core.Student;

public class ControllerClass {
    private iGetModel model;
    private iGetView view;
    private List<iGetModel> modelList = new ArrayList<>();
    private List<iGetView> viewList = new ArrayList<>();
    private List<Student> studentBuffer = new ArrayList<>();

    public ControllerClass(List<iGetModel> models, List<iGetView> views) {
        initialize(models, views);
    }

    public ControllerClass(List<iGetModel> models, iGetView... views) {
        List<iGetView> newViews = new ArrayList<>();
        for (iGetView view : views) {
            newViews.add(view);
        }
        initialize(models, newViews);
    }

    public ControllerClass(iGetModel model, iGetView... views) {
        List<iGetModel> newModels = new ArrayList<>();
        newModels.add(model);
        List<iGetView> newViews = new ArrayList<>();
        for (iGetView view : views) {
            newViews.add(view);
        }
        initialize(newModels, newViews);
    }

    private void initialize(List<iGetModel> models, List<iGetView> views) {
        for (iGetModel model : models) {
            modelList.add(model);
        }
        for (iGetView view : views) {
            this.viewList.add(view);
        }
        this.model = modelList.getFirst();
        this.view = viewList.getFirst();
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
        if (viewList.size() > 1) {
            int choiceLanguage = choiceLanguage();
            String language = new String();
            if (choiceLanguage == 1)
                language = "ru";
            else
                language = "en";
            for (iGetView view : viewList) {
                if (view.languageView().equals(language))
                    this.view = view;
            }
        } else
            this.view = viewList.getFirst();

        if (modelList.size() > 1) {
            for (iGetModel model : modelList) {
                studentBuffer.addAll(model.getStudents());
            }
        } else studentBuffer = model.getStudents();
        if (teestData(studentBuffer))
            view.printAllStudents(studentBuffer);
        else if (view.languageView().equals("ru")) {
            System.out.println("Список студентов пуст!");
        } else if (view.languageView().equals("en")) {
            System.out.println("The list of students is empty!");
        }
    }

    private void update(List<Student> students) {

        if (modelList.size() > 1) {
            studentBuffer = new ArrayList<>();
            for (iGetModel model : modelList) {
                studentBuffer.addAll(model.getStudents());
            }
        } else studentBuffer = model.getStudents();
        if (teestData(studentBuffer))
            view.printAllStudents(studentBuffer);
        else if (view.languageView().equals("ru")) {
            System.out.println("Список студентов пуст!");
        } else if (view.languageView().equals("en")) {
            System.out.println("The list of students is empty!");
        }
    }

    public void run() {
        if (viewList.size() > 1) {
            useLanguagee();
        } else
            this.view = viewList.getFirst();
        Command com = (Command) Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = new String();
            if (view.languageView().equals("ru")) {
                command = view.prompt("Введите команду:");
            } else if (view.languageView().equals("en")) {
                command = view.prompt("Enter the command:");
            }
            try {
                com = Command.valueOf(command.toUpperCase());
                switch (com) {
                    case EXIT:
                        getNewIter = false;
                        view.exit(true);
                        if (view.languageView().equals("ru")) {
                            System.out.println("Выход из программы");
                        } else if (view.languageView().equals("en")) {
                            System.out.println("Exit the program");
                        }
                        break;
                    case LIST:
                        update(model.getStudents());
                        break;
                    case DELETE:
                        int studentId = view.deleteStudent();
                        boolean findStudent = false;
                        for (iGetModel model : modelList) {
                            findStudent = model.deleteStudent(studentId);
                            if (findStudent) break;
                        }
                        if (findStudent) {
                            if (view.languageView().equals("ru")) {
                                System.out.println("Удаление завершено!");
                            } else if (view.languageView().equals("en")) {
                                System.out.println("Removal complete!");
                            }
                        } else {
                            if (view.languageView().equals("ru")) {
                                System.out.println("Студент не найден!");
                            } else if (view.languageView().equals("en")) {
                                System.out.println("Student not found!");
                            }
                        }
                        break;
                    case LANGUAGE:
                        if (viewList.size() > 1) {
                            useLanguagee();
                        } else {
                            if (view.languageView().equals("ru")) System.out.println("Программа поддерживает только один язык!");
                            else if (view.languageView().equals("en")) System.out.println("The program only supports one language!");
                        }
                        break;
                    default:
                        if (view.languageView().equals("ru")) {
                            System.out.println("Функционал для этой команды пока не реализован!");
                        } else if (view.languageView().equals("en")) {
                            System.out.println("The functionality for this command has not yet been implemented!");
                        }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int choiceLanguage() {
        Scanner choiceLanguageScanner = new Scanner(System.in);
        if (view.languageView().equals("ru")) System.out.println("Выберите язык.\n1. Русский   2. Английский");
        else if (view.languageView().equals("en")) System.out.println("Select a language.\n1. Russian   2. English");
        try {
            int choice = choiceLanguageScanner.nextInt();
            return choice;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    private void useLanguagee() {
        int choiceLanguage = choiceLanguage();
            String language = new String();
            if (choiceLanguage == 1)
                language = "ru";
            else
                language = "en";
            for (iGetView view : viewList) {
                if (view.languageView().equals(language))
                    this.view = view;
            }
    }
}
