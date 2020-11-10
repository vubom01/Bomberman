package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Wall;
import uet.oop.bomberman.graphics.Screen;

public class Board {

    public int width, height;
    protected Game game;
    protected Keyboard input;

    public Entity[] entities;

    public Board(Game game, Keyboard input) {
        this.game = game;
        this.input = input;
    }

    public void update() {
        updateEntities();
    }

    public void render(Screen screen) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                entities[x + y * width].render(screen);
            }
        }
    }

    public void newGame() {
    }

    private void updateEntities() {
    }

    public void addEntity(int pos, Entity e) {
        entities[pos] = e;
    }

}
