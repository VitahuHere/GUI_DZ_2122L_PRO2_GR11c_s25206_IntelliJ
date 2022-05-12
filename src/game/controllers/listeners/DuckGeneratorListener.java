package game.controllers.listeners;

import game.buttons.ducks.*;
import game.panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DuckGeneratorListener implements ActionListener {
    private final GamePanel panel;
    private int current;
    private final int max;
    private final boolean easy;
    private final boolean medium;

    public DuckGeneratorListener(GamePanel panel, int max, boolean easy, boolean medium) {
        this.panel = panel;
        this.current = 0;
        this.max = max;
        this.easy = easy;
        this.medium = medium;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (current < max) {
            Duck0 duck;
            int pick = (int) (Math.random() * 10);
            int side = (int) (Math.random() * 2);
            if(easy){
                duck = generateEasyDuck(side == 0, pick);
            }
            else if(medium){
                duck = generateMediumDuck(side == 0, pick);
            }
            else{
                duck = generateHardHardDuck(side == 0, pick);
            }
            if(side == 0){
                duck.setLocation(0, (int)(Math.random() * (panel.getHeight() - 2 * duck.getHeight())));
            }
            else{
                duck.setLocation(panel.getWidth()-duck.getWidth(), (int)(Math.random() * (panel.getHeight() - 2 * duck.getHeight())));
            }
            current++;
            panel.addNewDuck(duck);
        }
    }

    private Duck0 generateEasyDuck(boolean right, int odd){
        Duck0 duck = null;
        switch (twoOdds(right, odd)){
            case 0 -> duck = new Duck1(true);
            case 1 -> duck = new Duck5(true);
            case 2 -> duck = new Duck1();
            case 3 -> duck = new Duck5();
        }
        return duck;
    }

    private Duck0 generateMediumDuck(boolean right, int odd){
        Duck0 duck = null;;
        switch (twoOdds(right, odd)){
            case 0 -> duck = new Duck5(true);
            case 1 -> duck = new Duck10(true);
            case 2 -> duck = new Duck5();
            case 3 -> duck = new Duck10();
        }
        return duck;
    }

    private Duck0 generateHardHardDuck(boolean right, int odd){
        Duck0 duck = null;
        switch (twoOdds(right, odd)){
            case 0 -> duck = new Duck10(true);
            case 1 -> duck = new Duck15(true);
            case 2 -> duck = new Duck10();
            case 3 -> duck = new Duck15();
        }
        return duck;
    }

    private int twoOdds(boolean right, int odd){
        if(right){
            return odd < 7 ? 0 : 1;
        }
        else{
            return odd < 7 ? 2 : 3;
        }
    }

    public void setCurrent(int current) {
         this.current = current;
    }

    public int getCurrent() {
        return current;
    }
}
