package Views;

import java.util.Scanner;

import Controllers.Interfaces.iView;
import Models.ComplexNumber;

public class ViewCalculator implements iView{
    private boolean exit = false;
    @Override
    public String promptSign(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.print(msg);
        if (exit) in.close();
        return in.nextLine();
    }

    @Override
    public ComplexNumber prompt() {
        int firstRealNumber = Integer.parseInt(promptSign("Введите первое вещественное число: "));
        int secondRealNumber = Integer.parseInt(promptSign("Введите второе вещественное число: "));
        return new ComplexNumber(firstRealNumber, secondRealNumber);
    }

    @Override
    public String inputSignMessage() {
        return "Введите знак операции (+, -, *, /, =): ";
    }

    @Override
    public String result() {
        return "Результат %s\n";
    }

    @Override
    public String inputError() {
        return "Введен неверный знак!";
    }

    @Override
    public boolean nextRun() {
        String next = promptSign("Хотите продолжить? (Y/N)");
        if (next.toUpperCase().equals("Y")) return true;
        return false;
    }

    @Override
    public void titleProgram() {
        System.out.println("Калькулятор комплексных чисел!");
    }

}
