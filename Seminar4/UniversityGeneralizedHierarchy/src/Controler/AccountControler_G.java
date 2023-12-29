package Controler;

import java.util.List;

import Domen.Person_G;
import Domen.iPerson_G;
import Domen.iWorker_G;
import Domen.Teachers.Teacher_G;
import Service.iPersonService_G;
import Service.iWorkerService_G;

/** Класс, необходимы для упраления сервисами */
public class AccountControler_G {

    /**
     * Обобщенный метод, необходимый для выдачи определенному сотруднику
     * определенной суммы
     */
    public static <T extends iWorker_G> void paySalary(Person_G<? extends iPerson_G> worker, int paySalary) {
        String profession = new String();
        if (worker.getPerson().getClass() == Teacher_G.class) profession = "Преподавателю";
        else profession = "Работнику";
        System.out.println(String.format("%s %s выплачено %d рублей", profession, worker.getPerson().getName(), paySalary));
    }

    /**
     * Обобщенный метод, необходимый для выдачи всем работникам, с которыми работает
     * указанный сервис
     */
    public static void paySalary(iWorkerService_G<? extends iWorker_G> service) {
        System.out.println(service.getSalaryPeoples());
    }

    /**
     * Метод, необходимый для вычисления среднего возраста указанной группы
     * работников, либо студентов
     */
    public static float averageAge(List<Person_G<? extends iPerson_G>> groupePeople) {
        float averageAgePeople = 0;
        for (Person_G<?> t : groupePeople) {
            averageAgePeople += (float) t.getPerson().getAge();
        }
        return averageAgePeople = averageAgePeople / groupePeople.size();
    }

    /**
     * Обобщенный метод, необходимый для вычисления среднего возраста работников,
     * либо студентов указанного сервиса
     */
    public static float averageAge(iPersonService_G<? extends iPerson_G> groupePeople) {
        float averageAgePeople = 0;
        int personCount = groupePeople.getAll().size();
    
        for (iPerson_G person : groupePeople.getAll()) {
            averageAgePeople += (float) person.getAge();
        }
    
        if (personCount > 0) {
            return averageAgePeople / personCount;
        } else {
            return 0;
        }
    }
}
