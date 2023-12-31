import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import Classes.Market;
import Classes.OrdinaryClient;
import Classes.PromotionalClient;
import Classes.TaxInspector;
import Classes.VipClient;
import Interfaces.iActorBehaviour;

public class App {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        PrintStream originalOut = System.out;
        PrintStream ps = null;
        FileOutputStream fos = null;
        try {
            File file = new File(
                    "OOP_Seminar\\Seminar2\\Supermarket\\src\\log.txt");

            fos = new FileOutputStream(file);

            ps = new PrintStream(fos);

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
            System.out.println(String.format("Количество людей, принимающих участие в акции - %d",
                    PromotionalClient.getCountParticipant()));
            System.out.println(String.format("Максимальное количество участников в акции - %d",
                    Market.getCountMaxParticipantInAction()));
            System.out.println();
            ps.close();
            fos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.setOut(originalOut);
        clearConsole();
        try (FileReader reader = new FileReader(
                "OOP_Seminar\\Seminar2\\Supermarket\\src\\log.txt")) {
            int charInFile;
            while ((charInFile = reader.read()) != -1) {
                System.out.print((char) charInFile);
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}