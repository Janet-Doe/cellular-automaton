package structure.states;

import structure.AnsiColor;

public class UnspecifiedState extends State{
    private static final UnspecifiedState instance;

    private UnspecifiedState(){
        super("UNSPECIFIED", AnsiColor.RESET, ".");
    }

    static {
        instance = new UnspecifiedState();
    }

    public static UnspecifiedState getInstance() {
        return instance;
    }
}
