package game.panels.obstacles;

import game.controllers.GameController;

import javax.swing.*;

public class Tree extends JPanel {
    public Tree(String treePath, int width, int height) {
        this.setOpaque(false);
        this.setFocusable(false);
        this.setSize(width, height);
        this.setLocation((int)(Math.random() * (GameController.getInstance().getPanel().getWidth() - width)),
                (int)(Math.random() * (GameController.getInstance().getPanel().getHeight() - height - 240) + 240));
        JButton button = new JButton(new ImageIcon(treePath));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setFocusable(false);
        this.add(button);
    }
}
