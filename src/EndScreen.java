import java.awt.Graphics2D;



public class EndScreen extends WorldState{
    /**
     * Loads a new "World" object for Mars
     * Initalizes the player object
     */



   public EndScreen(){

   }

    public void update(){

    }

    public void render(Graphics2D g2){
         // Draw components
         g2.drawImage(Resources.endScreen, 0, 0, 1280,800,null);  // renders the background first then renders the blocks
         



        
    }
}