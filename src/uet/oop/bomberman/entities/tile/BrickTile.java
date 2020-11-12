package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class BrickTile extends Tile {
    public BrickTile(double x, double y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }
}