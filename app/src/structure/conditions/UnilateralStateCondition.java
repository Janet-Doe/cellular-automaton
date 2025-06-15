package structure.conditions;

import structure.State;

public abstract class UnilateralStateCondition extends StateCondition {

    public UnilateralStateCondition(State toState, Condition condition) {
        super(toState);
        this.addCondition(condition);
    }
}
