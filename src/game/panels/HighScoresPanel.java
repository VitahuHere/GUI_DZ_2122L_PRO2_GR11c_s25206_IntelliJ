package game.panels;

import game.players.HighScoresList;

import javax.swing.*;
import java.awt.*;

public class HighScoresPanel extends JPanel {

    public HighScoresPanel(){
        this.setLayout(new SpringLayout());
        JLabel label = new JLabel("High Scores");
        label.setFont(new Font("Arial", Font.ITALIC, 36));


        HighScoresList list = new HighScoresList();
        JScrollPane scrollPane = new JScrollPane(list);


        this.add(label);
        this.add(scrollPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/game/images/backgrounds/export XP background.png").getImage(), 0, 0, null);
    }
}
