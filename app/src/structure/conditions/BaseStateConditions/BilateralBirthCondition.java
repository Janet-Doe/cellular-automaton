package structure.conditions.BaseStateConditions;

import structure.conditions.BilateralStateCondition;
import structure.conditions.Comparison;
import structure.conditions.Condition;
import structure.State;

public class BilateralBirthCondition extends BilateralStateCondition {

    /**
     *
     * @param lowerBound: lowest alive/neighbours ratio at which the cell state will be changed to alive
     * @param upperBound: greatest alive/neighbours ratio at which the cell state will be changed to alive
     */
    public BilateralBirthCondition(double lowerBound, double upperBound) {
        super(State.LIVING);
        this.getConditions().add(new Condition(lowerBound, Comparison.GREATER));
        this.getConditions().add(new Condition(upperBound, Comparison.LOWER));
        this.setName("Birth condition");
    }
}
