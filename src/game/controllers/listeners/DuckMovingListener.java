package game.controllers.listeners;

import game.buttons.ducks.Duck0;
import game.controllers.GameController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckMovingListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Component c : GameController.getInstance().getPanel().getComponents()) {
            if (c instanceof Duck0) {
                ((Duck0) c).move(0);
            }
        }
    }
}
