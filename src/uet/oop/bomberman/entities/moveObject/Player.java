package uet.oop.bomberman.entities.moveObject;

import uet.oop.bomberman.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.ListExplosion;
import uet.oop.bomberman.entities.tile.item.Item;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player extends MoveObject {

    private Keyboard input;

    private List<Bomb> bombs;
    private Collision collision;
    private int timetoPutBomb;

    public static List<Item> items = new ArrayList<>();

    public Player(double x, double y, Board board) {
        super(x, y, board);
        input = board.getInput();
        bombs = board.getBombs();

        collision = new Collision(board, this);
    }


    @Override
    public void update() {
        clearBombs();
        if (!alive) {
            dead();
            return;
        }

        if(timetoPutBomb < 0) {
            timetoPutBomb = 0;
        }
        else {
            timetoPutBomb--;
        }
        setAnimation();
        calculateMove();
        detectPlaceBomb();
        collision.checkBombExplode();
        collision.itemCollision();
        collision.enemyCollision(this.x, this.y);
    }

    @Override
    public void render(Screen screen) {
        if (board.getLevel().getWidth() == 31) {
            calculateXOffset();
        } else if (board.getLevel().getHeight() == 29) {
            calculateYOffset();
        }

        if (!alive) {
            if (!kt) {
                animation = 0;
                kt = true;
            }
            if (sprite != Sprite.player_dead) {
                sprite = Sprite.movingSprite(Sprite.player_dead6, Sprite.player_dead5, Sprite.player_dead4, Sprite.player_dead3, Sprite.player_dead2, Sprite.player_dead1, Sprite.player_dead, animation, 84);
            }
        }
        else {
            if (moving == true) {
                setSprite();
            } else {
                if (direction == 0) sprite = Sprite.player_up;
                if (direction == 1) sprite = Sprite.player_down;
                if (direction == 2) sprite = Sprite.player_left;
                if (direction == 3) sprite = Sprite.player_right;
            }
        }
        screen.renderEntity((int) x, (int) y - sprite.getSize(), this);

    }

    @Override
    public boolean checkcollision(Entity e) {
        if (e instanceof ListExplosion) {
            kill();
            return true;
        }
        return false;
    }

    @Override
    public void calculateMove() {
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
    public boolean canMove(double xa, double ya) {
        return collision.collision(xa, ya);
    }

    @Override
    public void move(double xa, double ya) {
        if (canMove(xa, 0)) {
            x += xa;
        }
        if (canMove(0, ya)) {
            y += ya;
        }
    }

    @Override
    public void kill() {
        alive = false;
        board.addLives(-1);
    }

    @Override
    public void dead() {
        if (timeAfter > 0) {
            setAnimation();
            timeAfter--;
        }
        else if (bombs.size() == 0) {
            if (board.getLives() <= 0) {
                board.endGame();
            }
            else {
                board.restartLevel();
            }
        }
    }

    public void setSprite() {
        int time = 36;
        switch (direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, animation, time);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, animation, time);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, animation, time);;
                break;
            default:
                sprite = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, animation, time);
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

    public boolean check(int x0, int y0) {
        Bomb res = board.getBomb(x0, y0);
        if (res == null) return true;
        return false;
    }

    public void detectPlaceBomb() {
        if (input.space && Game.getBombRate() > 0 && timetoPutBomb < 0) {
            int x0 = (int) ((x + Game.TILES_SIZE / 2) / Game.TILES_SIZE);
            int y0 = (int) ((y + Game.TILES_SIZE / 2 - Game.TILES_SIZE) / Game.TILES_SIZE);

            if (check(x0, y0)) {
                Bomb b = new Bomb(x0, y0, board);
                board.addBomb(b);
                Game.setBombRate(-1);
                timetoPutBomb = 20;
            }
        }
    }

    public void clearBombs() {
        Iterator<Bomb> bs = bombs.iterator();

        Bomb b;
        while(bs.hasNext()) {
            b = bs.next();
            if(b.isRemoved())  {
                bs.remove();
                Game.setBombRate(1);
            }
        }
    }

    public void addItem(Item item) {
        if(item.isRemoved()) return;
        items.add(item);
        item.setValues();
    }
}
