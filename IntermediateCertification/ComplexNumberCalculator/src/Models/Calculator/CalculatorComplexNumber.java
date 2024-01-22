package Models.Calculator;

import Controllers.Interfaces.iCalculator;
import Models.ComplexNumber;

/**
 * Класс, описывающий поведение калькулятора комплексных чисел.
 * Имеет интерфейс iCalculator
 */
public class CalculatorComplexNumber implements iCalculator {
    private ComplexNumber primaryArg = new ComplexNumber(0, 0); // Комплексное число, инициализируемое при создании экземпляра класса CalculatorComplexNumber

    /** Переопределенный метод для сложения комплексных чисел */
    @Override
    public iCalculator sum(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() + arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() + arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    /** Переопределенный метод для вычитания комплексных чисел */
    @Override
    public iCalculator diff(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() - arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() - arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    /** Переопределенный метод для умножения комплексных чисел */
    @Override
    public iCalculator multi(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() * arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() * arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    /** Переопределенный метод для деления комплексных чисел */
    @Override
    public iCalculator div(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() / arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() / arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    /** Переопределенный метод для получения результата операций */
    @Override
    public ComplexNumber result() {
        return primaryArg;
    }
}
