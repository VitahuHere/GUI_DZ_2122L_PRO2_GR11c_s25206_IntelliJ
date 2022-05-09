package game.buttons.menuButtons;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class MenuButton extends JButton implements ChangeListener {

    protected String notPressedPath;
    protected String pressedPath;

    protected MenuButton(String notPressedPath, String pressedPath) {
        this.setIcon(iconGet(notPressedPath));
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.addChangeListener(this);
        this.notPressedPath = notPressedPath;
        this.pressedPath = pressedPath;
    }

    protected ImageIcon iconGet(String path) {
        Image img = new ImageIcon(path).getImage();
        img = img.getScaledInstance(200, 50, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void setActionListener(ActionListener listener) {
        this.addActionListener(listener);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (this.getModel().isPressed()) {
            this.setIcon(iconGet(pressedPath));
        } else {
            this.setIcon(iconGet(notPressedPath));
        }
    }
}
