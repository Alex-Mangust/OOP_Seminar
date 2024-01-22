package Models;
public class ComplexNumber {
    private static Character imaginaryUnit = 'i';
    private int firstRealNumber;
    private int secondRealNumber;
    private String complexNumber = new String();

    public ComplexNumber(int firstNumber, int secondNumber) {
        String sign = new String();
        this.firstRealNumber = firstNumber;
        this.secondRealNumber = secondNumber;
        if (secondNumber >= 0)
            sign = "+";
        else if (secondNumber == -1)
            sign = "-";
        if (secondNumber == 1 || secondNumber == -1)
            complexNumber += firstNumber + sign + imaginaryUnit;
        else
            complexNumber += firstNumber + sign + secondNumber + imaginaryUnit;
    }

    public int getFirstRealNumber() {
        return firstRealNumber;
    }

    public int getSecondRealNumber() {
        return secondRealNumber;
    }

    @Override
    public String toString() {
        return complexNumber;
    }
}
