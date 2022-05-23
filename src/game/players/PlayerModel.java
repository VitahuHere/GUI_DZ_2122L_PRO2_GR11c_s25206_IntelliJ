package game.players;

import java.io.Serializable;

public class PlayerModel implements Serializable, Comparable<PlayerModel> {
    private static PlayerModel instance;
    private int lives;
    private int score;
    private int upgradeCost;
    private int hitOnClick;
    private String name;
    private int difficultyLevel;

    public PlayerModel() {
        this.lives = 10;
        this.score = 0;
        this.upgradeCost = 2;
        this.hitOnClick = 1;
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

    public void setScore(int score) {
        this.score = score;
    }

    public void addPoints(int score) {
        this.score += score;
    }

    public int getHitOnClick() {
        return hitOnClick;
    }

    public void upgradeHitOnClick() {
        hitOnClick++;
        this.score -= upgradeCost;
        upgradeCost *= 2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUpgradeCost() {
        return this.upgradeCost;
    }

    public int getDifficulty() {
        return this.difficultyLevel;
    }

    public void setDifficulty(int difficulty) {
        this.difficultyLevel = difficulty;
    }

    @Override
    public String toString() {
        String diff = switch (difficultyLevel) {
            case 1 -> "Easy";
            case 2 -> "Medium";
            case 3 -> "Hard";
            default -> null;
        };
        return name + " score: " + score + " difficulty: " + diff;
    }

    @Override
    public int compareTo(PlayerModel o) {
        return o.score - this.score;
    }
}
