package game.buttons.gameButtons;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SavePlayerButton extends JButton implements ChangeListener {
    private final String path = "src/game/images/game/save.png";

    public SavePlayerButton() {
        this.setIcon(new ImageIcon(path));
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.addChangeListener(this);
        this.setSize(this.getPreferredSize());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (this.getModel().isPressed()) {
            this.setIcon(new ImageIcon("src/game/images/game/save pressed.png"));
        } else {
            this.setIcon(new ImageIcon(path));
        }
    }
}
