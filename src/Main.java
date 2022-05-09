import game.controllers.MenuController;
import game.frames.GameFrame;

public class Main {

    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
        MenuController controller = new MenuController(frame);
        controller.start();
    }
}
