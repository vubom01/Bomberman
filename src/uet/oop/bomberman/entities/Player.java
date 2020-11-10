package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.Keyboard;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class Player extends Entity {

    protected Keyboard input;

    public static int direction = -1;
    public static boolean moving = false;

    public void caculateMove() {
        int xa = 0, ya = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        System.out.println(xa);
        if (xa != 0 || ya != 0) {
            move(xa * Game.getPlayerSpeed(), ya * Game.getPlayerSpeed());
            moving = true;
        }
        else {
            moving = false;
        }
    }

    public void move(double xa, double ya) {
        x += xa;
        y += ya;
    }

    public Player(int x, int y, Sprite sprite) {
        super(x, y, sprite);
        input = Game.getInput();
    }

    @Override
    public void render(Screen screen) {
        sprite = Sprite.player_left;
        screen.renderEntity((int) x, (int) y, this);
    }

    @Override
    public void update() {
        caculateMove();
    }
}
