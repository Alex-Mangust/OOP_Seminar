import Classes.Actor;
import Classes.Market;
import Classes.OrdinaryClient;
import Classes.TaxInspector;
import Classes.VipClient;
import Interfaces.iActorBehaviour;

public class App {
    public static void main(String[] args) throws Exception {
        Market market = new Market();

        iActorBehaviour actor1 = new OrdinaryClient("Саша");
        iActorBehaviour actor2 = new OrdinaryClient("Маша");
        iActorBehaviour actor3 = new VipClient("Миша", 1);
        iActorBehaviour inspector = new TaxInspector();

        market.acceptToMarket(actor1);
        market.acceptToMarket(actor2);
        market.acceptToMarket(actor3);
        market.acceptToMarket(inspector);
        
        market.update();
        

    }
}
