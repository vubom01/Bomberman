package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.AnimationEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends AnimationEntity {

    private Board board;

    private int timeToExplode = 120; //2s
    private int timeAfter = 20; //thoi gian bomb bien mat
    private boolean exploded = false;
    private Directional[] explosions;
    private boolean pass = true; //tia lua co xuyen duoc qua Tile hay khong


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
            if (!exploded) explosion();
            else updateExplosions();

            if (timeAfter > 0) timeAfter--;
            else remove();
        }
        if (Game.getBombRate() == 0) {
            Game.setBomRate(1);
        }
        setAnimation();
    }

    @Override
    public void render(Screen screen) {
        if (exploded) {
            sprite = Sprite.movingSprite(Sprite.bomb_exploded4, Sprite.bomb_exploded3, Sprite.bomb_exploded2, Sprite.bomb_exploded1, Sprite.bomb_exploded, animation, 20);
            renderExplosions(screen);
        }
        else {
            sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animation, 60);
        }

        int x0 = (int) x << 4;
        int y0 = (int) y << 4;
        screen.renderEntity(x0, y0, this);
    }

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }

    public void renderExplosions(Screen screen) {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].render(screen);
        }
    }

    public void updateExplosions() {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].update();
        }
    }

    protected void explosion() {
        pass = true;
        exploded = true;
        explosions = new Directional[4];

        for (int i = 0; i < explosions.length; i++) {
            explosions[i] = new Directional((int) x, (int) y, i, Game.getBombRadius(), board);
        }
    }

}
