package Controllers.Interfaces;

import Models.ComplexNumber;

public interface iView {
    String promptSign(String msg);
    ComplexNumber prompt();
    String inputSignMessage();
    String result();
    String inputError();
    boolean nextRun();
    void titleProgram();
}
