package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.gamestage.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.ListExplosion;
import uet.oop.bomberman.entities.moveObject.player.Player;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;
import uet.oop.bomberman.sound.Sound;

public class iLive extends Item {
    public iLive(double x, double y, int level, Sprite sprite) {
        super(x, y, level, sprite);
    }

    @Override
    public void setValues() {
        Game.getBoard().addLives(1);
    }

    @Override
    public boolean checkcollision(Entity e) {
        if(e instanceof Player) {
            Sound.playGetNewItem();
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
