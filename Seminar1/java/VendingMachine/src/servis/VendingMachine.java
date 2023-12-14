package servis;

import java.util.List;

import domen.Product;

public class VendingMachine {
    private Holder holder;
    private CoinDispenser dispenser;
    private List<Product> assortiment;

    /**
     * Конструктор
     * @param holder
     * @param dispenser
     * @param assortiment
     */
    public VendingMachine(Holder holder, CoinDispenser dispenser, List<Product> assortiment) {
        this.holder = holder;
        this.dispenser = dispenser;
        this.assortiment = assortiment;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public CoinDispenser getDispenser() {
        return dispenser;
    }

    public void setDispenser(CoinDispenser dispenser) {
        this.dispenser = dispenser;
    }

    public List<Product> getProduct() {
        return assortiment;
    }

    public void setProduct(List<Product> assortiment) {
        this.assortiment = assortiment;
    }

    
}
