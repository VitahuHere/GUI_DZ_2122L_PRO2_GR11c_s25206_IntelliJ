package game.buttons.menuButtons;

import game.controllers.MenuController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButton extends MenuButton implements ActionListener {

    public BackButton() {
        super("src/game/images/menuButtons/back.png", "src/game/images/menuButtons/back pressed.png");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MenuController.getInstance().start();
    }
}

