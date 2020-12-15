package model.entity.tile;

import model.entity.Entity;

public abstract class Tile extends Entity {
    public Tile(int x, int y, Integer imageID) {
        super(x, y);
        this.imageID = imageID;
    }
}
