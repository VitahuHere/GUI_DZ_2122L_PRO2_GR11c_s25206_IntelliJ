package game.buttons.gameButtons;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WeaponUpgradeButton extends JButton implements ChangeListener {
    private String path;
    private String pressedPath;

    public WeaponUpgradeButton() {
        this.setIcon(new ImageIcon("src/game/images/game/upgrade disabled.png"));
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setFocusable(false);
        this.addChangeListener(this);
    }

    public void enableImage() {
        this.path = "src/game/images/game/upgrade.png";
        this.pressedPath = "src/game/images/game/upgrade pressed.png";
        stateChanged(null);
    }

    public void disableImage() {
        this.path = "src/game/images/game/upgrade disabled.png";
        this.pressedPath = "src/game/images/game/upgrade disabled.png";
        stateChanged(null);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (this.getModel().isPressed()) {
            this.setIcon(new ImageIcon(pressedPath));
        } else {
            this.setIcon(new ImageIcon(path));
        }
    }
}
