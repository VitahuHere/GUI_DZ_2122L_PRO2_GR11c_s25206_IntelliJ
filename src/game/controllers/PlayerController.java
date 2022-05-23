package game.controllers;

import game.players.PlayerModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PlayerController {
    public PlayerController() {

    }

    public PlayerController getInstance() {
        return this;
    }

    public void savePlayer(PlayerModel player) {
        // check if file exists, if not create it
        File file = new File("player.ser");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // save player object to file using ObjectOutputStream
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(player);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPlayers() {

    }
}
