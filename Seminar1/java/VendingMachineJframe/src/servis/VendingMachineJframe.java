package servis;

import java.util.HashMap;
import java.util.List;

import domen.ProductJframe;

public class VendingMachineJframe {
    private static int numberProduct;
    private static HashMap<ProductJframe, Integer> numberProducts;

    static {
        VendingMachineJframe.numberProduct = 1;
        VendingMachineJframe.numberProducts = new HashMap<ProductJframe, Integer>();
    }

    private HolderJframe holder;
    private CoinDispenserJframe dispenser;
    private List<ProductJframe> assortiment;

    /**
     * Конструктор
     * @param holder - держатель продукта (Экземпляр класса Holder)
     * @param dispenser - диспенсер для монет (Экземпляр класса CoinDispenser)
     * @param assortiment - ассортимент продуктов (Список List c элементами из экземпляров класса Product, либо его наследниками)
     */
    public VendingMachineJframe(HolderJframe holder, CoinDispenserJframe dispenser, List<ProductJframe> assortiment) {
        this.holder = holder;
        this.dispenser = dispenser;
        this.assortiment = assortiment;
        for (ProductJframe product : assortiment) {
            VendingMachineJframe.numberProducts.put(product, numberProduct++);
        }
    }

    /** Получить экземляр класса Holder */
    public HolderJframe getHolder() {
        return holder;
    }
    
    /** Получить экземпляр класса CoinDispenser */
    public CoinDispenserJframe getDispenser() {
        return dispenser;
    }

    /** Получить ассортимент продуктов (Список List c элементами из экземпляров класса Product, либо его наследниками)*/
    public List<ProductJframe> getProduct() {
        return assortiment;
    }

    /** Задать экземпляр класса Holder */
    public void setHolder(HolderJframe holder) {
        this.holder = holder;
    }

    /** Задать экземпляр класса CoinDispenser */
    public void setDispenser(CoinDispenserJframe dispenser) {
        this.dispenser = dispenser;
    }

    /** Задать ассортимент продуктов  (Список List c элементами из экземпляров класса Product, либо его наследниками)*/
    public void setProduct(List<ProductJframe> assortiment) {
        this.assortiment = assortiment;
    }

    public static int getNumberProducts(ProductJframe product) {
        return numberProducts.get(product);
    }
}
