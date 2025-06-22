package structure.boards;

import structure.Board;
import structure.Cell;
import structure.conditions.StateCondition;
import java.util.Set;

public class DeadBoard extends Board {

    public DeadBoard(int width, int height, Set<StateCondition> rules) {
        super(width, height, 0, rules);
        for (int i = 0; i < height; i++) {
            for (Cell cell : this.getCells().get(i)) {
                cell.death();
            }
        }
    }

    public DeadBoard(int width, int height) {
        super(width, height, 0);
        for (int i = 0; i < height; i++) {
            for (Cell cell : this.getCells().get(i)) {
                cell.death();
            }
        }
    }

}
