package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;

/** 
 * Абстрактный класс Actor, имеющий интерфейсы iActorBehavior и iReturnOrder
 * @param name -  имя покупателя
 * @param isTakeOrder - статус получения заказа
 * @param isMakeOrder - статус заказа
 * */
public abstract class Actor implements iActorBehaviour, iReturnOrder {
    protected String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    /**
     * Конструктор класса
     * @param name - имя покупателя
     */
    public Actor(String name) {
        this.name = name;
    }

    /**
     * Абстрактный метод, принимающий параметр типа String. Реализация описана в классах наследниках
     * @param name - имя покупателя
     */
    public abstract void setName(String name);

    /**
     * Абстрактный метод, принимающий параметр типа String. Реализация описана в классах наследниках
     * @return - возвращает String значение
     */
    public abstract String getName();
}
