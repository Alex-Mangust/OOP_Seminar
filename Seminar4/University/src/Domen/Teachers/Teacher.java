package Domen.Teachers;

import Domen.Worker;

/** Класс, описывающий преподавателя университета. Является наследником класса Person */
public class Teacher extends Worker{
    private String academicDegree;

    /**
     * Конструктор класса
     * @param name - имя преподавателя
     * @param age - возраст преподавателя
     * @param academicDegree - академическая степень преподавателя
     */
    public Teacher(String name, int age, String academicDegree) {
        super(name, age);
        this.academicDegree = academicDegree;
    }

    /** Метод, возвращающий академическую степень преподавателя */
    public String getAcademicDegree() {
        return academicDegree;
    }
}
