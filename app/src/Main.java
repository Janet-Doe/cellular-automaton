import structure.Board;
import structure.Boards.TestBoard;

public class Main {
    public static void main(String[] args) {
        TestBoard board = new TestBoard(30, 10, 0.33);
        System.out.println(board);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Tick n°" + i + ":");
            board.clockTick();
        }
    }
}