package Domen;


/** Класс описывающий персону (человека, который не подходит под категорию сотрудника, студента или преподователя) */
public class Person_G<T extends iPerson_G> implements Comparable<T> {
    private T person;
    
    /**
     * Конструктор класса
     * @param name - имя
     * @param age - возраст
     */
    public Person_G(T person) {
        this.person = person;
    }
    public T getPerson() {
        return person;
    }

    /** Переопределенный метод, необходимый для сравнения экземпляров класса Student */
    @Override
    public int compareTo(T o) {
        return this.compareTo(o);
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return person.toString();
    }
}
