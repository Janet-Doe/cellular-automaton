package changes.condition;

import changes.comparison.ComparisonDecorator;
import structure.Cell;
import structure.neighbourhood.AbstractNeighbourhood;
import structure.states.State;

public abstract class AbstractCondition {
    protected AbstractNeighbourhood neighborhood;
    protected State neighbourState;
    protected ComparisonDecorator comparison;

    public AbstractCondition(AbstractNeighbourhood neighborhood, State neighbourState, ComparisonDecorator comparison){
        this.neighborhood = neighborhood;
        this.neighbourState = neighbourState;
        this.comparison = comparison;
    }

    public AbstractNeighbourhood getNeighborhood(){
        return this.neighborhood;
    }

    public State getNeighbourState(){
        return this.neighbourState;
    }

    public ComparisonDecorator getComparison(){
        return this.comparison;
    }

    public abstract boolean appliable(Cell cell);
}