package structure.neighbourhood;

import structure.Cell;
import structure.boards.Board;

/*
SelfNeighbourhood defines the cell neighbourhood composed of the cell itself.
*/
public class SelfNeighbourhood extends AbstractNeighbourhood {

    private static SelfNeighbourhood INSTANCE;
    
    private SelfNeighbourhood(){
        super();
    }

    public static SelfNeighbourhood getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SelfNeighbourhood();
        }
        return INSTANCE;
    }

    @Override
    public void setNeighbours(Board board) {
        for (int x = 0; x < board.getHeight(); x++) {
            for (Cell cell : board.getCells().get(x)) {
                cell.addNeighbour(cell, SelfNeighbourhood.getInstance());
            }
        }
    }
    
}
