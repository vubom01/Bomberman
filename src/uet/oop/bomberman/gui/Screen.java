package uet.oop.bomberman.gui;

import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.gamestage.Board;
import uet.oop.bomberman.gamestage.Game;
import uet.oop.bomberman.entities.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;

public class Screen {


    private int width, height;
    private int transparent_color = 0xFFFFFFFF;

    public static double xOffset = 0, yOffset = 0;

    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void renderEntity(int xp, int yp, Entity entity) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < entity.getSprite().getSIZE_Y(); y++) {
            int ya = y + yp;
            for (int x = 0; x < entity.getSprite().getSIZE_X(); x++) {
                int xa = x + xp;
                if (xa < -entity.getSprite().getSIZE_X() || xa >= width || ya < -entity.getSprite().getSIZE_Y() || ya >= height) break;
                if (xa < 0) xa = 0;
                if (ya < 0) ya = 0;
                int color = entity.getSprite().getPixels(x + y * entity.getSprite().getSIZE_Y());
                if (color != transparent_color) pixels[xa + ya * width] = color;
            }
        }
    }

    public void renderEntity(int xp, int yp, Entity entity, Sprite below) {
        xp -= xOffset;
        yp -= yOffset;
        for (int y = 0; y < entity.getSprite().getSIZE_Y(); y++) {
            int ya = y + yp;
            for (int x = 0; x < entity.getSprite().getSIZE_X(); x++) {
                int xa = x + xp;
                if (xa < -entity.getSprite().getSIZE_X() || xa >= width || ya < -entity.getSprite().getSIZE_Y() || ya >= height) break;
                if (xa < 0) xa = 0;
                if (ya < 0) ya = 0;
                int color = entity.getSprite().getPixels(x + y * entity.getSprite().getSIZE_Y());
                if(color != transparent_color) pixels[xa + ya * width] = color;
                else pixels[xa + ya * width] = below.getPixels(x + y * below.getSIZE_Y());
            }
        }
    }


    public static void setxOffset(double xO) {
        xOffset = xO;
    }

    public static void setyOffset(double y0) {
        yOffset = y0;
    }

    public static double calculateXOffset(Board board, MoveObject player) {
        double temp = xOffset;

        int firstBreakpoint = board.getWidth() / 4;
        int lastBreakpoint = board.getWidth() - firstBreakpoint;

        if(player.getX() / 16 > firstBreakpoint + 0.45 && player.getX() / 16 < lastBreakpoint - 0.45) {
            temp = player.getX()  - (Game.WIDTH / 2);
        }

        return temp;
    }

    public static double calculateYOffset(Board board, MoveObject player) {
        double temp = yOffset;

        int firstBreakpoint = board.getHeight() / 4;
        int lastBreakpoint = board.getHeight() - firstBreakpoint;

        if(player.getY() / 16 > firstBreakpoint - 0.5 && player.getY() / 16 < lastBreakpoint + 0.5) {
            temp = player.getY()  - (Game.HEIGHT / 2);
        }

        return temp;
    }

    public void drawEndGame(Graphics g, int points) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getRealWidth(), getRealHeight());

        Font font = new Font("Arial", Font.PLAIN, 20 * Game.SCALE);
        g.setFont(font);
        g.setColor(Color.white);
        drawCenteredString("GAME OVER", getRealWidth(), getRealHeight(), g);

        font = new Font("Arial", Font.PLAIN, 10 * Game.SCALE);
        g.setFont(font);
        g.setColor(Color.yellow);
        drawCenteredString("POINTS: " + points, getRealWidth(), getRealHeight() + (Game.TILES_SIZE * 2) * Game.SCALE, g);
    }

    public void drawChangeLevel(Graphics g, int level) {
        BufferedImage image;
        String filePath = "/textures/level" + level + ".png   ";
        URL a = getClass().getResource(filePath);
        try {
            image = ImageIO.read(a);
            g.drawImage(image, 0, 0, getWidth() * Game.SCALE, getHeight() * Game.SCALE, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPaused(Graphics g) {

        Font font = new Font("Arial", Font.PLAIN, 20 * Game.SCALE);
        g.setFont(font);
        g.setColor(Color.white);
        drawCenteredString("PAUSE", getRealWidth(), getRealHeight(), g);

    }

    public void drawCenteredString(String s, int w, int h, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRealWidth() {
        return width * Game.SCALE;
    }

    public int getRealHeight() {
        return height * Game.SCALE;
    }

    public void resetOffset() {
        xOffset = 0;
        yOffset = 0;
    }
}
