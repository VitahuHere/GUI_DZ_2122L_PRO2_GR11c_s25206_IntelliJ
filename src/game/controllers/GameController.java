package game.controllers;

import game.buttons.ducks.Duck0;
import game.controllers.listeners.DuckCheckerListener;
import game.controllers.listeners.DuckGeneratorListener;
import game.controllers.threads.DuckCheckerThread;
import game.frames.GameFrame;
import game.panels.GamePanel;

import javax.swing.*;
import java.util.ArrayList;

public class GameController {
    private final GameFrame frame;
    private final GamePanel panel;
    private final ArrayList<Duck0> ducks;
    private final PlayerModel player;
    private final int difficulty;
    private int delay;
    private Timer duckGenerator;
    private Thread duckChecker;

    public GameController(int difficulty, GameFrame frame) {
        this.frame = frame;
        this.difficulty = difficulty;
        this.panel = new GamePanel();
        this.ducks = new ArrayList<>();
        this.player = new PlayerModel();
        this.delay = 1000;
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
        Only ducks 1, 5, 10
        Chances of ducks: 7/10, 2/10, 1/10
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
        DuckGeneratorListener listener = null;
        switch (MAX_DUCKS){
            case 7 -> listener = new DuckGeneratorListener(panel, MAX_DUCKS, true, false);
            case 10 -> listener = new DuckGeneratorListener(panel, MAX_DUCKS, false, true);
            case 15 -> listener = new DuckGeneratorListener(panel, MAX_DUCKS, false, false);
        }
        duckGenerator = new Timer(this.delay, listener);
        duckGenerator.start();
        duckChecker = new DuckCheckerThread(panel, listener);
        duckChecker.start();
    }

    public void stopDuckGenerator(){
        duckGenerator.stop();
    }

    public void startDuckChecker(DuckCheckerListener listener) {

    }

    public void stopDuckChecker(){

    }
}
