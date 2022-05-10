package game.controllers.listeners;

import game.buttons.ducks.Duck0;
import game.panels.GamePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckCheckerListener implements ActionListener {
    GamePanel panel;
    DuckGeneratorListener listener;

    public DuckCheckerListener(GamePanel panel, DuckGeneratorListener listener) {
        this.panel = panel;
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Component c:  panel.getComponents()){
            if(c instanceof Duck0){
                if (!((Duck0) c).isAlive()){
                    panel.remove(c);
                    listener.setCurrent(listener.getCurrent() - 1);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        }
    }
}
