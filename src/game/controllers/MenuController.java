package game.controllers;

import game.buttons.menuButtons.*;
import game.controllers.listeners.KeyCombListener;
import game.controllers.listeners.MenuButtonListener;
import game.frames.GameFrame;
import game.panels.MenuPanel;

public record MenuController(GameFrame frame) {

    public MenuController(GameFrame frame) {
        this.frame = frame;
        this.frame.setKeyListener(new KeyCombListener(this.frame));
        this.frame.setVisible(true);
    }

    public void start() {
        MenuPanel panel = new MenuPanel();

        NewGameButton newGameButton = new NewGameButton();
        newGameButton.setActionListener(new MenuButtonListener(this));
        newGameButton.setActionCommand("New Game");

        HighScoresButton highScoresButton = new HighScoresButton();
        highScoresButton.setActionListener(new MenuButtonListener(this));
        highScoresButton.setActionCommand("High Scores");

        ExitButton exitButton = new ExitButton();
        exitButton.setActionListener(new MenuButtonListener(this));
        exitButton.setActionCommand("Exit");

        panel.setMenuButtons(newGameButton, highScoresButton, exitButton);

        this.frame.setNewPanel(panel);
    }

    public void newGame() {
        MenuPanel panel = new MenuPanel();

        EasyModeButton easyModeButton = new EasyModeButton();
        easyModeButton.setActionListener(new MenuButtonListener(this));
        easyModeButton.setActionCommand("Easy");

        MediumModeButton mediumModeButton = new MediumModeButton();
        mediumModeButton.setActionListener(new MenuButtonListener(this));
        mediumModeButton.setActionCommand("Medium");

        HardModeButton hardModeButton = new HardModeButton();
        hardModeButton.setActionListener(new MenuButtonListener(this));
        hardModeButton.setActionCommand("Hard");

        panel.setMenuButtons(easyModeButton, mediumModeButton, hardModeButton);

        this.frame.setNewPanel(panel);
    }

    public void highScores() {

    }

    public void exit() {
        System.exit(0);
    }
}
