package uet.oop.bomberman;

import uet.oop.bomberman.entities.mob.Player;
import uet.oop.bomberman.entities.tile.GrassTile;
import uet.oop.bomberman.entities.tile.WallTile;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateMap {

    protected int width, height, level;
    protected char[][] map;
    protected Board board;

    public CreateMap(String path, Board board) throws IOException {
        loadLevel(path);
        this.board = board;
    }

    public void loadLevel(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        level = Integer.parseInt(br.readLine());
        height = Integer.parseInt(br.readLine());
        width = Integer.parseInt(br.readLine());

        map = new char[width][height];
        String line;
        int rowNum = 0;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                map[i][rowNum] = line.charAt(i);
            }
            rowNum++;
        }
    }

    public void createEntity() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pos = x + y * width;
                switch (map[x][y]) {
                    case '#':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wall));
                        break;
                    case 'p':
                        board.addMob(new Player(x * 16, y * 16 + 16, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass));
                        break;
                    default:
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass) );
                        break;
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLevel() {
        return level;
    }
}
