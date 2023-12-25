package Controler;

import java.util.List;

import Domen.GroupeInUniversity;
import Domen.Person;
import Domen.Worker;

public class AccountControler {
    public static <T> void paySalary(Worker person, int paySalary) {
        System.out.println(String.format("%s выплачено %d рублей", person.getName(), paySalary));
    }
    
    public static float averageAge(List<Person> groupePeople){
        float averageAgePeople = 0;
        for (Person t : groupePeople) {
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
