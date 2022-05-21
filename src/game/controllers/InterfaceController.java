package game.controllers;

import game.buttons.WeaponUpgradeButton;
import game.controllers.threads.Stopwatch;
import game.labels.LivesLabel;
import game.labels.ScoreLabel;
import game.labels.StopwatchLabel;

import javax.swing.*;
import java.awt.*;

public class InterfaceController {
    private final LivesLabel livesLabel;
    private final ScoreLabel scoreLabel;
    private final StopwatchLabel stopwatchLabel;
    private final JLabel upgradeLabel;
    private final JButton upgradeButton;
    private final Stopwatch stopwatch;
    private final JPanel panel;
    private Timer interTimer;

    public InterfaceController() {
        panel = new JPanel();
        this.stopwatch = new Stopwatch();
        this.livesLabel = new LivesLabel();
        this.scoreLabel = new ScoreLabel();
        this.upgradeLabel = new JLabel("Upgrade: ");
        this.upgradeButton = new WeaponUpgradeButton();
        this.stopwatchLabel = new StopwatchLabel();
    }

    public void run() {
        setLabels();
        this.stopwatch.start();
        Thread thread = new Thread(() -> {
            interTimer = new Timer(0, e -> {
                livesLabel.setText("Lives: " + GameController.getInstance().getPlayer().getLives());
                scoreLabel.setText("Score: " + GameController.getInstance().getPlayer().getScore());
                stopwatchLabel.setTime(stopwatch.getTicks());
            });
            interTimer.start();
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void setLabels(){
        panel.setBackground(Color.BLACK);
        panel.setSize(1280, 50);
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, stopwatchLabel, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, stopwatchLabel, 0, SpringLayout.VERTICAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, livesLabel, 0, SpringLayout.VERTICAL_CENTER, panel);
        layout.putConstraint(SpringLayout.WEST, livesLabel, 0, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, scoreLabel, 0, SpringLayout.VERTICAL_CENTER, panel);
        layout.putConstraint(SpringLayout.EAST, scoreLabel, -50, SpringLayout.EAST, panel);
        panel.add(this.livesLabel);
        panel.add(this.stopwatchLabel);
        panel.add(this.scoreLabel);

        GameController.getInstance().getPanel().add(panel, BorderLayout.NORTH);
    }

    public void stop() {
        interTimer.stop();
    }

    public int getTick(){
        return stopwatch.getTicks();
    }
}
