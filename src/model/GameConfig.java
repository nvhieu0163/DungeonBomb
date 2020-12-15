package model;

import java.util.Random;

public class GameConfig {
    public static int SCREEN_WIDTH = 1024;
    // MAX TILE WIDTH: 32 BOX
    public static int SCREEN_HEIGHT = 704;
    // MAX TILE HEIGHT: 22 BOX

    public static int TILE_SIZE = 32;

    public static final int SOFT_EDGE = 4;
    public static final int SOFT_EDGE_WALL = 2;

    public static final Random RANDOM = new Random();

}
