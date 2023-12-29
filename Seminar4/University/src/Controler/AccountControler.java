package Controler;

import java.util.List;

import Domen.Person;
import Domen.Worker;
import Service.iWorkerService;
import Service.iPersonService;

/** Класс, необходимы для упраления сервисами*/
public class AccountControler {

    /** Обобщенный метод, необходимый для выдачи определенному сотруднику определенной суммы */
    public static <T> void paySalary(Worker person, int paySalary) {
        System.out.println(String.format("%s выплачено %d рублей", person.getName(), paySalary));
    }

    /** Обобщенный метод, необходимый для выдачи зарплаты всем работникам, с которыми работает указанный сервис */
    public static <T extends iWorkerService<?>> void paySalary(T service) {
        System.out.println(service.getSalaryPeoples());
    }

    /** Метод, необходимый для вычисления среднего возраста указанной группы работников, либо студентов */
    public static float averageAge(List<Person> groupePeople) {
        float averageAgePeople = 0;
        for (Person t : groupePeople) {
            averageAgePeople += (float) t.getAge();
        }
        return averageAgePeople = averageAgePeople / groupePeople.size();
    }

    /** Обобщенный метод, необходимый для вычисления среднего возраста работников, либо студентов указанного сервиса */
    public static <T extends iPersonService<?>> float averageAge(T groupePeople) {
        float averageAgePeople = 0;
        for (Object e : groupePeople.getAll()) {
            Person person = (Person) e;
            averageAgePeople += (float) person.getAge();
        }
        return averageAgePeople = averageAgePeople / groupePeople.getAll().size();
    }
}
