package model.entity.item;

import model.entity.Dynamic;
import model.entity.Entity;

public class Trap extends Entity implements Dynamic {
    private final int UPDATE_RATE = 10;

    private final int clipFrames;
    private int activeFrame;
    private int clipCounter;
    private final Integer[] clip;

    public Trap(int x, int y, Integer[] clip) {
        super(x, y);
        this.clip = clip;
        this.clipFrames = clip.length;
        this.activeFrame = 0;
        this.clipCounter = 0;
        this.imageID = clip[0];
    }

    @Override
    public void update() {
        clipCounter = (clipCounter + 1) % UPDATE_RATE;
        if (clipCounter == 0) {
            activeFrame = (activeFrame + 1) % clipFrames;
            imageID = clip[activeFrame];
        }
    }
}
