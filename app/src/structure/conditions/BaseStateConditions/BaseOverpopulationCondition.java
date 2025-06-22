package structure.conditions.BaseStateConditions;

import structure.conditions.UnilateralStateCondition;
import structure.conditions.Comparison;
import structure.conditions.Condition;
import structure.states.AliveState;
import structure.states.DeadState;

public class BaseOverpopulationCondition extends UnilateralStateCondition {

    public BaseOverpopulationCondition(int upperBound) {
        super(AliveState.getInstance(), new Condition(AliveState.getInstance(), upperBound, Comparison.GREATER), DeadState.getInstance());
        this.setName("Overpopulation condition");
    }
}