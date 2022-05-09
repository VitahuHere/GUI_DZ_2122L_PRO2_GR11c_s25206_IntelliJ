package game.controllers.listeners;

import game.controllers.MenuController;
import game.frames.GameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public record KeyCombListener(GameFrame frame) implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
            new MenuController(frame).start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
