import java.awt.Graphics2D;

public abstract class WorldState{

    private static WorldState currentState = null;

    public static void setState(WorldState state){
        currentState = state;
    }

    public static WorldState getState(){
        return currentState;
    }
    

    public abstract void update();
    
    public abstract void render(Graphics2D g2);


}