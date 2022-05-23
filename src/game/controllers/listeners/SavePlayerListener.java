package game.controllers.listeners;

import game.controllers.PlayerController;
import game.players.PlayerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SavePlayerListener implements ActionListener {
    private final JTextField field;

    public SavePlayerListener(JTextField field){
        this.field = field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(field.getText().length() <= 0){
            JOptionPane.showMessageDialog(null, "Player name cannot be empty", "Empty name", JOptionPane.WARNING_MESSAGE);
        }
        else{
            PlayerModel.getInstance().setName(field.getText());
            new PlayerController().savePlayer(PlayerModel.getInstance());
        }
    }
}
