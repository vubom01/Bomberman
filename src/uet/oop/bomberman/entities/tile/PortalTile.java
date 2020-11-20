package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.moveObject.Player;
import uet.oop.bomberman.gui.Sprite;

public class PortalTile extends Tile {

    private Board board;

    public PortalTile(double x, double y, Sprite sprite, Board board) {
        super(x, y, sprite);
        this.board = board;
    }

    public boolean checkCollision(Entity e) {
        if (e.getX() == getX() * Game.TILES_SIZE && e.getY() == getY() * Game.TILES_SIZE + Game.TILES_SIZE)
            board.nextLevel();
        if (!board.detectNoEnemies())
            return false;
        if (board.detectNoEnemies())
            return true;
        return false;
    }
}
