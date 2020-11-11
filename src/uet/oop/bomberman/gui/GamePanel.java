package uet.oop.bomberman.gui;

import uet.oop.bomberman.Game;
import java.awt.*;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    private Game _game;

    public GamePanel(Frame frame) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));

        _game = new Game(frame);

        add(_game);
        _game.setVisible(true);

        setVisible(true);
        setFocusable(true);

    }

    public void changeSize() {
        setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));
        revalidate();
        repaint();
    }

    public Game getGame() {
        return _game;
    }

}
