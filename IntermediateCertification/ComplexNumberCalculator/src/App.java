import Controllers.ControllerCalculator;
import Controllers.Loggers.LoggerFile;
import Models.Calculator.CalculatorComplexNumber;
import Models.Calculator.Decorator;
import Views.ViewCalculator;

public class App {
    public static void main(String[] args) throws Exception {
        Decorator decorator = new Decorator(new CalculatorComplexNumber(), new LoggerFile());
        ControllerCalculator calculator = new ControllerCalculator(decorator, new ViewCalculator());
        calculator.run();
        
    }
}
