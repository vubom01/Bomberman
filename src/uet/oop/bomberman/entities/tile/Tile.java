package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.gamestage.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public abstract class Tile extends Entity {

    public Tile(double x, double y, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public boolean checkcollision(Entity e) {
        return false;
    }

    public void render(Screen screen) {
        screen.renderEntity( (int) x * Game.TILES_SIZE, (int) y * Game.TILES_SIZE, this);
    }

    public void update() {}
}
