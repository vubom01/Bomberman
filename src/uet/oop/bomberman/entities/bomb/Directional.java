package uet.oop.bomberman.entities.bomb;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Screen;

public class Directional extends Entity {

    private Board board;

    /* 0: up
    // 1: down
    // 2: left
    // 3: right
    */
    private int direction;

    private int radius;
    private Explosion[] explosions;

    public Directional(double x, double y, int direction, int radius, Board board) {
        this.board = board;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.radius = radius;

        explosions = new Explosion[calculateDistance()];
        createExplosions();
    }

    public void createExplosions() {
        boolean last = false;

        int x0 = (int) x;
        int y0 = (int) y;
        for (int i = 0; i < explosions.length; i++) {
            switch (direction) {
                case 0: y--; break;
                case 1: y++; break;
                case 2: x--; break;
                case 3: x++; break;
            }

            if (i == explosions.length - 1) last = true;
            else last = false;

            explosions[i] = new Explosion(x, y, direction, last, board);
        }
    }

    @Override
    public void update() {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].update();
        }
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < explosions.length; i++) {
            explosions[i].render(screen);
        }
    }

    @Override
    public boolean checkcollision(Entity e) {
        return false;
    }

    public int calculateDistance() {
        int radius0 = 0;
        double x0 = x;
        double y0 = y;
        while (radius0 < radius) {
            if (direction == 0) y0--;
            if (direction == 1) y0++;
            if (direction == 2) x0--;
            if (direction == 3) x0++;

            Entity a = board.getEntity(x0, y0);
            if (a.checkcollision(this) == false) {
                break;
            }

            radius0++;
        }
        return radius0;
    }
}
