package Classes;

public class PromotionalClient extends Actor {
    private static int countParticipant;

    private String nameAction;
    private int clientId;
    
    static {
        countParticipant = 0;
    }


    public PromotionalClient(String name, Action nameAction, int clientId) {
        super(name);
        this.nameAction = nameAction.getNameAction();
        this.clientId = clientId;
        countParticipant++;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public void setTakeOrder(boolean value) {
        super.isTakeOrder = value;
    }
    
    @Override
    public void setMakeOrder(boolean value) {
        super.isMakeOrder = value;
    }

    @Override
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
    

    public String getNameAction() {
        return nameAction;
    }

    public int getClientId() {
        return clientId;
    }

    public static int getCountParticipant() {
        return countParticipant;
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
