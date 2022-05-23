package game.controllers.listeners;

import game.buttons.ducks.Duck0;
import game.controllers.GameController;
import game.panels.GamePanel;
import game.players.PlayerModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckCheckerListener implements ActionListener {
    final GamePanel panel;
    final DuckGeneratorListener listener;
    final PlayerModel player;

    public DuckCheckerListener(GamePanel panel, DuckGeneratorListener listener, PlayerModel player) {
        this.panel = panel;
        this.listener = listener;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Component c : panel.getComponents()) {
            if (c instanceof Duck0) {
                if (!((Duck0) c).isAlive() && !((Duck0) c).reachedEnd()) {
                    panel.remove(c);
                    listener.setCurrent(listener.getCurrent() - 1);
                    player.addPoints(((Duck0) c).getReward());
                } else if (((Duck0) c).reachedEnd()) {
                    panel.remove(c);
                    listener.setCurrent(listener.getCurrent() - 1);
                    player.strike();
                    if (player.getLives() <= 0) {
                        GameController.getInstance().stopGame();
                        break;
                    }
                }
                panel.revalidate();
                panel.repaint();
            }
        }
    }
}
