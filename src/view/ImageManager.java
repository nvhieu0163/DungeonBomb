package view;

import javafx.scene.image.Image;

import java.util.*;

public class ImageManager {
    private final int imageWidth;
    private final int imageHeight;
    private Map<Integer, Image> imageMap;

    // CHARACTER
    public static final int SKELETON1_1 = 1001;
    public static final int SKELETON1_2 = 1002;
    public static final int SKELETON1_3 = 1003;
    public static final int SKELETON1_4 = 1004;
    public static final int SKELETON1_5 = 1005;
    public static final int SKELETON1_6 = 1006;
    public static final int SKELETON1_7 = 1007;
    public static final int SKELETON1_8 = 1008;

    public static final int SKELETON2_1 = 1011;
    public static final int SKELETON2_2 = 1012;
    public static final int SKELETON2_3 = 1013;
    public static final int SKELETON2_4 = 1014;
    public static final int SKELETON2_5 = 1015;
    public static final int SKELETON2_6 = 1016;
    public static final int SKELETON2_7 = 1017;
    public static final int SKELETON2_8 = 1018;

    public static final int SKULL_1 = 1021;
    public static final int SKULL_2 = 1022;
    public static final int SKULL_3 = 1023;
    public static final int SKULL_4 = 1024;
    public static final int SKULL_5 = 1025;
    public static final int SKULL_6 = 1026;
    public static final int SKULL_7 = 1027;
    public static final int SKULL_8 = 1028;

    public static final int VAMPIRE_1 = 1031;
    public static final int VAMPIRE_2 = 1032;
    public static final int VAMPIRE_3 = 1033;
    public static final int VAMPIRE_4 = 1034;
    public static final int VAMPIRE_5 = 1035;
    public static final int VAMPIRE_6 = 1036;
    public static final int VAMPIRE_7 = 1037;
    public static final int VAMPIRE_8 = 1038;

    public static final int PRIEST1_1 = 1101;
    public static final int PRIEST1_2 = 1102;
    public static final int PRIEST1_3 = 1103;
    public static final int PRIEST1_4 = 1104;
    public static final int PRIEST1_5 = 1105;
    public static final int PRIEST1_6 = 1106;
    public static final int PRIEST1_7 = 1107;
    public static final int PRIEST1_8 = 1108;

    public static final int PRIEST2_1 = 1111;
    public static final int PRIEST2_2 = 1112;
    public static final int PRIEST2_3 = 1113;
    public static final int PRIEST2_4 = 1114;
    public static final int PRIEST2_5 = 1115;
    public static final int PRIEST2_6 = 1116;
    public static final int PRIEST2_7 = 1117;
    public static final int PRIEST2_8 = 1118;

    public static final int PRIEST3_1 = 1121;
    public static final int PRIEST3_2 = 1122;
    public static final int PRIEST3_3 = 1123;
    public static final int PRIEST3_4 = 1124;
    public static final int PRIEST3_5 = 1125;
    public static final int PRIEST3_6 = 1126;
    public static final int PRIEST3_7 = 1127;
    public static final int PRIEST3_8 = 1128;

    // INTERFACE
    public static final int I_ARROW_1 = 2001;
    public static final int I_ARROW_2 = 2002;
    public static final int I_ARROW_3 = 2003;
    public static final int I_ARROW_4 = 2004;

    public static final int FLAG_1 = 2101;
    public static final int FLAG_2 = 2102;
    public static final int FLAG_3 = 2103;
    public static final int FLAG_4 = 2104;

    public static final int CANDLESTICK_1_1 = 2201;
    public static final int CANDLESTICK_1_2 = 2202;
    public static final int CANDLESTICK_1_3 = 2203;
    public static final int CANDLESTICK_1_4 = 2204;

    public static final int CANDLESTICK_2_1 = 2211;
    public static final int CANDLESTICK_2_2 = 2212;
    public static final int CANDLESTICK_2_3 = 2213;
    public static final int CANDLESTICK_2_4 = 2214;

    public static final int SIDE_TORCH_1 = 2221;
    public static final int SIDE_TORCH_2 = 2222;
    public static final int SIDE_TORCH_3 = 2223;
    public static final int SIDE_TORCH_4 = 2224;

    public static final int TORCH_1 = 2231;
    public static final int TORCH_2 = 2232;
    public static final int TORCH_3 = 2233;
    public static final int TORCH_4 = 2234;

    public static final int BONE_1 = 2301;
    public static final int BONE_2 = 2302;
    public static final int CLOSED_GATE_LEFT = 2311;
    public static final int CLOSED_GATE_RIGHT = 2312;
    public static final int OPENED_GATE_LEFT = 2313;
    public static final int OPENED_GATE_RIGHT = 2314;
    public static final int LADDER = 2321;
    public static final int MUD_1 = 2331;
    public static final int MUD_2 = 2332;
    public static final int WEB_LEFT = 2341;

    // ITEM AND TRAP
    public static final int ARROW_1 = 3001;
    public static final int ARROW_2 = 3002;
    public static final int ARROW_3 = 3003;
    public static final int ARROW_4 = 3004;
    public static final int ARROW_5 = 3005;

    public static final int BOMB_1 = 3101;
    public static final int BOMB_2 = 3102;
    public static final int BOMB_3 = 3103;
    public static final int BOMB_4 = 3104;
    public static final int BOMB_5 = 3105;
    public static final int BOMB_6 = 3106;
    public static final int BOMB_7 = 3107;
    public static final int BOMB_8 = 3108;
    public static final int BOMB_9 = 3109;
    public static final int BOMB_10 = 3110;

    public static final int BOX1_1 = 3201;
    public static final int BOX1_2 = 3202;
    public static final int BOX1_3 = 3203;
    public static final int BOX1_4 = 3204;

    public static final int BOX2_1 = 3301;
    public static final int BOX2_2 = 3302;
    public static final int BOX2_3 = 3303;
    public static final int BOX2_4 = 3304;

    public static final int CHEST_1 = 3401;
    public static final int CHEST_2 = 3402;
    public static final int CHEST_3 = 3403;
    public static final int CHEST_4 = 3404;
    public static final int CHEST_5 = 3405;
    public static final int CHEST_6 = 3406;
    public static final int CHEST_7 = 3407;
    public static final int CHEST_8 = 3408;

    public static final int COIN_1 = 3501;
    public static final int COIN_2 = 3502;
    public static final int COIN_3 = 3503;
    public static final int COIN_4 = 3504;

    public static final int FIRE_TOP_1 = 3601;
    public static final int FIRE_TOP_2 = 3602;
    public static final int FIRE_TOP_3 = 3603;
    public static final int FIRE_TOP_4 = 3604;
    public static final int FIRE_BOTTOM_1 = 3605;
    public static final int FIRE_BOTTOM_2 = 3606;
    public static final int FIRE_BOTTOM_3 = 3607;
    public static final int FIRE_BOTTOM_4 = 3608;
    public static final int FIRE_RIGHT_1 = 3609;
    public static final int FIRE_RIGHT_2 = 3610;
    public static final int FIRE_RIGHT_3 = 3611;
    public static final int FIRE_RIGHT_4 = 3612;
    public static final int FIRE_LEFT_1 = 3613;
    public static final int FIRE_LEFT_2 = 3614;
    public static final int FIRE_LEFT_3 = 3615;
    public static final int FIRE_LEFT_4 = 3616;

    public static final int FLAMETHROWER_1 = 3701;
    public static final int FLAMETHROWER_2 = 3702;
    public static final int FLAMETHROWER_3 = 3703;
    public static final int FLAMETHROWER_4 = 3704;

    public static final int FLASK1_1 = 3801;    //XANH DUONG
    public static final int FLASK1_2 = 3802;
    public static final int FLASK1_3 = 3803;
    public static final int FLASK1_4 = 3804;

    public static final int FLASK2_1 = 3805;    //DO
    public static final int FLASK2_2 = 3806;
    public static final int FLASK2_3 = 3807;
    public static final int FLASK2_4 = 3808;

    public static final int FLASK3_1 = 3809;    //XANH LA
    public static final int FLASK3_2 = 3811;
    public static final int FLASK3_3 = 3812;
    public static final int FLASK3_4 = 3813;

    public static final int KEY1_1 = 3901;    //KEY VANG
    public static final int KEY1_2 = 3902;
    public static final int KEY1_3 = 3903;
    public static final int KEY1_4 = 3904;

    public static final int KEY2_1 = 3905;    //KEY BAC
    public static final int KEY2_2 = 3906;
    public static final int KEY2_3 = 3907;
    public static final int KEY2_4 = 3908;

    public static final int PEAKS_1 = 3911;    //BAY DUOI CHAN
    public static final int PEAKS_2 = 3912;
    public static final int PEAKS_3 = 3913;
    public static final int PEAKS_4 = 3914;


    // TILE
    // _
    public static final int FLOOR_1 = 4001;
    public static final int FLOOR_2 = 4002;
    public static final int FLOOR_3 = 4003;
    public static final int FLOOR_4 = 4004;
    public static final int FLOOR_5 = 4005;
    public static final int FLOOR_6 = 4006;
    public static final int FLOOR_7 = 4007;
    public static final int FLOOR_8 = 4008;
    public static final int FLOOR_9 = 4009;
    public static final int FLOOR_10 = 4010;
    public static final int FLOOR_11 = 4011;
    public static final int FLOOR_12 = 4012;

    // B
    public static final int WALL_BOTTOM_1 = 4101;
    public static final int WALL_BOTTOM_2 = 4102;
    public static final int WALL_BOTTOM_3 = 4103;
    public static final int WALL_BOTTOM_4 = 4104;

    // }
    public static final int WALL_CORNER_1_LEFT = 4201;

    // {
    public static final int WALL_CORNER_1_RIGHT = 4202;

    // [
    public static final int WALL_CORNER_3_LEFT_1 = 4301;
    public static final int WALL_CORNER_3_LEFT_2 = 4302;
    public static final int WALL_CORNER_3_LEFT_3 = 4303;

    // ]
    public static final int WALL_CORNER_3_RIGHT_1 = 4401;
    public static final int WALL_CORNER_3_RIGHT_2 = 4402;
    public static final int WALL_CORNER_3_RIGHT_3 = 4403;

    // L
    public static final int WALL_LEFT_1 = 4501;
    public static final int WALL_LEFT_2 = 4502;

    // R
    public static final int WALL_RIGHT_1 = 4601;
    public static final int WALL_RIGHT_2 = 4602;

    // T
    public static final int WALL_TOP_1 = 4701;
    public static final int WALL_TOP_2 = 4702;
    public static final int WALL_TOP_3 = 4703;
    public static final int WALL_TOP_4 = 4704;

    // |
    public static final int WALL_H = 4801;
    // (
    public static final int WALL_H_LEFT = 4802;
    // )
    public static final int WALL_H_RIGHT = 4803;

    // -
    public static final int WALL_V = 4901;
    // +
    public static final int WALL_V_BOTTOM = 4902;
    // ^
    public static final int WALL_V_TOP = 4903;

    private final List<Integer> TILE_IMAGE = List.of(
            FLOOR_1, FLOOR_2, FLOOR_3, FLOOR_4, FLOOR_5, FLOOR_6,
            FLOOR_7, FLOOR_8, FLOOR_9, FLOOR_10, FLOOR_11, FLOOR_12,
            WALL_BOTTOM_1, WALL_BOTTOM_2, WALL_BOTTOM_3, WALL_BOTTOM_4,
            WALL_CORNER_1_LEFT, WALL_CORNER_1_RIGHT,
            WALL_CORNER_3_LEFT_1, WALL_CORNER_3_LEFT_2, WALL_CORNER_3_LEFT_3,
            WALL_CORNER_3_RIGHT_1, WALL_CORNER_3_RIGHT_2, WALL_CORNER_3_RIGHT_3,
            WALL_LEFT_1, WALL_LEFT_2, WALL_RIGHT_1, WALL_RIGHT_2,
            WALL_TOP_1, WALL_TOP_2, WALL_TOP_3, WALL_TOP_4,
            WALL_H, WALL_H_LEFT, WALL_H_RIGHT,
            WALL_V, WALL_V_BOTTOM, WALL_V_TOP
    );

    private final List<Integer> INTERFACE_IMAGE = List.of(
            I_ARROW_1, I_ARROW_2, I_ARROW_3, I_ARROW_4,
            FLAG_1, FLAG_2, FLAG_3, FLAG_4,
            CANDLESTICK_1_1, CANDLESTICK_1_2, CANDLESTICK_1_3, CANDLESTICK_1_4,
            CANDLESTICK_2_1, CANDLESTICK_2_2, CANDLESTICK_2_3, CANDLESTICK_2_4,
            SIDE_TORCH_1, SIDE_TORCH_2, SIDE_TORCH_3, SIDE_TORCH_4,
            TORCH_1, TORCH_2, TORCH_3, TORCH_4,
            BONE_1, BONE_2,
            CLOSED_GATE_LEFT, CLOSED_GATE_RIGHT,
            OPENED_GATE_LEFT, OPENED_GATE_RIGHT,
            LADDER,
            MUD_1, MUD_2,
            WEB_LEFT
    );

    private final List<Integer> CHARACTER_IMAGE = List.of(
            SKELETON1_1, SKELETON1_2, SKELETON1_3, SKELETON1_4,
            SKELETON1_5, SKELETON1_6, SKELETON1_7, SKELETON1_8,
            SKELETON2_1, SKELETON2_2, SKELETON2_3, SKELETON2_4,
            SKELETON2_5, SKELETON2_6, SKELETON2_7, SKELETON2_8,
            SKULL_1, SKULL_2, SKULL_3, SKULL_4,
            SKULL_5, SKULL_6, SKULL_7, SKULL_8,
            VAMPIRE_1, VAMPIRE_2, VAMPIRE_3, VAMPIRE_4,
            VAMPIRE_5, VAMPIRE_6, VAMPIRE_7, VAMPIRE_8,
            PRIEST1_1, PRIEST1_2, PRIEST1_3, PRIEST1_4,
            PRIEST1_5, PRIEST1_6, PRIEST1_7, PRIEST1_8,
            PRIEST2_1, PRIEST2_2, PRIEST2_3, PRIEST2_4,
            PRIEST2_5, PRIEST2_6, PRIEST2_7, PRIEST2_8,
            PRIEST3_1, PRIEST3_2, PRIEST3_3, PRIEST3_4,
            PRIEST3_5, PRIEST3_6, PRIEST3_7, PRIEST3_8
    );

    private final List<Integer> ITEM_AND_TRAP_IMAGE = List.of(
            ARROW_1, ARROW_2, ARROW_3, ARROW_4, ARROW_5,
            BOMB_1, BOMB_2, BOMB_3, BOMB_4, BOMB_5, BOMB_6, BOMB_7, BOMB_8, BOMB_9, BOMB_10,
            BOX1_1, BOX1_2, BOX1_3, BOX1_4,
            BOX2_1, BOX2_2, BOX2_3, BOX2_4,
            CHEST_1, CHEST_2, CHEST_3, CHEST_4,
            CHEST_5, CHEST_6, CHEST_7, CHEST_8,
            COIN_1, COIN_2, COIN_3, COIN_4,
            FIRE_TOP_1, FIRE_TOP_2, FIRE_TOP_3, FIRE_TOP_4,
            FIRE_BOTTOM_1, FIRE_BOTTOM_2, FIRE_BOTTOM_3, FIRE_BOTTOM_4,
            FIRE_RIGHT_1, FIRE_RIGHT_2, FIRE_RIGHT_3, FIRE_RIGHT_4,
            FIRE_LEFT_1, FIRE_LEFT_2, FIRE_LEFT_3, FIRE_LEFT_4,
            FLAMETHROWER_1, FLAMETHROWER_2, FLAMETHROWER_3, FLAMETHROWER_4,
            FLASK1_1, FLASK1_2, FLASK1_3, FLASK1_4,
            FLASK2_1, FLASK2_2, FLASK2_3, FLASK2_4,
            FLASK3_1, FLASK3_2, FLASK3_3, FLASK3_4,
            KEY1_1, KEY1_2, KEY1_3, KEY1_4,
            KEY2_1, KEY2_2, KEY2_3, KEY2_4,
            PEAKS_1, PEAKS_2, PEAKS_3, PEAKS_4
    );

    private static final Map<Integer, String> IMAGE_PATH = new HashMap<>() {{
        // TILE
        put(FLOOR_1, "img/tile/floor_1.png");
        put(FLOOR_2, "img/tile/floor_2.png");
        put(FLOOR_3, "img/tile/floor_3.png");
        put(FLOOR_4, "img/tile/floor_4.png");
        put(FLOOR_5, "img/tile/floor_5.png");
        put(FLOOR_6, "img/tile/floor_6.png");
        put(FLOOR_7, "img/tile/floor_7.png");
        put(FLOOR_8, "img/tile/floor_8.png");
        put(FLOOR_9, "img/tile/floor_9.png");
        put(FLOOR_10, "img/tile/floor_10.png");
        put(FLOOR_11, "img/tile/floor_11.png");
        put(FLOOR_12, "img/tile/floor_12.png");

        put(WALL_BOTTOM_1, "img/tile/wall_bottom_1.png");
        put(WALL_BOTTOM_2, "img/tile/wall_bottom_2.png");
        put(WALL_BOTTOM_3, "img/tile/wall_bottom_3.png");
        put(WALL_BOTTOM_4, "img/tile/wall_bottom_4.png");

        put(WALL_CORNER_1_LEFT, "img/tile/wall_corner_1_left.png");
        put(WALL_CORNER_1_RIGHT, "img/tile/wall_corner_1_right.png");

        put(WALL_CORNER_3_LEFT_1, "img/tile/wall_corner_3_left_1.png");
        put(WALL_CORNER_3_LEFT_2, "img/tile/wall_corner_3_left_2.png");
        put(WALL_CORNER_3_LEFT_3, "img/tile/wall_corner_3_left_3.png");

        put(WALL_CORNER_3_RIGHT_1, "img/tile/wall_corner_3_right_1.png");
        put(WALL_CORNER_3_RIGHT_2, "img/tile/wall_corner_3_right_2.png");
        put(WALL_CORNER_3_RIGHT_3, "img/tile/wall_corner_3_right_3.png");

        put(WALL_LEFT_1, "img/tile/wall_left_1.png");
        put(WALL_LEFT_2, "img/tile/wall_left_2.png");

        put(WALL_RIGHT_1, "img/tile/wall_right_1.png");
        put(WALL_RIGHT_2, "img/tile/wall_right_2.png");

        put(WALL_TOP_1, "img/tile/wall_top_1.png");
        put(WALL_TOP_2, "img/tile/wall_top_2.png");
        put(WALL_TOP_3, "img/tile/wall_top_3.png");
        put(WALL_TOP_4, "img/tile/wall_top_4.png");

        put(WALL_H, "img/tile/wall_h.png");
        put(WALL_H_LEFT, "img/tile/wall_h_left.png");
        put(WALL_H_RIGHT, "img/tile/wall_h_right.png");

        put(WALL_V, "img/tile/wall_v.png");
        put(WALL_V_BOTTOM, "img/tile/wall_v_bottom.png");
        put(WALL_V_TOP, "img/tile/wall_v_top.png");

        // ITEM AND TRAP
        put(ARROW_1, "img/item_and_trap/arrow/arrow_1.png");
        put(ARROW_2, "img/item_and_trap/arrow/arrow_2.png");
        put(ARROW_3, "img/item_and_trap/arrow/arrow_3.png");
        put(ARROW_4, "img/item_and_trap/arrow/arrow_4.png");
        put(ARROW_5, "img/item_and_trap/arrow/Just_arrow.png");

        put(BOMB_1, "img/item_and_trap/bomb/bomb_1.png");
        put(BOMB_2, "img/item_and_trap/bomb/bomb_2.png");
        put(BOMB_3, "img/item_and_trap/bomb/bomb_3.png");
        put(BOMB_4, "img/item_and_trap/bomb/bomb_4.png");
        put(BOMB_5, "img/item_and_trap/bomb/bomb_5.png");
        put(BOMB_6, "img/item_and_trap/bomb/bomb_6.png");
        put(BOMB_7, "img/item_and_trap/bomb/bomb_7.png");
        put(BOMB_8, "img/item_and_trap/bomb/bomb_8.png");
        put(BOMB_9, "img/item_and_trap/bomb/bomb_9.png");
        put(BOMB_10, "img/item_and_trap/bomb/bomb_10.png");

        put(BOX1_1, "img/item_and_trap/box_1/box_1_1.png");
        put(BOX1_2, "img/item_and_trap/box_1/box_1_2.png");
        put(BOX1_3, "img/item_and_trap/box_1/box_1_3.png");
        put(BOX1_4, "img/item_and_trap/box_1/box_1_4.png");

        put(BOX2_1, "img/item_and_trap/box_2/box_2_1.png");
        put(BOX2_2, "img/item_and_trap/box_2/box_2_2.png");
        put(BOX2_3, "img/item_and_trap/box_2/box_2_3.png");
        put(BOX2_4, "img/item_and_trap/box_2/box_2_4.png");

        put(CHEST_1, "img/item_and_trap/chest/chest_1.png");
        put(CHEST_2, "img/item_and_trap/chest/chest_2.png");
        put(CHEST_3, "img/item_and_trap/chest/chest_3.png");
        put(CHEST_4, "img/item_and_trap/chest/chest_4.png");

        put(CHEST_5, "img/item_and_trap/chest/chest_open_1.png");
        put(CHEST_6, "img/item_and_trap/chest/chest_open_2.png");
        put(CHEST_7, "img/item_and_trap/chest/chest_open_3.png");
        put(CHEST_8, "img/item_and_trap/chest/chest_open_4.png");

        put(COIN_1, "img/item_and_trap/coin/coin_1.png");
        put(COIN_2, "img/item_and_trap/coin/coin_2.png");
        put(COIN_3, "img/item_and_trap/coin/coin_3.png");
        put(COIN_4, "img/item_and_trap/coin/coin_4.png");

        put(FIRE_BOTTOM_1, "img/item_and_trap/fire/fire_bottom_1.png");
        put(FIRE_BOTTOM_2, "img/item_and_trap/fire/fire_bottom_2.png");
        put(FIRE_BOTTOM_3, "img/item_and_trap/fire/fire_bottom_3.png");
        put(FIRE_BOTTOM_4, "img/item_and_trap/fire/fire_bottom_4.png");
        put(FIRE_LEFT_1, "img/item_and_trap/fire/fire_left_1.png");
        put(FIRE_LEFT_2, "img/item_and_trap/fire/fire_left_2.png");
        put(FIRE_LEFT_3, "img/item_and_trap/fire/fire_left_3.png");
        put(FIRE_LEFT_4, "img/item_and_trap/fire/fire_left_4.png");
        put(FIRE_RIGHT_1, "img/item_and_trap/fire/fire_right_1.png");
        put(FIRE_RIGHT_2, "img/item_and_trap/fire/fire_right_2.png");
        put(FIRE_RIGHT_3, "img/item_and_trap/fire/fire_right_3.png");
        put(FIRE_RIGHT_4, "img/item_and_trap/fire/fire_right_4.png");
        put(FIRE_TOP_1, "img/item_and_trap/fire/fire_top_1.png");
        put(FIRE_TOP_2, "img/item_and_trap/fire/fire_top_2.png");
        put(FIRE_TOP_3, "img/item_and_trap/fire/fire_top_3.png");
        put(FIRE_TOP_4, "img/item_and_trap/fire/fire_top_4.png");

        put(FLAMETHROWER_1, "img/item_and_trap/flamethrower/flamethrower_1_1.png");
        put(FLAMETHROWER_2, "img/item_and_trap/flamethrower/flamethrower_1_2.png");
        put(FLAMETHROWER_3, "img/item_and_trap/flamethrower/flamethrower_1_3.png");
        put(FLAMETHROWER_4, "img/item_and_trap/flamethrower/flamethrower_1_4.png");

        put(FLASK1_1, "img/item_and_trap/flasks/flasks_3_1.png");
        put(FLASK1_2, "img/item_and_trap/flasks/flasks_3_2.png");
        put(FLASK1_3, "img/item_and_trap/flasks/flasks_3_3.png");
        put(FLASK1_4, "img/item_and_trap/flasks/flasks_3_4.png");
        put(FLASK2_1, "img/item_and_trap/flasks/flasks_4_1.png");
        put(FLASK2_2, "img/item_and_trap/flasks/flasks_4_2.png");
        put(FLASK2_3, "img/item_and_trap/flasks/flasks_4_3.png");
        put(FLASK2_4, "img/item_and_trap/flasks/flasks_4_4.png");
        put(FLASK3_1, "img/item_and_trap/flasks/flasks_5_1.png");
        put(FLASK3_2, "img/item_and_trap/flasks/flasks_5_2.png");
        put(FLASK3_3, "img/item_and_trap/flasks/flasks_5_3.png");
        put(FLASK3_4, "img/item_and_trap/flasks/flasks_5_4.png");

        put(KEY1_1, "img/item_and_trap/keys/keys_1_1.png");
        put(KEY1_2, "img/item_and_trap/keys/keys_1_2.png");
        put(KEY1_3, "img/item_and_trap/keys/keys_1_3.png");
        put(KEY1_4, "img/item_and_trap/keys/keys_1_4.png");
        put(KEY2_1, "img/item_and_trap/keys/keys_2_1.png");
        put(KEY2_2, "img/item_and_trap/keys/keys_2_2.png");
        put(KEY2_3, "img/item_and_trap/keys/keys_2_3.png");
        put(KEY2_4, "img/item_and_trap/keys/keys_2_4.png");

        put(PEAKS_1, "img/item_and_trap/peaks/peaks_1.png");
        put(PEAKS_2, "img/item_and_trap/peaks/peaks_2.png");
        put(PEAKS_3, "img/item_and_trap/peaks/peaks_3.png");
        put(PEAKS_4, "img/item_and_trap/peaks/peaks_4.png");

        // CHARACTER
        put(SKELETON1_1, "img/character/enemy/skeleton1/skeleton_v2_1.png");
        put(SKELETON1_2, "img/character/enemy/skeleton1/skeleton_v2_2.png");
        put(SKELETON1_3, "img/character/enemy/skeleton1/skeleton_v2_3.png");
        put(SKELETON1_4, "img/character/enemy/skeleton1/skeleton_v2_4.png");
        put(SKELETON1_5, "img/character/enemy/skeleton1/skeleton_v2_5.png");
        put(SKELETON1_6, "img/character/enemy/skeleton1/skeleton_v2_6.png");
        put(SKELETON1_7, "img/character/enemy/skeleton1/skeleton_v2_7.png");
        put(SKELETON1_8, "img/character/enemy/skeleton1/skeleton_v2_8.png");

        put(SKELETON2_1, "img/character/enemy/skeleton2/skeleton2_v2_1.png");
        put(SKELETON2_2, "img/character/enemy/skeleton2/skeleton2_v2_2.png");
        put(SKELETON2_3, "img/character/enemy/skeleton2/skeleton2_v2_3.png");
        put(SKELETON2_4, "img/character/enemy/skeleton2/skeleton2_v2_4.png");
        put(SKELETON2_5, "img/character/enemy/skeleton2/skeleton2_v2_5.png");
        put(SKELETON2_6, "img/character/enemy/skeleton2/skeleton2_v2_6.png");
        put(SKELETON2_7, "img/character/enemy/skeleton2/skeleton2_v2_7.png");
        put(SKELETON2_8, "img/character/enemy/skeleton2/skeleton2_v2_8.png");

        put(SKULL_1, "img/character/enemy/skull/skull_v2_1.png");
        put(SKULL_2, "img/character/enemy/skull/skull_v2_2.png");
        put(SKULL_3, "img/character/enemy/skull/skull_v2_3.png");
        put(SKULL_4, "img/character/enemy/skull/skull_v2_4.png");
        put(SKULL_5, "img/character/enemy/skull/skull_v2_5.png");
        put(SKULL_6, "img/character/enemy/skull/skull_v2_6.png");
        put(SKULL_7, "img/character/enemy/skull/skull_v2_7.png");
        put(SKULL_8, "img/character/enemy/skull/skull_v2_8.png");

        put(VAMPIRE_1, "img/character/enemy/vampire/vampire_v2_1.png");
        put(VAMPIRE_2, "img/character/enemy/vampire/vampire_v2_2.png");
        put(VAMPIRE_3, "img/character/enemy/vampire/vampire_v2_3.png");
        put(VAMPIRE_4, "img/character/enemy/vampire/vampire_v2_4.png");
        put(VAMPIRE_5, "img/character/enemy/vampire/vampire_v2_5.png");
        put(VAMPIRE_6, "img/character/enemy/vampire/vampire_v2_6.png");
        put(VAMPIRE_7, "img/character/enemy/vampire/vampire_v2_7.png");
        put(VAMPIRE_8, "img/character/enemy/vampire/vampire_v2_8.png");

        put(PRIEST1_1, "img/character/player/priest1/priest1_v1_1.png");
        put(PRIEST1_2, "img/character/player/priest1/priest1_v1_2.png");
        put(PRIEST1_3, "img/character/player/priest1/priest1_v1_3.png");
        put(PRIEST1_4, "img/character/player/priest1/priest1_v1_4.png");
        put(PRIEST1_5, "img/character/player/priest1/priest1_v1_5.png");
        put(PRIEST1_6, "img/character/player/priest1/priest1_v1_6.png");
        put(PRIEST1_7, "img/character/player/priest1/priest1_v1_7.png");
        put(PRIEST1_8, "img/character/player/priest1/priest1_v1_8.png");

        put(PRIEST2_1, "img/character/player/priest2/priest2_v1_1.png");
        put(PRIEST2_2, "img/character/player/priest2/priest2_v1_2.png");
        put(PRIEST2_3, "img/character/player/priest2/priest2_v1_3.png");
        put(PRIEST2_4, "img/character/player/priest2/priest2_v1_4.png");
        put(PRIEST2_5, "img/character/player/priest2/priest2_v1_5.png");
        put(PRIEST2_6, "img/character/player/priest2/priest2_v1_6.png");
        put(PRIEST2_7, "img/character/player/priest2/priest2_v1_7.png");
        put(PRIEST2_8, "img/character/player/priest2/priest2_v1_8.png");

        put(PRIEST3_1, "img/character/player/priest3/priest3_v1_1.png");
        put(PRIEST3_2, "img/character/player/priest3/priest3_v1_2.png");
        put(PRIEST3_3, "img/character/player/priest3/priest3_v1_3.png");
        put(PRIEST3_4, "img/character/player/priest3/priest3_v1_4.png");
        put(PRIEST3_5, "img/character/player/priest3/priest3_v1_5.png");
        put(PRIEST3_6, "img/character/player/priest3/priest3_v1_6.png");
        put(PRIEST3_7, "img/character/player/priest3/priest3_v1_7.png");
        put(PRIEST3_8, "img/character/player/priest3/priest3_v1_8.png");

        // INTERFACE
        put(I_ARROW_1, "img/interface/arrow/arrow_1.png");
        put(I_ARROW_2, "img/interface/arrow/arrow_2.png");
        put(I_ARROW_3, "img/interface/arrow/arrow_3.png");
        put(I_ARROW_4, "img/interface/arrow/arrow_4.png");

        put(FLAG_1, "img/interface/flag/flag_1.png");
        put(FLAG_2, "img/interface/flag/flag_2.png");
        put(FLAG_3, "img/interface/flag/flag_3.png");
        put(FLAG_4, "img/interface/flag/flag_4.png");

        put(CANDLESTICK_1_1, "img/interface/torch/candlestick_1_1.png");
        put(CANDLESTICK_1_2, "img/interface/torch/candlestick_1_2.png");
        put(CANDLESTICK_1_3, "img/interface/torch/candlestick_1_3.png");
        put(CANDLESTICK_1_4, "img/interface/torch/candlestick_1_4.png");

        put(CANDLESTICK_2_1, "img/interface/torch/candlestick_2_1.png");
        put(CANDLESTICK_2_2, "img/interface/torch/candlestick_2_2.png");
        put(CANDLESTICK_2_3, "img/interface/torch/candlestick_2_3.png");
        put(CANDLESTICK_2_4, "img/interface/torch/candlestick_2_4.png");

        put(SIDE_TORCH_1, "img/interface/torch/side_torch_1.png");
        put(SIDE_TORCH_2, "img/interface/torch/side_torch_2.png");
        put(SIDE_TORCH_3, "img/interface/torch/side_torch_3.png");
        put(SIDE_TORCH_4, "img/interface/torch/side_torch_4.png");

        put(TORCH_1, "img/interface/torch/torch_1.png");
        put(TORCH_2, "img/interface/torch/torch_2.png");
        put(TORCH_3, "img/interface/torch/torch_3.png");
        put(TORCH_4, "img/interface/torch/torch_4.png");

        put(BONE_1, "img/interface/bone_1.png");
        put(BONE_2, "img/interface/bone_2.png");

        put(CLOSED_GATE_LEFT, "img/interface/closed_gate_left.png");
        put(CLOSED_GATE_RIGHT, "img/interface/closed_gate_right.png");
        put(OPENED_GATE_LEFT, "img/interface/opened_gate_left.png");
        put(OPENED_GATE_RIGHT, "img/interface/opened_gate_right.png");

        put(LADDER, "img/interface/ladder.png");

        put(MUD_1, "img/interface/mud_1.png");
        put(MUD_2, "img/interface/mud_2.png");

        put(WEB_LEFT, "img/interface/web_left.png");
    }};

    public ImageManager(int imageWidth, int imageHeight) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageMap = new HashMap<>();
    }

    public void load() {
        loadCharacter();
        loadInterface();
        loadItemAndTrap();
        loadTile();
    }

    public void loadCharacter() {
        CHARACTER_IMAGE.forEach(imageID -> imageMap.put(
                imageID,
                new Image(
                        IMAGE_PATH.get(imageID),
                        this.imageWidth, this.imageHeight,
                        false, false
                )
        ));
    }

    public void loadInterface() {
        INTERFACE_IMAGE.forEach(imageID -> imageMap.put(
                imageID,
                new Image(
                        IMAGE_PATH.get(imageID),
                        this.imageWidth, this.imageHeight,
                        false, false
                )
        ));
    }

    public void loadItemAndTrap() {
        ITEM_AND_TRAP_IMAGE.forEach(imageID -> imageMap.put(
                imageID,
                new Image(
                        IMAGE_PATH.get(imageID),
                        this.imageWidth, this.imageHeight,
                        false, false
                )
        ));
    }

    public void loadTile() {
        TILE_IMAGE.forEach(imageID -> imageMap.put(
                imageID,
                new Image(
                        IMAGE_PATH.get(imageID),
                        this.imageWidth, this.imageHeight,
                        false, false
                )
        ));
    }

    public Image getImage(int imageID) throws MissingResourceException {
        if (imageMap == null) {
            throw new MissingResourceException("Images have not loaded!", this.getClass().getName(), "imageMap");
        } else {
            return imageMap.get(imageID);
        }
    }
}
