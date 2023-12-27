package Service;

import java.util.List;

/** Обобщенный интерфейс, объявляющий поведения сервиса, связанного с классом Person и его наследниками */
public interface iPersonService<T> {
    public List<T> getAll(); // Объявленный метод, возвращающий обобщенную коллекцию List
    public void create(String name, int age); // Объявленный метод для создания персоны, с которой будет работать сервис
}
