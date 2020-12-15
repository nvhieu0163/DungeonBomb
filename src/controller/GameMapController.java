package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import javafx.util.Pair;
import model.GameMap;
import model.GameConfig;
import model.entity.character.Enemy;
import model.entity.character.Player;
import model.entity.item.Interface;
import model.entity.item.Item;
import model.entity.item.Trap;
import model.entity.tile.Floor;
import model.entity.tile.Tile;
import model.entity.tile.Wall;
import view.ImageManager;

import static model.GameConfig.RANDOM;


public class GameMapController {
    public static final Integer MAP_1 = 1;
    public static final Integer MAP_1_OBJECT_1 = 101;
    public static final Integer MAP_1_OBJECT_2 = 102;

    public static final Integer MAP_2 = 2;
    public static final Integer MAP_2_OBJECT_1 = 201;
    public static final Integer MAP_2_OBJECT_2 = 202;

    public static final int MAX_LEVEL = 4;

    public static final List<Pair<Integer, Integer>> LEVELS = List.of(
            new Pair<>(MAP_1, MAP_1_OBJECT_1),
            new Pair<>(MAP_2, MAP_2_OBJECT_1),
            new Pair<>(MAP_1, MAP_1_OBJECT_2),
            new Pair<>(MAP_2, MAP_2_OBJECT_2)
    );

    public static Map<Integer, String> MAP_PATH = new HashMap<>() {{
        put(MAP_1, "res/level/map1.txt");
        put(MAP_1_OBJECT_1, "res/level/map1_object1.txt");
        put(MAP_1_OBJECT_2, "res/level/map1_object2.txt");
        put(MAP_2, "res/level/map2.txt");
        put(MAP_2_OBJECT_1, "res/level/map2_object1.txt");
        put(MAP_2_OBJECT_2, "res/level/map2_object2.txt");
    }};

    private static final Map<Character, List<Integer>> TILE_BY_TYPE = new HashMap<>() {{
        put('_', List.of(ImageManager.FLOOR_1, ImageManager.FLOOR_2, ImageManager.FLOOR_3, ImageManager.FLOOR_4, ImageManager.FLOOR_5, ImageManager.FLOOR_6, ImageManager.FLOOR_7, ImageManager.FLOOR_8, ImageManager.FLOOR_9, ImageManager.FLOOR_10, ImageManager.FLOOR_11, ImageManager.FLOOR_12));
        put('T', List.of(ImageManager.WALL_TOP_1, ImageManager.WALL_TOP_2, ImageManager.WALL_TOP_3, ImageManager.WALL_TOP_4));
        put('B', List.of(ImageManager.WALL_BOTTOM_1, ImageManager.WALL_BOTTOM_2, ImageManager.WALL_BOTTOM_3, ImageManager.WALL_BOTTOM_4));
        put('L', List.of(ImageManager.WALL_LEFT_1, ImageManager.WALL_LEFT_2));
        put('R', List.of(ImageManager.WALL_RIGHT_1, ImageManager.WALL_RIGHT_2));
        put('{', List.of(ImageManager.WALL_CORNER_1_RIGHT));
        put('}', List.of(ImageManager.WALL_CORNER_1_LEFT));
        put('-', List.of(ImageManager.WALL_H));
        put('(', List.of(ImageManager.WALL_H_LEFT));
        put(')', List.of(ImageManager.WALL_H_RIGHT));
        put('|', List.of(ImageManager.WALL_V));
        put('+', List.of(ImageManager.WALL_V_BOTTOM));
        put('^', List.of(ImageManager.WALL_V_TOP));
        put('[', List.of(ImageManager.WALL_CORNER_3_LEFT_1, ImageManager.WALL_CORNER_3_LEFT_2, ImageManager.WALL_CORNER_3_LEFT_3));
        put(']', List.of(ImageManager.WALL_CORNER_3_RIGHT_1, ImageManager.WALL_CORNER_3_RIGHT_2, ImageManager.WALL_CORNER_3_RIGHT_3));
    }};

    public static int getRandomTile(char tileType) {
        Random rand = new Random();
        return TILE_BY_TYPE.get(tileType).get(rand.nextInt(TILE_BY_TYPE.get(tileType).size()));
    }

    public static GameMap loadLevel(int level, Player player) {
        if (level > MAX_LEVEL) {
            return null;
        } else {
            Pair<Integer, Integer> levelInfo = LEVELS.get(level - 1);
            String mapPath = MAP_PATH.get(levelInfo.getKey());
            String mapObjectPath = MAP_PATH.get(levelInfo.getValue());

            try {
                Scanner sc = new Scanner(new File(mapPath));
                int nRow = sc.nextInt();
                int nCol = sc.nextInt();
                sc.nextLine();

                // Tinh tien toa do x, y
                // sao cho ban do can giua man hinh
                int moveX = ((GameConfig.SCREEN_WIDTH / GameConfig.TILE_SIZE) - nCol) * GameConfig.TILE_SIZE / 2;
                int moveY = ((GameConfig.SCREEN_HEIGHT / GameConfig.TILE_SIZE) - nRow) * GameConfig.TILE_SIZE / 2;

                List<Tile> tiles = new ArrayList<>();
                for (int i = 0; i < nRow; i++) {
                    String row = sc.nextLine();
                    for (int j = 0; j < nCol; j++) {
                        char tileType = row.charAt(j);
                        if (tileType != ' ') {
                            Integer tileImageID = getRandomTile(tileType);
                            if (tileType == '_') {
                                tiles.add(new Floor(
                                        moveX + j * GameConfig.TILE_SIZE,
                                        moveY + i * GameConfig.TILE_SIZE,
                                        tileImageID
                                ));
                            } else {
                                tiles.add(new Wall(
                                        moveX + j * GameConfig.TILE_SIZE,
                                        moveY + i * GameConfig.TILE_SIZE,
                                        tileImageID
                                ));
                            }
                        }
                    }
                }

                sc = new Scanner(new File(mapObjectPath));
                int nRow2 = sc.nextInt();
                int nCol2 = sc.nextInt();
                sc.nextLine();

                if (nRow2 != nRow || nCol2 != nCol) {
                    return null;
                }

                List<Enemy> enemies = new ArrayList<>();
                List<Item> items = new ArrayList<>();
                List<Trap> traps = new ArrayList<>();
                List<Interface> interfaces = new ArrayList<>();
                for (int i = 0; i < nRow; i++) {
                    String row = sc.nextLine();
                    for (int j = 0; j < nCol; j++) {
                        char objectType = row.charAt(j);
                        if (objectType != ' ') {
                            int x = moveX + j * GameConfig.TILE_SIZE;
                            int y = moveY + i * GameConfig.TILE_SIZE;
                            switch (objectType) {
                                case 'X':
                                    player.setX(x);
                                    player.setY(y);
                                    break;
                                    //LADDER
                                case 'Y':
                                    interfaces.add(ItemsController.createInterface(x, y,false, false,11));
                                    break;
                                    //ENEMIES
                                case '*':
                                    enemies.add(EnemyController.createSkull(x, y, true, true));
                                    break;
                                case '@':
                                    enemies.add(EnemyController.createVampire(x, y, true, true));
                                    break;
                                case '#':
                                    double rand = RANDOM.nextDouble();
                                    enemies.add(EnemyController.createSkeleton2(x, y, rand > 0.5, rand < 0.5));
                                    break;
                                case '(':
                                    enemies.add(EnemyController.createSkeleton1(x, y, true, false));
                                    break;
                                case ')':
                                    enemies.add(EnemyController.createSkeleton1(x, y, false, true));
                                    break;
                                    //ITEMS AND INTERFACES
                                case 'E':
                                    interfaces.add(ItemsController.createInterface(x, y, true, false, 0));
                                    break;
                                case 'I':
                                    interfaces.add(ItemsController.createInterface(x, y, true, true,0));
                                    break;
                                case 'A' :
                                    interfaces.add(ItemsController.createInterface(x, y,false, false, 12));
                                    break;
                                case 'F' :
                                    interfaces.add(ItemsController.createInterface(x,y,false,false,10));
                                    break;
                                case '|' :
                                    interfaces.add(ItemsController.createInterface(x,y,false,false,14));
                                    break;
                                case '{' :
                                    interfaces.add(ItemsController.createInterface(x,y,false,false,13));
                                    break;
                                case 'K' :
                                    items.add(ItemsController.creatGoldKey(x, y));
                                    break;
                                case '$' :
                                    items.add(ItemsController.createCoin(x, y));
                                    break;
                                    //TRAPS
                                case 'T' :
                                    traps.add(ItemsController.creatTrap(x, y));
                                    break;
                                default:
                            }
                        }
                    }
                }
                return new GameMap(tiles, enemies, items, traps, interfaces, player);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
