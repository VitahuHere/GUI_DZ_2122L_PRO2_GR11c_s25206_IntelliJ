package game.panels.obstacles;

import javax.swing.*;

public class Cloud extends JPanel {
    int side;

    public Cloud(String path, int width, int height, int side) {
        this.side = side;
        this.setSize(width, height);
        this.setOpaque(false);
        this.setFocusable(false);
        JButton button = new JButton(new ImageIcon(path));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setFocusable(false);
        this.add(button);
    }

    public int getSide() {
        return side;
    }
}
