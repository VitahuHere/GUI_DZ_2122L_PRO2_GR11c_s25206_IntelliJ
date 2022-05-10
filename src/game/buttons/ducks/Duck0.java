package game.buttons.ducks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Duck0 extends JButton implements ActionListener {
    public int lives;
    public int movementSpeed;
    public boolean right;

    public Duck0(String leftIconPath, int lives, int movementSpeed) {
        this.lives = lives;
        this.movementSpeed = movementSpeed;
        this.right = false;

        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setIcon(new ImageIcon(leftIconPath));
        this.setSize(new Dimension(120, 100));
        this.setFocusable(false);

        this.addActionListener(this);

        this.setText(String.valueOf(lives));
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
    }

    public Duck0(String rightIconPath, boolean right, int lives, int movementSpeed) {
        this(rightIconPath, lives, movementSpeed);
        this.right = right;
    }

    public void move() {
        this.setLocation(this.getX() + this.movementSpeed, this.getY());
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void hit() {
        this.lives--;
        this.setText(String.valueOf(lives));
    }

    public boolean reachedEnd() {
        if (this.movementSpeed > 0) {
            return this.getX() >= 1160;
        }
        return this.getX() <= 120;
    }

    public void setVisibility(boolean visibility) {
        this.setVisible(visibility);
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
