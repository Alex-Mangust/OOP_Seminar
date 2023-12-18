package servis;

import java.util.HashMap;
import java.util.List;

import domen.Product;

public class CoinDispenser extends Holder {
    private HashMap<Integer, Integer> priceProducts = new HashMap<>();
    
    public CoinDispenser(List<Product> products) {
        int i = 1;
        for (Product product : products){
            this.priceProducts.put(i++, product.getPrice());
        }
    }

    public void pay(int coins, int numberProduct) {
        if (priceProducts.get(numberProduct) == coins) {
            System.out.println("Оплата прошла успешно! Ожидается выдача.");
            proofInWork(true);
        } else if (priceProducts.get(numberProduct) <= coins) {
            System.out.println(String.format("Оплата прошла успешно! Ожидается выдача.\nВаша сдача %d рублей.", coins - priceProducts.get(numberProduct)));
            proofInWork(true);
        } else {
            System.out.println("У вас недостаточно средств!");
            proofInWork(false);
        }
        
    }
    
}