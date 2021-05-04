/**
 * Class NoMansBudget - Creates a two dimensional solar system containing
 * planets orbiting around a star. The planets are clickable and if a planet is
 * clicked, the user will be transported to the planet to walk around and
 * explore in a two dimensional setting.
 * 
 * @author Love Lindgren
 * @author Samin
 * @version 2021-05-04
 */
public class NoMansBudget {
    private Display display;

    public NoMansBudget() {
        this.display = new Display();
    }

    public static void main(String[] args) {
        NoMansBudget program = new NoMansBudget();
    }
}
