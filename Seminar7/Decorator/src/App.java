public class App {
    public static void main(String[] args) throws Exception {
        iCalculable decorator = new Decorator(new Calculator(0), new Logger());

        ViewCalculator calculator = new ViewCalculator(decorator);
        calculator.run();    
    }
}
