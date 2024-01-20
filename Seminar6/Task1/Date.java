package Task1;

import java.util.ArrayList;
import java.util.List;

/** Класс, описывающий дату рождения*/
public class Date {
    private String dob; // Дата рождения
    
    /**
     * Конструктор класса
     * @param day - день
     * @param month - месяц
     * @param year - год
     * Преобразует переменные в формат даты рождения
     */
    public Date(int day, int month, int year) {
        List<Integer> dobList = new ArrayList<>(); // Список для хранения значений дня, месяца и года
        dobList.add(day);
        dobList.add(month);
        dobList.add(year);
        for (int i = 0; i < dobList.size(); i++) { // Цикл проходит по всему списку и добавляет в поле dob значения, разделяя их точкой. В итоге выходит day.month.year
            this.dob += dobList.get(i);
            if (i < dobList.size() - 1) this.dob += ".";
        }
    }

    /** Переопределенная функция. Возвращает строку с информацией об экземпляре класса*/
    @Override
    public String toString() {
        return dob;
    }
}
