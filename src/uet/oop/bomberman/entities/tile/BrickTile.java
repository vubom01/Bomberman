package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.ListExplosion;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public class BrickTile extends Tile {
    private boolean destroyed = false;
    private int timeAfter = 21;
    private Sprite belowSprite = Sprite.grass;

    public BrickTile(double x, double y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void update() {
        if (destroyed) {
            setAnimation();
            if (timeAfter > 0) timeAfter--;
            else remove();
        }
    }

    @Override
    public void render(Screen screen) {
        if (destroyed) {
            if (sprite != Sprite.brick_exploded)
                sprite = Sprite.movingSprite(Sprite.brick_exploded6, Sprite.brick_exploded5, Sprite.brick_exploded4, Sprite.brick_exploded3, Sprite.brick_exploded2, Sprite.brick_exploded1, Sprite.brick_exploded, animation, 21);
        }

        screen.renderEntity((int) x * Game.TILES_SIZE, (int) y * Game.TILES_SIZE, this, belowSprite);
    }

    @Override
    public boolean checkcollision(Entity e) {
        if (e instanceof ListExplosion) {
            destroy();
        }
        return false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public void addBelowSprite(Sprite sprite) {
        belowSprite = sprite;
    }
}
