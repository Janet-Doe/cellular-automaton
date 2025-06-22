package structure.states;

import structure.AnsiColor;

public abstract class State {
    private static final String UNDESCRIBED = null;
    private static int IDCOUNTER = 0;
    private final int id;
    private String name;
    private AnsiColor color;
    private String symbol;
    private String description = UNDESCRIBED;

    public State(String name, AnsiColor color, String symbol, String description) {
        this.name = name;
        this.color = color;
        this.symbol = symbol;
        this.description = description;
        this.id = IDCOUNTER++;
    }

    public State(String name, AnsiColor color, String symbol) {
        this.name = name;
        this.color = color;
        this.symbol = symbol;
        this.id = IDCOUNTER++;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setColor(AnsiColor color) {
        this.color = color;
    }

    public void setAppearance(String symbol, AnsiColor color) {
        this.symbol = symbol;
        this.color = color;
    }

    public int getId(){
        return id;
    }

    public String getIdentity() {
        return name + "(" + this + "):" + description;
    }

    public String print(){
       return AnsiColor.color(this.color) + this.symbol + AnsiColor.color(AnsiColor.RESET);
    }

    public String toString(){
        return name + "(" + print() + ")";
    }


    public boolean equals(State compared){
        return this.id == compared.getId();
    }


}
