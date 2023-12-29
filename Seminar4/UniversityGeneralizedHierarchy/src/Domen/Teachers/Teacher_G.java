package Domen.Teachers;

import Domen.iPerson_G;
import Domen.iWorker_G;

/** Класс, описывающий преподавателя университета. Является наследником класса Worker */
public class Teacher_G implements Comparable<Teacher_G>, iPerson_G, iWorker_G{
    private String academicDegree;
    private String name;
    private int age;
    private int salary;
    /**
     * Конструктор класса
     * @param name - имя преподавателя
     * @param age - возраст преподавателя
     * @param academicDegree - академическая степень преподавателя
     */
    public Teacher_G(String name, int age, String academicDegree, int salary) {
        this.name = name;
        this.age = age;
        this.academicDegree = academicDegree;
        this.salary = salary;
    }

    /** Метод, возвращающий академическую степень преподавателя */
    public String getAcademicDegree() {
        return academicDegree;
    }

    /** Метод, возвращающий зарпалту работника */
    public int getSalary() {
        return salary;
    }

    /** Метод возвращает имя */
    public String getName() {
        return name;
    }

    
    /** Метод возвращает возраст */
    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    /** Метод задает имя */
    public void setName(String name) {
        this.name = name;
    }

    /** Метод задает возраст */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Teacher_G o) {
        if (this.getSalary() > o.getSalary()) return -1;
        else if (this.getSalary() < o.getSalary()) return 1;
        if (this.getAge() < o.getAge()) return -1;
        else if (this.getAge() > o.getAge()) return 1;
        return 0;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return String.format("\"Имя - %s; Возраст: %d; Академическая специальность: %s; Зарплата: %d",getName(), getAge(), getAcademicDegree(), getSalary());
    }
}
