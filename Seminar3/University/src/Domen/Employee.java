package Domen;

/** Класс, описывающий сотрудника университета. Является наследником класса Person */
public class Employee extends Person {
    private String specialication;

    /**
     * Конструктор класса
     * @param name - имя сотрудника
     * @param age - возраст сотрудника
     * @param specialication - специализация сотрудника
     */
    public Employee(String name, int age, String specialication) {
        super(name, age);
        this.specialication = specialication;
    }

    /** Метод возвращающий специализацию сотрудника */
    public String getSpecialication() {
        return specialication;
    }
    
}
