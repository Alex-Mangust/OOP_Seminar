package Controllers.Interfaces;

import Models.ComplexNumber;

/** Интерфейс, объявляющий поведение калькулятора комплексных чисел */
public interface iCalculator {
    iCalculator sum(ComplexNumber arg); // Объявленный метод, необходимый для сложения комплексных чисел
    iCalculator diff(ComplexNumber arg); // Объявленныый метод, необходимый для вычитания комплексных чисел
    iCalculator multi(ComplexNumber arg); // Объявленный метод, необходимый для умножения комплексных чисел
    iCalculator div(ComplexNumber arg); // Объявленный метод, необходимый для деления комплексных чисел
    ComplexNumber result(); // Объявленный метод, необходимый для получения результата операции
    void inputZero(String error); // Объявленный метод, необходимый для вывода сообщения об ошибке, если при делении пользователь введет нули
}
