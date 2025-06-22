package structure.conditions;

import structure.states.State;

public abstract class UnilateralStateCondition extends StateCondition {

    public UnilateralStateCondition(Condition condition, State toState) {
        super(toState);
        this.addCondition(condition);
    }

    public UnilateralStateCondition(State fromState, Condition condition, State toState) {
        super(fromState, toState);
        this.addCondition(condition);
    }


}
