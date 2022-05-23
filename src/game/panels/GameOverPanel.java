package game.panels;

import game.buttons.gameButtons.SavePlayerButton;
import game.buttons.gameButtons.SkipSaveButton;
import game.controllers.listeners.SavePlayerListener;
import game.controllers.listeners.SkipSaveListener;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel{
    private final ImageIcon background = new ImageIcon("src/game/images/backgrounds/export XP background.png");

    public GameOverPanel() {
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        JLabel gameOverLabel = new JLabel(new ImageIcon("src/game/images/menuButtons/game over.png"));
        gameOverLabel.setSize(gameOverLabel.getPreferredSize());
        layout.putConstraint(SpringLayout.NORTH, gameOverLabel, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, gameOverLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 25));
        textField.setPreferredSize(new Dimension(500, 50));
        layout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.SOUTH, gameOverLabel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textField, 0, SpringLayout.HORIZONTAL_CENTER, this);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        layout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.SOUTH, textField);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel, 0, SpringLayout.HORIZONTAL_CENTER, this);

        SavePlayerButton saveButton = new SavePlayerButton();
        saveButton.addActionListener(new SavePlayerListener(textField));

        SkipSaveButton skipButton = new SkipSaveButton();
        skipButton.addActionListener(new SkipSaveListener());

        panel.add(saveButton);
        panel.add(skipButton);

        this.add(gameOverLabel);
        this.add(textField);
        this.add(panel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background.getImage(), 0, 0, null);
    }
}
