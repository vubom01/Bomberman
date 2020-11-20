package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

import java.util.Random;

public class Enemy1 extends Enemy {

    public Enemy1(double x, double y, Board board) {
        super(x, y, board, 0.5, 100);
        sprite = Sprite.enemy1_2;
    }

    public void render(Screen screen) {
        if(alive) setSprite();
        else sprite = Sprite.enemy1_dead;
        screen.renderEntity((int) x, (int) y - sprite.getSize(), this);
    }

    @Override
    public void setSprite() {
        sprite = Sprite.movingSprite(Sprite.enemy1_3, Sprite.enemy1_2, Sprite.enemy1_1, animation, 60);
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
