package Views;

import java.util.Scanner;

import Controllers.Interfaces.iView;
import Models.ComplexNumber;

/**
 * Класс, описывающий поведение пользовательского интерфейса.
 * Имеет интерфейс iView
 */
public class ViewCalculator implements iView {
    private boolean exit = false; // Поле, отслеживающее завершена ли программа (Нужно только для того, чтобы закрыть сканнер и избавиться от предупреждения)

    /** Переопределенный метод, необходимый для ввода знака операции */
    @Override
    public String promptSign(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.print(msg);
        if (exit)
            in.close();
        return in.nextLine();
    }
    
    /** Переопределенный метод, необходимый для ввода вещественных чисел */
    @Override
    public ComplexNumber prompt(ComplexNumber currentNumber) {
        String firstRealNumber = promptSign("Введите первое вещественное число: ");
        String secondRealNumber = promptSign("Введите второе вещественное число: ");
        if (convertToNumber(firstRealNumber) && convertToNumber(secondRealNumber)) {
            return new ComplexNumber(Integer.parseInt(firstRealNumber), Integer.parseInt(secondRealNumber));
        }
        System.out.println("Вы ввели некорретные вещественные числа!");
        return currentNumber;
    }

    /** Переопределенный метод, необходимый для запроса у пользователя каких-либо действий*/
    @Override
    public String inputSignMessage() {
        return "Введите знак операции (+, -, *, /, =): ";
    }

    /** Переопределенный метод, необходимый для вывода в консоль результата операции */
    @Override
    public String result() {
        return "Результат %s\n";
    }

    /** Переопределенный метод, необходимый для вывода в консоль ошибки ввода */
    @Override
    public String inputError() {
        return "Введен неверный знак!";
    }

    /** Переопределенный метод, необходимый для проверки, желает ли пользователь продолжать работу */
    @Override
    public boolean nextRun() {
        String next = promptSign("Хотите продолжить? (Y/N)");
        if (next.toUpperCase().equals("Y"))
            return true;
        return false;
    }

    /** Переопределенный метод, необходимый для вывода в консоль заголовка с названием программы при запуске */
    @Override
    public void titleProgram() {
        System.out.println("Калькулятор комплексных чисел!");
    }
    
    public boolean convertToNumber(String numberConvert) {
        try {
            Integer.parseInt(numberConvert);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
