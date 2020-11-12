package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.AnimatedEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends AnimatedEntity {

    protected Board board;

    protected double timeToExplode = 120; //2s

    protected boolean exploded = false;


    public Bomb(double x, double y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
        sprite = Sprite.bomb;
    }
    @Override
    public void update() {
        if (timeToExplode > 0) {
            timeToExplode--;
        } else {
            remove();
        }
        animate();
    }

    @Override
    public void render(Screen screen) {

        sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, _animate, 60);
        int x0 = (int) x << 4;
        int y0 = (int) y << 4;
        screen.renderEntity(x0, y0, this);
    }

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }
}
