package structure.boards;

import structure.Board;
import structure.Cell;
import structure.conditions.StateCondition;
import java.util.Set;

public class LiveBoard extends Board {
    public LiveBoard(int width, int height, Set<StateCondition> rules) {
        super(width, height, 1, rules);
        for (int i = 0; i < height; i++) {
            for (Cell cell : this.getCells().get(i)) {
                cell.birth();
            }
        }
    }

    public LiveBoard(int width, int height) {
        super(width, height, 1);
        for (int i = 0; i < height; i++) {
            for (Cell cell : this.getCells().get(i)) {
                cell.birth();
            }
        }
    }
}
