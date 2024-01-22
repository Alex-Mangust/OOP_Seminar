public class Decorator implements iCalculable {
    private Calculator calculator;
    private Logger logger;

    public Decorator(Calculator calculator, Logger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    @Override
    public iCalculable sum(int arg) {
        int firstArg = calculator.getResult();
        logger.log(String.format("Первое значение калькулятора %d. Начало вызова метода sum с параметром %d", firstArg, arg));
        iCalculable result = calculator.sum(arg);
        logger.log("Вызов метода sum произошел");

        return result;
    }

    @Override
    public iCalculable multi(int arg) {
        int firstArg = calculator.getResult();
        logger.log(String.format("Первое значение калькулятора %d. Начало вызова метода multi с параметром %d", firstArg, arg));
        iCalculable result = calculator.multi(arg);
        logger.log("Вызов метода multi произошел");

        return result;
    }

    @Override
    public int getResult() {
        int result = calculator.getResult();
        logger.log(String.format("Получение результата %d", result));
        return result;
    }
    
}
