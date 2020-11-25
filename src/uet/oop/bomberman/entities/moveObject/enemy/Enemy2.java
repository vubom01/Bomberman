package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

import java.util.Random;

public class Enemy2 extends Enemy {

    private int step = 16 * 8;

    public Enemy2(double x, double y, Board board) {
        super(x, y, board, 1.0, 300);
        setSprite();
        wallpass = true;
    }

    public void render(Screen screen) {
        if (alive) setSprite();
        else {
            if (timeAfter > 0) {
                sprite = Sprite.enemy2_dead;
                animation = 0;
            }
            else sprite = Sprite.movingSprite(Sprite.dead1, Sprite.dead2, Sprite.dead3, animation, 60);
        }
        screen.renderEntity((int) x, (int) y - sprite.getSIZE_Y(), this);
    }

    @Override
    public void setSprite() {
        int time = 60;
        switch (direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.enemy2_up1, Sprite.enemy2_up2, Sprite.enemy2_up3, animation, time);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.enemy2_down1, Sprite.enemy2_down2, Sprite.enemy2_down3, animation, time);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.enemy2_left1, Sprite.enemy2_left2, Sprite.enemy2_left3, animation, time);
                break;
            case 3:
                sprite = Sprite.movingSprite(Sprite.enemy2_right1, Sprite.enemy2_right2, Sprite.enemy2_right3, animation, time);
                break;
        }
    }

    public boolean canMove(double xa, double ya) {
        return collision.collision(xa, ya);
    }

    public void calculateMove() {
        int xa = 0, ya = 0;

        if (step <= 0) {
            while (true) {
                direction = new Random().nextInt(4);
                double xx = xa, yy = ya;
                if (direction == 0) yy--;
                if (direction == 1) yy++;
                if (direction == 2) xx--;
                if (direction == 3) xx++;

                if (canMove(xx * speed, yy * speed)) {
                    step = 16 * 8;
                    break;
                }
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
