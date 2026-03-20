package structure.neighbourhood;

import structure.boards.Board;

/* This abstract class defines the comportement of a Neighbourhood - and identify each instance of Neighbourhoods through an id. */
public abstract class AbstractNeighbourhood {
    private int id;
    protected static int nextId = 0;

    public AbstractNeighbourhood(){
        this.id = nextId;
        nextId++;
    }

    public int getId(){
        return this.id;
    }

    public abstract void setNeighbours(Board board);

    @Override
    public boolean equals(Object other){
        if ((getClass() != other.getClass()) || this.getId() != ((AbstractNeighbourhood)other).getId()) return false;
        return true;
    }
    
}
