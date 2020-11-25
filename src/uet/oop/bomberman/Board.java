package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Bomb;
import uet.oop.bomberman.entities.bomb.Explosion;
import uet.oop.bomberman.entities.moveObject.MoveObject;
import uet.oop.bomberman.entities.moveObject.player.Player;
import uet.oop.bomberman.entities.moveObject.player.input.Keyboard;
import uet.oop.bomberman.entities.tile.item.Item;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.map.CreateMap;

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

    private int time = Game.TIMES;
    private int points = Game.POINTS;
    private int lives = Game.LIVES;

    private int screenToShow = -1; //1:endGame, 2:changeLevel

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

        for (int i = 0; i < moveObjects.size(); i++) {
            MoveObject a = moveObjects.get(i);
            if(((Entity)a).isRemoved()) moveObjects.remove(i);
        }

    }

    public void render(Screen screen) {
        if(game.isPaused() ) return;
        renderEntity(screen);
        renderBombs(screen);
        renderMoveObjects(screen);
    }

    public void newGame() {
        screen.resetOffset();
        points = Game.POINTS;
        lives = Game.LIVES;
        Player.items.clear();
        game.playerSpeed = 0.8;
        game.bombRadius = 1;
        game.bombRate = 1;

        changeLevel(1);
    }

    public void restartLevel() {
        changeLevel(level.getLevel());
    }

    public void nextLevel() {
        changeLevel(level.getLevel() + 1);
    }

    public void changeLevel(int levelNumber) {
        time = Game.TIMES;
        screen.resetOffset();
        screenToShow = 2;
        game.resetScreenDelay();
        game.resetScreenDelayEnd();
        game.pause();
        moveObjects.clear();
        bombs.clear();

        try {
            level = new CreateMap("res/levels/Level" + levelNumber + ".txt", this);
            entities = new Entity[level.getHeight() * level.getWidth()];
            level.createEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawScreen(Graphics g) {
        switch (screenToShow) {
            case 1:
                screen.drawEndGame(g, getPoints());
                break;
            case 2:
                screen.drawChangeLevel(g, level.getLevel());
                break;
            case 3:
                screen.drawPaused(g);
                break;
        }
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
        for (int i = 0; i < moveObjects.size(); i++) {
            moveObjects.get(i).update();
        }
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

    public Entity getEntity(double x, double y, MoveObject m) {

        Entity res = null;

        res = getExplosion(x, y);
        if( res != null) return res;

        res = getBomb(x, y);
        if( res != null) return res;

        res = getEntity(x, y);

        return res;
    }

    public Explosion getExplosion(double x, double y) {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while(bs.hasNext()) {
            b = bs.next();

            Explosion e = b.explosionAt(x, y);
            if(e != null) {
                return e;
            }

        }

        return null;
    }

    public Bomb getBomb(double x, double y) {
        Iterator<Bomb> bs = bombs.iterator();
        Bomb b;
        while(bs.hasNext()) {
            b = bs.next();
            if(b.getX() == x && b.getY() == y)
                return b;
        }

        return null;
    }

    public List<MoveObject> getMoveObject() {
        return moveObjects;
    }

    public Entity getEntity(double x, double y) {
       return entities[(int) x + (int) y * level.getWidth()];
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

    public void resetProperties() {
        Player.items.clear();

        game.playerSpeed = 1.0;
        game.bombRadius = 1;
        game.bombRate = 1;
    }

    public void endGame() {
        screenToShow = 1;
        game.resetScreenDelay();
        game.pause();
    }

    public void setShow(int i) {
        screenToShow = i;
    }

    public int getShow() {
        return screenToShow;
    }

    public boolean isItemUsed(int x, int y, int level) {
        Item item;
        for (int i = 0; i < Player.items.size(); i++) {
            item = Player.items.get(i);
            if(item.getX() == x && item.getY() == y && level == item.getLevel())
                return true;
        }
        return false;
    }

    public boolean detectNoEnemies() {
        int total = 0;
        for (int i = 0; i < moveObjects.size(); i++) {
            if(moveObjects.get(i) instanceof Player == false)
                total++;
        }
        return (total == 0);
    }

    public int getTime() {
        return time;
    }

    public int getLives() {
        return lives;
    }

    public int subtractTime() {
        if(game.isPaused())
            return this.time;
        else
            return this.time--;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addLives(int lives) {
        this.lives += lives;
    }

    public Game getGame() {
        return game;
    }
}
