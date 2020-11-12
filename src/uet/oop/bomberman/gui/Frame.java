package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {

    private GamePanel gamepane;
    private JPanel containerpane;
    private Game game;

    public Frame() {

        containerpane = new JPanel(new BorderLayout());
        gamepane = new GamePanel(this);

        containerpane.add(gamepane, BorderLayout.PAGE_END);

        game = gamepane.getGame();

        add(containerpane);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        game.start();
    }
}
