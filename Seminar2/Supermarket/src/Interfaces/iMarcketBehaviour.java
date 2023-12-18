package Interfaces;

import java.util.List;

public interface iMarcketBehaviour {
    public void acceptToMarket(iActorBehaviour actor);
    public void releseFromMarket(List<iActorBehaviour> actors);
    public void update();
}
