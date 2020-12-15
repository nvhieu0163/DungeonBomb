package model.entity;

import model.GameConfig;

public abstract class Entity {
    protected int x;
    protected int y;

    protected Integer imageID;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.imageID = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public boolean collisionWith(Entity other, int softEdge) {
        int x1 = x + softEdge, y1 = y + softEdge;
        int x2 = other.x + softEdge, y2 = other.y + softEdge;
        int width = GameConfig.TILE_SIZE - 2 * softEdge, height = GameConfig.TILE_SIZE - 2 * softEdge;

        return (
                x1 < x2 + width &&
                        x1 + width > x2 &&
                        y1 < y2 + height &&
                        y1 + height > y2
        );
    }
}
