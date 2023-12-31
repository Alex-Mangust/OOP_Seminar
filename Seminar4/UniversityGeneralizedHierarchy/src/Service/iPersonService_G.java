package Service;

import java.util.List;

/** Обобщенный интерфейс, объявляющий поведения сервиса, который работает со всеми людьми университета */
public interface iPersonService_G<T> {
    public List<T> getAll(); // Объявленный метод, возвращающий обобщенную коллекцию List
    public void create(String name, int age); // Объявленный метод для создания персоны, с которой будет работать сервис
}
