package game.panels;

import game.buttons.menuButtons.BackButton;
import game.players.HighScoresList;
import game.players.PlayersListModel;

import javax.swing.*;
import java.awt.*;

public class HighScoresPanel extends JPanel {

    public HighScoresPanel(PlayersListModel players) {
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        JLabel label = new JLabel("High Scores");
        label.setFont(new Font("Arial", Font.ITALIC, 36));

        JScrollPane scrollPane = new JScrollPane(new HighScoresList(players));
        scrollPane.setPreferredSize(new Dimension(900, 500));
        BackButton backButton = new BackButton();

        layout.putConstraint(SpringLayout.VERTICAL_CENTER, scrollPane, 0, SpringLayout.VERTICAL_CENTER, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollPane, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.SOUTH, label, -10, SpringLayout.NORTH, scrollPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, label, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, backButton, 10, SpringLayout.SOUTH, scrollPane);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, backButton, 0, SpringLayout.HORIZONTAL_CENTER, this);
        this.add(label);
        this.add(backButton);
        this.add(scrollPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/game/images/backgrounds/export XP background.png").getImage(), 0, 0, null);
    }
}
