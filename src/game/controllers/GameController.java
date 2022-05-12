package game.controllers;

import game.PlayerModel;
import game.controllers.listeners.DuckCheckerListener;
import game.controllers.listeners.DuckGeneratorListener;
import game.frames.GameFrame;
import game.panels.GamePanel;

import javax.swing.*;

public class GameController {
    private final GameFrame frame;
    private final GamePanel panel;
    private final PlayerModel player;
    private final int difficulty;
    private int MAX_DUCKS;
    private Timer duckGeneratorTimer;
    private DuckGeneratorListener duckGeneratorListener;
    private Timer duckCheckerTimer;
    private DuckCheckerListener duckCheckerListener;
    public static boolean playing = false;

    public GameController(int difficulty, GameFrame frame) {
        this.frame = frame;
        this.difficulty = difficulty;
        this.panel = new GamePanel();
        this.player = new PlayerModel();
        startGame();
    }

    public void startGame() {
        frame.setNewPanel(this.panel);
        switch (difficulty) {
            case 0 -> easy();
            case 1 -> medium();
            case 2 -> hard();
        }
    }

    public void easy() {
        /*
        Max count of ducks: 5
        Only ducks 1, 5
        Chances of ducks: 7/10, 3/10
         */
        MAX_DUCKS = 5;
        startDuckGenerator("easy");
    }

    public void medium() {
        /*
        Max count of ducks: 7
        Only ducks 5, 10
        Chances of ducks: 7/10, 3/10
         */
        MAX_DUCKS = 7;
        startDuckGenerator("medium");
    }

    public void hard() {
        /*
        Max count of ducks: 10
        Only ducks 10, 15
        Chances of ducks: 7/10, 3/10
         */
        MAX_DUCKS = 10;
        startDuckGenerator("hard");
    }

    public void startDuckGenerator(String difficulty) {
        playing = true;
        switch (difficulty){
            case "easy" -> duckGeneratorListener = new DuckGeneratorListener(panel, MAX_DUCKS, true, false);
            case "medium" -> duckGeneratorListener = new DuckGeneratorListener(panel, MAX_DUCKS, false, true);
            case "hard" -> duckGeneratorListener = new DuckGeneratorListener(panel, MAX_DUCKS, false, false);
        }
        startDuckChecker();
        duckGeneratorTimer = new Timer(1000, duckGeneratorListener);
        duckGeneratorTimer.start();
    }

    public void setDelay(int delay) {
        duckGeneratorTimer.setDelay(delay);
    }

    public void stopDuckGenerator(){
        duckGeneratorTimer.stop();
    }

    public void startDuckChecker() {
        Thread duckCheckerThread = new Thread(() -> {
            duckCheckerListener = new DuckCheckerListener(panel, duckGeneratorListener, player);
            duckCheckerTimer = new Timer(0, duckCheckerListener);
            duckCheckerTimer.start();
        });
        duckCheckerThread.start();
    }

    public void stopDuckChecker(){
        duckCheckerTimer.stop();
    }
}
