package uet.oop.bomberman.entities.tile.block;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.tile.Tile;
import uet.oop.bomberman.gui.Sprite;

public class GrassTile extends Tile {

    public GrassTile(double x, double y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public boolean checkcollision(Entity e) {
        return true;
    }
}
