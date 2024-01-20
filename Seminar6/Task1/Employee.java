package Task1;

// 1) Переписать код в соответствии с Single Responsibility Principle:

/** Класс, описывающий работника */
public class Employee {
    private String name; // Имя
    private Date dob; // Дата рождения
    private int baseSalary; // Стандартная зарплата

    /**
     * Конструктор класса
     * @param name - имя
     * @param dob - дата рождения (экземпляр класса Date)
     * @param baseSalary - стандратная зарплата
     */
    public Employee(String name, Date dob, int baseSalary) {
        this.name = name;
        this.dob = dob;
        this.baseSalary = baseSalary;
    }

    /** Метод, который возвращает строку с информацией об экземпляре класса */
    public String getEmpInfo() {
        return "name - " + name + " , dob - " + dob.toString();
    }

    /** Метод, который возвращает стандартную зарплату работника */
    public int getBaseSalary() {
        return baseSalary;
    }
}