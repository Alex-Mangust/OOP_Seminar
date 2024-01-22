import Controllers.ControllerCalculator;
import Controllers.Loggers.LoggerFile;
import Models.Calculator.CalculatorComplexNumber;
import Models.Calculator.Decorator;
import Views.ViewCalculator;

public class App {
    public static void main(String[] args) throws Exception {
        Decorator decorator = new Decorator(new CalculatorComplexNumber(), new LoggerFile()); // Создаю экземпляр класса Decorator, в котором, в качестве аргументов, выступают экземпляр класса CalculatorComplexNumber и экземпляр класса LoggerFile
        ControllerCalculator calculator = new ControllerCalculator(decorator, new ViewCalculator()); // Создаю экземпляр класса ControllerCalculartir, в котором, в качестве аргумента, выступают экземпляр класса Decorator и экземпляр класса ViewCalculator
        calculator.run(); // Вызываю функцию для запуска программы
        
    }
}
