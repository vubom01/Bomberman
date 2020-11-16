package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.entities.tile.GrassTile;
import uet.oop.bomberman.graphics.Screen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {

    private CreateMap level;
    private Game game;
    private Keyboard input;
    private Screen screen;

    private Entity[] entities;
    private List<MoveObject> moveObjects = new ArrayList<MoveObject>();
    private List<Bomb> bombs = new ArrayList<>();

    public Board(Game game, Keyboard input, Screen screen) {
        this.game = game;
        this.input = input;
        this.screen = screen;

        changeLevel(1);
    }

    public void update() {
        updateEntities();
        updateBombs();
        updateMoveObjects();
    }

    public void render(Screen screen) {
        renderEntity(screen);
        renderBombs(screen);
        renderMoveObjects(screen);
    }

    public void changeLevel(int levelNumber) {
        try {
            level = new CreateMap("res/levels/Level" + levelNumber + ".txt", this);
            entities = new Entity[level.getHeight() * level.getWidth()];
            level.createEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawScreen(Graphics g) {
        screen.drawChangeLevel(g, level.getLevel());
    }

    public void addEntity(int pos, Entity e) {
        entities[pos] = e;
    }

    public void addMob(MoveObject e) {
        moveObjects.add(e);
    }

    public void addBomb(Bomb b) {
        bombs.add(b);
    }

    public void renderEntity(Screen screen) {
        for (int y = 0; y < level.getHeight(); y++) {
            for (int x = 0; x < level.getWidth(); x++) {
                entities[x + y * level.getWidth()].render(screen);
            }
        }
    }

    public void renderMoveObjects(Screen screen) {
        Iterator<MoveObject> itr = moveObjects.iterator();

        while(itr.hasNext())
            itr.next().render(screen);
    }

    public void renderBombs(Screen screen) {
        Iterator<Bomb> itr = bombs.iterator();

        while(itr.hasNext())
            itr.next().render(screen);
    }

    public void updateEntities() {
        for (int i = 0; i < entities.length; i++) {
            entities[i].update();
        }
    }

    public void updateMoveObjects() {
        Iterator<MoveObject> itr = moveObjects.iterator();

        while(itr.hasNext())
            itr.next().update();
    }

    public void updateBombs() {
        Iterator<Bomb> itr = bombs.iterator();

        while(itr.hasNext())
            itr.next().update();
    }

    public Keyboard getInput() {
        return input;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public Entity getEntity(double x, double y) {
        Entity res = entities[(int) x + (int) y * level.getWidth()];
        return res;
    }

    public int getWidth() {
        return level.getWidth();
    }

    public int getHeight() {
        return level.getHeight();
    }

    public CreateMap getLevel() {
        return level;
    }
}
