package uet.oop.bomberman.entities.mob;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.graphics.Screen;

public abstract class Mob extends AnimatedEntity {

    protected Board board;

    /* 0: up
    // 1: down
    // 2: left
    // 3: right
    */
    protected int direction = 1;

    protected boolean alive = true;
    protected boolean moving = false;

    public Mob(double x, double y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public abstract void update();

    public abstract void render(Screen screen);

    public abstract void move(double xa, double ya);

    public abstract void kill();

    public abstract void dead();

    public abstract void calculateMove();

    public abstract boolean canMove(double xa, double ya);

    public boolean isAlive() {
        return alive;
    }

    public boolean isMoving() {
        return moving;
    }

    public int getDirection() {
        return direction;
    }
}
