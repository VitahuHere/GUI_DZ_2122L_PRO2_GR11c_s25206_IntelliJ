package game.controllers.listeners;

import game.players.PlayerModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerUpgradeListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        PlayerModel.getInstance().upgradeHitOnClick();
    }
}
