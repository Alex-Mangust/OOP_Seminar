package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.Core.Student;

/** Класс, описывающий взаимодействие модели с пользовательским интерфейсом */
public class ControllerClass {
    private iGetModel model; // Модель, с которой работает контроллер в данный момент
    private iGetView view; // Пользовательский интерфейс, с которым работает контроллер в данный момент
    private List<iGetModel> modelList = new ArrayList<>(); // Список моделей в программе
    private List<iGetView> viewList = new ArrayList<>(); // Список пользовательских интерфейсов в прогграмме
    private List<Student> studentBuffer = new ArrayList<>(); // Список, хранящий список студентов текущей модели.

    /**
     * Конструктор класса (Принимает список моделей и список интерфейсов)
     * 
     * @param models - список моделей программы
     * @param views  - список пользовательских интерфейсов программы
     */
    public ControllerClass(List<iGetModel> models, List<iGetView> views) {
        initialize(models, views);
    }

    /**
     * Конструктор класса (принимает список моделий и произвольное количество
     * интерфейсов)
     * 
     * @param models - список моделей программы
     * @param views  - пользовательские интерфейсы программы
     */
    public ControllerClass(List<iGetModel> models, iGetView... views) {
        List<iGetView> newViews = new ArrayList<>();
        for (iGetView view : views) {
            newViews.add(view);
        }
        initialize(models, newViews);
    }

    /**
     * Конструктор класса (принимает модель и пользовательские интерфейсы программы)
     * 
     * @param models - список моделей программы
     * @param views  - список пользовательских интерфейсов программы
     */
    public ControllerClass(iGetModel model, iGetView... views) {
        List<iGetModel> newModels = new ArrayList<>();
        newModels.add(model);
        List<iGetView> newViews = new ArrayList<>();
        for (iGetView view : views) {
            newViews.add(view);
        }
        initialize(newModels, newViews);
    }

    /**
     * Метод, инициализирующий работу контроллера
     * 
     * @param models - список моделей программы
     * @param views  - список пользовательских интерфейсов программы
     */
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

    /**
     * Метод, проверяющий наличие студентов в studentBuffer
     * 
     * @param students - список студентов подели
     * @return возвращает имеет ли список какие-либо значения
     */
    private boolean teestData(List<Student> students) {
        if (students.size() > 0)
            return true;
        else
            return false;
    }

    // Этот метод не используется в программе
    // public void update() {
    // if (viewList.size() > 1) {
    // int choiceLanguage = choiceLanguage();
    // String language = new String();
    // if (choiceLanguage == 1)
    // language = "ru";
    // else
    // language = "en";
    // for (iGetView view : viewList) {
    // if (view.languageView().equals(language))
    // this.view = view;
    // }
    // } else
    // this.view = viewList.getFirst();

    // if (modelList.size() > 1) {
    // for (iGetModel model : modelList) {
    // studentBuffer.addAll(model.getStudents());
    // }
    // } else studentBuffer = model.getStudents();
    // if (teestData(studentBuffer))
    // view.printAllStudents(studentBuffer);
    // else if (view.languageView().equals("ru")) {
    // System.out.println("Список студентов пуст!");
    // } else if (view.languageView().equals("en")) {
    // System.out.println("The list of students is empty!");
    // }
    // }

    /**
     * Метод, проверяющий каждую модель на наличие в ней студентов и добавляющий их
     * в список studentBuffer, после чего вызывает метод printAllStudents, который
     * выводит в консоль список студентов. Если студентов нет ни в одной из моделей,
     * выдает сообщение "Список студентов пуст"
     */
    private void update() {

        if (modelList.size() > 1) { // Если моделей в программе больше, чем одна, добавляет в studentBuffer студентов из каждой модели
            studentBuffer = new ArrayList<>();
            for (iGetModel model : modelList) {
                studentBuffer.addAll(model.getStudents());
            }
        } else
            studentBuffer = model.getStudents();
        if (teestData(studentBuffer)) // Проверяет, имеются ли студенты в studentBuffer
            view.printAllStudents(studentBuffer);
        else
            view.listStudentisEmptyMessage();

    }

    /** Метод, описывающий запуск и работу программы */
    public void run() {
        if (viewList.size() > 1) {
            useLanguage();
        } else
            this.view = viewList.getFirst();
        Command com = (Command) Command.NONE; // Инициализируется экземпляр класса перечисления со значением NONE
        boolean getNewIter = true; // Переменная, необходимая для продолжения работы программы, пока пользователь не введет команду о завершении
        while (getNewIter) {
            String command = new String(); // Происходит запрос пользователю, чтобы он ввел команду. Язык зависит от текущего интерфейса
            command = view.prompt(view.inputMessage());
            try {
                com = Command.valueOf(command.toUpperCase()); // Экземпляру класса записывается значение, которое ввел пользователь
                switch (com) {
                    case EXIT: // Завершение программы
                        getNewIter = false;
                        view.exit(true);
                        view.exitMessage(); // Выводит сообщение о завершение програмы
                        break;
                    case LIST: // Вывод в консоль список студентов
                        update();
                        break;
                    case DELETE: // Удаление студента
                        int studentId = view.deleteStudent(); // Происходит запрос пользователю, какого студента он хочет удалить
                        boolean findStudent = false; // Переменная, необходимая для проверки имеется ли запрашиваемый студент в системе
                        for (iGetModel model : modelList) {
                            findStudent = model.deleteStudent(studentId); // Проверяется каждая модель на наличие запрашиваемого студента
                            if (findStudent)
                                break; // Если студент найден, цикл завершается досрочно
                        }
                        view.removeMessage(findStudent); // Если студент найден, выводится сообщение о успешном удалении

                        break;
                    case LANGUAGE: // Смена языка пользовательского интерфейса
                        if (viewList.size() > 1) { // Если программа использует больше одного пользовательского интерфейса, вызывается метод смены текущего интерфейса
                            useLanguage();
                        } else { // Иначе выводится сообщение о том, что программа поддерживает только один язык
                            view.onlyLanguageMessage();
                        }
                        break;
                    default: // При вводе команды из класса перечисления Command, функционал которой нереализован, выводится сообщение пользователю, сообщающее об этом
                        view.nonimplementedMessage();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Метод, запрашивающий у пользователя предпочитаемый им язык пользовательского
     * интерфейса
     */
    private void useLanguage() {
        boolean firstRunChoice = true;
        String languageMessange = new String();
        int numberLanguage = 1;
        languageMessange += view.choiceLanguageMessage(firstRunChoice);
        firstRunChoice = false;
        for (iGetView view : viewList) {
            languageMessange += String.format("%d. %s\n", numberLanguage, view.choiceLanguageMessage(firstRunChoice));
            numberLanguage++;
        }
        System.out.println(languageMessange);
        int choiceLanguage = view.choiceLanguage();
        if (choiceLanguage < 0 || choiceLanguage > viewList.size())
            view.defaultLanguageMessage();
        else 
            this.view = viewList.get(choiceLanguage - 1);
    }
}
