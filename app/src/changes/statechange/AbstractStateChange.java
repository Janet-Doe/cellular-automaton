package changes.statechange;

import java.util.ArrayList;

import changes.condition.AbstractCondition;
import structure.states.State;

public abstract class AbstractStateChange {
    protected State changedState;
    protected ArrayList<AbstractCondition> conditions = new ArrayList<>();

    public AbstractStateChange(State changedState, ArrayList<AbstractCondition> conditions){
        this.changedState = changedState;
        this.conditions.addAll(conditions);
    }

    public AbstractStateChange(State changedState, AbstractCondition condition){
        this.changedState = changedState;
        this.conditions.add(condition);
    }

    public State getChangedState(){
        return this.changedState;
    }

    public ArrayList<AbstractCondition> getConditions(){
        return this.getConditions();
    }
    
}
