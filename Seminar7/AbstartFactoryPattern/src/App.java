import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Fabric.EmeraldGenerator;
import Fabric.GemGenerator;
import Fabric.GoldGenerator;
import Fabric.ItemGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        ItemGenerator gemFabric = new GemGenerator();
        ItemGenerator goldFabric = new GoldGenerator();
        ItemGenerator emeraldFabric = new EmeraldGenerator();


        List<ItemGenerator> fabrics = new ArrayList<>();
        fabrics.add(gemFabric);
        fabrics.add(emeraldFabric);
        fabrics.add(gemFabric);
        fabrics.add(goldFabric);
        fabrics.add(gemFabric);
        fabrics.add(gemFabric);
        fabrics.add(gemFabric);
        fabrics.add(goldFabric);
        fabrics.add(goldFabric);
        fabrics.add(goldFabric);
        fabrics.add(goldFabric);

        Random randomFabricGenerator = ThreadLocalRandom.current();
        // for (int i = 0; i < fabrics.size(); i++) {
        //     int index = randomFabricGenerator.nextInt(fabrics.size());
        //     fabrics.get(index).openReward();
            
        // }
        int index = randomFabricGenerator.nextInt(fabrics.size());
        fabrics.get(index).openReward();
    }
}
