import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


import domen.Bottle;
import domen.HotDrink;
import domen.Product;
import servis.CoinDispenser;
import servis.Holder;
import servis.VendingMachine;

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

    public static void showAssortiment(VendingMachine machine) {
        for (Product prod : machine.getProduct()) {
            System.out.printf("%d. %s\n",VendingMachine.getNumberProducts(prod), prod);
            
        }
    }

    public static void choiceProduct(VendingMachine machine, int choice, CoinDispenser dispenser, Scanner pay) {
        for (Product product : machine.getProduct()) {
            if (VendingMachine.getNumberProducts(product) == choice) {
                System.out.printf("Вы вабрали продукт = %s\nЦена продукта = %d рублей\n", product.getName(), product.getPrice());
                System.out.print("Внести деньги: ");
                String yourPay = pay.nextLine();
                if (isNumbers(yourPay)) {
                    dispenser.pay(Integer.parseInt(yourPay), choice);
                } else {
                    System.out.println("Ошибка! Неккоректный ввод!");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // Создаю список ArrayList, в котором будут храниться экземпляры Produst
        List<Product> products = new ArrayList<>();

        // Создаю экземпляры класса Product
        Product product1 = new Product("Лэйс", 100, 0);
        Product product2 = new Product("Кока-колла", 50, 1);
        Product product3 = new Product("Милка", 80, 2);
        Product product4 = new Bottle("Акваминерале", 110, 3, 0.5);
        Product product5 = new HotDrink("Горячий шоколад", 160, 4, 50);

        // Добавляю экземпляры в список ArrayList
        Collections.addAll(products, product1, product2, product3, product4, product5);
        // product.add(product1);
        // product.add(product2);
        // product.add(product3);
        // product.add(product4);
        // product.add(product5);

        // Создаю экземпляр класса Holder
        Holder holder = new Holder();

        // Создаю экземпляр класса CoinDispenser
        CoinDispenser dispenser = new CoinDispenser(products);

        // Создаю экземпляр класса VendingMachine и передаю в качестве аргументов
        // экземпляры классов Holder и CoinDispenser, а также список продуктов ArrayList
        VendingMachine machine = new VendingMachine(holder, dispenser, products);

        // Вызываю метод, который выводит в консоль каждый продукт
        showAssortiment(machine);

        //
        //
        //
        // Код выше выполняет задачу из домашнего заданяя, далее идет моя доработка.
        Scanner yourChoice = new Scanner(System.in);
        System.out.print("Выберите продукт из списка: ");
        String choiceProduct = yourChoice.nextLine();
        boolean error = !(isNumbers(choiceProduct) && Integer.parseInt(choiceProduct) > 0
                && Integer.parseInt(choiceProduct) <= products.size());
        if (!error) {
            clearConsole();
            choiceProduct(machine, Integer.parseInt(choiceProduct), dispenser, yourChoice);

        } else {
            clearConsole();
            boolean firstError = true, showAssortimentOpen = false;
            while (error) {
                boolean oneConditionChoice = (firstError && choiceProduct.equals(""));
                boolean twoConditionChoice = (!firstError && choiceProduct.equals(""));
                boolean threeConditionChoice = !(isNumbers(choiceProduct) && Integer.parseInt(choiceProduct) > 0 && Integer.parseInt(choiceProduct) <= products.size());
                if (oneConditionChoice || !(twoConditionChoice && threeConditionChoice)) {
                    System.out.println("Некорректный ввод! Пожалуйста, выберите продукт из списка!\nНажмите \"Enter\", чтобы показать ассортимент");
                }
                firstError = false;
                choiceProduct = yourChoice.nextLine();
                if (choiceProduct.equals("")) {
                    if (!showAssortimentOpen) {
                        clearConsole();
                        showAssortiment(machine);
                        showAssortimentOpen = true;
                    System.out.print("Выберите продукт из списка: ");
                    } else {
                        clearConsole();
                        showAssortimentOpen = false;
                        System.out.println("Некорректный ввод! Пожалуйста, выберите продукт из списка!\nНажмите \"Enter\", чтобы показать ассортимент");
                    }
                } else {
                    error = !(isNumbers(choiceProduct) && Integer.parseInt(choiceProduct) > 0
                            && Integer.parseInt(choiceProduct) <= products.size());
                    clearConsole();
                    showAssortimentOpen = false;
                    if (!error) {
                        clearConsole();
                        choiceProduct(machine, Integer.parseInt(choiceProduct), dispenser, yourChoice);
                    }
                }
            }
        }
        holder.work();
        yourChoice.close();
    }
}
