package Models;

/** Класс, описывающий поведение комплексного числа */
public class ComplexNumber {
    private static Character imaginaryUnit = 'i'; // Мнимая единица
    private int firstRealNumber; // Первое вещественное число
    private int secondRealNumber; // Второе вещественное число
    private String complexNumber = new String(); // Поле для записи комплексного числа

    /**
     * Конструктор класса
     * @param firstNumber - первое вещественное число
     * @param secondNumber - второе вещественное число
     */
    public ComplexNumber(int firstNumber, int secondNumber) {
        String sign = new String();
        this.firstRealNumber = firstNumber;
        this.secondRealNumber = secondNumber;
        if (secondNumber >= 0) // Если условие выполняется, то перед первым вещественным числом и вторым вещественным числом ставится знак '+'
            sign = "+";
        else if (secondNumber == -1) // Если условие выполняется, то перед первым вещественным числом и вторым вещественным числом ставится знак '-'. Необходимо, так как при выполнении этого условие второе вещественное число не записывается
            sign = "-";
        if (secondNumber == 1 || secondNumber == -1)
            complexNumber += firstNumber + sign + imaginaryUnit; // Если второе вещественное число равняется 1 или -1, то оно не записывается. Нужно для того, чтобы комплексное число имело форму, например, 2 + i (второе число = 1) или 2 - i (второе число = - 1), а не, например, 2 + 1i или 2 - 1i
        else
            complexNumber += firstNumber + sign + secondNumber + imaginaryUnit;
    }

    /** Метод, для получение первого вещественного числа*/
    public int getFirstRealNumber() {
        return firstRealNumber;
    }
    
    /** Метод, для получение второго вещественного числа*/
    public int getSecondRealNumber() {
        return secondRealNumber;
    }

    /** Переопределенный метод. Возвращает строку с информацией об экземпляре класса */
    @Override
    public String toString() {
        return complexNumber;
    }
}
