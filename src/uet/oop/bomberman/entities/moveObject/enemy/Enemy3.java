package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

import java.util.Random;

public class Enemy3 extends Enemy {

    private int step = 20;

    public Enemy3(double x, double y, Board board) {
        super(x, y, board, 0.8, 200);
        sprite = Sprite.enemy3_1;
    }

    public void render(Screen screen) {
        if (alive) setSprite();
        else {
            if (timeAfter > 0) {
                sprite = Sprite.enemy3_dead;
                animation = 0;
            }
            else sprite = Sprite.movingSprite(Sprite.dead1, Sprite.dead2, Sprite.dead3, animation, 60);
        }
        screen.renderEntity((int) x, (int) y - sprite.getSIZE_Y(), this);
    }

    @Override
    public void setSprite() {
        sprite = Sprite.movingSprite(Sprite.enemy3_1, Sprite.enemy3_2, Sprite.enemy3_3, animation, 60);
    }

    public boolean canMove(double xa, double ya) {
        return collision.collision(xa, ya);
    }

    public void calculateMove() {
        int xa = 0, ya = 0;
        boolean[] kt = new boolean[4];
        if (step <= 0) {
            while (true) {
                direction = new Random().nextInt(4);
                double xx = xa, yy = ya;
                if (direction == 0) yy--;
                if (direction == 1) yy++;
                if (direction == 2) xx--;
                if (direction == 3) xx++;

                if (canMove(xx * speed, yy * speed)) {
                    step = 20;
                    break;
                }
                kt[direction] = true;
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    if (kt[i] == true) cnt++;
                }
                if (cnt == 4) break;
            }
        }

        if(direction == 0) ya--;
        if(direction == 1) ya++;
        if(direction == 2) xa--;
        if(direction == 3) xa++;


        if(canMove(xa, ya)) {
            step--;
            move(xa * speed, ya * speed);
            moving = true;
        } else {
            step = 0;
            moving = false;
        }
    }
}
