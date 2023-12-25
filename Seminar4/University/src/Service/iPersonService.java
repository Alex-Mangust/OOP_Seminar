package Service;

import java.util.List;

public interface iPersonService<T> {
    public List<T> getAll();
    public void create(String name, int age);
}
