package structure.conditions;

import structure.states.State;
import structure.states.UnspecifiedState;

import java.util.HashSet;
import java.util.Set;

public abstract class StateCondition {
    public static final String ANONYMOUS = null;
    private String name = ANONYMOUS;
    private State fromState = UnspecifiedState.getInstance();
    private State toState;
    private Set<Condition> conditions = new HashSet<>();

    public StateCondition(String name, State toState) {
        this.name = name;
        this.toState = toState;
    }

    public StateCondition(String name, State fromState, State toState) {
        this.name = name;
        this.fromState = fromState;
        this.toState = toState;
    }

    public StateCondition(State fromState, State toState) {
        this.fromState = fromState;
        this.toState = toState;
    }

    public StateCondition(State toState) {
        this.toState = toState;
    }

    public String getName(){
        return name;
    }

    public State getFromState(){
        return fromState;
    }

    public State getToState(){
        return toState;
    }

    public Set<Condition> getConditions(){
        return conditions;
    }

    public void addCondition(Condition condition) {
        conditions.add(condition);
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String name = this.getName();
        if (name.equals(ANONYMOUS)) {
            sb.append("Unnamed state condition: ");
        }
        else {
            sb.append(name).append(": ");
        }
        sb.append("cell");
        State fromState = getFromState();
        if (fromState instanceof UnspecifiedState) sb.append(" of state ").append(fromState);
        sb.append(" will turn to state ").append(this.getToState());
        sb.append(" if the following conditions are met :\n");
        for (Condition condition : this.conditions) {
            sb.append("   - ").append(condition).append("\n");
        }
        return sb.toString();
    }
}
