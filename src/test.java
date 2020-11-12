import uet.oop.bomberman.Board;
import uet.oop.bomberman.CreateMap;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.Keyboard;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.gui.Frame;

public class test {

    Board board = new Board();

    public test() {

        board.changeLevel(1);
    }

    public static void main(String[] args) {
        test t = new test();
        double xa = 1.8, ya = 0;
        double x = 2, y = 1;
        for (int c = 0; c < 4; c++) {
            double xt = ((x + xa) + c % 2 * 14 + 3.5) / Game.TILES_SIZE;
            double yt = ((y + ya) + c / 2 * 12 - 16) / Game.TILES_SIZE;
            System.out.println(xt + " " + yt);
            System.out.println(t.board.getEntity(xt, yt).getX() + " " + t.board.getEntity(xt, yt).getY() + "\n");
        }
    }
}
