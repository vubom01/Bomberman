package uet.oop.bomberman.gui;

import javafx.scene.image.*;

public class Sprite {

    private final int SIZE;
    private int x, y;
    private int[] pixels; // diem anh
    private SpriteSheet sheet = SpriteSheet.tiles;

    // LAY ANH CON TU 1 ANH LON

    /*
    |--------------------------------------------------------------------------
    | Board sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite grass = new Sprite(16, 689, 110);
    public static Sprite brick = new Sprite(16, 721,110);
	public static Sprite portal = new Sprite(16, 393, 789);

    /*
    |--------------------------------------------------------------------------
    | Wall sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite wall = new Sprite(16, 737, 110);

    /*
    |--------------------------------------------------------------------------
    | Player Sprites
    |--------------------------------------------------------------------------
     */
    public static Sprite player_up = new Sprite(21,217, 0);
    public static Sprite player_down = new Sprite(21, 1, 0);
    public static Sprite player_left = new Sprite(21, 145, 0);
    public static Sprite player_right = new Sprite(21, 72, 0);

    public static Sprite player_up_1 = new Sprite(21, 240, 0);
    public static Sprite player_up_2 = new Sprite(21, 266, 0);

    public static Sprite player_down_1 = new Sprite(21, 26, 0);
    public static Sprite player_down_2 = new Sprite(21, 48, 0);

    public static Sprite player_left_1 = new Sprite(21, 168, 0);
    public static Sprite player_left_2 = new Sprite(21, 192, 0);

    public static Sprite player_right_1 = new Sprite(21, 97, 0);
    public static Sprite player_right_2 = new Sprite(21, 121, 0);

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
    //Enemy 1

	public static Sprite enemy1_1 = new Sprite(16, 426, 215);
	public static Sprite enemy1_2 = new Sprite(16, 442, 215);
	public static Sprite enemy1_3 = new Sprite(16, 458, 215);

	public static Sprite enemy1_dead1 = new Sprite(16, 474, 215);
	public static Sprite enemy1_dead2 = new Sprite(16, 490, 215);
//
//	//ONEAL
//	public static Sprite oneal_left1 = new Sprite(11, 0);
//	public static Sprite oneal_left2 = new Sprite(11, 1);
//	public static Sprite oneal_left3 = new Sprite(11, 2);
//
//	public static Sprite oneal_right1 = new Sprite(12, 0);
//	public static Sprite oneal_right2 = new Sprite(12, 1);
//	public static Sprite oneal_right3 = new Sprite(12, 2);
//
//	public static Sprite oneal_dead = new Sprite(11, 3);
//
//	//Doll
//	public static Sprite doll_left1 = new Sprite(13, 0);
//	public static Sprite doll_left2 = new Sprite(13, 1);
//	public static Sprite doll_left3 = new Sprite(13, 2);
//
//	public static Sprite doll_right1 = new Sprite(14, 0);
//	public static Sprite doll_right2 = new Sprite(14, 1);
//	public static Sprite doll_right3 = new Sprite(14, 2);
//
//	public static Sprite doll_dead = new Sprite(13, 3);
//
//	//Minvo
//	public static Sprite minvo_left1 = new Sprite(8, 5);
//	public static Sprite minvo_left2 = new Sprite(8, 6);
//	public static Sprite minvo_left3 = new Sprite(8, 7);
//
//	public static Sprite minvo_right1 = new Sprite(9, 5);
//	public static Sprite minvo_right2 = new Sprite(9, 6);
//	public static Sprite minvo_right3 = new Sprite(9, 7);
//
//	public static Sprite minvo_dead = new Sprite(8, 8);
//
//	//Kondoria
//	public static Sprite kondoria_left1 = new Sprite(10, 5);
//	public static Sprite kondoria_left2 = new Sprite(10, 6);
//	public static Sprite kondoria_left3 = new Sprite(10, 7);
//
//	public static Sprite kondoria_right1 = new Sprite(11, 5);
//	public static Sprite kondoria_right2 = new Sprite(11, 6);
//	public static Sprite kondoria_right3 = new Sprite(11, 7);
//
//	public static Sprite kondoria_dead = new Sprite(10, 8);
//
//	//ALL
//	public static Sprite mob_dead1 = new Sprite(15, 0);
//	public static Sprite mob_dead2 = new Sprite(15, 1);
//	public static Sprite mob_dead3 = new Sprite(15, 2);

    /*
    |--------------------------------------------------------------------------
    | Brick FlameSegment
    |--------------------------------------------------------------------------
     */
    public static Sprite brick_exploded = new Sprite(16, 495 + 16 * 6, 159);
    public static Sprite brick_exploded1 = new Sprite(16, 495 + 16 * 5, 159);

    public static Sprite brick_exploded2 = new Sprite(16, 495 + 16 * 4, 159);
    public static Sprite brick_exploded3 = new Sprite(16, 495 + 16 * 3, 159);
    public static Sprite brick_exploded4 = new Sprite(16, 495 + 16 * 2, 159);
    public static Sprite brick_exploded5 = new Sprite(16, 495 + 16 * 1, 159);
    public static Sprite brick_exploded6 = new Sprite(16, 495, 159);

	/*
	|--------------------------------------------------------------------------
	| Powerups
	|--------------------------------------------------------------------------
	 */
	public static Sprite itemBomb = new Sprite(16, 16, 48);
	public static Sprite itemFire = new Sprite(16, 0, 48);
	public static Sprite itemSpeed = new Sprite(16, 48, 48);
//	public static Sprite powerup_wallpass = new Sprite(3, 10);
//	public static Sprite powerup_detonator = new Sprite(4, 10);
//	public static Sprite powerup_bombpass = new Sprite(5, 10);
//	public static Sprite powerup_flamepass = new Sprite(6, 10);

    public Sprite(int size, int xx, int yy) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        x = xx;
        y = yy;
        sheet = SpriteSheet.tiles;

        // luu tru diem anh
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                pixels[i + j * SIZE] = sheet.pixels[(i + x) + (j + y) * sheet.SIZE];
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

        if (calc == 0 && animate > time) {
            return x4;
        }
        else {
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
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, Sprite x3, Sprite x4, Sprite x5, Sprite x6, int animate, int time) {
        int calc = animate % time;
        int diff = time / 7;

        if (calc == 0 && animate > time) {
            return x6;
        }
        else {
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
    }


    public int getSize() {
        return SIZE;
    }

    public int getPixels(int i) {
        return pixels[i];
    }
}
