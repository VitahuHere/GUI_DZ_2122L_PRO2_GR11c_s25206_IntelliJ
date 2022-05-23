package game.controllers.listeners;

import game.controllers.GameController;
import game.players.PlayerModel;
import game.players.PlayersListModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavePlayerListener implements ActionListener {
    private final JTextField field;

    public SavePlayerListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (field.getText().length() <= 0) {
            JOptionPane.showMessageDialog(null, "Player name cannot be empty", "Empty name", JOptionPane.WARNING_MESSAGE);
        } else {
            PlayerModel.getInstance().setName(field.getText());
            PlayersListModel.getInstance().addPlayer(PlayerModel.getInstance());
            GameController.getInstance().restart();
        }
    }
}
