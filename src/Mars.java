
import java.awt.Color;
import java.awt.Graphics2D;


public class Mars extends WorldState{

private Player testChar;

   public Mars(NoMansBudget game){
       super(game);
       testChar = new Player(50,280);

   }

    public void update(){
        testChar.update();

    }

    public void render(Graphics2D g2){
         // Draw components
        
        g2.drawImage(Resources.marsBackground, 0, 0 ,null);
        testChar.render(g2);
    }
}