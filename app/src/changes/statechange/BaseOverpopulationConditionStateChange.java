package changes.statechange;

import changes.comparison.GTComparison;
import changes.condition.Condition;
import structure.neighbourhood.DirectNeighbourhood;
import structure.states.AliveState;
import structure.states.DeadState;

public class BaseOverpopulationConditionStateChange extends AbstractStateChange {

    public BaseOverpopulationConditionStateChange() {
        super(DeadState.getInstance(), new Condition(DirectNeighbourhood.getInstance(), 
            AliveState.getInstance(), 
            new GTComparison(3)));
    }    
}
