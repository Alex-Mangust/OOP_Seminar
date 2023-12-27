package Controler;

import java.util.List;

import Domen.Person;
import Domen.Worker;
import Service.iPersonService;

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

    public static <T extends iPersonService> float averageAge(T groupePeople){
        float averageAgePeople = 0;
        for (Object e : groupePeople.getAll()) {
            Person person = (Person)e;
            averageAgePeople += (float)person.getAge();
        }
        return averageAgePeople = averageAgePeople / groupePeople.getAll().size();
    }
}
