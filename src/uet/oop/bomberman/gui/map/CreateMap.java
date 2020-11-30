package uet.oop.bomberman.gui.map;

import uet.oop.bomberman.entities.moveObject.player.Player2;
import uet.oop.bomberman.entities.tile.item.*;
import uet.oop.bomberman.gamestage.Board;
import uet.oop.bomberman.gamestage.Game;
import uet.oop.bomberman.entities.ListEntity;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy4;
import uet.oop.bomberman.entities.moveObject.player.Player;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy1;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy2;
import uet.oop.bomberman.entities.moveObject.enemy.Enemy3;
import uet.oop.bomberman.entities.tile.block.BrickTile;
import uet.oop.bomberman.entities.tile.block.GrassTile;
import uet.oop.bomberman.entities.tile.block.PortalTile;
import uet.oop.bomberman.entities.tile.block.WallTile;
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
                    case 'l':
                        listEntity = new ListEntity(x, y, new GrassTile(x ,y, Sprite.grass[getLevel()]),
                                new BrickTile(x ,y, Sprite.brick[getLevel()], getLevel()));
                        if (!board.isItemUsed(x, y, level)) {
                            listEntity.addBeforeTop(new iLive(x, y, level, Sprite.itemLive));
                        }
                        board.addEntity(pos, listEntity);
                        break;
                    case 'w':
                        listEntity = new ListEntity(x, y, new GrassTile(x ,y, Sprite.grass[getLevel()]),
                                new BrickTile(x ,y, Sprite.brick[getLevel()], getLevel()));
                        if (!board.isItemUsed(x, y, level)) {
                            listEntity.addBeforeTop(new iWallPass(x, y, level, Sprite.itemWallPass));
                        }
                        board.addEntity(pos, listEntity);
                        break;
                    //
                    case 'p':
                        board.addMob(new Player(x * Game.TILES_SIZE, y * Game.TILES_SIZE + Game.TILES_SIZE, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]));
                        break;
                    case 'q':
                        board.addMob(new Player2(x * Game.TILES_SIZE, y * Game.TILES_SIZE + Game.TILES_SIZE, board));
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
                        board.addMob(new Enemy1(x * Game.TILES_SIZE, y * Game.TILES_SIZE + Game.TILES_SIZE, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]));
                        break;
                    case '2':
                        board.addMob(new Enemy2(x * Game.TILES_SIZE, y * Game.TILES_SIZE + Game.TILES_SIZE, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]));
                        break;
                    case '3':
                        board.addMob(new Enemy3(x * Game.TILES_SIZE, y * Game.TILES_SIZE + Game.TILES_SIZE, board));
                        board.addEntity(pos, new GrassTile(x, y, Sprite.grass[getLevel()]));
                        break;
                    case '4':
                        board.addMob(new Enemy4(x * Game.TILES_SIZE, y * Game.TILES_SIZE + Game.TILES_SIZE, board));
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
