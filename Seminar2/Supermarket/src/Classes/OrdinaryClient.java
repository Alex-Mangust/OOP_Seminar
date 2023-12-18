package Classes;

public class OrdinaryClient extends Actor {

    public OrdinaryClient(String name) {
        super(name);
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
