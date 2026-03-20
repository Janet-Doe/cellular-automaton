import structure.boards.Board;
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

        /*
        Board deadBoard = new DeadBoard(width, height);
        System.out.println(deadBoard);
        */

        /*
        Board liveBoard = new LiveBoard(width, height);
        System.out.println(liveBoard);
        */
        
        Board testBoard = new TestBoard(width, height, 0.3);
        System.out.println(testBoard);

        /*
        Random rd = new Random();
        for (int i = 0; i < 30; i++) {
            int x = rd.nextInt(20);
            int y = rd.nextInt(30);
            System.out.println(testBoard.getCell(x, y).getStateAtTime(0) + " : " + 
            testBoard.getCell(x, y).getInitialState() + " : " + testBoard.getCell(x, y).getCurrentState());
        }
         */


        for (int i = 1; i <= 5; i++) {
            System.out.println("Tick n°" + i + ":");
            testBoard.clockTick();
        }

    }
}