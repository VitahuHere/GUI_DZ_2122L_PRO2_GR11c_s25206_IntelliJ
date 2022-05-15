package game.controllers.listeners;

import game.controllers.GameController;
import game.controllers.MenuController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record MenuButtonListener(MenuController controller) implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New Game" -> this.controller.newGame();
            case "High Scores" -> this.controller.highScores();
            case "Exit" -> this.controller.exit();
            case "Easy" -> new GameController(0, controller.frame()).startGame();
            case "Medium" -> new GameController(1, controller.frame()).startGame();
            case "Hard" -> new GameController(2, controller.frame()).startGame();
        }
    }

}
