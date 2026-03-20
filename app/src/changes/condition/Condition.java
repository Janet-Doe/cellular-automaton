package changes.condition;

import changes.comparison.ComparisonDecorator;
import structure.Cell;
import structure.neighbourhood.AbstractNeighbourhood;
import structure.states.State;

public class Condition extends AbstractCondition {

    public Condition(AbstractNeighbourhood neighborhood, State neighbourState, ComparisonDecorator comparison) {
        super(neighborhood, neighbourState, comparison);
    }

    @Override
    public boolean appliable(Cell cell) {
        throw new UnsupportedOperationException("Unimplemented method 'appliable'");
    }
    
}
