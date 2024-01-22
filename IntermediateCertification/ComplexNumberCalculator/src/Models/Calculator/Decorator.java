package Models.Calculator;

import Controllers.Logger;
import Controllers.Interfaces.iCalculator;
import Models.ComplexNumber;

public class Decorator implements iCalculator {
    private CalculatorComplexNumber calculator;
    private Logger logger;


    public Decorator(CalculatorComplexNumber calculator, Logger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }


    @Override
    public iCalculator sum(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода sum с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.sum(arg);
        logger.log("Вызов метода sum произошел");
        return result;
    }

    @Override
    public iCalculator diff(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода diff с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.diff(arg);
        logger.log("Вызов метода diff произошел");
        return result;
    }

    @Override
    public iCalculator multi(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода multi с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.multi(arg);
        logger.log("Вызов метода multi произошел");
        return result;
    }

    @Override
    public iCalculator div(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода div с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.div(arg);
        logger.log("Вызов метода div произошел");
        return result;
    }

    @Override
    public ComplexNumber result() {
        ComplexNumber result = calculator.result();
        logger.log(String.format("Получение результата %s", result));
        return result;
    }
    
}
