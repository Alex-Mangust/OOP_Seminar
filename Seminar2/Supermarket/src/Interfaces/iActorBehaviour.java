package Interfaces;

import Classes.Actor;

/** Интерфейс iActorBehaviour описывает поведение клиента */
public interface iActorBehaviour {

    /** Объявленый метод isTakeOrder, отвечающий за возвращение статуса получения заказа */
    public boolean isTakeOrder();

     /** Объявленый метод isMakeOrder, отвечающий за возвращение статуса заказа */
    public boolean isMakeOrder();

     /** Объявленый метод setTakeOrder, отвечающий за установку статуса получения заказа */
    public void setTakeOrder(boolean value);

    /** Объявленый метод setMakeOrder, отвечающий за установку статуса заказа */
    public void setMakeOrder(boolean value);

    /** Объяввленый метод getActor, отвечающий за возвращение экземпляра классаActor */
    public Actor getActor();
}
