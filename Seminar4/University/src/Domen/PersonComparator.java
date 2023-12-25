package Domen;

import java.util.Comparator;

public class PersonComparator<T extends Person> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
       // System.out.println(super.getName() + "-" + o.getName());
    //    if (o1.getAge() < o2.getAge()) return -1;
    //    else if (o1.getAge() > o2.getAge()) return 1;
    // //    if o1.getId() < o2.getId()) return -1;
    // //    else if o1.getId() > o2.getId()) return 1;
    //    return 0; 
        if (o1.getName().compareTo(o2.getName()) == 0) return 0;
        else return o1.getName().compareTo(o2.getName());
    }
    
}
