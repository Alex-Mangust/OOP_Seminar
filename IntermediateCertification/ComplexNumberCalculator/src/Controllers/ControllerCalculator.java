package Controllers;

import Controllers.Interfaces.iCalculator;
import Controllers.Interfaces.iView;
import Models.ComplexNumber;


/** Класс, описывающий взаимодействие модели с пользовательским интерфейсом */
public class ControllerCalculator {
    private iCalculator calculator; // Модель, с которой работает контроллер
    private iView view; // Пользовательский интерфейс, с которым работает контроллер

    /**
     * Конструктор класса
     * @param calculator - модель
     * @param view - пользовательский интерфейс
     */
    public ControllerCalculator(iCalculator calculator, iView view) {
        this.calculator = calculator;
        this.view = view;
    }

    /** Метод для запуска программы */
    public void run() {
        view.titleProgram(); // Вывод в консоль названия программы
        boolean nextRun = true; // Переменная, отвечающая за продолжение работы программы
        while (nextRun) {
            ComplexNumber primaryArg = view.prompt(calculator.result()); // Происходит запрос у пользователя первого комплексного числа
            calculator.sum(primaryArg); // В калькулятор записывается первое комплексное число (происходит сложение, так как изначально хранится 0+0i)
            while (nextRun) {
                String cmd = view.promptSign(view.inputSignMessage()); // Происходит запрос у пользователя знака операции
                ComplexNumber arg; 
                switch (cmd) { // В зависимости от знака операции, который ввел пользователь, происходит одно из следующих действий
                    case "+":
                        arg = view.prompt(calculator.result()); // Происходит запрос у пользователя второго комплексного числа
                        calculator.sum(arg); // Происходит сложение комплексных чисел
                        break;
                    case "-":
                        arg = view.prompt(calculator.result()); // Происходит запрос у пользователя второго комплексного числа
                        calculator.diff(arg); // Происходит вычитание комплексных чисел
                        break;
                    case "*":
                        arg = view.prompt(calculator.result()); // Происходит запрос у пользователя второго комплексного числа
                        calculator.multi(arg); // Происходит умножение комплексных чисел
                        break;
                    case "/":
                        arg = view.prompt(calculator.result()); // Происходит запрос у пользователя второго комплексного числа
                        if (arg.getFirstRealNumber() == 0 || arg.getSecondRealNumber() == 0) calculator.inputZero(view.inputZeroError()); // Если пользователь ввел нули в качестве делителя, выводится сообщение об ошибке.
                        else calculator.div(arg); // Происходит деление комплексных чисел
                        break;
                    case "=":
                        System.out.printf(view.result(), calculator.result()); // В консоль выводится сообщение с результатом выполненной операции
                        if (!view.nextRun()) nextRun = false; // Происходит запрос у пользователя, желает ли он продолжить работу с программой
                        break;
                    default:
                        System.out.println(view.inputError()); // Выводится сообщение об ошибке, сообщающая что пользователь ввел неверный знак операции
                        break;
                }
            }
        }
    }
}
