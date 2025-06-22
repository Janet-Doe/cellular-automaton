package structure.conditions.BaseStateConditions;

import structure.conditions.UnilateralStateCondition;
import structure.conditions.Comparison;
import structure.conditions.Condition;
import structure.states.AliveState;
import structure.states.DeadState;

public class BaseUnderpopulationCondition extends UnilateralStateCondition {

    public BaseUnderpopulationCondition(int lowerBound) {
        super(AliveState.getInstance(), new Condition(AliveState.getInstance(), lowerBound, Comparison.LOWER), DeadState.getInstance());
        this.setName("Underpopulation condition");
    }
}
