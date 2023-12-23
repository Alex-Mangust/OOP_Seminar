package Classes;

/**
 * Класс OrdinaryClient наследник класса Actor
 * Описывает обычного клиента
 */
public class OrdinaryClient extends Actor {

    /**
     * Конструктор класса
     * @param name - имя клиента
     */
    public OrdinaryClient(String name) {
        super(name);
    }


    /** Метод возвращает значение статуса получения заказа */
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    /** Метод возвращает значение статуса заказа */
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    /** Метод задает значение статуса получения заказа */
    public void setTakeOrder(boolean value) {
        super.isTakeOrder = value;
    }

    /** Метод задает значение статуса заказа */
    public void setMakeOrder(boolean value) {
        super.isMakeOrder = value;
    }

    /** Метод возвращает экземпляр класса Actor */
    public Actor getActor() {
        return this;
    }

    /** Переопределенный метод из класса родителя. Возвращает имя клиента */
    @Override
    public String getName() {
        return super.name;
    }

    /**
     * Переопределенный метод из класса родителя. Задает имя клиента
     * Принимает в качестве аргумента String значение.
     * @param name - имя клиента*/
    @Override
    public void setName(String name) {
        super.name = name;
    }

    /**
     * Переопределенный метод из интерфейса iReturnOrder
     * Метод проверяет заказ на возможность возврата 
     * */
    @Override
    public boolean receptionOrder() {
        return super.isTakeOrder;
    }

    /**
     * Переопределенный метод из интерфейса iReturnOrder
     * Метод вызывает сообщение о том, что заказ принят и деньги возвращены клиенту, если receptionOrder возвращает значение true, и вызывает сообщение об отказе, если метод возвращает false
     */
    @Override
    public String returnOrder() {
        if (receptionOrder()) {
            return String.format("Клиент %s вернул заказ и получил деньги.", super.name);
        } else {
            return String.format("У клиента %s не получилось вернуть заказ. Заказ не соотвествует требованиям!", super.name);
        }
    }

}
