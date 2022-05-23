package game.buttons.gameButtons;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SkipSaveButton extends JButton implements ChangeListener {
    private final String path = "src/game/images/game/skip.png";

    public SkipSaveButton() {
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
            this.setIcon(new ImageIcon("src/game/images/game/skip pressed.png"));
        } else {
            this.setIcon(new ImageIcon(path));
        }
    }
}
