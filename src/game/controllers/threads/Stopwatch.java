package game.controllers.threads;

import game.frames.GameFrame;

public class Stopwatch extends Thread {
    private int ticks = 0;

    @Override
    public void run() {
        while (!GameFrame.thread.isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticks++;
        }
    }

    public int getSeconds() {
        return this.ticks;
    }
}
