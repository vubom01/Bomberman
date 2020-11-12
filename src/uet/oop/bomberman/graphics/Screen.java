package uet.oop.bomberman.graphics;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.Player;

import java.awt.*;

public class Screen {


    private int width, height;
    private int transparent_color = 0xffffffff;
    private static double xOffset = 0, yOffset = 0;

    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void renderEntity(int xp, int yp, Entity entity) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < entity.getSprite().getSize(); y++) {
            int ya = y + yp;
            for (int x = 0; x < entity.getSprite().getSize(); x++) {
                int xa = x + xp;
                if (xa < -entity.getSprite().getSize() || xa >= width || ya < -entity.getSprite().getSize() || ya >= height) break;
                if (xa < 0) xa = 0;
                if (ya < 0) ya = 0;
                int color = entity.getSprite().getPixels(x + y * entity.getSprite().getSize());
                if (color != transparent_color) pixels[xa + ya * width] = color;
            }
        }
    }

    public static void setxOffset(double xO) {
        xOffset = xO;
    }

    public static void setyOffset(double y0) {
        yOffset = y0;
    }

    public static double calculateXOffset(Board board, Player player) {
        double temp = xOffset;

        int firstBreakpoint = board.getWidth() / 4;
        int lastBreakpoint = board.getWidth() - firstBreakpoint;

        if(player.getX() / 16 > firstBreakpoint + 0.45 && player.getX() / 16 < lastBreakpoint - 0.45) {
            temp = player.getX()  - (Game.WIDTH / 2);
        }

        return temp;
    }

    public static double calculateYOffset(Board board, Player player) {
        double temp = yOffset;

        int firstBreakpoint = board.getHeight() / 4;
        int lastBreakpoint = board.getHeight() - firstBreakpoint;

        if(player.getY() / 16 > firstBreakpoint - 0.5 && player.getY() / 16 < lastBreakpoint + 0.5) {
            temp = player.getY()  - (Game.HEIGHT / 2);
        }

        return temp;
    }


    public void drawChangeLevel(Graphics g, int level) {
        g.setColor(Color.black);
        g.fillRect(0, 0, width * 3, height * 3);

        Font font = new Font("Arial", Font.PLAIN, 20 * 3);
        g.setFont(font);
        g.setColor(Color.white);
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
}
