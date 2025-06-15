package structure.Boards;

import structure.Board;
import structure.conditions.StateCondition;
import java.util.Set;

public class DeadBoard extends Board {

    public DeadBoard(int width, int height, double initializingRatio, Set<StateCondition> rules) {
        super(width, height, initializingRatio, rules);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                getCell(i, j).death();
            }
        }
    }

}
