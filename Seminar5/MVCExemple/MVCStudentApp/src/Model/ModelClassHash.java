package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

/**
 * Класс, описывающий поведение модели, которая хранит список студентов в HashMap.
 * Имеет интерфейс iGetModel
 */
public class ModelClassHash implements iGetModel {
    private HashMap<Integer, Student> students; // Поле для хранения списка студентов

    /**
     * Конструктор класса
     * @param students - список студентов
     */
    public ModelClassHash(HashMap<Integer, Student> students) {
        this.students = students;
    }

    /** Переопределенный метод, возвращает список студентов */
    @Override
    public List<Student> getStudents() {
        List<Student> studentsList = new ArrayList<>();
        for (Student student : students.values()) {
            studentsList.add(student);
        }
        return studentsList;
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
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            if (entry.getValue().getId() == id) {
                successfulDeletion = true;
                break; // Если студент найден, цикл завершается досрочно.
            }
        }
        if (successfulDeletion) students.remove(id); // Происходит удаление
        return successfulDeletion;
    }

    /** 
     * Переопределенный метод, добавляющий список студентов
     * @param newStudents - список новых студентов
     */
    @Override
    public void add(List<Student> newStudents) {
        for (Student student : newStudents) {
            students.put(student.getId(), student);
        }
    }

    /** 
     * Переопределенный метод, добавляющий одного студента
     * @param newStudent - новый студент
     */
    @Override
    public void add(Student newStudent) {
        students.put(newStudent.getId(), newStudent);
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
