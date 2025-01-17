package uet.oop.bomberman.gamestage;

import uet.oop.bomberman.entities.moveObject.player.input.Keyboard;
import uet.oop.bomberman.entities.moveObject.player.input.Keyboard2;
import uet.oop.bomberman.gui.Screen;
import uet.oop.bomberman.gui.menu.Frame;
import uet.oop.bomberman.sound.Sound;

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
    private static final int BOMBRATE = 1;
    private static final int BOMBRADIUS = 1;
    private static final int SCREENDELAY = 3;
    public static final int TIMES = 300;
    public static final int POINTS = 0;
    public static final int LIVES = 3;


    public static double playerSpeed = PLAYERSPEED;
    public static int bombRate = BOMBRATE;
    public static int bombRadius = BOMBRADIUS;
    public static int screenDelay = SCREENDELAY;
    public static int screenDelayEnd = SCREENDELAY;
    public static Board board;

    private Keyboard input;
    private Keyboard2 input2;
    private boolean running = false;
    private boolean paused = true;

    private Screen screen;
    private Frame frame;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();


    public Game(Frame frame) {
        this.frame = frame;

        screen = new Screen(WIDTH, HEIGHT);
        input = new Keyboard();
        input2 = new Keyboard2();

        board = new Board(this, input, input2, screen);
        addKeyListener(input);
        addKeyListener(input2);
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

        while (!running) {
            System.out.println();
        }
        Sound.playStartStage();
        long  lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
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
            }


            if(paused) {
                if(screenDelay <= 0) {
                    board.setShow(-1);
                    paused = false;
                }
                if (screenDelayEnd <= 0) {
                    board.setShow(-1);
                    paused = false;
                    frame.gameOver();
                }
                if (board.getShow() == 3 && input.pause == false) board.gameResume();
                renderScreen();
            } else {
                renderGame();
                if (input.pause == true) board.gamePause();
            }



            if(System.currentTimeMillis() - timer > 1000) {
                frame.setTime(board.subtractTime());
                frame.setScore(board.getPoints());
                frame.setLives(board.getLives());
                timer += 1000;

                if(board.getShow() == 2) screenDelay--;
                if(board.getShow() == 1) screenDelayEnd--;
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

    public static Board getBoard() {
        return board;
    }

    public Board getB() {
        return board;
    }

    public void resetScreenDelay() {
        screenDelay = SCREENDELAY;
    }

    public void resetScreenDelayEnd() {
        screenDelayEnd = SCREENDELAY;
    }

    public void pause() {
        paused = true;
    }

    public void run() {
        running = true;
        paused = false;
    }

    public void isRunning() {
        running = true;
        paused = true;
    }

    public void isMenu() {
        running = false;
        paused = false;
    }

    public boolean isPaused() {
        return paused;
    }

    public Frame getFrame() {
        return frame;
    }
}
