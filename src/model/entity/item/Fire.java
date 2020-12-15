package model.entity.item;

import model.GameConfig;
import model.entity.Dynamic;
import model.entity.Entity;

public class Fire extends Entity implements Dynamic {
    private final int speedX;
    private final int speedY;
    private final int power;
    private int distance;

    private final int UPDATE_RATE = 10;

    private int activeFrame;
    private int clipCounter;
    private final Integer[] clip;

    private int status;
    public static final int START = 0;
    public static final int FLYING = 10;
    public static final int END = 20;
    public static final int CLEAR = 999;

    private int moveCounter;
    private final int MOVE_RATE = 1;

    public Fire(int x, int y, Integer[] clip, int speedX, int speedY, int power) {
        super(x, y);

        this.clip = clip;
        this.activeFrame = 0;
        this.clipCounter = 0;
        this.imageID = clip[0];

        this.moveCounter = 0;

        this.speedX = speedX;
        this.speedY = speedY;

        this.status = START;

        this.power = power;
        this.distance = 0;
    }

    @Override
    public void update() {
        if (status == START) {
            clipCounter = (clipCounter + 1) % UPDATE_RATE;
            if (clipCounter == 0) {
                activeFrame += 1;
                imageID = clip[activeFrame];
                if (activeFrame == 2) {
                    status = FLYING;
                }
            }
        } else if (status == END) {
            clipCounter = clipCounter + 1;
            if (clipCounter == UPDATE_RATE) {
                status = CLEAR;
            }
        }
    }

    public void move() {
        if (status == FLYING) {
            moveCounter = (moveCounter + 1) % MOVE_RATE;
            if (moveCounter == 0) {
                x += speedX;
                y += speedY;
                // speedX or speedY is 0
                distance += Math.abs(speedX + speedY);

                if (distance >= (power * GameConfig.TILE_SIZE - GameConfig.TILE_SIZE / 2)) {
                    end();
                }
            }
        }
    }

    public void end() {
        clipCounter = 0;
        activeFrame = 3;
        imageID = clip[activeFrame];
        status = END;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
