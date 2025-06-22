package structure.conditions.BaseStateConditions;

import structure.conditions.Comparison;
import structure.conditions.Condition;
import structure.conditions.UnilateralStateCondition;
import structure.states.AliveState;
import structure.states.DeadState;

public class BaseReproductionCondition extends UnilateralStateCondition {

    /**
     *
     * @param numberOfAliveNeighbours: number of alive neighbours at which the cell state will be changed to alive
     */
    public BaseReproductionCondition(int numberOfAliveNeighbours) {
        super(DeadState.getInstance(), new Condition(AliveState.getInstance(), numberOfAliveNeighbours, Comparison.EQUALS), AliveState.getInstance());
        this.setName("Birth condition");
    }
}
