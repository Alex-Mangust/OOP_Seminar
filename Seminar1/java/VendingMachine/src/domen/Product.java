package domen;
public class Product {
    private String name;
    private int price;
    private int place;

    /**
     * Конструктор
     * @param name - имя продукта
     * @param price - цена продукта
     * @param place - место, занимаемое продуктом
     */
    public Product(String name, int price, int place) {
        this.name = name;
        this.price = price;
        // setPrice(price); // Можно так
        this.place = place;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getPlace() {
        return place;
    }
    public void setPrice(int value){
        if (value <= 0) this.price = 10;
        else this.price = value;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setPlace(int place) {
        this.place = place;
    }
    
    @Override
    public String toString() {
        return String.format("Продукт = %s Цена = %d Место = %d", this.name, this.price, this.place);
    }

    
}
