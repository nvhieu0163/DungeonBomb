package controller;

import javafx.util.Pair;
import model.entity.item.Interface;
import model.entity.item.Item;
import model.entity.item.Trap;
import view.ImageManager;

import java.util.List;
import java.util.Random;

public class ItemsController {

    public static Integer[] TRAP_CLIP = new Integer[]{
            ImageManager.PEAKS_1, ImageManager.PEAKS_2, ImageManager.PEAKS_3, ImageManager.PEAKS_4
    };

    public static List<Pair<Integer, Integer[]>> LIST_INTERFACES_CLIP = List.of(
            ///DESTROYABLE: 'I' has items, 'E' no items
            //Silver Box
            new Pair<>(0, new Integer[]{
                    ImageManager.BOX1_1, ImageManager.BOX1_2, ImageManager.BOX1_3, ImageManager.BOX1_4
            }),

            //Metal Box
            new Pair<>(1, new Integer[]{
                    ImageManager.BOX2_1, ImageManager.BOX2_2, ImageManager.BOX2_3, ImageManager.BOX2_4
            }),

            //Chest
            new Pair<>(2, new Integer[]{
                    ImageManager.CHEST_1, ImageManager.CHEST_2, ImageManager.CHEST_3, ImageManager.CHEST_4
            }),

            //Mud
            new Pair<>(3, new Integer[]{
                    ImageManager.MUD_1
            }),

            //Mud 2
            new Pair<>(4, new Integer[]{
                    ImageManager.MUD_2
            }),

            //Web Spide
            new Pair<>(5, new Integer[]{
                    ImageManager.WEB_LEFT
            }),

            //Bone1
            new Pair<>(6, new Integer[]{
                    ImageManager.BONE_1
            }),

            //Bone2
            new Pair<>(7, new Integer[]{
                    ImageManager.BONE_2
            }),

            //Torch
            new Pair<>(8, new Integer[]{
                    ImageManager.CANDLESTICK_1_1, ImageManager.CANDLESTICK_1_2, ImageManager.CANDLESTICK_1_3, ImageManager.CANDLESTICK_1_4
            }),

            //Torch 2
            new Pair<>(9, new Integer[]{
                    ImageManager.CANDLESTICK_2_1, ImageManager.CANDLESTICK_2_2, ImageManager.CANDLESTICK_2_3,
                    ImageManager.CANDLESTICK_2_4
            }),

            ///NO DESTROYABLE
            //Flag 'F'
            new Pair<>(10, new Integer[]{
                    ImageManager.FLAG_1, ImageManager.FLAG_2, ImageManager.FLAG_3, ImageManager.FLAG_4
            }),

            //Ladder 'Y'
            new Pair<>(11, new Integer[]{
                    ImageManager.LADDER,
            }),

            //Arrow 'A'
            new Pair<>(12, new Integer[]{
                    ImageManager.I_ARROW_1, ImageManager.I_ARROW_2, ImageManager.I_ARROW_3, ImageManager.I_ARROW_4
            }),

            //Left Wall Torch '{'
            new Pair<>(13, new Integer[]{
                    ImageManager.SIDE_TORCH_1, ImageManager.SIDE_TORCH_2, ImageManager.SIDE_TORCH_3, ImageManager.SIDE_TORCH_4
            }),

            //Center Torch '|'
            new Pair<>(14, new Integer[]{
                    ImageManager.TORCH_1, ImageManager.TORCH_2, ImageManager.TORCH_3, ImageManager.TORCH_4
            })
    );

//    public static void main(String[] args) {
//        Interface aInteface = new Interface(60, 60, 11);
//        System.out.println(aInteface.getTypeOfInteface());
//        aInteface.getClip();
//    }

    public static List<Pair<Integer, Integer[]>> LIST_ITEMS_CLIP = List.of(
            //Gold Key 'K'
            new Pair<>(0, new Integer[]{
                    ImageManager.KEY1_1, ImageManager.KEY1_2, ImageManager.KEY1_3, ImageManager.KEY1_4
            }),

            //RedFlask
            new Pair<>(1, new Integer[]{
                    ImageManager.FLASK2_1, ImageManager.FLASK2_2, ImageManager.FLASK2_3, ImageManager.FLASK2_4,
            }),

            //BlueFlask
            new Pair<>(2, new Integer[]{
                    ImageManager.FLASK1_1, ImageManager.FLASK1_2, ImageManager.FLASK1_3, ImageManager.FLASK1_4,
            }),

            //GreenFlask
            new Pair<>(3, new Integer[]{
                    ImageManager.FLASK3_1, ImageManager.FLASK3_2, ImageManager.FLASK3_3, ImageManager.FLASK3_4,
            }),

            //Coin '$'
            new Pair<>(4, new Integer[]{
                    ImageManager.COIN_1, ImageManager.COIN_2, ImageManager.COIN_3, ImageManager.COIN_4
            })
    );

    public static int getRandomInterfaces() {
        Random random = new Random();
        return random.nextInt(LIST_INTERFACES_CLIP.size() - 5);
    }

    public static int getRandomItems() {
        Random random = new Random();
        return random.nextInt(LIST_ITEMS_CLIP.size());
    }

//    public static void main(String[] args) {
//        for (int i =0; i < 20; i++) {
//            System.out.print(getRandomInterfaces() + " ");
//        }
//    }

//    public static Item creatRedFlask(int x, int y, int numberOfItems) {
//        return new Item(x, y, numberOfItems);
//    }
//
//    public static Item creatBlueFlask(int x, int y, int numberOfItems) {
//        return new Item(x, y, numberOfItems);
//    }
//
//    public static Item createGreenFlask(int x, int y, int numberOfItems) {
//        return new Item(x, y, numberOfItems);
//    }

    public static Interface createInterface(int x, int y, boolean destroyable, boolean hasItem, int numberOfItf) {
        if (destroyable) {
            return new Interface(x, y, hasItem);
        } else {
            return new Interface(x, y, numberOfItf);
        }
    }

    public static Trap creatTrap(int x, int y) {
        return new Trap(x, y, TRAP_CLIP);
    }

    public static Item creatGoldKey(int x, int y) {
        return new Item(x, y, 0);
    }

    public static Item createCoin(int x, int y) {
        return new Item(x, y, 4);
    }
}
