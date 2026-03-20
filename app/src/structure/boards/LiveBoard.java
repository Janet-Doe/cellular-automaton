package structure.boards;

import java.util.Set;

import changes.statechange.AbstractStateChange;

public class LiveBoard extends Board {
    public LiveBoard(int width, int height, Set<AbstractStateChange> rules) {
        super(width, height, 1, rules);
    }

    public LiveBoard(int width, int height) {
        super(width, height, 1);
    }
}
