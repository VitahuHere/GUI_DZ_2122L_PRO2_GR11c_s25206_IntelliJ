package game.buttons.ducks;

public class Duck1 extends Duck0 {

    public Duck1() {
        super("src/game/images/ducks/left 1 duck.png", 1, -3);
    }

    public Duck1(boolean right) {
        super("src/game/images/ducks/right 1 duck.png", right, 1, 3);
    }
}
