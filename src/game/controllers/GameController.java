package game.controllers;

import game.buttons.ducks.Duck0;
import game.controllers.listeners.GameListener;
import game.frames.GameFrame;
import game.panels.GamePanel;

import javax.swing.*;
import java.util.ArrayList;

public class GameController {
    private final GameFrame frame;
    private final GamePanel panel;
    private final ArrayList<Duck0> ducks;
    private final PlayerModel player;
    int difficulty;

    public GameController(int difficulty, GameFrame frame) {
        this.frame = frame;
        this.difficulty = difficulty;
        this.panel = new GamePanel();
        this.ducks = new ArrayList<>();
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
        Only ducks 1, 5, 10
        Chances of ducks: 7/10, 2/10, 1/10
         */
        int MAX_DUCKS = 7;
        GameListener listener = new GameListener(this.panel, this.ducks, MAX_DUCKS);
        Timer timer = new Timer(1000, listener);
        timer.start();
    }

    public void medium() {
        /*
        Max count of ducks: 10
        Only ducks 5, 10
        Chances of ducks: 7/10, 3/10
         */
    }

    public void hard() {
        /*
        Max count of ducks: 15
        Only ducks 10, 15
        Chances of ducks: 7/10, 3/10
         */
    }
}
