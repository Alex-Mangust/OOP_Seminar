package Domen;


/** Обобщенный класс описывающий персону */
public class Person_G<T extends iPerson_G> implements Comparable<T> {
    private T person;
    
    /**
     * Конструктор класса
     * @param person - экземпляр класса Student, Teacher или Employee
     */
    public Person_G(T person) {
        this.person = person;
    }

    /** Метод возвращает экземпляр класса персоны */
    public T getPerson() {
        return person;
    }

    /** Переопределенный метод, необходимый для сравнения экземпляров классов персон */
    @Override
    public int compareTo(T o) {
        return this.compareTo(o);
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса персоны */
    @Override
    public String toString() {
        return person.toString();
    }
}
