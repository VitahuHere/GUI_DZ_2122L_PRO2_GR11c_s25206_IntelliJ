package game.controllers.threads;

import game.controllers.listeners.DuckCheckerListener;
import game.controllers.listeners.DuckGeneratorListener;
import game.panels.GamePanel;

import javax.swing.*;

public class DuckCheckerThread extends Thread {
    private final GamePanel gamePanel;
    private final DuckGeneratorListener duckCheckerListener;

    public DuckCheckerThread(GamePanel panel, DuckGeneratorListener listener) {
        this.gamePanel = panel;
        this.duckCheckerListener = listener;
    }

    @Override
    public void run() {
        DuckCheckerListener listener = new DuckCheckerListener(gamePanel, duckCheckerListener);
        Timer timer = new Timer(0, listener);
        timer.start();
    }
}
