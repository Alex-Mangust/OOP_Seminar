package servis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import domen.ProductJframe;

public class CoinDispenserJframe extends HolderJframe {
    private HashMap<Integer, Integer> priceProducts = new HashMap<>();

    public CoinDispenserJframe(List<ProductJframe> products) {
        int i = 1;
        for (ProductJframe product : products) {
            this.priceProducts.put(i++, product.getPrice());
        }
    }

    public void pay(int coins, int numberProduct) {
        // JFrame workFrame = new JFrame("Работа");
        // String worked = "Гудение...";
        String pay = "";
        boolean confirmation = false;
        if (priceProducts.get(numberProduct) == coins) {
            pay = "Оплата прошла успешно! Ожидается выдача.";
            confirmation = true;
        } else if (priceProducts.get(numberProduct) < coins) {
            pay = String.format("Оплата прошла успешно! Ожидается выдача.\nВаша сдача %d рублей.",
                    coins - priceProducts.get(numberProduct));
            confirmation = true;
        } else {
            pay = "У вас недостаточно средств!";
        }
        JFrame payFrame = new JFrame("Покупка");
        JTextComponent payText = new JTextArea();
        JPanel payJPanel = new JPanel();
        payFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolKit.getScreenSize();
        payFrame.setBounds(dimension.width / 2 - 225, dimension.height / 2 - 225, 450, 450);
        payText.setText(pay);
        payJPanel.add(payText);
        payFrame.getContentPane().add(BorderLayout.CENTER, payJPanel);
        payText.setBackground(Color.black);
        payJPanel.setBackground(Color.black);
        payText.setEditable(false);
        payText.setForeground(Color.red);
        payFrame.setVisible(true);
        proofInWork(confirmation);
        try {
            TimeUnit.SECONDS.sleep(3);
            payFrame.dispose();
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

}