import java.util.Random;

/** Эта компания, которая нуждается в сотрудниках. Она будет давать команду агенству. */
public class Company {
    private iPublisher jobAgency;
    private String nameCompany;
    private Random rnd;
    private int maxSalary;

    /** Компания работает с определенным агенством */
    public Company(iPublisher jobAgency, String nameCompany, int maxSalary) {
        this.jobAgency = jobAgency;
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.rnd = new Random();
    }
    
    public void needEmployee() {
        int salary = rnd.nextInt(maxSalary);
        jobAgency.sendOffer(nameCompany, salary);
    }
    
}