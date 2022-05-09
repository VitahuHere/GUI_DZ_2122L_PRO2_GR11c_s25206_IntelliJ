package game.buttons.ducks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Duck0 extends JButton implements ActionListener {
    public int lives;
    public int movementSpeed;

    public Duck0(String iconPath) {
        super("Duck0");
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
        Image img = new ImageIcon(iconPath).getImage();
        img = img.getScaledInstance(120, 100, Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(img));
        this.setSize(new Dimension(120, 100));
        this.addActionListener(this);
    }

    public void move() {
        this.setLocation(this.getX() + this.movementSpeed, this.getY());
    }

    public boolean isAlive() {
        return lives > 0;
    }

    protected void hit() {
        this.lives--;
    }

    public boolean reachedEnd() {
        if (this.movementSpeed > 0) {
            return this.getX() >= 1160;
        }
        return this.getX() <= 120;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == null) {
            this.move();
        } else {
            this.hit();
        }
    }
}
