package Classes;

import Interfaces.iActorBehaviour;

public class TaxInspector implements iActorBehaviour {
    private String name;
    private boolean isMakeOrder;
    private boolean isTakeOrder;
    public TaxInspector() {
        this.name = "Tax audit";
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean isTakeOrder() {
        return isTakeOrder;
    }
    @Override
    public boolean isMakeOrder() {
        return isMakeOrder;
    }
    @Override
    public void setTakeOrder(boolean value) {
        isTakeOrder = value;
    }
    @Override
    public void setMakeOrder(boolean value) {
        isTakeOrder = value;
    }
    @Override
    public Actor getActor() {
        return new OrdinaryClient(name);
    }

}
