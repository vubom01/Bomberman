package uet.oop.bomberman;

import uet.oop.bomberman.entities.ListEntity;
import uet.oop.bomberman.entities.moveObject.Player;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy1;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy2;
import uet.oop.bomberman.entities.tile.BrickTile;
import uet.oop.bomberman.entities.tile.GrassTile;
import uet.oop.bomberman.entities.tile.PortalTile;
import uet.oop.bomberman.entities.tile.WallTile;
import uet.oop.bomberman.entities.tile.item.iBomb;
import uet.oop.bomberman.entities.tile.item.iFire;
import uet.oop.bomberman.entities.tile.item.iSpeed;
import uet.oop.bomberman.gui.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateMap {

    private int width, height, level;
    private char[][] map;
    private Board board;

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
        ListEntity listEntity;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pos = x + y * width;
                switch (map[x][y]) {
                    // Create Wall
                    case 'W':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallUp[getLevel()]));
                        break;
                    case 'D':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallDown[getLevel()]));
                        break;
                    case 'L':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallLeft[getLevel()]));
                        break;
                    case 'R':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallRight[getLevel()]));
                        break;
                    case '[':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallUpLeft[getLevel()]));
                        break;
                    case ']':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallUpRight[getLevel()]));
                        break;
                    case '{':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallDownRight[getLevel()]));
                        break;
                    case '}':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wallDownLeft[getLevel()]));
                        break;
                    case '#':
                        board.addEntity(pos, new WallTile(x, y, Sprite.wall[getLevel()]));
                        break;
                    case '*':
                        board.addEntity(pos, new ListEntity(x, y,
                                new GrassTile(x, y, Sprite.grass[getLevel()]),
                                new BrickTile(x, y, Sprite.brick[getLevel()], getLevel())
                        ));
                        break;
                    // Create Item
                    case 'b':
                        listEntity = new ListEntity(x, y, new GrassTile(x, y, Sprite.grass[getLevel()]),
                                                    new BrickTile(x, y, Sprite.brick[getLevel()], getLevel()));
                        if (!board.isItemUsed(x, y, level)) {
                            listEntity.addBeforeTop(new iBomb(x, y, level, Sprite.itemBomb));
                        }
                        board.addEntity(pos, listEntity);
                        break;
                    case 'f':
                        listEntity = new ListEntity(x, y, new GrassTile(x ,y, Sprite.grass[getLevel()]),
                                                    new BrickTile(x ,y, Sprite.brick[getLevel()], getLevel()));
                        if (!board.isItemUsed(x, y, level)) {
                            listEntity.addBeforeTop(new iFire(x, y, level, Sprite.itemFire));
                        }
                        board.addEntity(pos, listEntity);
                        break;
                    case 's':
                        listEntity = new ListEntity(x, y, new GrassTile(x ,y, Sprite.grass[getLevel()]),
                                                    new BrickTile(x ,y, Sprite.brick[getLevel()], getLevel()));
                        if (!board.isItemUsed(x, y, level)) {
                            listEntity.addBeforeTop(new iSpeed(x, y, level, Sprite.itemSpeed));
                        }
                        board.addEntity(pos, listEntity);
                        break;
                    //
                    case 'p':
                        board.addMob(new Player(x * 16, y * 16 + 16, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]));
                        break;
                    case 'x':
                        board.addEntity(pos, new ListEntity(x, y,
                                new GrassTile(x ,y, Sprite.grass[getLevel()]),
                                new PortalTile(x ,y, Sprite.portal, board),
                                new BrickTile(x ,y, Sprite.brick[getLevel()], getLevel())) );
                        break;
                    // Enemy
                    case '1':
                        board.addMob(new Enemy1(x * 16, y * 16 + 16, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]));
                        break;
                    case '2':
                        board.addMob(new Enemy2(x * 16, y * 16 + 16, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]));
                        break;
                    // Grass
                    default:
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]) );
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
