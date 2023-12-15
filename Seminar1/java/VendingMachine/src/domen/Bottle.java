package domen;

public class Bottle extends Product {
    private double volume;

    /**
     * Конструктор
     * @param name - имя продукта
     * @param price - цена продукта
     * @param place - место продукта
     * @param volume - объем продукта
     */
    public Bottle(String name, int price, int place, double volume) {
        super(name, price, place);
        this.volume = volume;
    }

    /** Получить объем продукта */
    public double getVolume() {
        return volume;
    }

    /** Задать объем продукта */
    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" Объем = %f", volume);
    }
     
}
