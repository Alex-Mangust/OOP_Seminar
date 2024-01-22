package Controllers.Interfaces;

import Models.ComplexNumber;

public interface iCalculator {
    iCalculator sum(ComplexNumber arg);
    iCalculator diff(ComplexNumber arg);
    iCalculator multi(ComplexNumber arg);
    iCalculator div(ComplexNumber arg);
    ComplexNumber result();
}
