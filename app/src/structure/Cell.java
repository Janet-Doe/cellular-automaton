package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import structure.neighbourhood.AbstractNeighbourhood;
import structure.states.AliveState;
import structure.states.DeadState;
import structure.states.State;

import changes.statechange.AbstractStateChange;
import changes.condition.AbstractCondition;


public abstract class Cell {
    private ArrayList<State> stateHistory = new ArrayList<>();
    private HashSet<AbstractStateChange> stateChanges = new HashSet<>();
    private int age = 0;
    private HashMap<AbstractNeighbourhood, Set<Cell>> neighbours = new HashMap<>();

    public Cell(){
        this.stateHistory.add(AliveState.getInstance());
    }

    public Cell(Set<AbstractStateChange> rules){
        this.stateHistory.add(AliveState.getInstance());
        this.stateChanges.addAll(rules);
    }

    public Cell(State state) {
        this.stateHistory.add(state);
    }

    public Cell(State state, Set<AbstractStateChange> rules) {
        this.stateHistory.add(state);
        this.stateChanges.addAll(rules);
    }

    public Cell(double ratio, Random seed){
        if (seed.nextInt(100)+1 > ratio*100) this.stateHistory.add(DeadState.getInstance());
        else this.stateHistory.add(AliveState.getInstance());
    }

    public Cell(double ratio, Random seed, Set<AbstractStateChange> rules){
        if (seed.nextInt(100)+1 > ratio*100) this.stateHistory.add(DeadState.getInstance());
        else this.stateHistory.add(AliveState.getInstance());
        this.stateChanges.addAll(rules);
    }

    public State getCurrentState() {
        return getStateAtTime(age);
    }

    public State getInitialState(){
        return getStateAtTime(0);
    }

    public ArrayList<State> getStateHistory(){
        return stateHistory;
    }

    public State getStateAtTime(int tick){
        return stateHistory.get(tick);
    }

    public int getAge() {
        return age;
    }

    public HashMap<AbstractNeighbourhood, Set<Cell>> getAllNeighbours(){
        return this.neighbours;
    }

    public Set<Cell> getNeighbourhood(AbstractNeighbourhood neighbourhood){
        return this.neighbours.containsKey(neighbourhood) ? this.neighbours.get(neighbourhood) : new HashSet<>() ;
    }

    public void addNeighbour(Cell cell, AbstractNeighbourhood neighbourhood) {
        if (this.neighbours.containsKey(neighbourhood)){
            this.neighbours.get(neighbourhood).add(cell);
        }
        else {
            Set<Cell> list = new HashSet<>();
            list.add(cell);
            this.neighbours.put(neighbourhood,list);
        }
        
    }

    public void addNeighbours(Set<Cell> neighbours, AbstractNeighbourhood neighbourhood) {
        this.neighbours.get(neighbourhood).addAll(neighbours);
    }

    public Set<Cell> getNeighboursOfState(State state, AbstractNeighbourhood neighbourhood, int tick){
        HashSet<Cell> livingNeighbours = new HashSet<>();
        for (Cell neighbour : this.neighbours.get(neighbourhood)) {
            if (neighbour.getStateAtTime(tick).equals(state)) {
                livingNeighbours.add(neighbour);
            }
        }
        return livingNeighbours;
    }

    public void tick(){
        // System.out.println("Previous tick: " + this.getCurrentState());
        age++;
        updateState();
        System.out.println("Tick " + this.age + ": " + this.stateHistory.get(age));
    }

    private void updateState() {
        this.unchanged();
        for (AbstractStateChange rule : this.stateChanges) {
            boolean appliable = true;

            for (AbstractCondition condition: rule.getConditions()){
                appliable = appliable && condition.appliable(this);
            }

            if (appliable){
                this.stateHistory.add(rule.getChangedState());
            }
        }
        /*
        System.out.println("Final state for this cell for tick " + this.age + ": " + this.getCurrentState());
        System.out.println("\n\n");
        */
    }


    //basic state changes :
    public void birth() {
        this.stateHistory.add(AliveState.getInstance());
    }

    public void death() {
        this.stateHistory.add(DeadState.getInstance());
    }

    public void unchanged(){
        this.stateHistory.add(getStateAtTime(age-1));
    }

    public String toString(){
        return " " + this.getCurrentState().print() + " ";
    }
}
