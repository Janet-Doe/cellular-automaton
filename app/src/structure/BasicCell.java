package structure;

import java.util.Random;
import java.util.Set;

import changes.statechange.AbstractStateChange;

public class BasicCell extends Cell {
    public BasicCell() {
        super();
    }

    public BasicCell(double initializingRatio, Random seed) {
        super(initializingRatio, seed);
    }

    public BasicCell(double initializingRatio, Random seed, Set<AbstractStateChange> rules) {
        super(initializingRatio, seed, rules);
    }
}
