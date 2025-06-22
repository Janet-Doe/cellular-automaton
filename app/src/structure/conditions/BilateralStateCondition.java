package structure.conditions;

import structure.states.State;

public abstract class BilateralStateCondition extends StateCondition {

    public BilateralStateCondition(State toState, Condition lower, Condition upper, String name) {
        super(name, toState);
        this.addCondition(lower);
        this.addCondition(upper);
    }

    public BilateralStateCondition(State toState, Condition lower, Condition upper) {
        super(toState);
        this.addCondition(lower);
        this.addCondition(upper);
    }

    public BilateralStateCondition(State state) {
        super(state);
    }
}
