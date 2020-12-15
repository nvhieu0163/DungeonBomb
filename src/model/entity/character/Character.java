package model.entity.character;

import model.entity.Dynamic;
import model.entity.Entity;

public abstract class Character extends Entity implements Dynamic {
    protected int speedX;
    protected int speedY;

    protected int histX;
    protected int histY;

    private final int UPDATE_RATE = 8;

    private final int clipFrames;
    private int activeFrame;
    private int clipCounter;
    private final Integer[] clip;

    private int moveCounter;
    private final int MOVE_RATE = 3;

    public Character(int x, int y, Integer[] clip, int speedX, int speedY) {
        super(x, y);

        this.clip = clip;
        this.clipFrames = clip.length / 2;
        this.activeFrame = 0;
        this.clipCounter = 0;
        this.imageID = clip[0];

        this.moveCounter = 0;

        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void update() {
        int moveFrame = activeFrame <= 3 ? 0 : clipFrames;
        if (speedX < 0) {
            moveFrame = clipFrames;
        }
        if (speedX > 0) {
            moveFrame = 0;
        }
        clipCounter = (clipCounter + 1) % UPDATE_RATE;
        if (clipCounter == 0) {
            activeFrame = (activeFrame + 1) % clipFrames + moveFrame;
            imageID = clip[activeFrame];
        }
    }

    public void move() {
        moveCounter = (moveCounter + 1) % MOVE_RATE;
        if (moveCounter == 0) {
            histX = x;
            histY = y;

            x += speedX;
            y += speedY;
        }
    }

    public void rollback() {
        x = histX;
        y = histY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
