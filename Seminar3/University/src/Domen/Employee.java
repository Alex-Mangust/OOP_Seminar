package Domen;

public class Employee extends Person {
    private String specialication;

    public Employee(String name, int age, String specialication) {
        super(name, age);
        this.specialication = specialication;
    }

    public String getSpecialication() {
        return specialication;
    }
    
}
