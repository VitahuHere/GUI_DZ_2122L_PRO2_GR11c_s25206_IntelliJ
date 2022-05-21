import game.controllers.MenuController;
import game.frames.MenuFrame;

public class Main {

    public static void main(String[] args) {
        MenuController controller = new MenuController(new MenuFrame());
        controller.start();
    }
}
