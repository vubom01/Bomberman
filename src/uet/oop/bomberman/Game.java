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
    public static int SCALE = 2;

    private static final double PLAYERSPEED = 0.8;
    private static final int BOMBRATE = 2;
    private static final int BOMBRADIUS = 2;

    public static double playerSpeed = PLAYERSPEED;
    public static int bombRate = BOMBRATE;
    public static int bombRadius = BOMBRADIUS;

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
        running = true;

        long  lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        requestFocus();
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                update();
                delta--;
                renderGame();
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

    public static void setBombRate(int i) {
        bombRate += i;
    }

    public static void setBombRadius(int i) {
        bombRadius += i;
    }

    public static void setPlayerSpeed(double i) {
        playerSpeed += i;
    }

    public Keyboard getInput() {
        return input;
    }

    public Board getBoard() {
        return board;
    }

    public static void main(String[] args) {
        Frame app = new Frame();
    }
}
