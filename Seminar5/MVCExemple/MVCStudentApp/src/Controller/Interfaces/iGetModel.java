package Controller.Interfaces;

import java.util.List;

import Model.Core.Student;


/** Интерфейс, объявляющий поведение модели */
public interface iGetModel {
    public List<Student> getStudents(); // Объявленный метод, необходимый для возвращения списокка студентов модели
    public boolean deleteStudent(int id); // Объявленный метод, необходимый для возвращающения ответа, имеется ли среди списка студентов модели тот, которого необходимо удалить.
    public void add(List<Student> newStudents); // Объявленный метод, необходимый для добавления списка студентов в модель
    public void add(Student newStudent); // Объявленный метод, необходимый для добавления нового студента в модель
    public void add(Student... newStudents); // Объявленный метод, необходимый для добавления произвольного количества студентов в модель
}
