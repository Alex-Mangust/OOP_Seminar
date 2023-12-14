import java.util.ArrayList;
import java.util.List;

import domen.Bottle;
import domen.Product;
import servis.CoinDispenser;
import servis.Holder;
import servis.VendingMachine;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> product = new ArrayList<>();
        Product product1 = new Product("Лэйс", 100, 0);
        Product product2 = new Product("Кока-колла", 50, 1);
        Product product3 = new Product("Милка", 80, 2);
        Product product4 = new Bottle("Акваминерале", 110, 3, 0.5);
        product.add(product1);
        product.add(product2);
        product.add(product3);
        product.add(product4);
        Holder holder1 = new Holder();
        CoinDispenser dispenser1 = new CoinDispenser();
        VendingMachine machine = new VendingMachine(holder1, dispenser1, product);
        for (Product prod : machine.getProduct()) {
            System.out.println(prod);
        }
    }
}
