package uet.oop.bomberman.entities.tile.block;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.moveObject.player.Player;
import uet.oop.bomberman.entities.tile.Tile;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Sprite;

public class PortalTile extends Tile {

    private Board board;

    public PortalTile(double x, double y, Sprite sprite, Board board) {
        super(x, y, sprite);
        this.board = board;
    }

    public boolean checkcollision(Entity e) {
        if(!board.detectNoEnemies())
            return false;
        else {
            if (e instanceof Player) {
                board.addPoints(1000);
                board.nextLevel();
            }
            return true;
        }
    }

    public void render(Screen screen) {
        if (board.detectNoEnemies())
            sprite = Sprite.movingSprite(Sprite.portal, Sprite.portal2, animation, 10);
        else sprite = Sprite.portal;
        screen.renderEntity( (int) x * Game.TILES_SIZE, (int) y * Game.TILES_SIZE, this);
    }

    public void update() {
        setAnimation();
    }
}
