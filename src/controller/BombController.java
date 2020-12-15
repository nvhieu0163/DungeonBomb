package controller;

import model.GameConfig;
import model.entity.character.Enemy;
import model.entity.item.Bomb;
import model.entity.item.Fire;
import view.ImageManager;

public class BombController {
    public static int SPEED_FIRE = 4;


    public static Integer[] BOMB_CLIP = new Integer[]{
            ImageManager.BOMB_1, ImageManager.BOMB_2, ImageManager.BOMB_3, ImageManager.BOMB_4, ImageManager.BOMB_5,
            ImageManager.BOMB_6, ImageManager.BOMB_7, ImageManager.BOMB_8, ImageManager.BOMB_9, ImageManager.BOMB_10
    };
    public static Integer[] FIRE_TOP_CLIP = new Integer[]{
            ImageManager.FIRE_TOP_1, ImageManager.FIRE_TOP_2, ImageManager.FIRE_TOP_3, ImageManager.FIRE_TOP_4,
    };
    public static Integer[] FIRE_BOTTOM_CLIP = new Integer[]{
            ImageManager.FIRE_BOTTOM_1, ImageManager.FIRE_BOTTOM_2, ImageManager.FIRE_BOTTOM_3, ImageManager.FIRE_BOTTOM_4,
    };
    public static Integer[] FIRE_LEFT_CLIP = new Integer[]{
            ImageManager.FIRE_LEFT_1, ImageManager.FIRE_LEFT_2, ImageManager.FIRE_LEFT_3, ImageManager.FIRE_LEFT_4,
    };
    public static Integer[] FIRE_RIGHT_CLIP = new Integer[]{
            ImageManager.FIRE_RIGHT_1, ImageManager.FIRE_RIGHT_2, ImageManager.FIRE_RIGHT_3, ImageManager.FIRE_RIGHT_4,
    };

    public static Bomb createBomb(int x, int y, int power) {
        return new Bomb(
                x, y,
                BOMB_CLIP,
                power
        );
    }

    // x and y are position of bomb
    public static Fire[] createFires(int x, int y, int power) {
        return new Fire[]{
                new Fire(
                        x, y - GameConfig.TILE_SIZE + GameConfig.TILE_SIZE / 2,
                        FIRE_TOP_CLIP,
                        0, -SPEED_FIRE,
                        power
                ),
                new Fire(
                        x, y + GameConfig.TILE_SIZE - GameConfig.TILE_SIZE / 2,
                        FIRE_BOTTOM_CLIP,
                        0, SPEED_FIRE,
                        power
                ),
                new Fire(
                        x - GameConfig.TILE_SIZE + GameConfig.TILE_SIZE / 2, y,
                        FIRE_LEFT_CLIP,
                        -SPEED_FIRE, 0,
                        power
                ),
                new Fire(
                        x + GameConfig.TILE_SIZE - GameConfig.TILE_SIZE / 2, y,
                        FIRE_RIGHT_CLIP,
                        SPEED_FIRE, 0,
                        power
                )
        };
    }

}
