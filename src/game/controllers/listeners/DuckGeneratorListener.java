package game.controllers.listeners;

import game.buttons.ducks.*;
import game.panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DuckGeneratorListener implements ActionListener {
    private GamePanel panel;
    private ArrayList<Duck0> ducks;
    private int max;

    public DuckGeneratorListener(GamePanel panel, ArrayList<Duck0> ducks, int max) {
        this.panel = panel;
        this.ducks = ducks;
        this.max = max;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ducks.size() < max) {
            Duck0 duck;
            int pick = (int) (Math.random() * 10);
            int side = (int) (Math.random() * 2);
            if (side == 0){
                duck = generateEasyRightDuck(pick);

            } else{
                duck = generateEasyLeftDuck(pick);
            }

            this.ducks.add(duck);
            panel.addNewDuck(duck);
        }
    }

    private Duck0 generateEasyRightDuck(int odd){
        Duck0 duck;
        if(odd < 7){
            duck = new Right1Duck();
        }
        else if (odd < 9){
            duck = new Right5Duck();
        }
        else {
            duck = new Right10Duck();
        }
        duck.setLocation(0, (int)(Math.random() * (panel.getHeight() - 2 * duck.getHeight())));
        return duck;
    }

    private Duck0 generateEasyLeftDuck(int odd){
        Duck0 duck;
        if(odd < 7){
            duck = new Left1Duck();
        }
        else if (odd < 9){
            duck = new Left5Duck();
        }
        else {
            duck = new Left10Duck();
        }
        duck.setLocation(panel.getWidth()-duck.getWidth(), (int)(Math.random() * (panel.getHeight() - 2 * duck.getHeight())));
        return duck;
    }
}
