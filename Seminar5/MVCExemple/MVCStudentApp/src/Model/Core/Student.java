package Model.Core;

/** Класс, описывающий студента университета. Является наследником класса Person. Имеет интерфейс Comparable */
public class Student extends Person implements Comparable<Student> {
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
    public Student(String name, int age) {
        super(name, age);
        this.id = generalId;
        generalId++;
    }

    public Student(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    /** Метод возвращает id студента*/
    public int getId() {
        return id;
    }

    /** Переопределенный метод, необходимый для сравнения экземпляров класса Student */
    @Override
    public int compareTo(Student o) {
        // System.out.println(super.getName() + "-" + o.getName());
        if (super.getAge() < o.getAge()) return -1;
        else if (super.getAge() > o.getAge()) return 1;
        if (this.getId() < o.getId()) return -1;
        else if (this.getId() > o.getId()) return 1;
        return 0;
    }
    
    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return super.toString() + String.format("; Id - %d", getId());
    }
    
}
