package Service;

/** Обобщенный интерфейс, объявляющий поведения сервиса, связанного с классом Worker и его наследниками */
public interface IWorkerService<T> {
    public String getSalaryPeoples(); // Объявленный метод, необходимый для выплаты зарплаты сотрудникам
}
