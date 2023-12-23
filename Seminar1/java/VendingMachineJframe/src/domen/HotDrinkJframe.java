package domen;

public class HotDrinkJframe extends ProductJframe {
    private int temperature;
    
    /**
     * Конструктор
     * @param name - имя продукта
     * @param price - цена продукта
     * @param place - место продукта
     * @param temperature - температура продукта
     */
    public HotDrinkJframe(String name, int price, int place, int temperature) {
        super(name,  price, place);
        this.temperature = temperature;
    }

    /** Получить температуру продукта */
    public int getTemperature() {
        return temperature;
    }

    /** Задать температуру продукта */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" Температура = %d градусов", this.temperature);
    }
}
