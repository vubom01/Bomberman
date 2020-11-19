package uet.oop.bomberman;

import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.Frame;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas {

    public static final int TILES_SIZE = 16,
            WIDTH = TILES_SIZE * 15,
            HEIGHT = TILES_SIZE * 13;
    public static int SCALE = 3;

    private static final double PLAYERSPEED = 0.8;
    private static final int BOMBRATE = 2;
    private static final int BOMBRADIUS = 2;
    private static final int SCREENDELAY = 3;
    private static final int TIMES = 200;
    private static final int POINTS = 0;
    private static final int LIVES = 3;


    public static double playerSpeed = PLAYERSPEED;
    public static int bombRate = BOMBRATE;
    public static int bombRadius = BOMBRADIUS;
    public static int screenDelay = SCREENDELAY;
    public static int times = TIMES;
    public static int points = POINTS;
    public static int lives = LIVES;


    private Keyboard input;
    private boolean running = false;
    private boolean paused = true;

    private Board board;
    private Screen screen;
    private Frame frame;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();


    public Game(Frame frame) {
        this.frame = frame;

        screen = new Screen(WIDTH, HEIGHT);
        input = new Keyboard();

        board = new Board(this, input, screen);
        addKeyListener(input);
    }


    public void renderGame() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        board.render(screen);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();
    }

    public void renderScreen() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        Graphics g = bs.getDrawGraphics();

        board.drawScreen(g);

        g.dispose();
        bs.show();
    }

    public void update() {
        board.update();
    }

    public void start() {
        running = false;

        while (true) {
            System.out.println(1);
            if (running) {
                System.out.println(2);
                break;
            }
        }

        System.out.println(3);


        long  lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                update();
                updates++;
                delta--;
            }


            if(paused) {
                if(screenDelay <= 0) {
                    board.setShow(-1);
                    paused = false;
                }

                renderScreen();
            } else {
                renderGame();
            }


            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                updates = 0;
                frames = 0;
                if(board.getShow() == 2)
                    screenDelay--;
            }
        }
    }

    public static double getPlayerSpeed() {
        return playerSpeed;
    }

    public static int getBombRate() {
        return bombRate;
    }

    public static int getBombRadius() {
        return bombRadius;
    }

    public static int getLives() {
        return lives;
    }

    public static void setBombRate(int i) {
        bombRate += i;
    }

    public static void setBombRadius(int i) {
        bombRadius += i;
    }

    public static void setPlayerSpeed(double i) {
        playerSpeed += i;
    }

    public static void setLives(int i) {
        lives += i;
    }

    public Keyboard getInput() {
        return input;
    }

    public Board getBoard() {
        return board;
    }

    public void resetScreenDelay() {
        screenDelay = SCREENDELAY;
    }

    public void pause() {
        paused = true;
    }

    public void running() {
        running = true;
    }

    public boolean isPaused() {
        return paused;
    }
}
