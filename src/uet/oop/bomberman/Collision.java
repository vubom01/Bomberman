package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.ListEntity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.Explosion;
import uet.oop.bomberman.entities.bomb.ListExplosion;
import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.entities.moveObject.Player;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy;
import uet.oop.bomberman.entities.tile.item.Item;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collision {

    private Board board;
    private MoveObject moveObject;

    public Collision(Board board, MoveObject moveObject) {
        this.board = board;
        this.moveObject = moveObject;
    }

    public boolean tileCollision(double x, double y) {
        CreateMap level = board.getLevel();
        int width = level.getWidth();
        int height = level.getHeight();

        ArrayList<Rectangle> rect = new ArrayList<>();
        double x00 = moveObject.getX() + x;
        if (moveObject instanceof Player) x00 += 3;
        Rectangle2D playerRect = new Rectangle2D.Double(
                x00,
                moveObject.getY() + y,
                15,
                15
        );

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Entity e = board.getEntity(i, j);
                if (!e.checkcollision(e)) {
                    Rectangle rectTile = new Rectangle(
                            i * Game.TILES_SIZE, j * Game.TILES_SIZE + Game.TILES_SIZE,
                            Game.TILES_SIZE, Game.TILES_SIZE
                    );
                    rect.add(rectTile);
                }

            }
        }

        for (Rectangle r : rect) {
            if (r.intersects(playerRect)) {
                return false;
            }
        }

        return true;
    }

    public boolean check2Rect(Rectangle r) {
        double x1 = moveObject.getX() + 3;
        double y1 = moveObject.getY();
        double w1 = Game.TILES_SIZE - 1;
        double h1 = Game.TILES_SIZE - 1;

        double x2 = r.getX();
        double y2 = r.getY();
        double w2 = Game.TILES_SIZE;
        double h2 = Game.TILES_SIZE;

        if ((x1 + w1 > x2) && (x2 + w2 > x1) && (y1 + h1 > y2) && (y2 + h2 > y1)) {
            return true;
        }
        return false;
    }

    public boolean bombCollision(double x, double y) {
        ArrayList<Rectangle> rect = new ArrayList<>();
        double x00 = moveObject.getX() + x;
        if (moveObject instanceof Player) x00 += 3;
        Rectangle2D playerRect = new Rectangle2D.Double(
                x00,
                moveObject.getY() + y,
                15,
                15
        );

        List<Bomb> b = board.getBombs();
        for (int i = 0; i < b.size(); i++) {
            Bomb bomb = b.get(i);
            int x0 = (int) bomb.getX();
            int y0 = (int) bomb.getY();
            Rectangle rectTile = new Rectangle(
                    x0 * Game.TILES_SIZE, y0 * Game.TILES_SIZE + Game.TILES_SIZE,
                    Game.TILES_SIZE, Game.TILES_SIZE
            );
            rect.add(rectTile);
        }

        for (Rectangle r : rect) {
            if (check2Rect(r) == true) {
                return true;
            }else if (r.intersects(playerRect)) {
                return false;
            }
        }

        return true;
    }

    public void checkBombExplode() {
        ArrayList<Rectangle> rect = new ArrayList<>();
        List<Bomb> bombs = board.getBombs();
        for (int i = 0; i < bombs.size(); i++) {
            rect.clear();
            Bomb bomb = bombs.get(i);
            int x0 = (int) bomb.getX();
            int y0 = (int) bomb.getY();
            Rectangle rectTile = new Rectangle(
                    x0 * Game.TILES_SIZE, y0 * Game.TILES_SIZE + Game.TILES_SIZE,
                    Game.TILES_SIZE, Game.TILES_SIZE
            );
            rect.add(rectTile);
            if (bomb.getExplosion() == null) continue;
            for (int j = 0; j < bomb.getExplosion().length; j++) {
                ListExplosion listExplosion = bomb.getExplosion()[j];
                for (int k = 0; k < listExplosion.getExplosions().length; k++) {
                    Explosion explosion = listExplosion.getExplosions()[k];
                    x0 = (int) explosion.getX();
                    y0 = (int) explosion.getY();
                    rectTile = new Rectangle(
                            x0 * Game.TILES_SIZE, y0 * Game.TILES_SIZE + Game.TILES_SIZE,
                            Game.TILES_SIZE, Game.TILES_SIZE
                    );
                    rect.add(rectTile);
                }
            }
            for (Rectangle r : rect) {
                if (check2Rect(r) == true) moveObject.kill();
            }
        }
    }

    public void itemCollision() {
        CreateMap level = board.getLevel();
        int width = level.getWidth();
        int height = level.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Entity e = board.getEntity(i, j);
                if (e instanceof ListEntity) {
                    Rectangle rectTile = new Rectangle(
                            i * Game.TILES_SIZE, j * Game.TILES_SIZE + Game.TILES_SIZE,
                            Game.TILES_SIZE, Game.TILES_SIZE
                    );
                    if (check2Rect(rectTile)) e.checkcollision(moveObject);
                }
            }
        }
    }

    public void enemyCollision(double x, double y) {
        List<MoveObject> moveObjects = board.getMoveObject();
        for (int i = 0; i < moveObjects.size(); i++) {
            MoveObject e = moveObjects.get(i);
            if (       e instanceof Enemy) {
                Rectangle rectTile = new Rectangle(
                        (int) e.getX(), (int) e.getY(),
                        Game.TILES_SIZE, Game.TILES_SIZE
                );
                if (check2Rect(rectTile)) moveObject.kill();
            }
        }
    }

    public boolean collision(double x, double y) {
        return tileCollision(x, y) && bombCollision(x, y);
    }
}
