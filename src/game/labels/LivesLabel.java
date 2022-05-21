package game.labels;

import javax.swing.*;
import java.awt.*;

public class LivesLabel extends JLabel {

    public LivesLabel() {
        this.setText("Lives: 10");
        this.setFont(new Font("Arial", Font.BOLD, 25));
        this.setForeground(Color.WHITE);
        this.setSize(this.getPreferredSize().width, 50);
    }
}
