package game.labels;

import javax.swing.*;
import java.awt.*;

public class StopwatchLabel extends JLabel {

    public StopwatchLabel() {
        this.setText("00:00:00");
        this.setSize(200, 100);
        this.setFont(new Font("Arial", Font.BOLD, 25));
    }

    public void setTime(int seconds){
        int minutes = seconds / 60;
        int hours = minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;
        this.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }
}
