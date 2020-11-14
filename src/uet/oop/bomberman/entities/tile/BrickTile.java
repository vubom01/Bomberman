package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.entities.AnimationEntity;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Directional;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class BrickTile extends AnimationEntity {
    private boolean destroyed = false;
    private int timeAfter = 21;

    public BrickTile(double x, double y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
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
        if (destroyed) sprite = Sprite.movingSprite(Sprite.brick_exploded6, Sprite.brick_exploded5, Sprite.brick_exploded4, Sprite.brick_exploded3, Sprite.brick_exploded2, Sprite.brick_exploded1, Sprite.brick_exploded, animation, 21);
        screen.renderEntity((int) x * 16, (int) y * 16, this, Sprite.grass);
    }

    @Override
    public boolean checkcollision(Entity e) {
        if (e instanceof Directional) {
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
}
