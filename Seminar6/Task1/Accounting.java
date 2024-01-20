package Task1;

/** Класс, описывающий бухгалтерию */
public class Accounting {

    /**
     * Метод, высчитывающий зарплату работнику
     * @param employee - экземпляр класса Employee (работник, которому нужно выдать зарплату)
     * @return возвращает зарплату работника (int)
     */
    public int calculateNetSalary(Employee employee) {
        int tax = (int) (employee.getBaseSalary() * 0.25); // calculate in otherway
        return employee.getBaseSalary() - tax;
    }
    
}
