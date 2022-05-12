package game.controllers.threads;

import game.controllers.GameController;

public class Stopwatch extends Thread {
    private int ticks = 0;

    @Override
    public void run() {
        while (GameController.playing) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticks++;
            System.out.println(ticks);
        }
    }

    public int getSeconds() {
        return this.ticks;
    }
}
