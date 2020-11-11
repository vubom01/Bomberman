package uet.oop.bomberman.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteSheet {

	private String filePath;
	public final int SIZE;
	public int[] pixels;
	public BufferedImage image;

	public static SpriteSheet tiles = new SpriteSheet("/textures/sprites.png", 1009);
	
	public SpriteSheet(String filePath, int size) {
		this.filePath = filePath;
		this.SIZE = size;
		pixels = new int[SIZE * SIZE];

		// loadImage
		try {
			URL a = SpriteSheet.class.getResource(filePath);
			image = ImageIO.read(a);
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
