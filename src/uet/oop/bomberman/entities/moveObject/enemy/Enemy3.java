package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

import java.util.Random;

public class Enemy3 extends Enemy {

    public Enemy3(double x, double y, Board board) {
        super(x, y, board, 1.0, 200);
        sprite = Sprite.enemy3_1;
    }

    public void render(Screen screen) {
        if (alive) setSprite();
        else if (sprite != Sprite.dead4)
            sprite = Sprite.movingSprite(Sprite.enemy3_dead1, Sprite.enemy3_dead2, Sprite.enemy3_dead2, Sprite.dead1, Sprite.dead2, Sprite.dead3, Sprite.dead4, animation, 70);
        screen.renderEntity((int) x, (int) y - sprite.getSIZE_Y(), this);
    }

    @Override
    public void setSprite() {
        sprite = Sprite.movingSprite(Sprite.enemy3_1, Sprite.enemy3_2, Sprite.enemy3_3, animation, 21);
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
