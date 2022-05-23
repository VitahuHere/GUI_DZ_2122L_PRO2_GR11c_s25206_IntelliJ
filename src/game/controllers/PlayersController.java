package game.controllers;

import game.panels.HighScoresPanel;
import game.players.PlayerModel;
import game.players.PlayersListModel;

import java.io.*;
import java.util.Vector;

public class PlayersController {
    private static PlayersController instance;
    private static boolean isLoaded = false;

    public PlayersController() {
        instance = this;
    }

    public static PlayersController getInstance() {
        if (instance == null) {
            instance = new PlayersController();
        }
        return instance;
    }

    public void savePlayers() {
        try {
            File file = new File("players.ser");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream("players.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(PlayersListModel.getInstance().getPlayers());
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPlayers() {
        isLoaded = true;
        try {
            File file = new File("players.ser");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fis = new FileInputStream("players.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            PlayersListModel.getInstance().loadPlayers((Vector<PlayerModel>) ois.readObject());
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ignore) {
        }
    }

    public void loadHighScores() {
        HighScoresPanel panel = new HighScoresPanel(PlayersListModel.getInstance());
        MenuController.getInstance().getFrame().setNewPanel(panel);
    }

    public boolean isLoaded() {
        return isLoaded;
    }
}
