package structure.boards;

import java.util.Set;

import changes.statechange.AbstractStateChange;

public class DeadBoard extends Board {

    public DeadBoard(int width, int height, Set<AbstractStateChange> rules) {
        super(width, height, 0, rules);
    }

    public DeadBoard(int width, int height) {
        super(width, height, 0);
    }

}
