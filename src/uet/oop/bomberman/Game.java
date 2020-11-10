package uet.oop.bomberman;

import java.awt.*;


public class Game extends Canvas {

    public static final int SIZE = 16;
    public static final int WIDTH = 15 * SIZE;
    public static final int HEIGHT = 13 * SIZE;

    private static final double PLAYERSPEED = 1.0;

    private static double playerSpeed = PLAYERSPEED;
    private static Keyboard input;

    public Game() {
        input = new Keyboard();
        addKeyListener(input);
    }

    public static double getPlayerSpeed() {
        return playerSpeed;
    }

    public static Keyboard getInput() {
        return input;
    }

}
