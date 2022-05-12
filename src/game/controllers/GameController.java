package game.controllers;

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
    private Timer duckGeneratorTimer;
    private DuckGeneratorListener duckGeneratorListener;
    private Timer duckCheckerTimer;
    private Thread duckCheckerThread;
    private DuckCheckerListener duckCheckerListener;

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
        Max count of ducks: 7
        Only ducks 1, 5
        Chances of ducks: 7/10, 3/10
         */
        startDuckGenerator(7);
    }

    public void medium() {
        /*
        Max count of ducks: 10
        Only ducks 5, 10
        Chances of ducks: 7/10, 3/10
         */
        startDuckGenerator(10);
    }

    public void hard() {
        /*
        Max count of ducks: 15
        Only ducks 10, 15
        Chances of ducks: 7/10, 3/10
         */
        startDuckGenerator(15);
    }

    public void startDuckGenerator(int MAX_DUCKS) {
        switch (MAX_DUCKS){
            case 7 -> duckGeneratorListener = new DuckGeneratorListener(panel, MAX_DUCKS, true, false);
            case 10 -> duckGeneratorListener = new DuckGeneratorListener(panel, MAX_DUCKS, false, true);
            case 15 -> duckGeneratorListener = new DuckGeneratorListener(panel, MAX_DUCKS, false, false);
        }
        startDuckChecker(duckGeneratorListener);
        duckGeneratorTimer = new Timer(1000, duckGeneratorListener);
        duckGeneratorTimer.start();
    }

    public void stopDuckGenerator(){
        duckGeneratorTimer.stop();
    }

    public void startDuckChecker(DuckGeneratorListener listener) {
        duckCheckerThread = new Thread(() -> {
            duckCheckerListener = new DuckCheckerListener(panel, listener);
            duckCheckerTimer = new Timer(0, duckCheckerListener);
            duckCheckerTimer.start();
        });
        duckCheckerThread.start();
    }

    public void stopDuckChecker(){
        duckCheckerTimer.stop();
    }

    public void setDelay(int delay) {
        duckGeneratorTimer.setDelay(delay);
    }
}
