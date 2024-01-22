public class Student implements iObserver {
    private String name;
    private int salary;
    

    public Student(String name, int salary) {
        this.name = name;
        this.salary = 0;
    }


    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (this.salary < salary) {
            System.out.println(String.format("Student %s: Мне нужна эта работа! (company, salary) = %s, %d", name, nameCompany, salary));
            this.salary = salary;
        }
        else{
            System.out.println(String.format("Student %s: У меня работа получше! (company, salary) = %s, %d", name, nameCompany, salary));
        }
    }
    
}
