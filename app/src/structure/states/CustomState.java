package structure.states;

import structure.AnsiColor;

public class CustomState extends State{
    public CustomState(String name, AnsiColor color, String symbol, String description){
        super(name, color, symbol, description);
    }

    public CustomState(String name, AnsiColor color, String symbol){
        super(name, color, symbol);
    }
}
