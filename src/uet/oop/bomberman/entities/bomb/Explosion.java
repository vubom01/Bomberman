package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class Explosion extends Entity {

    private boolean last = false;
    private Board board;
    private int direction;

    public Explosion(double x, double y, int direction, boolean last, Board board) {
        this.x = x;
        this.y = y;
        this.last = last;
        this.board = board;
        this.direction = direction;
    }

    @Override
    public void update() {
        setAnimation();
    }

    @Override
    public void render(Screen screen) {
        setSprite(direction);
        screen.renderEntity((int) x * Game.TILES_SIZE, (int) y * Game.TILES_SIZE, this);
    }

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }

    public Sprite setSprite(int direction) {
        int time = 20;
        switch (direction) {
            case 0:
                if(last == false) {
                    sprite = Sprite.movingSprite(Sprite.explosion_vertical3, Sprite.explosion_vertical2, Sprite.explosion_vertical1, Sprite.explosion_vertical, Sprite.explosion_vertical, animation, time);
                } else {
                    sprite = Sprite.movingSprite(Sprite.explosion_vertical_top_last3, Sprite.explosion_vertical_top_last2, Sprite.explosion_vertical_top_last1, Sprite.explosion_vertical_top_last, Sprite.explosion_vertical_top_last, animation, time);

                }
                break;
            case 1:
                if(last == false) {
                    sprite = Sprite.movingSprite(Sprite.explosion_vertical3, Sprite.explosion_vertical2, Sprite.explosion_vertical1, Sprite.explosion_vertical, Sprite.explosion_vertical, animation, time);
                } else {
                    sprite = Sprite.movingSprite(Sprite.explosion_vertical_down_last3, Sprite.explosion_vertical_down_last2, Sprite.explosion_vertical_down_last1, Sprite.explosion_vertical_down_last, Sprite.explosion_vertical_down_last, animation, time);
                }
                break;
            case 2:
                if(last == false) {
                    sprite = Sprite.movingSprite(Sprite.explosion_horizontal3, Sprite.explosion_horizontal2, Sprite.explosion_horizontal1, Sprite.explosion_horizontal, Sprite.explosion_horizontal, animation, time);
                } else {
                    sprite = Sprite.movingSprite(Sprite.explosion_horizontal_left_last3, Sprite.explosion_horizontal_left_last2, Sprite.explosion_horizontal_left_last1, Sprite.explosion_horizontal_left_last, Sprite.explosion_horizontal_left_last, animation, time);
                }
                break;
            case 3:
                if(last == false) {
                    sprite = Sprite.movingSprite(Sprite.explosion_horizontal3, Sprite.explosion_horizontal2, Sprite.explosion_horizontal1, Sprite.explosion_horizontal, Sprite.explosion_horizontal, animation, time);
                } else {
                    sprite = Sprite.movingSprite(Sprite.explosion_horizontal_right_last3, Sprite.explosion_horizontal_right_last2, Sprite.explosion_horizontal_right_last1, Sprite.explosion_horizontal_right_last, Sprite.explosion_horizontal_right_last, animation, time);
                }
                break;
        }
        return null;
    }
}
