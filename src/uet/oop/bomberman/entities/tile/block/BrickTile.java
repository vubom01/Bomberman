package uet.oop.bomberman.entities.tile.block;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.ListExplosion;
import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.entities.tile.Tile;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public class BrickTile extends Tile {
    private boolean destroyed = false;
    private int timeAfter = 21;
    private int level;
    private Sprite belowSprite;

    public BrickTile(double x, double y, Sprite sprite, int level) {
        super(x, y, sprite);
        this.level = level;
        belowSprite = Sprite.grass[level];
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
            if (sprite != Sprite.brick_exploded[level])
                sprite = Sprite.movingSprite(Sprite.brick_exploded6[level], Sprite.brick_exploded5[level], Sprite.brick_exploded4[level], Sprite.brick_exploded3[level], Sprite.brick_exploded2[level], Sprite.brick_exploded1[level], Sprite.brick_exploded[level], animation, 21);
        }

        screen.renderEntity((int) x * Game.TILES_SIZE, (int) y * Game.TILES_SIZE, this, belowSprite);
    }

    @Override
    public boolean checkcollision(Entity e) {
        if (e instanceof MoveObject && ((MoveObject) e).isWallpass() == true) {
            return true;
        }
        if (e instanceof ListExplosion) {
            destroy();
        }
        return false;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public void addBelowSprite(Sprite sprite) {
        belowSprite = sprite;
    }
}
