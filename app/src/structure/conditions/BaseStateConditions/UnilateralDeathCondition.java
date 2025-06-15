package structure.conditions.BaseStateConditions;

import structure.conditions.Comparison;
import structure.conditions.Condition;
import structure.conditions.UnilateralStateCondition;
import structure.State;

public class UnilateralDeathCondition extends UnilateralStateCondition {

    public UnilateralDeathCondition(double ratio, Comparison comparison){
        super(State.DEAD, new Condition(ratio, comparison));
        this.setName("Death condition");
    }
}
