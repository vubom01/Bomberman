package uet.oop.bomberman.graphics;

import uet.oop.bomberman.entities.Entity;

public class Screen {

    protected int width, height;
    public int[] pixels;
    private int transparent_color = 0xffff00ff;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void renderEntity(int xp, int yp, Entity entity) {
        for (int y = 0; y < entity.getSprite().getSize(); y++) {
            int ya = y + yp;
            for (int x = 0; x < entity.getSprite().getSize(); x++) {
                int xa = x + xp;
                if (xa < -entity.getSprite().getSize() || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                int color = entity.getSprite().getPixels(x + y * entity.getSprite().getSize());
                if (color != transparent_color) pixels[xa + ya * width] = color;
            }
        }
    }

}
