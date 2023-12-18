package Classes;

public class VipClient extends Actor {
    
    private int vipId;

    public VipClient(String name, int vipId) {
        super(name);
        this.vipId = vipId;
    }

    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    public void setTakeOrder(boolean value) {
        super.isTakeOrder = value;
    }
    public void setMakeOrder(boolean value) {
        super.isMakeOrder = value;
    }

    public Actor getActor() {
        return this;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
    
}
