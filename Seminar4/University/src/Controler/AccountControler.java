package Controler;

import java.util.List;

import Domen.GroupeInUniversity;
import Domen.Person;
import Domen.Worker;

public class AccountControler {
    public static <T extends Worker> void paySalary(T person, int paySalary) {
        System.out.println(String.format("%s выплачено %d рублей", person.getName(), paySalary));
    }
    
    public static <T extends Person> float averageAge(List<T> groupePeople){
        float averageAgePeople = 0;
        for (T t : groupePeople) {
            averageAgePeople += (float)t.getAge();
        }
        return averageAgePeople = averageAgePeople / groupePeople.size();
    }

    public static <T extends GroupeInUniversity> float averageAge(T groupePeople){
        float averageAgePeople = 0;
        for (Person e : groupePeople.getGroupe()) {
            averageAgePeople += (float)e.getAge();
        }
        return averageAgePeople = averageAgePeople / groupePeople.getGroupe().size();
    }
}
