package Domen;

import java.util.Comparator;

/** Обобщенный класс, необходимый для сравнения экземпляров классов наследников класса Person */
public class PersonComparator_G<T extends Person_G<? extends iPerson_G>> implements Comparator<T> {

    /** Переопределенный метод, необходимый для сравнения экземпляров класса PersonComparator */
    @Override
    public int compare(T o1, T o2) {
        if (o1.getPerson().getName().compareTo(o2.getPerson().getName()) == 0) return 0;
        else return o1.getPerson().getName().compareTo(o2.getPerson().getName());
    }
    
}
