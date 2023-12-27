package Domen.Teachers;

import Domen.Worker;

/** Класс, описывающий преподавателя университета. Является наследником класса Worker */
public class Teacher extends Worker{
    private String academicDegree;

    /**
     * Конструктор класса
     * @param name - имя преподавателя
     * @param age - возраст преподавателя
     * @param academicDegree - академическая степень преподавателя
     */
    public Teacher(String name, int age, String academicDegree, int salary) {
        super(name, age, salary);
        this.academicDegree = academicDegree;
    }

    /** Метод, возвращающий академическую степень преподавателя */
    public String getAcademicDegree() {
        return academicDegree;
    }
}
