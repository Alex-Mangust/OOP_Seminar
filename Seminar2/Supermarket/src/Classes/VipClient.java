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
    
    public int getVipId() {
        return vipId;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }
    
    @Override
    public boolean checkinOfOrden() {
        return super.isTakeOrder;
    }

    @Override
    public boolean receptionOrder() {
        return checkinOfOrden();
    }

    @Override
    public String returnOrder() {
        if (receptionOrder()) {
            return String.format("Клиент %s вернул заказ и получил деньги.", super.name);
        } else {
            return String.format("У клиента %s не получилось вернуть заказ. Заказ не соотвествует требованиям!", super.name);
        }
    }
}
