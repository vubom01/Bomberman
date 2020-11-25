package uet.oop.bomberman.entities;

import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public abstract class Entity {
    protected double x, y;
    protected boolean removed = false;
    protected Sprite sprite;
    protected int animation = 0;

    public abstract void update();

    public abstract void render(Screen screen);

    public abstract boolean checkcollision(Entity e);


    public void remove() {
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setAnimation() {
        if (animation < 7500) animation++;
        else animation = 0;
    }
}
