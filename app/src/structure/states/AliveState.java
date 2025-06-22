package structure.states;

import structure.AnsiColor;

public class AliveState extends State{
    private static final AliveState instance;

    private AliveState(){
        super("ALIVE", AnsiColor.BLACK, "X");
    }

    static {
        instance = new AliveState();
    }

    public static AliveState getInstance() {
        return instance;
    }
}
