import java.util.Random;

/** Джуниор ищет работу, подбрасывая монетки */
public class Junior implements iObserver{
    private String name;

    public Junior(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (new Random().nextBoolean()){
            System.out.println(String.format("Junior %s: Я принимаю предложение! (company, salary) = %s, %d", name, nameCompany, salary));
        }
        else{
            System.out.println(String.format("Junior %s: Я не принимаю предложение! (company, salary) = %s, %d", name, nameCompany, salary));
        }
    }
}
