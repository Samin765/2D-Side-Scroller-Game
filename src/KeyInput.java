import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Class KeyInput - Reads keyboard input from the user
 * and stores them into an array
 * 
 * @author Samin chowdhury
 * @version 2021-05-15
 */
public class KeyInput implements KeyListener{
    private boolean[] keys;
    public boolean up,down,right, left, jump, esc, aUp, aDown,aLeft,aRight;
    private Display display;
    
    final private static long keyReleasedTimeLock = 800L;
    private static long keyReleased;


    public KeyInput(Display display){
        keys = new boolean[300];
        this.display = display;

    }
    @Override
    public void keyPressed(KeyEvent event){  
    

    if(event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_SPACE){
        final long currentTime = System.currentTimeMillis();

        
            if( (currentTime - keyReleased) <= keyReleasedTimeLock){
                return;
            }
            keyReleased = System.currentTimeMillis();

        }

    keys[event.getKeyCode()] = true;
    }

    @Override
    public void keyTyped(KeyEvent event){

        
    }
    @Override
    public void keyReleased(KeyEvent event){
       
        
        keys[event.getKeyCode()] = false;

    }

    public void update(){ 
        jump = keys[KeyEvent.VK_W] || keys[KeyEvent.VK_SPACE]; // Player goes "up" if Up arrow or W is pressed
        down = keys[KeyEvent.VK_S];
        right = keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_A];
        esc = keys[KeyEvent.VK_ESCAPE];

        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];

        

    }

   

}