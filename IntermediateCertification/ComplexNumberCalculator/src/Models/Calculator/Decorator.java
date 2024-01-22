package Models.Calculator;

import Controllers.Interfaces.iCalculator;
import Controllers.Interfaces.iLogger;
import Controllers.Interfaces.iLoggerFile;
import Models.ComplexNumber;

/** Класс, описывающий поведение декоратора, который расширяет функциональность калькулятора */
public class Decorator implements iCalculator {
    private iCalculator calculator; // Экземпляр класса калькулятора
    private iLogger logger; // Экземпляр класса логгера


    /**
     * Конструктор класса
     * @param calculator - калькулятор
     * @param logger - логгер
     */
    public Decorator(iCalculator calculator, iLogger logger) {
        this.calculator = calculator;
        this.logger = logger;
        if (logger instanceof iLoggerFile) ((iLoggerFile)logger).rewrite(); // Если логгер имплементирует интерфейс iLoggerFile, то вызывается функция, перезаписывающая файл, в который будет записываться сообщения логгера
    }

    /** Переопределенный метод для сложения комплексных чисел */
    @Override
    public iCalculator sum(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода sum с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.sum(arg);
        logger.log("Вызов метода sum произошел");
        return result;
    }

    /** Переопределенный метод для вычитания комплексных чисел */
    @Override
    public iCalculator diff(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода diff с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.diff(arg);
        logger.log("Вызов метода diff произошел");
        return result;
    }

    /** Переопределенный метод для умножения комплексных чисел */
    @Override
    public iCalculator multi(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода multi с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.multi(arg);
        logger.log("Вызов метода multi произошел");
        return result;
    }

    /** Переопределенный метод для деления комплексных чисел */
    @Override
    public iCalculator div(ComplexNumber arg) {
        ComplexNumber firstArg = calculator.result();
        logger.log(String.format("Первое значение калькулятора %s. Начало вызова метода div с параметром %s", firstArg.toString(), arg.toString()));
        iCalculator result = calculator.div(arg);
        logger.log("Вызов метода div произошел");
        return result;
    }

    /** Переопределенный метод для получения результата операций */
    @Override
    public ComplexNumber result() {
        ComplexNumber result = calculator.result();
        logger.log(String.format("Получение результата %s", result));
        return result;
    }

    /** Переопределенный метод, для вывода в консоль и логирования сообщения об ошибке, если пользователь, при делении, ввел в качестве делителя нули */
    @Override
    public void inputZero(String error) {
        logger.log(error);
        System.out.println(error);
    }
    
}
