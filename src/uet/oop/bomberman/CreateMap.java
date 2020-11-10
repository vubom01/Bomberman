package uet.oop.bomberman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CreateMap {

    protected int width, height;
    protected char[][] map;
    protected Board board;

    public CreateMap() {
        for (int i)
    }

    public CreateMap(String path, Board board) throws FileNotFoundException {
        loadLevel(path);
        this.board = board;
    }

    public void loadLevel(String path) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(path));

    }
}
