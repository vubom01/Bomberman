package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.Player;
import uet.oop.bomberman.entities.tile.BrickTile;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Collision {

    Board board;
    Player player;

    public Collision(Board board , Player player) {
        this.board = board;
        this.player = player;
    }

    public boolean collision(double x, double y) {
        CreateMap level = board.getLevel();
        int width = level.getWidth();
        int height = level.getHeight();

        ArrayList<Rectangle> rect = new ArrayList<>();
        Rectangle2D playerRect = new Rectangle2D.Double(
                player.getX() + x + 3,
                player.getY() + y,
                15,
                15
        );

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Entity e = board.getEntity(i, j);
                if (!e.checkcollision(e)) {
                    Rectangle rectTile = new Rectangle(
                        i * 16, j * 16 + 16,
                        16, 16
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
}
