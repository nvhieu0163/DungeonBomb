package model.entity.item;

import model.entity.Dynamic;
import model.entity.Entity;

public class Bomb extends Entity implements Dynamic {
    private final int UPDATE_RATE = 15;
    private final int power;

    private final int clipFrames;
    private int activeFrame;
    private int clipCounter;
    private final Integer[] clip;

    private boolean triggered;

    public Bomb(int x, int y, Integer[] clip, int power) {
        super(x, y);

        this.clip = clip;
        this.clipFrames = clip.length;
        this.activeFrame = 0;
        this.clipCounter = 0;
        this.imageID = clip[0];

        this.triggered = false;
        this.power = power;
    }

    public void update() {
        clipCounter = (clipCounter + 1) % UPDATE_RATE;
        if (clipCounter == 0) {
            activeFrame = activeFrame + 1;
            if (activeFrame < clipFrames) {
                imageID = clip[activeFrame];
            } else {
                triggered = true;
            }
        }
    }

    public boolean isTriggered() {
        return triggered;
    }

    public int getPower() {
        return power;
    }
}
