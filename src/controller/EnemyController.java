package controller;

import model.entity.character.Enemy;
import view.ImageManager;

public class EnemyController {
    public static int SPEED_SKELETON = 2;
    public static int VISIBLE_SKELETON_1 = 1;
    public static int VISIBLE_SKELETON_2 = 2;

    public static int SPEED_SKULL = 1;
    public static int VISIBLE_SKULL = 3;

    public static int SPEED_VAMPIRE = 3;
    public static int VISIBLE_VAMPIRE = 3;

    public static Integer[] SKELETON1_CLIP = new Integer[] {
            ImageManager.SKELETON1_1, ImageManager.SKELETON1_2, ImageManager.SKELETON1_3, ImageManager.SKELETON1_4,
            ImageManager.SKELETON1_5, ImageManager.SKELETON1_6, ImageManager.SKELETON1_7, ImageManager.SKELETON1_8
    };

    public static Integer[] SKELETON2_CLIP = new Integer[] {
            ImageManager.SKELETON2_1, ImageManager.SKELETON2_2, ImageManager.SKELETON2_3, ImageManager.SKELETON2_4,
            ImageManager.SKELETON2_5, ImageManager.SKELETON2_6, ImageManager.SKELETON2_7, ImageManager.SKELETON2_8
    };

    public static Integer[] SKULL_CLIP = new Integer[] {
            ImageManager.SKULL_1, ImageManager.SKULL_2, ImageManager.SKULL_3, ImageManager.SKULL_4,
            ImageManager.SKULL_5, ImageManager.SKULL_6, ImageManager.SKULL_7, ImageManager.SKULL_8
    };

    public static Integer[] VAMPIRE_CLIP = new Integer[] {
            ImageManager.VAMPIRE_1, ImageManager.VAMPIRE_2, ImageManager.VAMPIRE_3, ImageManager.VAMPIRE_4,
            ImageManager.VAMPIRE_5, ImageManager.VAMPIRE_6, ImageManager.VAMPIRE_7, ImageManager.VAMPIRE_8
    };

    public static Enemy createSkeleton1(int x, int y, boolean vertical, boolean horizontal) {
        return new Enemy(
                x, y,
                SKELETON1_CLIP,
                (horizontal ? SPEED_SKELETON : 0),
                (vertical ? SPEED_SKELETON : 0),
                VISIBLE_SKELETON_1,
                false, false
        );
    }

    public static Enemy createSkeleton2(int x, int y, boolean vertical, boolean horizontal) {
        return new Enemy(
                x, y,
                SKELETON2_CLIP,
                (horizontal ? SPEED_SKELETON : 0),
                (vertical ? SPEED_SKELETON : 0),
                VISIBLE_SKELETON_2,
                false, false
        );
    }

    public static Enemy createSkull(int x, int y, boolean vertical, boolean horizontal) {
        return new Enemy(
                x, y,
                SKULL_CLIP,
                (horizontal ? SPEED_SKULL : 0),
                (vertical ? SPEED_SKULL : 0),
                VISIBLE_SKULL,
                true, false
        );
    }

    public static Enemy createVampire(int x, int y, boolean vertical, boolean horizontal) {
        return new Enemy(
                x, y,
                VAMPIRE_CLIP,
                (horizontal ? SPEED_VAMPIRE : 0),
                (vertical ? SPEED_VAMPIRE : 0),
                VISIBLE_VAMPIRE,
                false, true
        );
    }
}
