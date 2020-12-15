package model;

import controller.ItemsController;
import model.entity.Entity;
import model.entity.character.Character;
import model.entity.character.Enemy;
import model.entity.character.Player;
import model.entity.item.*;
import model.entity.tile.Tile;
import model.entity.tile.Wall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static model.GameConfig.*;

public class GameMap {
    private List<Tile> tiles;
    private List<Interface> interfaces;
    private List<Item> items;
    private List<Trap> traps;
    private List<Bomb> bombs;
    private List<Fire> fires;
    private List<Enemy> enemies;
    private Player player;

    private int startX;
    private int startY;
    private boolean nextLevel;

    public GameMap(List<Tile> tiles, List<Enemy> enemies, List<Item> items, List<Trap> traps, List<Interface> interfaces, Player player) {
        this.tiles = tiles;
        this.items = items;
        this.traps = traps;
        this.interfaces = interfaces;
        this.enemies = enemies;

        this.player = player;

        this.bombs = new ArrayList<>();
        this.fires = new ArrayList<>();

        this.startX = player.getX();
        this.startY = player.getY();
        this.nextLevel = false;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Trap> getTraps() {
        return traps;
    }

    public void setTraps(List<Trap> traps) {
        this.traps = traps;
    }

    public List<Interface> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(List<Interface> interfaces) {
        this.interfaces = interfaces;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public List<Fire> getFires() {
        return fires;
    }

    public void setFires(List<Fire> fires) {
        this.fires = fires;
    }

    public void addBomb(Bomb bomb) {
        bombs.add(bomb);
    }

    public void removeBomb(Bomb bomb) {
        bombs.remove(bomb);
    }

    public void addFires(Fire[] fs) {
        fires.addAll(Arrays.asList(fs));
    }

    public void updateInfinity() {
        // update animation
        player.update();
        enemies.forEach(Character::update);
        items.forEach(Item::update);
        interfaces.forEach(Interface::update);
        traps.forEach(Trap::update);
    }

    public void updateWhenPlaying() {
        // update animation
        bombs.forEach(Bomb::update);
        fires.forEach(Fire::update);
    }

    public void move() {
        // move enemies
        enemies.forEach(e -> {
            e.move();

            if (RANDOM.nextInt(1000) > 994) {
                e.randomOblique();
                e.randomVerticalHorizontal();
            }

            if (entityCollision(e)) {
                e.rollback();

                e.randomVerticalHorizontal();
                e.randomOblique();
                e.randomEveryDirection();

                if (e.getVisible() == 1) {
                    e.turnAround();
                }
            }
        });

        // move fire
        List<Fire> fireToRemove = new ArrayList<>();
//        List<Entity> entitiesToRemove = new ArrayList<>();
        fires.forEach(f -> {
            if (f.getStatus() == Fire.CLEAR) {
                fireToRemove.add(f);
            } else {
                f.move();

                Interface itfToRemove = interfaceCollisionFire(f);
                if (f.getStatus() == Fire.FLYING && itfToRemove != null) {
                    if (itfToRemove.isDestroyable()) {
                        interfaces.remove(itfToRemove);
                        if (itfToRemove.isHasItem()) {
                            items.add(new Item(itfToRemove.getX(), itfToRemove.getY(), ItemsController.getRandomItems()));
                            f.end();
                        }
                    }
                    f.end();
//                    itfToRemove = null;
                }

                if (f.getStatus() == Fire.FLYING && entityCollision(f)) {
                    f.end();
                }

                Enemy enemyToDie = enemyCollisionFire(f);
                if (enemyToDie != null) {
                    f.end();
                    enemies.remove(enemyToDie);
                    getPlayer().increaseScore();
//                    enemyToDie = null;
                }
            }
        });
        fireToRemove.forEach(f -> fires.remove(f));

        // move player
        player.move();
        if (playerCollisionHarmful(player)) {
            playerComebackStart();
        }

        if (entityCollision(player)) {
            if (getEnemies().isEmpty() && player.isHasKey()) {
                for (Interface aInterface : interfaces) {
                    if (aInterface.getTypeOfInterface() == 11 && player.collisionWith(aInterface, SOFT_EDGE_WALL)) {
                        setNextLevel(true);
                    }
                }
            }
            player.rollback();
        }

        Item itemToRemove = playerEatItems();
        if (itemToRemove != null) {
            items.remove(itemToRemove);
//            itemToRemove = null;
        }

    }

    public void setNextLevel(boolean nextLevel) {
        this.nextLevel = nextLevel;
    }

    public boolean isNextLevel() {
        return nextLevel;
    }

    private Item playerEatItems() {
        for (Item item : items) {
            if (player.collisionWith(item, SOFT_EDGE)) {
                int typeOfItem = item.getTypeOfItem();
                switch (typeOfItem) {
                    case 0:
                        player.setHasKey(true);
                        System.out.println("Player got Key");
                        return item;
                    case 1:
                        player.increaseLife();
                        System.out.println("Live is increased");
                        return item;
                    case 2:
                        player.increaseBombs();
                        System.out.println("Bomb is increased");
                        return item;
                    case 3:
                        player.increasePower();
                        System.out.println("Power is increased");
                        return item;
                    case 4:
                        player.increaseScore();
                        System.out.println("Ting ting:  $ ");
                        return item;
                }
            }
        }
        return null;
    }

    private boolean entityCollision(Entity e) {
        for (Tile tile : tiles) {
            if (tile instanceof Wall && e.collisionWith(tile, SOFT_EDGE_WALL)) {
                return true;
            }
        }
        for (Interface aInterface : interfaces) {
            if (e.collisionWith(aInterface, SOFT_EDGE_WALL) && aInterface.getTypeOfInterface() != 12 && aInterface.getTypeOfInterface() != 13) {
                return true;
            }
        }
        for (Trap trap : traps) {
            if(e.collisionWith(trap, SOFT_EDGE_WALL)) {
                return true;
            }
        }
        return false;
    }

    private Enemy enemyCollisionFire(Fire fire) {
        for (Enemy enemy : enemies) {
            if (enemy.collisionWith(fire, SOFT_EDGE)) {
                return enemy;
            }
        }
        return null;
    }

    private Interface interfaceCollisionFire(Fire fire) {
        for (Interface i : interfaces) {
            if (i.collisionWith(fire, SOFT_EDGE)) {
                return i;
            }
        }
        return null;
    }

    private boolean playerCollisionHarmful(Player player) {
        for (Enemy enemy : enemies) {
            if (player.collisionWith(enemy, SOFT_EDGE)) {
                return true;
            }
        }

        for (Fire fire : fires) {
            if (player.collisionWith(fire, SOFT_EDGE)) {
                return true;
            }
        }

        for (Trap trap : traps) {
            if (player.collisionWith(trap, SOFT_EDGE)) {
                return true;
            }
        }
        return false;
    }

    private void playerComebackStart() {
        player.decreaseLife();
        System.out.println("Lives: " + player.getLives());
        player.setX(startX);
        player.setY(startY);
    }

}
