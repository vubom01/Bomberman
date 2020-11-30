package uet.oop.bomberman.entities.moveObject.player;

import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.moveObject.player.input.Keyboard2;
import uet.oop.bomberman.gamestage.Board;
import uet.oop.bomberman.gamestage.Game;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;
import uet.oop.bomberman.sound.Sound;

public class Player2 extends Player {

    private Keyboard2 input2;

    public Player2(double x, double y, Board board) {
        super(x, y, board);
        input2 = board.getInput2();
    }

    public void calculateMove() {
        int xa = 0, ya = 0;
        if(input2.up) {
            direction = 0;
            ya--;
        }
        if(input2.down) {
            direction = 1;
            ya++;
        }
        if(input2.left) {
            direction = 2;
            xa--;
        }
        if(input2.right) {
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

    public void detectedPlaceBomb() {
        if (input2.space && Game.getBombRate() > 0 && timetoPutBomb < 0) {
            int x0 = (int) ((x + Game.TILES_SIZE / 2) / Game.TILES_SIZE);
            int y0 = (int) ((y + Game.TILES_SIZE / 2 - Game.TILES_SIZE) / Game.TILES_SIZE);

            if (check(x0, y0)) {
                Bomb b = new Bomb(x0, y0, board);
                Sound.playPlaceNewBomb();
                board.addBomb(b);
                Game.setBombRate(-1);
                timetoPutBomb = 20;
            }
        }
    }

    public void render(Screen screen) {
        if (!alive) {
            if (sprite != Sprite.player2_dead) {
                sprite = Sprite.movingSprite(Sprite.player2_dead6, Sprite.player2_dead5, Sprite.player2_dead4, Sprite.player2_dead3, Sprite.player2_dead2, Sprite.player2_dead1, Sprite.player2_dead, animation, 84);
            }
        }
        else {
            if (moving == true) {
                setSprite();
            } else {
                if (direction == 0) sprite = Sprite.player2_up;
                if (direction == 1) sprite = Sprite.player2_down;
                if (direction == 2) sprite = Sprite.player2_left;
                if (direction == 3) sprite = Sprite.player2_right;
            }
        }
        screen.renderEntity((int) x, (int) y - sprite.getSIZE_Y(), this);
    }

    public void setSprite() {
        int time = 36;
        switch (direction) {
            case 0:
                sprite = Sprite.movingSprite(Sprite.player2_up, Sprite.player2_up_1, Sprite.player2_up_2, animation, time);
                break;
            case 1:
                sprite = Sprite.movingSprite(Sprite.player2_down, Sprite.player2_down_1, Sprite.player2_down_2, animation, time);
                break;
            case 2:
                sprite = Sprite.movingSprite(Sprite.player2_left, Sprite.player2_left_1, Sprite.player2_left_2, animation, time);;
                break;
            default:
                sprite = Sprite.movingSprite(Sprite.player2_right, Sprite.player2_right_1, Sprite.player2_right_2, animation, time);
                break;
        }
    }
}
