package uet.oop.bomberman.gui;

import javafx.scene.image.*;

public class Sprite {

    private final int SIZE_X;
    private final int SIZE_Y;
    private int x, y;
    private int[] pixels; // diem anh
    private SpriteSheet sheet = SpriteSheet.tiles;

    // LAY ANH CON TU 1 ANH LON

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite[] grass = new Sprite[]{new Sprite(16, 367, 110),
                                            new Sprite(16, 689, 110),
                                            new Sprite(16, 367, 176),
                                            new Sprite(16, 689, 143)};
	public static Sprite portal = new Sprite(16, 393, 789);
	public static Sprite portal2 = new Sprite(16, 409, 789);

    /*
    |--------------------------------------------------------------------------
    | Wall sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite[] wall = new Sprite[]{new Sprite(16, 415, 110),
                                            new Sprite(16, 737, 110),
                                            new Sprite(16, 415, 176),
                                            new Sprite(16, 737, 143)};
    public static Sprite[] wallUp = new Sprite[]{new Sprite(16, 447, 110),
                                            new Sprite(16, 769, 110),
                                            new Sprite(16, 447, 176),
                                            new Sprite(16, 769, 143)};
    public static Sprite[] wallDown = new Sprite[]{new Sprite(16, 566, 110),
                                            new Sprite(16, 881, 110),
                                            new Sprite(16, 566, 176),
                                            new Sprite(16, 881, 143)};
    public static Sprite[] wallLeft = new Sprite[]{new Sprite(16, 623, 110),
                                            new Sprite(16, 945, 110),
                                            new Sprite(16, 623, 176),
                                            new Sprite(16, 945, 143)};
    public static Sprite[] wallRight = new Sprite[]{new Sprite(16, 495, 110),
                                            new Sprite(16, 817, 110),
                                            new Sprite(16, 495, 176),
                                            new Sprite(16, 817, 143)};
    public static Sprite[] wallUpLeft = new Sprite[]{new Sprite(16, 431, 110),
                                            new Sprite(16, 753, 110),
                                            new Sprite(16, 431, 176),
                                            new Sprite(16, 753, 143)};
    public static Sprite[] wallUpRight = new Sprite[]{new Sprite(16, 479, 110),
                                            new Sprite(16, 801, 110),
                                            new Sprite(16, 479, 176),
                                            new Sprite(16, 801, 143)};
    public static Sprite[] wallDownLeft = new Sprite[]{new Sprite(16,543, 110),
                                            new Sprite(16,865, 110),
                                            new Sprite(16,543, 176),
                                            new Sprite(16,865, 143)};
    public static Sprite[] wallDownRight = new Sprite[]{new Sprite(16, 607, 110),
                                            new Sprite(16, 929, 110),
                                            new Sprite(16, 607, 176),
                                            new Sprite(16, 929, 143)};

    /*
    |--------------------------------------------------------------------------
    | Player Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite player_up = new Sprite(22, 19,218, 0);
    public static Sprite player_down = new Sprite(22, 19, 2, 0);
    public static Sprite player_left = new Sprite(22, 19, 146, 0);
    public static Sprite player_right = new Sprite(22, 19, 73, 0);

    public static Sprite player_up_1 = new Sprite(22, 19, 241, 0);
    public static Sprite player_up_2 = new Sprite(22, 19, 267, 0);

    public static Sprite player_down_1 = new Sprite(22, 19, 27, 0);
    public static Sprite player_down_2 = new Sprite(22, 19, 49, 0);

    public static Sprite player_left_1 = new Sprite(22, 19, 169, 0);
    public static Sprite player_left_2 = new Sprite(22, 19, 193, 0);

    public static Sprite player_right_1 = new Sprite(22, 19, 98, 0);
    public static Sprite player_right_2 = new Sprite(22, 19, 122, 0);

    public static Sprite player_dead = new Sprite(21, 168, 25);
	public static Sprite player_dead1 = new Sprite(21, 145, 25);
    public static Sprite player_dead2 = new Sprite(21, 121, 25);
    public static Sprite player_dead3 = new Sprite(21, 97, 25);
	public static Sprite player_dead4 = new Sprite(21, 49, 24);
	public static Sprite player_dead5 = new Sprite(21, 25, 24);
	public static Sprite player_dead6 = new Sprite(21, 1, 24);

    /*
    |--------------------------------------------------------------------------
    | Bomb Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb = new Sprite(16, 470, 0);
    public static Sprite bomb_1 = new Sprite(16, 486, 0);
    public static Sprite bomb_2 = new Sprite(16, 502, 0);

    /*
    |--------------------------------------------------------------------------
    | FlameSegment Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite bomb_exploded = new Sprite(16, 454, 32);
    public static Sprite bomb_exploded1 = new Sprite(16, 438, 32);
    public static Sprite bomb_exploded2 = new Sprite(16, 422, 32);
    public static Sprite bomb_exploded3 = new Sprite(16, 406, 32);
    public static Sprite bomb_exploded4 = new Sprite(16, 390, 32);
    //
    public static Sprite explosion_vertical = new Sprite(16, 630, 16);
    public static Sprite explosion_vertical1 = new Sprite(16, 614, 16);
    public static Sprite explosion_vertical2 = new Sprite(16, 598, 16);
    public static Sprite explosion_vertical3 = new Sprite(16, 582, 16);
    //
    public static Sprite explosion_horizontal = new Sprite(16, 374, 32);
    public static Sprite explosion_horizontal1 = new Sprite(16, 358, 32);
    public static Sprite explosion_horizontal2 = new Sprite(16, 342, 32);
    public static Sprite explosion_horizontal3 = new Sprite(16, 326, 32);
    //
    public static Sprite explosion_horizontal_left_last = new Sprite(16, 566, 16);
    public static Sprite explosion_horizontal_left_last1 = new Sprite(16, 550, 16);
    public static Sprite explosion_horizontal_left_last2 = new Sprite(16, 534, 16);
    public static Sprite explosion_horizontal_left_last3 = new Sprite(16, 518, 16);
    //
    public static Sprite explosion_horizontal_right_last = new Sprite(16, 438, 16);
    public static Sprite explosion_horizontal_right_last1 = new Sprite(16, 422, 16);
    public static Sprite explosion_horizontal_right_last2 = new Sprite(16, 406, 16);
    public static Sprite explosion_horizontal_right_last3 = new Sprite(16, 390, 16);
    //
    public static Sprite explosion_vertical_top_last = new Sprite(16, 374, 16);
    public static Sprite explosion_vertical_top_last1 = new Sprite(16, 358, 16);
    public static Sprite explosion_vertical_top_last2 = new Sprite(16, 342, 16);
    public static Sprite explosion_vertical_top_last3 = new Sprite(16, 326, 16);
    //
    public static Sprite explosion_vertical_down_last = new Sprite(16, 502, 16);
    public static Sprite explosion_vertical_down_last1 = new Sprite(16, 486, 16);
    public static Sprite explosion_vertical_down_last2 = new Sprite(16, 470, 16);
    public static Sprite explosion_vertical_down_last3 = new Sprite(16, 454, 16);

	/*
	|--------------------------------------------------------------------------
	| Character
	|--------------------------------------------------------------------------
	 */

    /*
|--------------------------------------------------------------------------
| Brick
|--------------------------------------------------------------------------
 */
    public static Sprite[] brick = new Sprite[]{new Sprite(16, 399,110),
                                            new Sprite(16, 721,110),
                                            new Sprite(16, 399,176),
                                            new Sprite(16, 721,143)};

    public static Sprite[] brick_exploded6 = new Sprite[]{new Sprite(16, 495, 126),
                                            new Sprite(16, 817, 126),
                                            new Sprite(16, 495, 192),
                                            new Sprite(16, 817, 159)};
    public static Sprite[] brick_exploded5 = new Sprite[]{new Sprite(16, 511, 126),
                                            new Sprite(16, 833, 126),
                                            new Sprite(16, 511, 192),
                                            new Sprite(16, 833, 159)};
    public static Sprite[] brick_exploded4 = new Sprite[]{new Sprite(16, 527, 126),
                                            new Sprite(16, 849, 126),
                                            new Sprite(16, 527, 192),
                                            new Sprite(16, 849, 159)};
    public static Sprite[] brick_exploded3 = new Sprite[]{new Sprite(16, 543, 126),
                                            new Sprite(16, 865, 126),
                                            new Sprite(16, 543, 192),
                                            new Sprite(16, 865, 159)};
    public static Sprite[] brick_exploded2 = new Sprite[]{new Sprite(16, 559, 126),
                                            new Sprite(16, 881, 126),
                                            new Sprite(16, 559, 192),
                                            new Sprite(16, 881, 159)};
    public static Sprite[] brick_exploded1 = new Sprite[]{new Sprite(16, 575, 126),
                                            new Sprite(16, 897, 126),
                                            new Sprite(16, 575, 192),
                                            new Sprite(16, 897, 159)};
    public static Sprite[] brick_exploded = new Sprite[]{new Sprite(16, 591, 126),
                                            new Sprite(16, 913, 126),
                                            new Sprite(16, 591, 192),
                                            new Sprite(16, 913, 159)};
    /*
    |--------------------------------------------------------------------------
    | Powerups
    |--------------------------------------------------------------------------
     */
    public static Sprite itemBomb = new Sprite(16, 16, 48);
    public static Sprite itemFire = new Sprite(16, 0, 48);
    public static Sprite itemSpeed = new Sprite(16, 48, 48);

    //Enemy 1

	public static Sprite enemy1_1 = new Sprite(16, 426, 215);
	public static Sprite enemy1_2 = new Sprite(16, 442, 215);
	public static Sprite enemy1_3 = new Sprite(16, 458, 215);

	public static Sprite enemy1_dead1 = new Sprite(16, 474, 215);
	public static Sprite enemy1_dead2 = new Sprite(16, 490, 215);

	//Enemy2
    public static Sprite enemy2_up1 = new Sprite(16, 522, 233);
    public static Sprite enemy2_up2 = new Sprite(16, 538, 233);
    public static Sprite enemy2_up3 = new Sprite(16, 554, 233);

    public static Sprite enemy2_down1 = new Sprite(16, 618, 233);
    public static Sprite enemy2_down2 = new Sprite(16, 314, 251);
    public static Sprite enemy2_down3 = new Sprite(16, 330, 251);

    public static Sprite enemy2_left1 = new Sprite(16, 474, 233);
    public static Sprite enemy2_left2 = new Sprite(16, 490, 233);
    public static Sprite enemy2_left3 = new Sprite(16, 506, 233);

    public static Sprite enemy2_right1 = new Sprite(16, 570, 233);
    public static Sprite enemy2_right2 = new Sprite(16, 586, 233);
    public static Sprite enemy2_right3 = new Sprite(16, 602, 233);

    public static Sprite enemy2_dead1 = new Sprite(16, 346, 251);
    public static Sprite enemy2_dead2 = new Sprite(16, 378, 251);
    public static Sprite enemy2_dead3 = new Sprite(16, 394, 251);

    // Enemy3
    public static Sprite enemy3_1 = new Sprite(16, 554, 269);
    public static Sprite enemy3_2 = new Sprite(16, 570, 269);
    public static Sprite enemy3_3 = new Sprite(16, 586, 269);

    public static Sprite enemy3_dead1 = new Sprite(16, 602, 269);
    public static Sprite enemy3_dead2 = new Sprite(16, 618, 269);
    // Enemy dead
    public static Sprite dead1 = new Sprite(16, 80, 341);
    public static Sprite dead2 = new Sprite(16, 96, 341);
    public static Sprite dead3 = new Sprite(16, 112, 341);
    public static Sprite dead4 = new Sprite(16, 128, 341);


    public Sprite(int size, int xx, int yy) {
        SIZE_X = size;
        SIZE_Y = size;
        pixels = new int[SIZE_X * SIZE_Y];
        x = xx;
        y = yy;
        sheet = SpriteSheet.tiles;

        // luu tru diem anh
        for (int j = 0; j < SIZE_Y; j++) {
            for (int i = 0; i < SIZE_X; i++) {
                pixels[i + j * SIZE_Y] = sheet.pixels[(i + x) + (j + y) * sheet.SIZE];
            }
        }
    }

    public Sprite(int sizeY, int sizeX, int xx, int yy) {
        SIZE_X = sizeX;
        SIZE_Y = sizeY;
        pixels = new int[SIZE_X * SIZE_Y * 2];
        x = xx;
        y = yy;
        sheet = SpriteSheet.tiles;

        // luu tru diem anh
        for (int j = 0; j < SIZE_Y; j++) {
            for (int i = 0; i < SIZE_X; i++) {
                pixels[i + j * SIZE_Y] = sheet.pixels[(i + x) + (j + y) * sheet.SIZE];
            }
        }
    }

    public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
        int calc = animate % time;
        int diff = time / 2;

        if(calc < diff) {
            return x1;
        } else {
            return x2;
        }
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, int animate, int time) {
        int calc = animate % time;
        int diff = time / 3;

        if(calc < diff) {
            return normal;
        } else if(calc < diff * 2) {
            return x1;
        } else {
            return x2;
        }
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3, Sprite x4, int animate, int time) {
        int calc = animate % time;
        int diff = time / 5;

        if (calc < diff) {
            return normal;
        } else if (calc < diff * 2) {
            return x1;
        } else if (calc < diff * 3) {
            return x2;
        } else if (calc < diff * 4) {
            return x3;
        } else {
            return x4;
        }
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3, Sprite x4, Sprite x5, Sprite x6, int animate, int time) {
        int calc = animate % time;
        int diff = time / 7;

        if (calc < diff) {
            return normal;
        } else if (calc < diff * 2) {
            return x1;
        } else if (calc < diff * 3) {
            return x2;
        } else if (calc < diff * 4) {
            return x3;
        } else if (calc < diff * 5) {
            return x4;
        } else if (calc < diff * 6) {
            return x5;
        } else {
            return x6;
        }
    }


    public int getSIZE_X() {
        return SIZE_X;
    }

    public int getSIZE_Y() {
        return SIZE_Y;
    }

    public int getPixels(int i) {
        return pixels[i];
    }
}
