package Interfaces;

/** Интерфейс iQueueBehaviour описывает работу очереди клиентов */
public interface iQueueBehaviour {
    /** Объявленый метод takeInQueue, отвечающий за добавления клиента в очередь */
    public void takeInQueue(iActorBehaviour actor);

    /** Объявленый метод releaseFromQueue, отвечающий за покидание клиентом очереди */
    public void releaseFromQueue();

    /**
     * Объявленый метод giveOrder, отвечающий за получение клиентом своего заказа, либо за
     * отказ в получении заказа
     */
    public void giveOrder();

    /** Объявленый метод takeOrder, отвечающий за то, что клиент сделал заказ */
    public void takeOrder();
}
