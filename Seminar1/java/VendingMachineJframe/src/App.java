import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import domen.BottleJframe;
import domen.HotDrinkJframe;
import domen.ProductJframe;
import servis.CoinDispenserJframe;
import servis.HolderJframe;
import servis.VendingMachineJframe;

public class App {

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

    public static boolean isNumbers(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String showAssortiment(VendingMachineJframe machine) {
        JFrame assortiment = new JFrame("Ассортимент");
        assortiment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolKit.getScreenSize();
        assortiment.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 600);
        JTextComponent assortimentText = new JTextArea();
        String allAssortiment = "";
        for (ProductJframe prod : machine.getProduct()) {
            allAssortiment += String.format("%d. %s\n\n", VendingMachineJframe.getNumberProducts(prod), prod);
        }
        assortimentText.setText(allAssortiment);
        assortiment.add(assortimentText);
        assortimentText.setBackground(Color.black);
        assortimentText.setEditable(false);
        assortimentText.setForeground(Color.red);
        JPanel inputPanel = new JPanel();
        JLabel input = new JLabel("Выберите продукт из списка: ");
        JTextField tf = new JTextField(20);
        JButton choiceButton = new JButton("Выбрать");
        inputPanel.add(input);
        inputPanel.add(tf);
        inputPanel.add(choiceButton);
        choiceButton.setBackground(Color.black);
        choiceButton.setForeground(Color.red);
        assortiment.getContentPane().add(BorderLayout.SOUTH, inputPanel);
        assortiment.setVisible(true);
        String[] yourChoice = { "" };
        choiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yourChoice[0] = tf.getText();
                assortiment.dispose();
            }
        });

        while (yourChoice[0].isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if (yourChoice[0].equals("show")) {
            return showAssortiment(machine);
        } else {
            return yourChoice[0];
        }
    }

    public static void choiceProduct(VendingMachineJframe machine, int choice, CoinDispenserJframe dispenser) {
        String choiceProduct = "";
        for (ProductJframe product : machine.getProduct()) {
            if (VendingMachineJframe.getNumberProducts(product) == choice) {
                choiceProduct = String.format("Вы выбрали продукт = %s\nЦена продукта = %d рублей\n", product.getName(), product.getPrice());
            }
        }
        JFrame choiceFrame = new JFrame("Выбранный продукт");
        choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolKit.getScreenSize();
        choiceFrame.setBounds(dimension.width / 2 - 225, dimension.height / 2 - 225, 450, 450);
        JTextComponent choiceProductText = new JTextArea();
        choiceProductText.setText(choiceProduct);
        choiceFrame.add(choiceProductText);
        choiceProductText.setBackground(Color.black);
        choiceProductText.setEditable(false);
        choiceProductText.setForeground(Color.red);
        JPanel inputPanel = new JPanel();
        JLabel input = new JLabel("Внести деньги:");
        JTextField tf = new JTextField(20);
        JButton choiceButton = new JButton("Отправить");
        inputPanel.add(input);
        inputPanel.add(tf);
        inputPanel.add(choiceButton);
        choiceButton.setBackground(Color.black);
        choiceButton.setForeground(Color.red);
        choiceFrame.getContentPane().add(BorderLayout.SOUTH, inputPanel);
        choiceFrame.setVisible(true);
        String[] yourChoice = { "" };
        choiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yourChoice[0] = tf.getText();
                choiceFrame.dispose();
            }

        });

        while (yourChoice[0].isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if (isNumbers(yourChoice[0])) {
            dispenser.pay(Integer.parseInt(yourChoice[0]), choice);
        } else {
            choiceFrame.dispose();
            JFrame errorFrame = new JFrame("Ошибка!");
            String error = "Ошибка! Неккоректный ввод!";
            errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            errorFrame.setBounds(dimension.width / 2 - 225, dimension.height / 2 - 225, 450, 450);
            JTextComponent errorText = new JTextArea();
            errorText.setText(error);
            errorFrame.add(errorText);
            errorText.setBackground(Color.black);
            errorText.setEditable(false);
            errorText.setForeground(Color.red);
            JButton errorButton = new JButton("Ок");
            JPanel errorPanel = new JPanel();
            errorPanel.add(errorButton);
            errorFrame.getContentPane().add(BorderLayout.SOUTH, errorButton);
            errorFrame.setVisible(true);
            errorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    errorFrame.dispose();
                }
            });
        }
    }

    public static String errorChoice(VendingMachineJframe machine) {
        JFrame error = new JFrame("Некорректный выбор");
        error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolKit.getScreenSize();
        error.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 300, 600, 600);
        JTextComponent assortimentText = new JTextArea();
        String allAssortiment = "Некорректный ввод! Пожалуйста, выберите продукт из списка!\nВведите \"show\", чтобы показать ассортимент";
        assortimentText.setText(allAssortiment);
        error.add(assortimentText);
        assortimentText.setBackground(Color.black);
        assortimentText.setEditable(false);
        assortimentText.setForeground(Color.red);
        JPanel inputPanel = new JPanel();
        JLabel input = new JLabel("Выберите продукт из списка: ");
        JTextField tf = new JTextField(20);
        JButton choiceButton = new JButton("Выбрать");
        inputPanel.add(input);
        inputPanel.add(tf);
        inputPanel.add(choiceButton);
        choiceButton.setBackground(Color.black);
        choiceButton.setForeground(Color.red);
        error.getContentPane().add(BorderLayout.SOUTH, inputPanel);
        error.setVisible(true);
        String[] yourChoice = { "" };
        choiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yourChoice[0] = tf.getText();
                error.dispose();
            }
        });

        while (yourChoice[0].isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if (yourChoice[0].equals("show")) {
            return showAssortiment(machine);
        } else {
            return yourChoice[0];
        }
    }

    public static void main(String[] args) throws Exception {
        // Создаю список ArrayList, в котором будут храниться экземпляры Produst
        List<ProductJframe> products = new ArrayList<>();

        // Создаю экземпляры класса Product
        ProductJframe product1 = new ProductJframe("Лэйс", 100, 0);
        ProductJframe product2 = new ProductJframe("Кока-колла", 50, 1);
        ProductJframe product3 = new ProductJframe("Милка", 80, 2);
        ProductJframe product4 = new BottleJframe("Акваминерале", 110, 3, 0.5);
        ProductJframe product5 = new HotDrinkJframe("Горячий шоколад", 160, 4, 50);

        // Добавляю экземпляры в список ArrayList
        Collections.addAll(products, product1, product2, product3, product4, product5);

        // Создаю экземпляр класса Holder
        HolderJframe holder = new HolderJframe();

        // Создаю экземпляр класса CoinDispenser
        CoinDispenserJframe dispenser = new CoinDispenserJframe(products);

        // Создаю экземпляр класса VendingMachine и передаю в качестве аргументов
        // экземпляры классов Holder и CoinDispenser, а также список продуктов ArrayList
        VendingMachineJframe machine = new VendingMachineJframe(holder, dispenser, products);

        // Вызываю метод, который выводит в консоль каждый продукт

        String choiceProduct = showAssortiment(machine);
        boolean error = !(isNumbers(choiceProduct) && Integer.parseInt(choiceProduct) > 0
                && Integer.parseInt(choiceProduct) <= products.size());
        if (!error) {
            clearConsole();
            choiceProduct(machine, Integer.parseInt(choiceProduct), dispenser);
        } else {
            while (error) {
                boolean threeConditionChoice = !(isNumbers(choiceProduct) && Integer.parseInt(choiceProduct) > 0
                        && Integer.parseInt(choiceProduct) <= products.size());
                if (threeConditionChoice) {
                    choiceProduct = errorChoice(machine);
                }
                error = !(isNumbers(choiceProduct) && Integer.parseInt(choiceProduct) > 0
                        && Integer.parseInt(choiceProduct) <= products.size());
                if (!error) {  
                    choiceProduct(machine, Integer.parseInt(choiceProduct), dispenser);
                }
            }
        }
        holder.work();
    }
}
