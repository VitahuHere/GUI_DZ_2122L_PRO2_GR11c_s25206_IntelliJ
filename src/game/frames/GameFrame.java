package game.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame {

    public GameFrame() {
        super("Duck shooter");
        this.setIconImage(new ImageIcon("src/game/images/ducks/right 1 duck.png").getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 770);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setFocusable(true);
    }

    public void setNewPanel(JPanel panel) {
        this.getContentPane().removeAll();
        this.add(panel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public void setKeyListener(KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }
}