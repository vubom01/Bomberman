package uet.oop.bomberman.graphics;

import javafx.scene.image.*;

public class Sprite {
	
	public static final int DEFAULT_SIZE = 16; // kich thuoc anh
	public static final int SCALED_SIZE = DEFAULT_SIZE * 2; // kich thuoc khi in len man hinh
    private static final int TRANSPARENT_COLOR = 0xffff00ff; // xu li diem anh (xoa background)
	public final int SIZE;
	private int x, y;
	public int[] pixels; // diem anh
	private SpriteSheet sheet = SpriteSheet.tiles;

	// LAY ANH CON TU 1 ANH LON

	/*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
	public static Sprite grass = new Sprite(16, 689, 110);
	public static Sprite brick = new Sprite(16, 721,110);
//	public static Sprite portal = new Sprite(4, 0);

	/*
	|--------------------------------------------------------------------------
	| Board sprites
	|--------------------------------------------------------------------------
	 */
	public static Sprite wall = new Sprite(16, 737, 110);

	/*
	|--------------------------------------------------------------------------
	| Bomber Sprites
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
	
//	public static Sprite player_dead1 = new Sprite(4, 2);
//	public static Sprite player_dead2 = new Sprite(5, 2);
//	public static Sprite player_dead3 = new Sprite(6, 2);
	
	/*
	|--------------------------------------------------------------------------
	| Character
	|--------------------------------------------------------------------------
	 */
	//BALLOM
//	public static Sprite balloom_left1 = new Sprite(9, 0);
//	public static Sprite balloom_left2 = new Sprite(9, 1);
//	public static Sprite balloom_left3 = new Sprite(9, 2);
//
//	public static Sprite balloom_right1 = new Sprite(10, 0);
//	public static Sprite balloom_right2 = new Sprite(10, 1);
//	public static Sprite balloom_right3 = new Sprite(10, 2);
//
//	public static Sprite balloom_dead = new Sprite(9, 3);
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
	| Bomb Sprites
	|--------------------------------------------------------------------------
	 */
//	public static Sprite bomb = new Sprite(0, 3);
//	public static Sprite bomb_1 = new Sprite(1, 3);
//	public static Sprite bomb_2 = new Sprite(2, 3);
	
	/*
	|--------------------------------------------------------------------------
	| FlameSegment Sprites
	|--------------------------------------------------------------------------
	 */
//	public static Sprite bomb_exploded = new Sprite(0, 4);
//	public static Sprite bomb_exploded1 = new Sprite(0, 5);
//	public static Sprite bomb_exploded2 = new Sprite(0, 6);
//
//	public static Sprite explosion_vertical = new Sprite(1, 5);
//	public static Sprite explosion_vertical1 = new Sprite(2, 5);
//	public static Sprite explosion_vertical2 = new Sprite(3, 5);
//
//	public static Sprite explosion_horizontal = new Sprite(1, 7);
//	public static Sprite explosion_horizontal1 = new Sprite(1, 8);
//	public static Sprite explosion_horizontal2 = new Sprite(1, 9);
//
//	public static Sprite explosion_horizontal_left_last = new Sprite(0, 7);
//	public static Sprite explosion_horizontal_left_last1 = new Sprite(0, 8);
//	public static Sprite explosion_horizontal_left_last2 = new Sprite(0, 9);
//
//	public static Sprite explosion_horizontal_right_last = new Sprite(2, 7);
//	public static Sprite explosion_horizontal_right_last1 = new Sprite(2, 8);
//	public static Sprite explosion_horizontal_right_last2 = new Sprite(2, 9);
//
//	public static Sprite explosion_vertical_top_last = new Sprite(1, 4);
//	public static Sprite explosion_vertical_top_last1 = new Sprite(2, 4);
//	public static Sprite explosion_vertical_top_last2 = new Sprite(3, 4);
//
//	public static Sprite explosion_vertical_down_last = new Sprite(1, 6);
//	public static Sprite explosion_vertical_down_last1 = new Sprite(2, 6);
//	public static Sprite explosion_vertical_down_last2 = new Sprite(3, 6);
	
	/*
	|--------------------------------------------------------------------------
	| Brick FlameSegment
	|--------------------------------------------------------------------------
	 */
//	public static Sprite brick_exploded = new Sprite(7, 1);
//	public static Sprite brick_exploded1 = new Sprite(7, 2);
//	public static Sprite brick_exploded2 = new Sprite(7, 3);
	
	/*
	|--------------------------------------------------------------------------
	| Powerups
	|--------------------------------------------------------------------------
	 */
//	public static Sprite powerup_bombs = new Sprite(0, 10);
//	public static Sprite powerup_flames = new Sprite(1, 10);
//	public static Sprite powerup_speed = new Sprite(2, 10);
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

	public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, int animate, int time) {
		int calc = animate % time;
		int diff = time / 3; // 20, 40, 60

		if(calc < diff) {
			return normal;
		}

		if(calc < diff * 2) {
			return x1;
		}

		return x2;
	}

	public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
		int diff = time / 2;
		return (animate % time > diff) ? x1 : x2;
	}

	public int getSize() {
		return SIZE;
	}

	public int getPixels(int i) {
		return pixels[i];
	}
}
