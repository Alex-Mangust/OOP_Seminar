
/** Профи, ищущие работу */
public class Master implements iObserver {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (salary < 80){
            System.out.println(String.format("Master %s: Я жду лучшей работы! (company, salary) = %s, %d", name, nameCompany, salary));
        }
        else{
            System.out.println(String.format("Master %s: Хорошо. Я готов к этой работе! (company, salary) = %s, %d", name, nameCompany, salary));
        }
    }
    
}
