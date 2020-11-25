package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.collision.Collision;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.gui.Screen;

import java.util.Random;

public abstract class Enemy extends MoveObject {
    protected int point;
    protected double speed;
    protected Collision collision;
    protected int finalAnimation = 30;

    public Enemy(double x, double y, Board board, double speed, int point) {
        super(x, y, board);
        this.speed = speed;
        this.point = point;
        timeAfter = 20;
        collision = new Collision(board, this);
        direction = new Random().nextInt(4);
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
        if (alive == false) return;
        alive = false;
        board.addPoints(point);
    }

    @Override
    public void dead() {
        if (timeAfter > 0) {
            timeAfter--;
        }
        else {
            if (finalAnimation > 0) finalAnimation--;
            else remove();
        }
    }

    @Override
    public abstract void calculateMove();

    @Override
    public boolean canMove(double xa, double ya) {
        return false;
    }

    public abstract void setSprite();
}
