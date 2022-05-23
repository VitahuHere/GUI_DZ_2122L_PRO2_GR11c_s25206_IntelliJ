package game.controllers.listeners;

import game.controllers.GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkipSaveListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GameController.getInstance().restart();
    }
}
