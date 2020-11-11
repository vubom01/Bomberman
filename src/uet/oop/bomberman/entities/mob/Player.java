package uet.oop.bomberman.entities.mob;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.CreateMap;
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

    /* 0: up
    // 1: down
    // 2: left
    // 3: right
     */
    public int direction = 1; //ban dau xuat hien voi tu the down

    public Player(int x, int y, Board board) {
        super(x, y, board);
        input = board.getInput();
    }


    @Override
    public void update() {
        animate();
        calculateMove();
    }

    @Override
    public void render(Screen screen) {
        if (board.getLevel().getWidth() == 31) {
            calculateXOffset();
        } else if (board.getLevel().getHeight() == 29) {
            calculateYOffset();
        }

        if (moving == true) {
            setSprite();
        } else {
            if (direction == 0) sprite = Sprite.player_up;
            if (direction == 1) sprite = Sprite.player_down;
            if (direction == 2) sprite = Sprite.player_left;
            if (direction == 3) sprite = Sprite.player_right;
        }
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }

    @Override
    protected void calculateMove() {
        int xa = 0, ya = 0;
        if(input.up) {
            direction = 0;
            ya--;
        }
        if(input.down) {
            direction = 1;
            ya++;
        }
        if(input.left) {
            direction = 2;
            xa--;
        }
        if(input.right) {
            direction = 3;
            xa++;
        }

        if(xa != 0 || ya != 0) {
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

    public void setSprite() {
        // time = 60: 60fps
        switch (direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, _animate, 60);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, _animate, 60);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, _animate, 60);;
                break;
            default:
                sprite = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, _animate, 60);
                break;
        }
    }

    public void calculateXOffset() {
        double x0 = Screen.calculateXOffset(board, this);
        Screen.setxOffset(x0);
    }

    public void calculateYOffset() {
        double y0 = Screen.calculateYOffset(board, this);
        Screen.setyOffset(y0);
    }
}
