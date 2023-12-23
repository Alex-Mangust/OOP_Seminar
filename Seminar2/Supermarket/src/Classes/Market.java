package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.iActorBehaviour;
import Interfaces.iMarcketBehaviour;
import Interfaces.iQueueBehaviour;

/**
 * Класс Market, имеющий интерфейсы iMarcketBehaviour и iQueueBehaviour
 * 
 * @static countParticipantInAction - количество участников в акции
 * @param List<iActorBehaviour> queue - очередь из покупателей
 * Класс описывает работу магазина
 */
public class Market implements iMarcketBehaviour, iQueueBehaviour {
    private static int countMaxParticipantInAction; // Максимальное количество участников акции
    private static int countParticipantInAction; // Оставшееся количество людей, которые могут учавствовать в акции

    private List<iActorBehaviour> queue; // очередь из покупателей. Создается при инициализации экземпляра класса

    static {
        countMaxParticipantInAction = 4;
        countParticipantInAction = countMaxParticipantInAction;
    }

    /**
     * Конструктор класса
     */
    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
    }

    /**
     * Переопределенный метод из интерфейса iMarketBehaviour
     * В качестве аргумента принимает экземпляр интерфейса iActorBehaviour
     * Метод вызывает сообщение о том, что клиент пришел в магазин и вызывает метод
     * takeInQueue
     * 
     * @param actor - экземпляр интерфейса iActorBehaviour
     */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println(String.format("Клиент %s пришел в магазин", actor.getActor().getName()));
        takeInQueue(actor);
    }

    /**
     * Переопределенный метод из интерфейса iQueueBehaviour
     * В качестве аргумента принимает экземпляр интерфейса iActorBehaviour
     * Метод добавляет клиента в коллекцию List и вызвает сообщение о том, что
     * клиент добавлен в очередь
     * 
     * @param actor экземпляр интерфейса iActorBehaviour
     */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(String.format("Клиент %s добавлен в очередь\n", actor.getActor().getName()));
    }

    /**
     * Переопределенный метод из интерфейса iMarketBehaviour
     * В качестве агрумента принимает коллекцию List, состоящую из экземпляров
     * интерфейса iActorBehaviour
     * Метод вызывает сообщение о том, что клиент ушел из магазина, после чего
     * вызывает метод remove для коллекции List
     * 
     * @param actors - коллекция List<iActorBehaviour>
     */
    @Override
    public void releseFromMarket(List<iActorBehaviour> actors) {
        for (iActorBehaviour actor : actors) {
            System.out.println(String.format("Клиент %s ушел из магазина", actor.getActor().getName()));
            queue.remove(actor);
        }
        if (!queue.isEmpty()) queue.clear();

    }

    /**
     * Переопределенный метод из интерфейса iMarcketBehaviour
     * Вызывает методы takeOrder, giveOrder и releaseFromQueue
     */
    @Override
    public void update() {
        takeOrder();
        // System.out.println();
        giveOrder();
        // System.out.println();
        releaseFromQueue();
    }

    /**
     * Переопределенный метод из интерфейса iMarketBehaviour
     * Метод обрабатывает элементы коллекции List queue и, либо одобряет клиенту
     * выдачу заказа, либо нет
     */
    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) { // Цикл проходит по всем элементам queue
            if (actor.isMakeOrder()) {
                if (!(actor instanceof PromotionalClient)) { // Если элемент не является экземпляром класса PromotionalClient, выполняется следующий код
                    actor.setTakeOrder(true);
                    System.out.println(String.format("Клиент %s получил свой заказ", actor.getActor().getName()));
                } else {
                    if (countParticipantInAction != 0) { // Если количество участников акции не равно 0, акционному клиенту одобряется получение заказа, после чего колличество участников сокращается.
                        actor.setTakeOrder(true);
                        countParticipantInAction--;
                        System.out.println(String.format("Клиент %s получил свой заказ", actor.getActor().getName()));
                    } else {
                        System.out.println(String.format(
                                "Клиенту %s отказано в получении заказа! Превышено максимальное колличество участников акции.",
                                actor.getActor().getName()));
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * Переопределенный метод из интерфейс iQueueBehaviour
     * Метод создает новую коллекцию List и добавляет в нее всех обслуженных клиентов, после чего вызывает метод releseFromMarket и передает в него эту коллекцию в качестве аргумента
     */
    @Override
    public void releaseFromQueue() {
        List<iActorBehaviour> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor);
                System.out.println(String.format("Клиент %s ушел из очереди", actor.getActor().getName()));
            }
        }
        System.out.println();
        releseFromMarket(releaseActors);
    }

    /**
     * Переопределенный метод из интерфейса iQueueBehaviour
     * Метод обрабатывает каждый элемент коллекции List queue и выдает сообщение о
     * том, что клиент сделал заказ
     */
    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(String.format("Клиент %s сделал заказ", actor.getActor().getName()));
            } else {
                actor.setMakeOrder(false);
                System.out.println(actor.getActor().returnOrder());
            }
        }
        if (queue.getLast().getActor().isMakeOrder()) System.out.println();
    }

    /**
     * Метод возвращает оставшееся количество клиентов, которые могут сделать заказ в рамках условия акции
     */
    public static int getCountParticipantInAction() {
        return countParticipantInAction;
    }

    /** Метод возвращает максимальное количество клиентов, которые могли сделать заказ в рамках условия акциии */
    public static int getCountMaxParticipantInAction() {
        return countMaxParticipantInAction;
    }

}