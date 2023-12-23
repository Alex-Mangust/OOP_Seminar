package Interfaces;

import java.util.List;

/** Интерфейс iMarcketBehaviour описывает работу магазина */
public interface iMarcketBehaviour {
    /** Объявленый метод acceptToMarket, отвечающий за то, что клиент пришел в магазин */
    public void acceptToMarket(iActorBehaviour actor);

    /** Объявленый метод releseFromMarket, отвечающий за уход клиента из магазина */
    public void releseFromMarket(List<iActorBehaviour> actors);

    /** Объявленый метод update, отвечающий за то, что клиент сделал заказ, за получение клиентом этого заказа и за покидание клиентом очереди */
    public void update();
}
