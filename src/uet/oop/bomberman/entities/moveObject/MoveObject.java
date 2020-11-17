package uet.oop.bomberman.entities.moveObject;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.gui.Screen;

public abstract class MoveObject extends Entity {

    protected Board board;

    /* 0: up
    // 1: down
    // 2: left
    // 3: right
    */
    protected int direction = 1;

    protected boolean alive = true;
    protected boolean moving = false;
    protected int timeAfter = 84;
    protected boolean kt = false;

    public MoveObject(double x, double y, Board board) {
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
