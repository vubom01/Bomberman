import uet.oop.bomberman.Board;
import uet.oop.bomberman.CreateMap;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.Keyboard;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.tile.BrickTile;
import uet.oop.bomberman.entities.tile.GrassTile;
import uet.oop.bomberman.entities.tile.WallTile;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.gui.Frame;

public class test {

    Board board = new Board();

    public test() {

        board.changeLevel(1);
    }

    public static void main(String[] args) {
        test t = new test();
        double xa = 1, ya = 0;
        double x = 1 * 16, y = 1 * 16;
        for (int c = 0; c < 4; c++) {
            double xt = ((x + xa) + c % 2 * 14 + 3) / Game.TILES_SIZE;
            double yt = ((y + ya) + c * 1.0 / 2 * 12 - 19) / Game.TILES_SIZE;
            Entity e = t.board.getEntity(xt, yt);
            if (e instanceof WallTile) {
                System.out.println((int) xt + " " + (int) yt);
                System.out.println(e.checkcollision(e));
            }
        }
    }
}
