package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.ListEntity;
import uet.oop.bomberman.entities.bomb.ListExplosion;
import uet.oop.bomberman.entities.moveObject.Player;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public class iSpeed extends Item {
    public iSpeed(double x, double y, Sprite sprite) {
        super(x, y, sprite);
    }

    @Override
    public void setValues() {
        Game.setPlayerSpeed(0.2);;
    }

    @Override
    public boolean checkcollision(Entity e) {
        if(e instanceof Player) {
            ((Player) e).addItem(this);
            remove();
        }
        if (e instanceof ListExplosion) {
            remove();
        }
        return true;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Screen screen) {
        screen.renderEntity((int) x * Game.TILES_SIZE, (int) y * Game.TILES_SIZE, this);
    }
}