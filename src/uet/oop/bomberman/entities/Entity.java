package uet.oop.bomberman.entities;

import uet.oop.bomberman.Game;
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
    public static int pixelToTile(double i) {
        return (int)(i / Game.TILES_SIZE);
    }

    public static int tileToPixel(int i) {
        return i * Game.TILES_SIZE;
    }

    public static int tileToPixel(double i) {
        return (int)(i * Game.TILES_SIZE);
    }

    public double getXTile() {
        return pixelToTile(x + sprite.getSize() / 2); //plus half block for precision
    }

    public double getYTile() {
        return pixelToTile(y - sprite.getSize() / 2); //plus half block
    }
}
