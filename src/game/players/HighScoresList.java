package game.players;

import javax.swing.*;
import java.awt.*;

public class HighScoresList extends JList<PlayerModel> {

    public HighScoresList(PlayersListModel players) {
        super(players);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayoutOrientation(JList.VERTICAL);
        this.setFont(new Font("Arial", Font.ITALIC, 30));
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) this.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
