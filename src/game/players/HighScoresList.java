package game.players;

import javax.swing.*;

public class HighScoresList extends JList<PlayerModel> {

    public HighScoresList(){
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayoutOrientation(JList.VERTICAL);
        this.setVisibleRowCount(7);
    }
}
