package game.controllers.listeners;

import game.controllers.GameController;
import game.controllers.MenuController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record MenuButtonListener(MenuController controller) implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int difficulty = -1;
        switch (e.getActionCommand()) {
            case "New Game" -> this.controller.newGame();
            case "High Scores" -> this.controller.highScores();
            case "Exit" -> this.controller.exit();
            case "Easy" -> difficulty = 0;
            case "Medium" -> difficulty = 1;
            case "Hard" -> difficulty = 2;
        }
        if (difficulty != -1) {
            controller.getFrame().dispose();
            new GameController(difficulty).startGame();
        }
    }
}
