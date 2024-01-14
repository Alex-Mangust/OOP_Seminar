package Model;

import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

/**
 * Класс, описывающий поведение модели, которая хранит список студентов в List.
 * Имеет интерфейс iGetModel
 */
public class ModelClassList implements iGetModel {
    private List<Student> students; // Поле для хранения списка студентов

    /**
     * Конструктор класса
     * @param students - список студентов
     */
    public ModelClassList(List<Student> students) {
        this.students = students;
    }

    /** Переопределенный метод, возвращает список студентов */
    @Override
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Переопределенный метод, необходимый для удаления студента из файла
     * 
     * @param id - id студента, которого необходимо удалить
     * Возвращает true, если студент найден и false, если нет.
     */
    @Override
    public boolean deleteStudent(int id) {
        boolean successfulDeletion = false; // Переменная, отвечающая за успешное удаление
        int idFind = 0; // Переменная, в которой будет храниться id найденного студента для удаления 
        for (Student student : students) {
            if (student.getId() == id) {
                successfulDeletion = true;
                break; // Если студент найден, цикл завершается досрочно.
            }
            idFind++;
        }
        if (successfulDeletion) students.remove(students.get(idFind)); // Происходит удаление
        return successfulDeletion;
    }

    /** 
     * Переопределенный метод, добавляющий список студентов
     * @param newStudents - список новых студентов
     */
    @Override
    public void add(List<Student> newStudents) {
        for (Student student : newStudents) {
            students.add(student);
        }
    }

    /** 
     * Переопределенный метод, добавляющий одного студента
     * @param newStudent - новый студент
     */
    @Override
    public void add(Student newStudent) {
        students.add(newStudent);
    }

    /** 
     * Переопределенный метод, добавляющий произвольное количество студентов
     * @param newStudents - новые студенты
    */
    @Override
    public void add(Student... newStudents) {
        for (Student student : newStudents) {
            this.add(student);
        }
    }

}
