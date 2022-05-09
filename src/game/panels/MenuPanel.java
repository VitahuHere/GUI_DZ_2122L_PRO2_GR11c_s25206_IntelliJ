package game.panels;

import game.buttons.menuButtons.MenuButton;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private final ImageIcon background = new ImageIcon("src/game/images/backgrounds/export XP background.png");
    private final SpringLayout layout;
    private MenuButton mid;

    public MenuPanel() {
        this.layout = new SpringLayout();
        setLayout(this.layout);
    }

    private void setTitle() {
        JLabel title = new JLabel("Duck Shooter Game");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setForeground(Color.BLACK);
        layout.putConstraint(SpringLayout.NORTH, title, 100, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        this.add(title);
    }

    public void setMenuButtons(MenuButton top, MenuButton mid, MenuButton bot) {
        this.removeAll();
        setTitle();
        setMidButton(mid);
        setTopButton(top);
        setBotButton(bot);
        this.revalidate();
        this.repaint();
    }

    private void setTopButton(MenuButton top) {
        this.layout.putConstraint(SpringLayout.SOUTH, top, 0, SpringLayout.NORTH, mid);
        this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, top, 0, SpringLayout.HORIZONTAL_CENTER, this);
        this.add(top);
    }

    private void setMidButton(MenuButton mid) {
        this.mid = mid;
        this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, this.mid, 0, SpringLayout.HORIZONTAL_CENTER, this);
        this.layout.putConstraint(SpringLayout.VERTICAL_CENTER, this.mid, 0, SpringLayout.VERTICAL_CENTER, this);
        this.add(this.mid);
    }

    private void setBotButton(MenuButton bot) {
        this.layout.putConstraint(SpringLayout.NORTH, bot, 0, SpringLayout.SOUTH, mid);
        this.layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, bot, 0, SpringLayout.HORIZONTAL_CENTER, this);
        this.add(bot);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.background.getImage(), 0, 0, null);
    }
}
