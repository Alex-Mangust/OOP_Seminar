package Domen.Students;

import Domen.iPerson_G;

/** Класс, описывающий студента университета. Является наследником класса Person. Имеет интерфейс Comparable */
public class Student_G implements Comparable<Student_G>, iPerson_G {
    private String name;
    private int age;
    private int id; // Идентификатор студента
    private static int generalId; // Статическая переменная, необходимая для присвоения каждому студенту уникального идентификатора

    static {
        generalId = 0;
    }

    /**
     * Конструктор класса
     * @param name - имя студента
     * @param age - возраст студента
     * При создании нового экземпляра класса, автоматически присваивается id
     */
    public Student_G(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = generalId;
        generalId++;
    }

    /** Метод возвращает id студента*/
    public int getId() {
        return id;
    }

    /** Метод возвращает имя */
    public String getName() {
        return name;
    }

    /** Метод задает имя */
    public void setName(String name) {
        this.name = name;
    }

    /** Метод возвращает возраст */
    public int getAge() {
        return age;
    }

    /** Метод задает возраст */
    public void setAge(int age) {
        this.age = age;
    }

    /** Переопределенный метод, необходимый для сравнения экземпляров класса Student */
    @Override
    public int compareTo(Student_G o) {
        // System.out.println(super.getName() + "-" + o.getName());
        if (this.getAge() < o.getAge()) return -1;
        else if (this.getAge() > o.getAge()) return 1;
        if (this.getId() < o.getId()) return -1;
        else if (this.getId() > o.getId()) return 1;
        return 0;
    }
    
    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return String.format("Имя - %s; Возраст: %d; Id - %d",getName(), getAge(), getId());
    }
    
}
