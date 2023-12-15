package servis;

import java.util.HashMap;
import java.util.List;

import domen.Product;

public class VendingMachine {
    private static int numberProduct;
    private static HashMap<Product, Integer> numberProducts;

    static {
        VendingMachine.numberProduct = 1;
        VendingMachine.numberProducts = new HashMap<Product, Integer>();
    }

    private Holder holder;
    private CoinDispenser dispenser;
    private List<Product> assortiment;

    /**
     * Конструктор
     * @param holder - держатель продукта (Экземпляр класса Holder)
     * @param dispenser - диспенсер для монет (Экземпляр класса CoinDispenser)
     * @param assortiment - ассортимент продуктов (Список List c элементами из экземпляров класса Product, либо его наследниками)
     */
    public VendingMachine(Holder holder, CoinDispenser dispenser, List<Product> assortiment) {
        this.holder = holder;
        this.dispenser = dispenser;
        this.assortiment = assortiment;
        for (Product product : assortiment) {
            VendingMachine.numberProducts.put(product, numberProduct++);
        }
    }

    /** Получить экземляр класса Holder */
    public Holder getHolder() {
        return holder;
    }
    
    /** Получить экземпляр класса CoinDispenser */
    public CoinDispenser getDispenser() {
        return dispenser;
    }

    /** Получить ассортимент продуктов (Список List c элементами из экземпляров класса Product, либо его наследниками)*/
    public List<Product> getProduct() {
        return assortiment;
    }

    /** Задать экземпляр класса Holder */
    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    /** Задать экземпляр класса CoinDispenser */
    public void setDispenser(CoinDispenser dispenser) {
        this.dispenser = dispenser;
    }

    /** Задать ассортимент продуктов  (Список List c элементами из экземпляров класса Product, либо его наследниками)*/
    public void setProduct(List<Product> assortiment) {
        this.assortiment = assortiment;
    }

    public static int getNumberProducts(Product product) {
        return numberProducts.get(product);
    }
}
