package controller;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.GameConfig;
import model.GameMap;
import model.entity.Entity;
import model.entity.character.Enemy;
import model.entity.character.Player;
import model.entity.item.Bomb;
import model.entity.item.Fire;
import view.FontManager;
import view.ImageManager;
import view.LayerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static controller.GameMapController.MAX_LEVEL;

public class GameController {
    public static final int GAME_MENU = 1;
    public static final int GAME_PLAYING = 10;
    public static final int GAME_PAUSING = 20;
    public static final int GAME_OVER = 999;

    private GameMap gameMap;
    private int gameStatus;
    private int level;

    private final ImageManager imageManager;
    private final LayerManager layerManager;
    private final AnimationTimer timer;
    private ArrayList<String> input;
    private boolean bombTrigger;


    public GameController() {
        layerManager = new LayerManager(GameConfig.SCREEN_WIDTH, GameConfig.SCREEN_HEIGHT);
        imageManager = new ImageManager(GameConfig.TILE_SIZE, GameConfig.TILE_SIZE);
        imageManager.load();
        level = 1;

        setInputHandle();

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (bombTrigger && gameMap.getPlayer().canDropMoreBomb()) {
                    triggerBomb();
                } else {
                    bombTrigger = false;
                }

                gameMap.updateInfinity();

                PlayerController.movePlayer(gameMap.getPlayer(), input);

                if (gameStatus == GAME_PLAYING) {
                    gameMap.updateWhenPlaying();
                    gameMap.move();

                    checkBomb();
                }
                renderDynamicObject();

//                if (gameMap.getPlayer().isHasKey() && gameMap.getEnemies().isEmpty()) {
//                    gameMap.getPlayer().setHasKey(false);
//                    level++;
//                    layerManager.clear(LayerManager.STATIC_MAP);
//                    layerManager.clear(LayerManager.DYNAMIC_OBJECT);
//                    startLevel(level, gameMap.getPlayer());
//                }

                if (gameMap.isNextLevel()) {
                    gameMap.getPlayer().setHasKey(false);
                    level++;
                    if (level <= MAX_LEVEL) {
                        layerManager.clear(LayerManager.STATIC_MAP);
                        layerManager.clear(LayerManager.DYNAMIC_OBJECT);
                        gameMap.setNextLevel(false);
                        startLevel(level, gameMap.getPlayer());
                    } else {
//                        endGame();
                        System.out.println("---- YOU WIN ----");
                        System.exit(0);
                    }
                }

                if (gameMap.getPlayer().getLives()==0) {
//                    endGame();
                    System.out.println("-----GAME OVER-----");
                    System.exit(0);
                }
            }
        };
    }

    private void triggerBomb() {
        int x = gameMap.getPlayer().getX();
        int y = gameMap.getPlayer().getY();
        int power = gameMap.getPlayer().getPower();

        Bomb newBomb = BombController.createBomb(x, y, power);
        gameMap.addBomb(newBomb);
        System.out.println("Bomb created");
        gameMap.getPlayer().dropABomb();
        bombTrigger = false;
    }

    private void checkBomb() {
        List<Bomb> bombToRemove = new ArrayList<>();
        gameMap.getBombs().forEach(b -> {
            if (b.isTriggered()) {
                int x = b.getX();
                int y = b.getY();
                int power = b.getPower();

                Fire[] fires = BombController.createFires(x, y, power);
                gameMap.addFires(fires);
                bombToRemove.add(b);
            }
        });
        bombToRemove.forEach(b->{
            gameMap.removeBomb(b);
            gameMap.getPlayer().increaseBombs();
        });
    }

    private void setInputHandle() {
        input = new ArrayList<String>();

        getScene().setOnKeyPressed(e -> {
            String code = e.getCode().toString();
//            System.out.println(code);

            // only add once... prevent duplicates
            if (!input.contains(code)) {
                input.add(code);
            }

            if (code.equals("SPACE")) {
                bombTrigger = true;
            }
        });

        getScene().setOnKeyReleased(e -> {
            String code = e.getCode().toString();
//            System.out.println(code);
            input.remove(code);
        });
    }

    private void renderDynamicObject() {
        layerManager.clear(LayerManager.DYNAMIC_OBJECT);
        if (gameMap != null) {
            gameMap.getEnemies().forEach(enemy -> renderEntity(LayerManager.DYNAMIC_OBJECT, enemy));
            gameMap.getBombs().forEach(bomb -> renderEntity(LayerManager.DYNAMIC_OBJECT, bomb));
            gameMap.getFires().forEach(fire -> renderEntity(LayerManager.DYNAMIC_OBJECT, fire));
            gameMap.getItems().forEach(item -> renderEntity(LayerManager.DYNAMIC_OBJECT, item));
            gameMap.getInterfaces().forEach(anInterface -> renderEntity(LayerManager.DYNAMIC_OBJECT, anInterface));
            gameMap.getTraps().forEach(trap -> renderEntity(LayerManager.DYNAMIC_OBJECT, trap));

            renderEntity(LayerManager.DYNAMIC_OBJECT, gameMap.getPlayer());
        }
    }

    public void startLevel(int level, Player player) {
        gameStatus = GAME_PLAYING;
        gameMap = GameMapController.loadLevel(level, player);
        if (gameMap == null) {
//            return;
        } else {
            // render static map
            gameMap.getTiles().forEach(tile -> renderEntity(LayerManager.STATIC_MAP, tile));
            layerManager.active(LayerManager.STATIC_MAP);

            // start dynamic object
            layerManager.active(LayerManager.DYNAMIC_OBJECT);
            timer.start();
        }
    }

    private void endGame() {
        gameStatus = GAME_OVER;
        System.out.println("--YOUR SCORE: " + gameMap.getPlayer().getScore() + "--");
    }

    private void renderEntity(int layer, Entity e) {
        Image img = imageManager.getImage(e.getImageID());
        layerManager.render(img, layer, e.getX(), e.getY());
    }

    public Scene getScene() {
        return layerManager.getScene();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
