package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.moveObject.player.Player;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

import java.util.Random;

public class Enemy4 extends Enemy {

    private Player p;
    private int step = 8;

    public Enemy4(double x, double y, Board board) {
        super(x, y, board, 2.0, 500);
        sprite = Sprite.enemy4_2;
        p = board.getPlayer();
    }

    public void render(Screen screen) {
        if (alive) setSprite();
        else {
            if (timeAfter > 0) {
                sprite = Sprite.enemy4_dead;
                animation = 0;
            }
            else sprite = Sprite.movingSprite(Sprite.dead1, Sprite.dead2, Sprite.dead3, animation, 60);
        }
        screen.renderEntity((int) x, (int) y - sprite.getSIZE_Y(), this);
    }

    @Override
    public void setSprite() {
        sprite = Sprite.movingSprite(Sprite.enemy4_3, Sprite.enemy4_2, Sprite.enemy4_1, animation, 60);
    }

    public boolean canMove(double xa, double ya) {
        return collision.collision(xa, ya);
    }

    public void calculateMove() {
        int xa = 0, ya = 0;

        if (step <= 0) {
            direction = setDirection();
            step = 8;

            double xx = xa, yy = ya;
            if (direction == 0) yy--;
            if (direction == 1) yy++;
            if (direction == 2) xx--;
            if (direction == 3) xx++;
            if (!canMove(xx * speed, yy * speed)) {
                boolean[] kt = new boolean[4];
                while (true) {
                    direction = new Random().nextInt(4);
                    xx = xa;
                    yy = ya;
                    if (direction == 0) yy--;
                    if (direction == 1) yy++;
                    if (direction == 2) xx--;
                    if (direction == 3) xx++;

                    if (canMove(xx * speed, yy * speed)) {
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

    public int setDirection() {
        if(p == null)
            return new Random().nextInt(4);

        int vertical = new Random().nextInt(2);

        if(vertical == 1) {
            int v = calculateRowDirection();
            if(v != -1) return v;
            else return calculateColDirection();

        } else {
            int h = calculateColDirection();
            if(h != -1) return h;
            else return calculateRowDirection();
        }
    }

    protected int calculateColDirection() {
        if(p.getXTile() < this.getXTile())
            return 2;
        else if(p.getXTile() > this.getXTile())
            return 3;

        return -1;
    }

    protected int calculateRowDirection() {
        if(p.getYTile() < this.getYTile())
            return 0;
        else if(p.getYTile() > this.getYTile())
            return 1;
        return -1;
    }
}
