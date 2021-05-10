
import java.awt.Color;
import java.awt.Graphics2D;


public class SolarSystem extends WorldState{

    private WorldMaps worlds;
    private Graphics2D g2;

     static final String solarSystemBackground = "../spaceStars.jpeg"; // add images to resources class instead 
    static final String marsBackground = "../marsBackground.png";     

   public SolarSystem(){
    worlds = new WorldMaps();
    worlds.solarSystem(solarSystemBackground, g2); 

   }

    public void update(){
        this.worlds.planet1.move(this.worlds.sun.getX(), this.worlds.sun.getY());
        this.worlds.planet2.move(this.worlds.sun.getX(), this.worlds.sun.getY());

    }

    public void render(Graphics2D g2){
        
        // Draw components
        worlds.drawSolarSystemBackground(g2, Resources.solarSystemBackground);  

        worlds.sun.draw(g2, Color.YELLOW);

        worlds.planet1.draw(g2, Color.GREEN);
        worlds.planet2.draw(g2, Color.BLUE);

        //State newGameState = new Mars();  
        //State.setState(newGameState);  // this will change the state of the game to mars

       



    }
}