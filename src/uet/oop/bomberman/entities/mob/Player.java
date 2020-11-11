package uet.oop.bomberman.entities.mob;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.Keyboard;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player extends Mob {

    protected Keyboard input;

    protected int _timeBetweenPutBombs = 0;


    public Player(int x, int y, Board board) {
        super(x, y, board);
        input = board.getInput();
        sprite = Sprite.player_right;
    }


    @Override
    public void update() {
        if(_timeBetweenPutBombs < -7500) _timeBetweenPutBombs = 0; else _timeBetweenPutBombs--; //dont let this get tooo big

        animate();

        calculateMove();
    }

    @Override
    public void render(Screen screen) {
        screen.renderEntity((int)x, (int)y - sprite.SIZE, this);
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }

    @Override
    protected void calculateMove() {
        int xa = 0, ya = 0;
        if(input.up) ya--;
        if(input.down) ya++;
        if(input.left) xa--;
        if(input.right) xa++;

        if(xa != 0 || ya != 0)  {
            move(xa * Game.getPlayerSpeed(), ya * Game.getPlayerSpeed());
            moving = true;
        } else {
            moving = false;
        }
    }

    @Override
    public void canMove(double xa, double ya) {

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
}
