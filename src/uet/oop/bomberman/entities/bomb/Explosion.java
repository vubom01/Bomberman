package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class Explosion extends Entity {

    private boolean last = false;
    private Board board;

    public Explosion(double x, double y, int direction, boolean last, Board board) {
        this.x = x;
        this.y = y;
        this.last = last;
        this.board = board;

        switch (direction) {
            case 0:
                if(last == false) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_top_last2;
                }
                break;
            case 1:
                if(last == false) {
                    sprite = Sprite.explosion_vertical2;
                } else {
                    sprite = Sprite.explosion_vertical_down_last2;
                }
                break;
            case 2:
                if(last == false) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_left_last2;
                }
                break;
            case 3:
                if(last == false) {
                    sprite = Sprite.explosion_horizontal2;
                } else {
                    sprite = Sprite.explosion_horizontal_right_last2;
                }
                break;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Screen screen) {
        int x0 = (int) x << 4;
        int y0 = (int) y << 4;

        screen.renderEntity(x0, y0, this);

    }

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }
}
