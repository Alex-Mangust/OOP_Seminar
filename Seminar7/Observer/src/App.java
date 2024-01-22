public class App {
    public static void main(String[] args) throws Exception {
        iPublisher jobAgency = new JobAgency();

        Company google = new Company(jobAgency, "Google", 50);
        Company geekBrains = new Company(jobAgency, "GeekBrains", 100);

        Master alex = new Master("Alex");
        Junior vasya = new Junior("Vasya");
        Student anna = new Student("Anna", 0);


        jobAgency.registerObserver(alex);
        jobAgency.registerObserver(vasya);
        jobAgency.registerObserver(anna);
        for (int i = 0; i < 5; i++) {
            google.needEmployee();
            System.out.println();
            geekBrains.needEmployee();
            System.err.println("\n");
        }
    }
}
