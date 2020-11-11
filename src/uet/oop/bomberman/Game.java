package uet.oop.bomberman;

import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.gui.Frame;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas {

    public static final double VERSION = 1.9;

    public static final int TILES_SIZE = 16,
            WIDTH = TILES_SIZE * (int)(31), //minus one to ajust the window,
            HEIGHT = 13 * TILES_SIZE;

    public static int SCALE = 3;

    public static final String TITLE = "Bomberman " + VERSION;

    //initial configs
    private static final int BOMBRATE = 1;
    private static final int BOMBRADIUS = 1;
    private static final double PLAYERSPEED = 1.0;

    public static final int TIME = 200;
    public static final int POINTS = 0;
    public static final int LIVES = 3;

    protected static int SCREENDELAY = 3;


    //can be modified with bonus
    protected static int bombRate = BOMBRATE;
    protected static int bombRadius = BOMBRADIUS;
    protected static double playerSpeed = PLAYERSPEED;


    //Time in the level screen in seconds
    protected int _screenDelay = SCREENDELAY;

    private Keyboard input;
    private boolean _running = false;
    private boolean _paused = true;

    private Board board;
    private Screen screen;
    private Frame frame;

    //this will be used to render the game, each render is a calculated image saved here
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game(Frame frame) {
        frame = frame;
        frame.setTitle(TITLE);

        screen = new Screen(WIDTH, HEIGHT);
        input = new Keyboard();

        board = new Board(this, input, screen);
        addKeyListener(input);
    }


    private void renderGame() { //render will run the maximum times it can per second
        BufferStrategy bs = getBufferStrategy(); //create a buffer to store images using canvas
        if(bs == null) { //if canvas dont have a bufferstrategy, create it
            createBufferStrategy(3); //triple buffer
            return;
        }

        screen.clear();

        board.render(screen);

        for (int i = 0; i < pixels.length; i++) { //create the image to be rendered
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();
    }

    private void renderScreen() { //TODO: merge these render methods
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

    private void update() {
        input.update();
        board.update();
    }

    public void start() {
        _running = true;

        long  lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0; //nanosecond, 60 frames per second
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();
        while(_running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                update();
                updates++;
                delta--;

                renderGame();
            }
        }
    }

    public static double getPlayerSpeed() {
        return playerSpeed;
    }

    public Keyboard getInput() {
        return input;
    }

    public Board getBoard() {
        return board;
    }

}
