package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Collision;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public abstract class Enemy extends MoveObject {
    protected int point;
    protected double speed;
    protected 
    protected Collision collision;
    protected boolean special = false;

    public Enemy(double x, double y, Board board, double speed, int point) {
        super(x, y, board);
        this.speed = speed;
        this.point = point;
        timeAfter = 10;
        collision = new Collision(board, this);
    }

    @Override
    public void update() {
        setAnimation();
        if (!alive) {
            dead();
            return;
        }
        if (alive) calculateMove();
        collision.checkBombExplode();

    }

    public abstract void render(Screen screen);

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }

    @Override
    public void move(double xa, double ya) {
        if (!alive) return;
        x += xa;
        y += ya;
    }

    @Override
    public void kill() {
        alive = false;
    }

    @Override
    public void dead() {
        if (timeAfter > 0) {
            setAnimation();
            timeAfter--;
        }
        else remove();
    }

    @Override
    public void calculateMove() {

    }

    @Override
    public boolean canMove(double xa, double ya) {
        return false;
    }

    public abstract Sprite setSprite();
}
