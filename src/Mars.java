
import java.awt.Color;
import java.awt.Graphics2D;


public class Mars extends WorldState{



   public Mars(){

   }

    public void update(){

    }

    public void render(Graphics2D g2){
         // Draw components
        g2.drawImage(Resources.marsBackground, 0, 0 ,null);
    }
}