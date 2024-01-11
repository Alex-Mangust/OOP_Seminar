

/** Класс описывающий персону (человека, который не подходит под категорию сотрудника, студента или преподователя) */
public class Person<T,V> {
    private T name;
    private V age;
    
    /**
     * Конструктор класса
     * @param name - имя
     * @param age - возраст
     */
    public Person(T name, V age) {
        this.name = name;
        this.age = age;
    }

    /** Метод возвращает имя */
    public T getName() {
        return name;
    }

    /** Метод задает имя */
    public void setName(T name) {
        this.name = name;
    }

    /** Метод возвращает возраст */
    public V getAge() {
        return age;
    }

    /** Метод задает возраст */
    public void setAge(V age) {
        this.age = age;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return String.format("Имя - %s; Возраст: %d", getName(), getAge());
    }
}
