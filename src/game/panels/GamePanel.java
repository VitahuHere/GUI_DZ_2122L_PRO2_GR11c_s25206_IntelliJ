package game.panels;

import game.buttons.ducks.Duck0;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final ImageIcon background = new ImageIcon("src/game/images/backgrounds/export XP background.png");

    public GamePanel() {
        setLayout(null);
        this.setFocusable(false);
    }

    public void addNewDuck(Duck0 duck) {
        add(duck);
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background.getImage(), 0, 50, null);
    }
}
