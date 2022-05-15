package game.panels;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel{
    private final ImageIcon background = new ImageIcon("src/game/images/backgrounds/export XP background.png");

    public GameOverPanel() {
        JLabel gameOverLabel = new JLabel(new ImageIcon("src/game/images/menuButtons/game over.png"));
        gameOverLabel.setBounds((this.getWidth() - 640) / 2, this.getHeight(), 640, 360);
        this.add(gameOverLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background.getImage(), 0, 0, null);
    }
}
