package game.labels;

import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {

    public ScoreLabel(String text) {
        this.setText(text);
        this.setSize(200, 100);
        this.setFont(new Font("Arial", Font.BOLD, 25));
    }
}
