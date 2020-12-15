package model.entity.character;

public class Player extends Character {

    protected int lives;
    protected int power;
    protected int bombs;

    protected boolean hasKey;
    protected int score;

    public Player(int x, int y, Integer[] clip, int speedX, int speedY, int lives, int power, int bombs) {
        super(x, y, clip, speedX, speedY);
        this.lives = lives;
        this.power = power;
        this.bombs = bombs;

        this.hasKey = false;
        this.score = 0;
    }

    public void increaseLife() {
        lives += 1;
    }

    public void decreaseLife() {
        lives -= 1;
    }

    public void increasePower() {
        power += 1;
    }

    public void increaseBombs() {
        bombs += 1;
    }

    public void dropABomb() {
        bombs -= 1;
    }

    public boolean canDropMoreBomb() {
        return bombs > 0;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore() {
        score += 100;
    }

}
