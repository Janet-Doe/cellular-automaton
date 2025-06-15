package structure;

import structure.conditions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Cell {
    private HashMap<Integer, State> state = new HashMap<>();
    private int age = 0;
    private Set<Cell> neighbours = new HashSet<>();

    public Cell(){
        this.state.put(0, State.DEAD);
    }

    public Cell(State state) {
        this.state.put(0, state);
    }

    public Cell(double ratio, Random seed){
        if (seed.nextInt(100)+1 > ratio*100) this.state.put(0, State.DEAD);
        else this.state.put(0, State.LIVING);
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

    public State getStateAtTime(int time){
        return state.get(time);
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

    public Set<Cell> getLivingNeighbours(){
        return getLivingNeighbours(this.age);
    }

    public Set<Cell> getLivingNeighbours(int tick) {
        HashSet<Cell> livingNeighbours = new HashSet<>();
        for (Cell neighbour : this.neighbours) {
            if (neighbour.getStateAtTime(tick) == State.LIVING) {
                livingNeighbours.add(neighbour);
            }
        }
        return livingNeighbours;
    }

    public void tick(Set<StateCondition> rules){
        this.age++;
        updateState(rules);
    }

    public void updateState(Set<StateCondition> rules) {
        this.unchanged();
        for (StateCondition rule : rules) {
            State relevantState = rule.getFromState();
            if ((relevantState == this.getCurrentState()) || (relevantState == State.UNSPECIFIED)) {
                boolean relevant = true;
                for (Condition condition : rule.getConditions()) {
                    if (!this.validStateChange(condition)) relevant = false;
                }
                if (relevant) {
                    this.updateState(rule.getToState());
                }
            }
        }
    }

    private boolean validStateChange(Condition condition) {
        int livingNeighbours = getLivingNeighbours(this.age-1).size();
        int neighbours = getNeighbours().size();
        double ratio = (double)livingNeighbours / neighbours;
        double conditionRatio = condition.getRatio();
        return switch (condition.getComparison()) {
            case STRICTLY_LOWER -> ratio < conditionRatio;
            case LOWER -> ratio <= conditionRatio;
            case EQUALS -> ratio == conditionRatio;
            case GREATER -> ratio >= conditionRatio;
            case STRICTLY_GREATER -> ratio > conditionRatio;
        };
    }

    private void updateState(State newState) {
        this.state.put(age, newState);
    }

    public void birth() {
        this.state.put(age, State.LIVING);
    }

    public void death() {
        this.state.put(age, State.DEAD);
    }

    public void unchanged(){
        this.state.put(age, getStateAtTime(age-1));
    }

    public String toString(){
        return switch (this.getCurrentState()) {
            case LIVING -> " " + AnsiColor.color(AnsiColor.GREEN) + "X" + AnsiColor.color(AnsiColor.RESET) + " ";
            case DEAD -> " " + AnsiColor.color(AnsiColor.RED) + "0" + AnsiColor.color(AnsiColor.RESET) + " " ;
            default -> " 0 ";
        };
    }
}
