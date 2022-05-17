package game.labels;

import game.controllers.GameController;

import javax.swing.*;
import java.awt.*;

public class LivesLabel extends JLabel {

    public LivesLabel(String text) {
        this.setText(text);
        this.setSize(200, 100);
        this.setLocation(new Point(GameController.getInstance().getPanel().getWidth()-200, 0));
        this.setFont(new Font("Arial", Font.BOLD, 25));
    }
}
