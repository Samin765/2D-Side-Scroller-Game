/**
 * Class NoMansBudget - Creates a two dimensional solar system containing
 * planets orbiting around a star. The planets are clickable and if a planet is
 * clicked, the user will be transported to the planet to walk around and
 * explore in a two dimensional setting.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-04
 */
public class NoMansBudget implements Runnable {
    private Display display;
    private boolean run = false;
    private Thread thread;


    public NoMansBudget() {
        start();
    }

    public static void main(String[] args) {
        NoMansBudget program = new NoMansBudget();
    }
    // updates the state of the game 
    private void update(){
          
        
    }
    // renders the update to the display
    private void render(){

    }
    private void initialize(){
        this.display = new Display();

    }

    public void run(){
        // Opens the game window
        initialize();  
        // The game loop. Runs until run becomes false
        while(run){
            update();
            render();

        }
        stop();

    }
    // Calling this method starts the game in a new thread
    public synchronized void start(){
        // do nothing if the game is already running
        if(run){
            return;
        }
        thread = new Thread(this);
        thread.start();

    }
    // stops the game
    public synchronized void stop(){
        if(!run){
            return;
        }
        try{
            thread.join();
        }
        catch (Exception e){

        }
        
        
    }
}

