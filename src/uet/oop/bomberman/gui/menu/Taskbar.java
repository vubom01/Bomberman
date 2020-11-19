package uet.oop.bomberman.gui.menu;

import uet.oop.bomberman.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Taskbar extends JPanel {

    BufferedImage image;

    public Taskbar() {
        URL a = getClass().getResource("/textures/taskbar.png");
        try {
            image = ImageIO.read(a);
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(720, 62));

        JLabel background = new JLabel(new ImageIcon(image));
        add(background);

        setVisible(true);
        setFocusable(true);
    }
}
