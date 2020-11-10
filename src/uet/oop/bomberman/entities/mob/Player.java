package uet.oop.bomberman.entities.mob;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.Keyboard;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class Player extends Mob {

    protected Keyboard input;

    public Player(double x, double y, Board board) {
        super(x, y, board);

        input = board.getInput();
        sprite = Sprite.player_left;
    }

    @Override
    public void update() {
        calculateMove();
    }

    @Override
    public void render(Screen screen) {
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }

    @Override
    public void move(double xa, double ya) {
        y += ya;
        x += xa;
    }

    @Override
    public void kill() {

    }

    @Override
    public void dead() {

    }

    @Override
    public void canMove(double xa, double ya) {

    }

    public void calculateMove() {
        int xa = 0, ya = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) {
            move(xa * Game.getPlayerSpeed(), ya * Game.getPlayerSpeed());
            moving = true;
        } else {
            moving = false;
        }
    }
}
