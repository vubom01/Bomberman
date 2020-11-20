package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

import java.util.Random;

public class Enemy2 extends Enemy {

    public Enemy2(double x, double y, Board board) {
        super(x, y, board, 1.0, 300);
        setSprite();
        wallpass = true;
    }

    public void render(Screen screen) {
        if(alive) setSprite();
        else sprite = Sprite.enemy2_dead;
        screen.renderEntity((int) x, (int) y - sprite.getSize(), this);
    }

    @Override
    public void setSprite() {
        int time = 21;
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
        if (!collision.collision(xa, ya)) {
            direction = new Random().nextInt(4);
        }
        return collision.collision(xa, ya);
    }

    public void calculateMove() {
        int xa = 0, ya = 0;

        if(direction == 0) ya--;
        if(direction == 1) ya++;
        if(direction == 2) xa--;
        if(direction == 3) xa++;

        if(canMove(xa, ya)) {
            move(xa * speed, ya * speed);
            moving = true;
        } else {
            moving = false;
        }
    }
}
