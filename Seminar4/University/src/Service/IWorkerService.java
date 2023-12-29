package Service;

/** Обобщенный интерфейс, объявляющий поведение сервиса, связанного с классом Worker и его наследниками */
public interface iWorkerService<T> {
    public String getSalaryPeoples(); // Объявленный метод, необходимый для выплаты зарплаты сотрудникам
}
