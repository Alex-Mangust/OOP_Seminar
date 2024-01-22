import java.util.Scanner;

public class ViewCalculator {
    private iCalculable calculator;

    public ViewCalculator(iCalculable calculator) {
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            int primaryArg = promtInt("Введите первый аргумент: ");
            calculator.sum(primaryArg);
            while (true) {
                String cmd = promt("Введите команду (*, +, =): ");
                if (cmd.equals("*")) {
                    int arg = promtInt("Введите второй аргумент: ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    int arg = promtInt("Введите второй аргуумент: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    int result = calculator.getResult();
                    System.out.printf("Результат %d\n", result);
                    break;
                }
            }
            String cmd = promt("Продолжить считать (Y/N)? ");
            if (cmd.equals("Y")) {
                calculator.sum(-calculator.getResult());
                continue;
            }
            break;
        }
    }

    private String promt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();

    }

    private int promtInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextInt();

    }
}
