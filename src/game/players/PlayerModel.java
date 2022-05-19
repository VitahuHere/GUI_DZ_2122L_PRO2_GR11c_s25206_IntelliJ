package game.players;

public class PlayerModel {
    private static PlayerModel instance;
    private int lives;
    private int score;
    private int hitOnClick;
    private String name;

    public PlayerModel() {
        this.lives = 10;
        this.score = 0;
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

    public void addPoints(int score) {
        this.score += score;
    }

    public int getHitOnClick() {
        return hitOnClick;
    }

    public void upgradeHitOnClick() {
        hitOnClick++;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Player: " + name + " score: " + score + " lives: " + lives;
    }
}
