package game.buttons.ducks;

import game.players.PlayerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Duck0 extends JButton implements ActionListener {
    protected int lives;
    protected int score;
    protected int movementSpeed;
    protected boolean right;

    public Duck0(String leftIconPath, int lives, int movementSpeed) {
        this.lives = lives;
        this.score = lives;
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

    public void move(int distance) {
        this.setLocation(this.getX() + this.movementSpeed + distance, this.getY());
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void hit(int hitValue) {
        this.lives -= hitValue;
        this.setText(String.valueOf(lives));
    }

    public boolean reachedEnd() {
        if (this.movementSpeed > 0) {
            return this.getX() >= this.getParent().getWidth();
        }
        return this.getX() <= -this.getWidth();
    }

    public int getReward(){
        return this.score;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == null) {
            this.move(0);
        } else {
            this.hit(PlayerModel.getInstance().getHitOnClick());
        }
    }
}
