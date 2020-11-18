package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.gui.Sprite;

public abstract class Item extends Entity {

    private int level;
    private boolean active = false;

    public Item(double x, double y, int level, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.level = level;
    }

    public abstract void setValues();

    public int getLevel() {
        return level;
    }
}
