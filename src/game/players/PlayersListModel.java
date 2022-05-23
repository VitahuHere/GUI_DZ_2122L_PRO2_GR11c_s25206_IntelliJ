package game.players;

import javax.swing.*;
import java.util.Vector;

public class PlayersListModel extends AbstractListModel<PlayerModel> {
    public static PlayersListModel instance;
    public Vector<PlayerModel> players;

    public PlayersListModel() {
        players = new Vector<>();
        instance = this;
    }

    public static PlayersListModel getInstance() {
        if (instance == null) {
            instance = new PlayersListModel();
        }
        return instance;
    }

    @Override
    public int getSize() {
        return players.size();
    }

    @Override
    public PlayerModel getElementAt(int index) {
        this.players.sort(PlayerModel::compareTo);
        return players.get(index);
    }

    public void addPlayer(PlayerModel player) {
        players.add(player);
    }

    public Vector<PlayerModel> getPlayers() {
        return players;
    }

    public void loadPlayers(Vector<PlayerModel> vector) {
        players = vector;
    }
}

