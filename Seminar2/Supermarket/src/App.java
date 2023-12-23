import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromotionalClient;
import Classes.TaxInspector;
import Classes.VipClient;
import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            File file = new File("C:\\Users\\Саня\\Desktop\\Учеба\\Программирование. Специализация\\Объектно-ориентированное программирование. Семинары\\OOP_Seminar\\Seminar2\\Supermarket\\src\\log.txt");
             
            FileOutputStream fos = new FileOutputStream(file);
            
            PrintStream ps = new PrintStream(fos);
        
            System.setOut(ps);

            Market market = new Market();

            iActorBehaviour actor1 = new OrdinaryClient("Саша");
            iActorBehaviour actor2 = new OrdinaryClient("Маша");
            iActorBehaviour actor3 = new VipClient("Миша", 1);
            iActorBehaviour inspector = new TaxInspector();

            market.acceptToMarket(actor1);
            market.acceptToMarket(actor2);
            market.acceptToMarket(actor3);
            market.acceptToMarket(inspector);

            iActorBehaviour actorPromotional = new PromotionalClient("Аня", "Акция 1");
            iActorBehaviour actorPromotional1 = new PromotionalClient("Глеб", "Акция 1");
            iActorBehaviour actorPromotional2 = new PromotionalClient("Костя", "Акция 1");
            iActorBehaviour actorPromotional3 = new PromotionalClient("Катя", "Акция 1");
            iActorBehaviour actorPromotional4 = new PromotionalClient("Никита", "Акция 1");
            iActorBehaviour actorPromotional5 = new PromotionalClient("Ира", "Акция 1");

            market.acceptToMarket(actorPromotional);
            market.acceptToMarket(actorPromotional1);
            market.acceptToMarket(actorPromotional2);
            market.acceptToMarket(actorPromotional3);
            market.acceptToMarket(actorPromotional4);
            market.acceptToMarket(actorPromotional5);
            
            market.update();
            System.out.println("\n__________________________\n__________________________\n");
            market.acceptToMarket(actorPromotional);
            market.acceptToMarket(actorPromotional1);
            market.update();

            System.out.println();
            System.out.println(String.format("Количество людей, принимающих участие в акции - %d", PromotionalClient.getCountParticipant()));
            System.out.println(String.format("Максимальное количество участников в акции - %d", Market.getCountMaxParticipantInAction()));
            System.out.println();
            
            // try {
            //     System.out.println(((iReturnOrder) actor1).returnOrder());
            // } catch (Exception e) {
            //     System.out.println(e.getMessage());
            // }
            ps.close();
            fos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
