package structure;

import structure.conditions.*;
import structure.states.AliveState;
import structure.states.DeadState;
import structure.states.State;
import structure.states.UnspecifiedState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Cell {
    private HashMap<Integer, State> state = new HashMap<>();
    private int age = 0;
    private Set<Cell> neighbours = new HashSet<>();

    public Cell(){
        this.state.put(0, AliveState.getInstance());
    }

    public Cell(State state) {
        this.state.put(0, state);
    }

    public Cell(double ratio, Random seed){
        if (seed.nextInt(100)+1 > ratio*100) this.state.put(0, DeadState.getInstance());
        else this.state.put(0, AliveState.getInstance());
    }

    public State getCurrentState() {
        return getStateAtTime(age);
    }

    public State getInitialState(){
        return getStateAtTime(0);
    }

    public HashMap<Integer, State> getStates(){
        return state;
    }

    public State getStateAtTime(int tick){
        return state.get(tick);
    }

    public int getAge() {
        return age;
    }

    public Set<Cell> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Set<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Cell neighbour) {
        this.neighbours.add(neighbour);
    }

    public void addNeighbours(Set<Cell> neighbours) {
        this.neighbours.addAll(neighbours);
    }

    public Set<Cell> getNeighboursOfState(State state, int tick){
        HashSet<Cell> livingNeighbours = new HashSet<>();
        if (state == null) {

        }
        for (Cell neighbour : this.neighbours) {
            if (neighbour.getStateAtTime(tick).equals(state)) {
                livingNeighbours.add(neighbour);
            }
        }
        return livingNeighbours;
    }

    public void tick(Set<StateCondition> rules){
        // System.out.println("Previous tick: " + this.getCurrentState());
        age++;
        updateState(rules);
    }

    private void updateState(Set<StateCondition> rules) {
        this.unchanged();
        for (StateCondition rule : rules) {
            boolean isRuleRelevantToThisCell = false;
            State relevantStateForRule = rule.getFromState();
            State stateOfCellAtPreviousTick = this.getStateAtTime(age-1);

            //System.out.println("Checking if cell state can be changed by rule: " + rule);

            if ( (relevantStateForRule == null)
                    || ( relevantStateForRule.equals(stateOfCellAtPreviousTick) )
                    || ( relevantStateForRule.equals(UnspecifiedState.getInstance()) )
                    || ( stateOfCellAtPreviousTick.equals(UnspecifiedState.getInstance()) ) ) {
                //System.out.println("The previous state of this cell meet the conditions of this rule. Checking neighbours.");
                isRuleRelevantToThisCell = true;
                for (Condition condition : rule.getConditions()) {
                    if (! this.isValidStateChange(condition))
                    {
                        isRuleRelevantToThisCell = false;
                        //System.out.println("The condition " + condition + " is not met.");
                    }
                }
            }
            if (isRuleRelevantToThisCell) {
                this.updateState(rule.getToState());
                //System.out.println("State updated.");
            }
        }
        /*
        System.out.println("Final state for this cell for tick " + this.age + ": " + this.getCurrentState());
        System.out.println("\n\n");
        */
    }

    private boolean isValidStateChange(Condition condition) {
        State stateToCheckAmongNeighbours = condition.getStateOfNeighboursToCheckConditionOn();
        int concernedNeighbours;
        if (stateToCheckAmongNeighbours instanceof UnspecifiedState) {
            concernedNeighbours = getNeighbours().size();
        }
        else {
            concernedNeighbours = getNeighboursOfState(stateToCheckAmongNeighbours, this.age-1).size()
                            + getNeighboursOfState(UnspecifiedState.getInstance(), this.age-1).size();
        }
        int conditionValue = condition.getValue();
        return switch (condition.getComparison()) {
            case STRICTLY_LOWER -> concernedNeighbours < conditionValue;
            case LOWER -> concernedNeighbours <= conditionValue;
            case EQUALS -> concernedNeighbours == conditionValue;
            case GREATER -> concernedNeighbours >= conditionValue;
            case STRICTLY_GREATER -> concernedNeighbours > conditionValue;
        };
    }

    private void updateState(State newState) {
        this.state.put(age, newState);
    }

    public void birth() {
        this.state.put(age, AliveState.getInstance());
    }

    public void death() {
        this.state.put(age, DeadState.getInstance());
    }

    public void unchanged(){
        this.state.put(age, getStateAtTime(age-1));
    }

    public String toString(){
        return " " + this.getCurrentState().print() + " ";
    }
}
