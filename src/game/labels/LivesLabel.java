package game.labels;

import game.panels.GamePanel;

import javax.swing.*;
import java.awt.*;

public class LivesLabel extends JLabel {

    public LivesLabel(GamePanel panel, String text) {
        this.setText(text);
        this.setSize(200, 100);
        this.setLocation(new Point(panel.getWidth()-200, 0));
        this.setFont(new Font("Arial", Font.BOLD, 25));
    }
}
