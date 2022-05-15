package game;

public class PlayerModel {
    private static PlayerModel instance;
    private int lives;
    private int score;
    private int hitOnClick;

    public PlayerModel() {
        this.lives = 10;
        this.score = 0;
        this.hitOnClick = 5;
        instance = this;
    }

    public static PlayerModel getInstance() {
        return instance;
    }

    public int getLives() {
        return lives;
    }

    public void strike() {
        lives--;
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int score) {
        this.score += score;
    }

    public int getHitOnClick() {
        return hitOnClick;
    }

    public void upgradeHitOnClick() {
        hitOnClick++;
    }
}
