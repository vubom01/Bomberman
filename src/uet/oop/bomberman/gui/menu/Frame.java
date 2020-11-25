package uet.oop.bomberman.gui.menu;

import uet.oop.bomberman.gamestage.Game;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

    private GamePanel gamepane;
    private JPanel containerpane;
    private JPanel _containerpane;
    private JPanel menu;
    private InfoPanel infopane;
    private Game game;
    private CardLayout cl;

    public Frame() {
        cl = new CardLayout();
        containerpane = new JPanel(cl);
        _containerpane = new JPanel(new BorderLayout());

        gamepane = new GamePanel(this);
        menu = new Menu(this);
        infopane = new InfoPanel(gamepane.getGame());

        _containerpane.add(infopane, BorderLayout.PAGE_START);
        _containerpane.add(gamepane, BorderLayout.PAGE_END);

        containerpane.add(menu, "Menu");
        containerpane.add(_containerpane, "New Game");

        game = gamepane.getGame();

        add(containerpane);

        revalidate();
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        game.start();
    }

    public void play() {
        cl.show(containerpane, "New Game");
        game.isRunning();
    }

    public void gameOver() {
        cl.show(containerpane, "Menu");
        game.isMenu();
        newGame();
    }

    public void newGame() {
        game.getBoard().newGame();
        game.start();
    }


    public void setTime(int time) {
        infopane.setTime(time);
    }

    public void setLives(int lives) {
        infopane.setLives(lives);
    }

    public void setScore(int points) {
        infopane.setScore(points);
    }
}
