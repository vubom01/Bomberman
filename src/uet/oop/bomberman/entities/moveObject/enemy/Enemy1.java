package uet.oop.bomberman.entities.moveObject.enemy;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public class Enemy1 extends Enemy {

    public Enemy1(double x, double y, Board board) {
        super(x, y, board, 0.5, 100);
        sprite = Sprite.enemy1_2;
    }

    public void render(Screen screen) {
        if(alive) setSprite();
        else if (sprite != Sprite.enemy1_dead1)
            sprite = Sprite.movingSprite(Sprite.enemy1_dead2, Sprite.enemy1_dead1, animation, 10);
        screen.renderEntity((int) x, (int) y - sprite.getSize(), this);
    }
    @Override
    public Sprite setSprite() {
        return Sprite.movingSprite(Sprite.enemy1_3, Sprite.enemy1_2, Sprite.enemy1_1, animation, 60);
    }
}
