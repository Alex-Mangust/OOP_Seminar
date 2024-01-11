package Model.Core;

/** Класс описывающий персону (человека, который не подходит под категорию сотрудника, студента или преподователя) */
public abstract class Person {
    private String name;
    private int age;
    
    /**
     * Конструктор класса
     * @param name - имя
     * @param age - возраст
     */
    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return String.format("Имя - %s; Возраст: %d", getName(), getAge());
    }
}
