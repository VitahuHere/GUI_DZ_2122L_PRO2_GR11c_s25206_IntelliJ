package game.controllers.listeners;

import game.buttons.ducks.Duck0;
import game.buttons.ducks.Left1Duck;
import game.buttons.ducks.Right1Duck;
import game.panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameListener implements ActionListener {
    private GamePanel panel;
    private ArrayList<Duck0> ducks;
    private int max;
    private int offset;

    public GameListener(GamePanel panel, ArrayList<Duck0> ducks, int max) {
        this.panel = panel;
        this.ducks = ducks;
        this.max = max;
        this.offset = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ducks.size() < max) {
            Duck0 duck = null;
            int pick = (int) (Math.random() * 10);
            int side = (int) (Math.random() * 2);
            if (side == 0 && pick < 7) {
                duck = new Left1Duck();
                duck.setBounds(100 + offset, 100 + offset, duck.getWidth(), duck.getHeight());
            } else if (side == 1 && pick < 7) {
                duck = new Right1Duck();
                duck.setBounds(100 + offset, 100 + offset, duck.getWidth(), duck.getHeight());
            }
            this.ducks.add(duck);
            panel.addNewDuck(duck);
            offset += 50;
        }
    }
}
