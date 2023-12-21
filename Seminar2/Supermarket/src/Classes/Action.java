package Classes;


public class Action {
    private String nameAction;
    private static int maxCountParticipant;
    
    public Action(String nameAction, int maxCountParticipant) {
        this.nameAction = nameAction;
        Action.maxCountParticipant = maxCountParticipant;
    }

    public String getNameAction() {
        return nameAction;
    }

    public static int getMaxCountParticipant() {
        return maxCountParticipant;
    }
}
