package game.labels;

import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {

    public ScoreLabel() {
        this.setText("Score: 0");
        this.setFont(new Font("Arial", Font.BOLD, 25));
        this.setForeground(Color.WHITE);
        this.setSize(this.getPreferredSize());
    }
}
