package structure.conditions;

import structure.states.State;
import structure.states.UnspecifiedState;

public class Condition {
    private State stateOfNeighboursToCheckConditionOn = UnspecifiedState.getInstance();
    private int value;
    private Comparison comparison;

    public Condition(State stateOfNeighbours, int value, Comparison comparison) {
        this.stateOfNeighboursToCheckConditionOn = stateOfNeighbours;
        this.value = value;
        this.comparison = comparison;
    }

    public Condition(int value, Comparison comparison) {
        this.value = value;
        this.comparison = comparison;
    }

    public State getStateOfNeighboursToCheckConditionOn() {
        return stateOfNeighboursToCheckConditionOn;
    }

    public int getValue() {
        return value;
    }

    public Comparison getComparison() {
        return comparison;
    }

    public String toString() {
        return stateOfNeighboursToCheckConditionOn + " neighbours " + comparison + " " + value;
    }

}
