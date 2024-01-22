package Models.Calculator;

import Controllers.Interfaces.iCalculator;
import Models.ComplexNumber;

public class CalculatorComplexNumber implements iCalculator {
    private ComplexNumber primaryArg = new ComplexNumber(0, 0);

    @Override
    public iCalculator sum(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() + arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() + arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    @Override
    public iCalculator diff(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() - arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() - arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    @Override
    public iCalculator multi(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() * arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() * arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    @Override
    public iCalculator div(ComplexNumber arg) {
        int firstNumber = primaryArg.getFirstRealNumber() / arg.getFirstRealNumber();
        int secondNumber = primaryArg.getSecondRealNumber() / arg.getSecondRealNumber();
        primaryArg = new ComplexNumber(firstNumber, secondNumber);
        return this;
    }

    @Override
    public ComplexNumber result() {
        return primaryArg;
    }

   
}
