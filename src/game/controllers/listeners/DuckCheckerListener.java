package game.controllers.listeners;

import game.PlayerModel;
import game.buttons.ducks.Duck0;
import game.panels.GamePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckCheckerListener implements ActionListener {
    GamePanel panel;
    DuckGeneratorListener listener;
    PlayerModel player;

    public DuckCheckerListener(GamePanel panel, DuckGeneratorListener listener, PlayerModel player) {
        this.panel = panel;
        this.listener = listener;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Component c:  panel.getComponents()){
            if(c instanceof Duck0){
                if (!((Duck0) c).isAlive() && !((Duck0) c).reachedEnd()){
                    panel.remove(c);
                    listener.setCurrent(listener.getCurrent() - 1);
                    player.setScore(player.getScore() + ((Duck0) c).getReward());
                }
                else if(((Duck0) c).reachedEnd()){
                    panel.remove(c);
                    listener.setCurrent(listener.getCurrent() - 1);
                    player.strike();
                }
                else{
                    ((Duck0) c).move();
                }
                panel.revalidate();
                panel.repaint();
            }
        }
    }
}
