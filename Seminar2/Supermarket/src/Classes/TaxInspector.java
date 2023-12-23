package Classes;

import Interfaces.iActorBehaviour;

/**
 * Класс TaxInspector, имеющий интерфейс iActorBehaviour
 * Описывает инспектора магазина
 */
public class TaxInspector implements iActorBehaviour {
    private String name; // Имя инспектора
    private boolean isMakeOrder; // статус заказа
    private boolean isTakeOrder; // статус получения заказа

    /** 
     * Конструктор класса
     */
    public TaxInspector() {
        this.name = "Tax audit";
    }

    /** Возвращает имя инспектора */
    public String getName() {
        return name;
    }

    /** Метод возвращает значение статуса получения заказа */
    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }

    /** Метод возвращает значение статуса заказа */
    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    /** Метод задает значение статуса получения заказа */
    @Override
    public void setTakeOrder(boolean value) {
        isTakeOrder = value;
    }

    /** Метод задает значение статуса заказа */
    @Override
    public void setMakeOrder(boolean value) {
        isTakeOrder = value;
    }

     /** Метод возвращает экземпляр класса Actor */
    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }

}
