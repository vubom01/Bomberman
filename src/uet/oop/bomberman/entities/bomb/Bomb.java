package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.gamestage.Board;
import uet.oop.bomberman.gamestage.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;
import uet.oop.bomberman.sound.Sound;

public class Bomb extends Entity {

    private Board board;

    private int timeToExplode = 180; //3s
    private int timeAfter = 20; //thoi gian bomb bien mat
    private boolean exploded = false;
    private ListExplosion[] explosions;


    public Bomb(double x, double y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
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
        setAnimation();
    }

    @Override
    public void render(Screen screen) {
        if (exploded) {
            if (sprite != Sprite.bomb_exploded)
                sprite = Sprite.movingSprite(Sprite.bomb_exploded4, Sprite.bomb_exploded3, Sprite.bomb_exploded2, Sprite.bomb_exploded1, Sprite.bomb_exploded, animation, 20);
            renderExplosions(screen);
        }
        else {
            sprite = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, animation, 60);
        }
        screen.renderEntity((int) x * Game.TILES_SIZE, (int) y * Game.TILES_SIZE, this);
    }

    @Override
    public boolean checkcollision(Entity e) {
        if(e instanceof ListExplosion) {
            timeToExplode = 5;
            return false;
        }
        return true;
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
        exploded = true;
        explosions = new ListExplosion[4];

        for (int i = 0; i < explosions.length; i++) {
            explosions[i] = new ListExplosion((int) x, (int) y, i, Game.getBombRadius(), board);
        }
        Sound.playBombExplose();

    }

    public Explosion explosionAt(double x, double y) {
        if(!exploded) return null;

        for (int i = 0; i < explosions.length; i++) {
            if(explosions[i] == null) return null;
            Explosion e = explosions[i].explosionAt(x, y);
            if(e != null) return e;
        }

        return null;
    }

    public ListExplosion[] getExplosion() {
        if (exploded) return explosions;
        return null;
    }
}
