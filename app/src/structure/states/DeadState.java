package structure.states;

import structure.AnsiColor;

public class DeadState extends State {
    private static final DeadState instance;

    private DeadState(){
        super("DEAD", AnsiColor.WHITE, "0");
    }

    static {
        instance = new DeadState();
    }

    public static DeadState getInstance() {
        return instance;
    }
}
