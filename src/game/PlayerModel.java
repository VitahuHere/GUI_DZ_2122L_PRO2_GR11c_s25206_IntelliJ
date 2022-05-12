package game;

public class PlayerModel {
    private int lives;
    private int score;
    private int hitOnClick;

    public PlayerModel() {
        this.lives = 10;
        this.score = 0;
        this.hitOnClick = 1;
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

    public void setScore(int score) {
        this.score += score;
    }

    public int getHitOnClick() {
        return hitOnClick;
    }

    public void upgradeHitOnClick() {
        hitOnClick++;
    }
}
