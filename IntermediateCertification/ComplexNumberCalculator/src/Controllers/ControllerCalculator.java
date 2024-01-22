package Controllers;

import Controllers.Interfaces.iCalculator;
import Controllers.Interfaces.iControler;
import Controllers.Interfaces.iView;
import Models.ComplexNumber;



public class ControllerCalculator implements iControler {
    private iCalculator calculator;
    private iView view;

    public ControllerCalculator(iCalculator calculator, iView view) {
        this.calculator = calculator;
        this.view = view;
    }

    @Override
    public void run() {
        view.titleProgram();
        boolean nextRun = true;
        while (nextRun) {
            ComplexNumber primaryArg = view.prompt();
            calculator.sum(primaryArg);
            while (nextRun) {
                String cmd = view.promptSign(view.inputSignMessage());
                ComplexNumber arg;
                switch (cmd) {
                    case "+":
                        arg = view.prompt();
                        calculator.sum(arg);
                        break;
                    case "-":
                        arg = view.prompt();
                        calculator.diff(arg);
                        break;
                    case "*":
                        arg = view.prompt();
                        calculator.multi(arg);
                        break;
                    case "/":
                        arg = view.prompt();
                        calculator.div(arg);
                        break;
                    case "=":
                        System.out.printf(view.result(), calculator.result());
                        if (!view.nextRun()) nextRun = false; 
                        break;
                    default:
                        System.out.println(view.inputError());
                        break;
                }
            }
        }
    }
}
