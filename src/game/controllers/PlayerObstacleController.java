package game.controllers;

import game.panels.obstacles.Cloud;
import game.players.PlayerModel;
import game.panels.obstacles.Tree;

import javax.swing.*;
import java.awt.*;

public class PlayerObstacleController {
    private PlayerModel player;
    private Timer cloudTimer;
    private Timer moveCloudsTimer;

    public PlayerObstacleController(PlayerModel player) {
        this.player = player;
    }

    public PlayerObstacleController getInstance() {
        return this;
    }

    public void run(){
        generateTrees();
        generateClouds();
        moveClouds();
    }

    public void generateTrees() {
        Tree tree = new Tree("src/game/images/obstacles/tree.png", 360, 618);
        Tree tree2 = new Tree("src/game/images/obstacles/tree2.png", 360, 366);
        GameController.getInstance().getPanel().add(tree);
        GameController.getInstance().getPanel().add(tree2);
    }

    public void generateClouds(){
        cloudTimer = new Timer(5000, e -> {
            Cloud cloud = new Cloud("src/game/images/obstacles/cloud.png", 300, 150, (int)(Math.random() * 2));
            int side = (int)(Math.random() * 2);
            if (side > 0){
                cloud.setLocation(-cloud.getWidth(), (int)(Math.random() * 50));
            } else {
                cloud.setLocation(GameController.getInstance().getPanel().getWidth() - cloud.getWidth(),
                        (int)(Math.random() * (GameController.getInstance().getPanel().getHeight() - cloud.getHeight())));
            }
            GameController.getInstance().getPanel().add(cloud);
        });
        cloudTimer.start();
    }

    public void setCloudTimerDelay(int delay){
        cloudTimer.setDelay(delay);
    }

    public int getCloudTimerDelay(){
        return cloudTimer.getDelay();
    }

    public void moveClouds(){
        Thread thread = new Thread(() -> {
            moveCloudsTimer = new Timer(0, e -> {
                for (Component c : GameController.getInstance().getPanel().getComponents()) {
                    if (c instanceof Cloud cloud) {
                        if(cloud.getSide() == 0){
                            cloud.setLocation(cloud.getX() + 1, cloud.getY());
                            if(cloud.getX() > GameController.getInstance().getPanel().getWidth()){
                                GameController.getInstance().getPanel().remove(cloud);
                            }
                        } else {
                            cloud.setLocation(cloud.getX() - 1, cloud.getY());
                            if(cloud.getX() < -cloud.getWidth()){
                                GameController.getInstance().getPanel().remove(cloud);
                            }
                        }
                    }
                }
            });
            moveCloudsTimer.start();
        });
        thread.setDaemon(true);
        thread.start();
    }

    public void stop(){
        moveCloudsTimer.stop();
        cloudTimer.stop();
    }
}
