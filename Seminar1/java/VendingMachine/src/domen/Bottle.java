package domen;

public class Bottle extends Product {
    private double volume;
    public Bottle(String name, int price, int place, double volume) {
        super(name, price, place);
        this.volume = volume;
    }
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format(" Объем %f", volume);
    }
     
}
