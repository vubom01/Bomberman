package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.mob.Mob;
import uet.oop.bomberman.graphics.Screen;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {

    public int width, height;
    protected CreateMap level;
    protected Game game;
    protected Keyboard input;
    protected Screen screen;

    public Entity[] entities;
    public List<Mob> mobs = new ArrayList<Mob>();

    private int _screenToShow = -1; //1:endgame, 2:changelevel, 3:paused

    public Board(Game game, Keyboard input, Screen screen) {
        this.game = game;
        this.input = input;
        this.screen = screen;

        changeLevel(1);
    }

    public void update() {

        updateEntities();
        updateMobs();
    }


    public void render(Screen screen) {
        for (int y = 0; y < level.getHeight(); y++) {
            for (int x = 0; x < level.getWidth(); x++) {
                entities[x + y * level.getWidth()].render(screen);
            }
        }
        renderMobs(screen);
    }

    public void newGame() {
        changeLevel(1);
    }

    public void restartLevel() {
        changeLevel(level.getLevel());
    }

    public void changeLevel(int levelNumber) {
        _screenToShow = 2;

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

    public void addMob(Mob e) {
        mobs.add(e);
    }

    protected void renderEntities(Screen screen) {
        for (int i = 0; i < entities.length; i++) {
            entities[i].render(screen);
        }
    }

    protected void renderMobs(Screen screen) {
        Iterator<Mob> itr = mobs.iterator();

        while(itr.hasNext())
            itr.next().render(screen);
    }


    protected void updateEntities() {
        for (int i = 0; i < entities.length; i++) {
            entities[i].update();
        }
    }

    protected void updateMobs() {
        Iterator<Mob> itr = mobs.iterator();

        while(itr.hasNext())
            itr.next().update();
    }

    public Keyboard getInput() {
        return input;
    }
}