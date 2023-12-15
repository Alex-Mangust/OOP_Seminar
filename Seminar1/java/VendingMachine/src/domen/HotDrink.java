package domen;

public class HotDrink extends Product {
    private int temperature;
    
    /**
     * Конструктор
     * @param name - имя продукта
     * @param price - цена продукта
     * @param place - место продукта
     * @param temperature - температура продукта
     */
    public HotDrink(String name, int price, int place, int temperature) {
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
        // TODO Auto-generated method stub
        return super.toString() + String.format(" Температура = %d градусов", this.temperature);
    }
}
