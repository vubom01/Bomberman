package uet.oop.bomberman.collision;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.Explosion;
import uet.oop.bomberman.entities.bomb.ListExplosion;
import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.entities.moveObject.player.Player;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy;
import uet.oop.bomberman.gui.map.CreateMap;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
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

        Rectangle2D moveObjectRect;
        if (moveObject instanceof Player) 
            moveObjectRect = new Rectangle2D.Double(
                        moveObject.getX() + x + 2,
                        moveObject.getY() + y,
                        Game.TILES_SIZE - 2,
                        Game.TILES_SIZE - 2
        );
        else moveObjectRect = new Rectangle2D.Double(
                moveObject.getX() + x,
                moveObject.getY() + y,
                Game.TILES_SIZE - 1,
                Game.TILES_SIZE - 1
        );

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Entity e = board.getEntity(i, j);
                Rectangle rectTile = new Rectangle(
                        i * Game.TILES_SIZE, j * Game.TILES_SIZE + Game.TILES_SIZE,
                        Game.TILES_SIZE, Game.TILES_SIZE
                );
                if (rectTile.intersects(moveObjectRect) && !e.checkcollision(moveObject)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean check2Rect(Rectangle r) {
        double x1, y1, h1, w1;
        Rectangle2D moveObjectRect;
        if (moveObject instanceof Player) {
            x1 = moveObject.getX() + 2;
            y1 = moveObject.getY();
            w1 = Game.TILES_SIZE - 2;
            h1 = Game.TILES_SIZE - 2;
        }
        else {
            x1 = moveObject.getX();
            y1 = moveObject.getY();
            h1 = Game.TILES_SIZE - 1;
            w1 = Game.TILES_SIZE - 1;
        }

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

        Rectangle2D moveObjectRect;
        if (moveObject instanceof Player)
            moveObjectRect = new Rectangle2D.Double(
                    moveObject.getX() + x + 2,
                    moveObject.getY() + y,
                    Game.TILES_SIZE - 2,
                    Game.TILES_SIZE - 2
            );
        else moveObjectRect = new Rectangle2D.Double(
                moveObject.getX() + x,
                moveObject.getY() + y,
                Game.TILES_SIZE - 1,
                Game.TILES_SIZE - 1
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
            }else if (r.intersects(moveObjectRect)) {
                return false;
            }
        }

        return true;
    }

    public boolean check2Rect_2(Rectangle r) {
        double x1, y1, h1, w1;
        Rectangle2D moveObjectRect;
        if (moveObject instanceof Player) {
            x1 = moveObject.getX() + 2;
            y1 = moveObject.getY();
            w1 = Game.TILES_SIZE - 2;
            h1 = Game.TILES_SIZE - 2;
        }
        else {
            x1 = moveObject.getX();
            y1 = moveObject.getY();
            h1 = Game.TILES_SIZE - 1;
            w1 = Game.TILES_SIZE - 1;
        }
        x1 += 3;
        y1 += 3;
        w1 -= 3;
        h1 -= 3;

        double x2 = r.getX();
        double y2 = r.getY();
        double w2 = Game.TILES_SIZE;
        double h2 = Game.TILES_SIZE;

        if ((x1 + w1 > x2) && (x2 + w2 > x1) && (y1 + h1 > y2) && (y2 + h2 > y1)) {
            return true;
        }
        return false;
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
                if (check2Rect_2(r) == true) moveObject.kill();
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
                if (check2Rect_2(rectTile)) moveObject.kill();
            }
        }
    }

    public boolean collision(double x, double y) {
        return tileCollision(x, y) && bombCollision(x, y);
    }
}
