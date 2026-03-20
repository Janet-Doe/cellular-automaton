package changes.statechange;

import changes.comparison.EqualComparison;
import changes.condition.Condition;
import structure.neighbourhood.DirectNeighbourhood;
import structure.states.AliveState;

public class BaseReproductionConditionStateChange extends AbstractStateChange {

    public BaseReproductionConditionStateChange() {
                super(AliveState.getInstance(), new Condition(DirectNeighbourhood.getInstance(), 
            AliveState.getInstance(), 
            new EqualComparison(3)));
    }
    
}
