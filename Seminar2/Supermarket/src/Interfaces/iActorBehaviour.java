package Interfaces;

import Classes.Actor;

public interface iActorBehaviour {

    public boolean isTakeOrder();
    public boolean isMakeOrder();
    public void setTakeOrder(boolean value);
    public void setMakeOrder(boolean value);
    public Actor getActor();
}
