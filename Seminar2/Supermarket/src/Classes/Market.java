package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.iActorBehaviour;
import Interfaces.iMarcketBehaviour;
import Interfaces.iQueueBehaviour;

public class Market implements iMarcketBehaviour,iQueueBehaviour {

    private List<iActorBehaviour> queue;
    private static int countParticipantInAction;
    
    static {
        countParticipantInAction = 0;
    }

    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
    }

    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        System.out.println(String.format("Клиент %s пришел в магазин", actor.getActor().getName()));
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        System.out.println(String.format("Клиент %s добавлен в очередь\n", actor.getActor().getName()));
    }

    @Override
    public void releseFromMarket(List<iActorBehaviour> actors) {
        for (iActorBehaviour actor : actors) {
            System.out.println(String.format("Клиент %s ушел из магазина", actor.getActor().getName()));
            queue.remove(actor);
        }

    }

    @Override
    public void update() {
        takeOrder();
        System.out.println();
        giveOrder();
        System.out.println();
        releaseFromQueue();
    }

    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                if (!(actor instanceof PromotionalClient)) {
                    actor.setTakeOrder(true);
                    System.out.println(String.format("Клиент %s получил свой заказ", actor.getActor().getName()));
                } else {
                    if (countParticipantInAction != Action.getMaxCountParticipant()) {
                        actor.setTakeOrder(true);
                        countParticipantInAction++;
                        System.out.println(String.format("Клиент %s получил свой заказ", actor.getActor().getName()));
                    }  else {
                        System.out.println(String.format("Клиенту %s отказано в получении заказа! Превышено максимальное колличество участников в акции.", actor.getActor().getName()));
                    }

                }
            }
        }

    }

    @Override
    public void releaseFromQueue() {
        List<iActorBehaviour> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor);
                System.out.println(String.format("Клиент %s ушел из очереди", actor.getActor().getName()));
            }
        }
        releseFromMarket(releaseActors);
    }

    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(String.format("Клиент %s сделал заказ", actor.getActor().getName()));

            }
        }

    }



}