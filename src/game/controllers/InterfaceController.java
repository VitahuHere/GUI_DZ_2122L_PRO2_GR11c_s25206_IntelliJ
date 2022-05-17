package game.controllers;

import game.controllers.threads.Stopwatch;
import game.labels.LivesLabel;
import game.labels.ScoreLabel;
import game.labels.StopwatchLabel;

import javax.swing.*;

public class InterfaceController {
    private final LivesLabel livesLabel;
    private final ScoreLabel scoreLabel;
    private final StopwatchLabel stopwatchLabel;
    private final Stopwatch stopwatch;
    private Timer interTimer;

    public InterfaceController() {
        this.stopwatch = new Stopwatch();
        this.livesLabel = new LivesLabel("Lives: " + GameController.getInstance().getPlayer().getLives());
        this.scoreLabel = new ScoreLabel("Score: " + GameController.getInstance().getPlayer().getScore());
        this.stopwatchLabel = new StopwatchLabel();
    }

    public void run() {
        GameController.getInstance().getPanel().add(this.livesLabel);
        GameController.getInstance().getPanel().add(this.scoreLabel);
        GameController.getInstance().getPanel().add(this.stopwatchLabel);
        this.stopwatch.start();
        Thread thread = new Thread(() -> {
            interTimer = new Timer(0, e -> {
                livesLabel.setText("Lives: " + GameController.getInstance().getPlayer().getLives());
                scoreLabel.setText("Score: " + GameController.getInstance().getPlayer().getScore());
                stopwatchLabel.setTime(stopwatch.getTicks());
            });
            interTimer.start();
        });
        thread.start();
    }

    public void stop() {
        interTimer.stop();
    }
}
