package controller;

import model.entity.character.Player;
import view.ImageManager;

import java.util.ArrayList;

public class PlayerController {
    public static int SPEED_X = 6;
    public static int SPEED_Y = 6;

    public static int DEFAULT_LIVES = 3;
    public static int DEFAULT_BOMBS = 1;
    public static int DEFAULT_POWERS = 1;

    public static Integer[] PRIEST1_CLIP = new Integer[] {
            ImageManager.PRIEST1_1, ImageManager.PRIEST1_2, ImageManager.PRIEST1_3, ImageManager.PRIEST1_4,
            ImageManager.PRIEST1_5, ImageManager.PRIEST1_6, ImageManager.PRIEST1_7, ImageManager.PRIEST1_8
    };

    public static Integer[] PRIEST2_CLIP = new Integer[] {
            ImageManager.PRIEST2_1, ImageManager.PRIEST2_2, ImageManager.PRIEST2_3, ImageManager.PRIEST2_4,
            ImageManager.PRIEST2_5, ImageManager.PRIEST2_6, ImageManager.PRIEST2_7, ImageManager.PRIEST2_8
    };

    public static Integer[] PRIEST3_CLIP = new Integer[] {
            ImageManager.PRIEST3_1, ImageManager.PRIEST3_2, ImageManager.PRIEST3_3, ImageManager.PRIEST3_4,
            ImageManager.PRIEST3_5, ImageManager.PRIEST3_6, ImageManager.PRIEST3_7, ImageManager.PRIEST3_8
    };

    public static Player createPriest1(int x, int y) {
        return new Player(
                x, y,
                PRIEST1_CLIP,
                0, 0,
                DEFAULT_LIVES + 1,
                DEFAULT_POWERS,
                DEFAULT_BOMBS
        );
    }

    public static Player createPriest2(int x, int y) {
        return new Player(
                x, y,
                PRIEST2_CLIP,
                0, 0,
                DEFAULT_LIVES,
                DEFAULT_POWERS,
                DEFAULT_BOMBS + 1
        );
    }

    public static Player createPriest3(int x, int y) {
        return new Player(
                x, y,
                PRIEST3_CLIP,
                0, 0,
                DEFAULT_LIVES,
                DEFAULT_POWERS + 1,
                DEFAULT_BOMBS
        );
    }

    public static void movePlayer(Player player, ArrayList<String> input) {
        int speedX = 0;
        int speedY = 0;
        if (input.contains("LEFT")) {
            speedX -= SPEED_X;
        }
        if (input.contains("RIGHT")) {
            speedX += SPEED_X;
        }
        if (input.contains("UP")) {
            speedY -= SPEED_Y;
        }
        if (input.contains("DOWN")) {
            speedY += SPEED_Y;
        }

        player.setSpeedX(speedX);
        player.setSpeedY(speedY);
    }
}
