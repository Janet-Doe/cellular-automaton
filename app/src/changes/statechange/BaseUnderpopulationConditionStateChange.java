package changes.statechange;

import changes.comparison.LTComparison;
import changes.condition.Condition;
import structure.neighbourhood.DirectNeighbourhood;
import structure.states.AliveState;
import structure.states.DeadState;

public class BaseUnderpopulationConditionStateChange extends AbstractStateChange{

    public BaseUnderpopulationConditionStateChange() {
        super(DeadState.getInstance(), new Condition(DirectNeighbourhood.getInstance(), 
            AliveState.getInstance(), 
            new LTComparison(2)));
    }
    
}
