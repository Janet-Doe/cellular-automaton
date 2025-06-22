import structure.Board;
import structure.boards.DeadBoard;
import structure.boards.LiveBoard;
import structure.boards.TestBoard;
import structure.Cell;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int height = 20;
        int width = 30;
        Board board = new TestBoard(width, height, 0.3);
        System.out.println(board);

        /*
        Random rd = new Random();
        for (int i = 0; i < 30; i++) {
            int x = rd.nextInt(20);
            int y = rd.nextInt(30);
            System.out.println(board.getCell(x, y).getStateAtTime(0) + " : " + board.getCell(x, y).getInitialState() + " : " + board.getCell(x, y).getCurrentState());
        }
         */


        for (int i = 1; i <= 5; i++) {
            System.out.println("Tick n°" + i + ":");
            board.clockTick();
        }

    }
}