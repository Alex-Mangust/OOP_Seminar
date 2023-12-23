package Classes;

/**
 * Класс PromotionalClient наследник класса Actor
 * Описывает акционного клиента
 * @param nameAction - название акции
 * @param clientId - уникальный id клиента
 * @staticParam countParticipant - количество клиентов
 */
public class PromotionalClient extends Actor {
    private static int countParticipant;  // Количество участников акции

    private String nameAction; // Название акции
    private int clientId; // id клиента
    
    static {
        countParticipant = 0;
    }

    /**
     * Конструктор класса
     * @param name - имя клиента
     * @param nameAction - название акции
     * 
     * @unicalId clientId - уникальный id, присваиваемый на основе количества желающих участников акции
     */
    public PromotionalClient(String name, String nameAction) {
        super(name);
        this.nameAction = nameAction;
        this.clientId = countParticipant;
        countParticipant++;
    }

    /** Метод возвращает значение статуса получения заказа */
    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    /** Метод возвращает значение статуса заказа */
    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    /** Метод задает значение статуса получения заказа */
    @Override
    public void setTakeOrder(boolean value) {
        super.isTakeOrder = value;
    }
    
    /** Метод задает значение статуса заказа */
    @Override
    public void setMakeOrder(boolean value) {
        super.isMakeOrder = value;
    }

    /** Метод возвращает экземпляр класса Actor */
    @Override
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
    
    /** Метод возвращает название акции */
    public String getNameAction() {
        return nameAction;
    }

    /** Метод возвращает id клиента */
    public int getClientId() {
        return clientId;
    }

    /** Метод возвращает количество клиентов желающих учавствовать в акции */
    public static int getCountParticipant() {
        return countParticipant;
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
