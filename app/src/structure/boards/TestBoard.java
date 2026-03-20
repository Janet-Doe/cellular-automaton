package structure.boards;

import structure.neighbourhood.DirectNeighbourhood;

import java.util.HashSet;
import java.util.Set;

import changes.statechange.*;

public class TestBoard extends Board {

    public TestBoard(int width, int height, double initializingRatio) {
        Set<AbstractStateChange> rules = new HashSet<>();
        rules.add(new BaseOverpopulationConditionStateChange());
        rules.add(new BaseUnderpopulationConditionStateChange());
        rules.add(new BaseReproductionConditionStateChange());
        super(width, height, initializingRatio, rules);
        DirectNeighbourhood.getInstance().setNeighbours(this);
    }
}
