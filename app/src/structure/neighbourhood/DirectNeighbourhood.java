package structure.neighbourhood;

import java.util.HashSet;
import java.util.Set;

import structure.Cell;
import structure.boards.Board;

public class DirectNeighbourhood extends AbstractNeighbourhood{

    private static DirectNeighbourhood INSTANCE;
    
    private DirectNeighbourhood(){
        super();
    }

    public static DirectNeighbourhood getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DirectNeighbourhood();
        }
        return INSTANCE;
    }

    @Override
    public void setNeighbours(Board board) {
        for (int x = 0; x < board.getHeight(); x++) {
            int y = 0;
            for (Cell cell : board.getCells().get(x)) {
                Set<Cell> neighbours = new HashSet<>();
                try{neighbours.add(board.getCell(x-1, y-1));} catch (Exception ignored) {}
                try{neighbours.add(board.getCell(x-1, y));} catch (Exception ignored) {}
                try{neighbours.add(board.getCell(x-1, y+1));} catch (Exception ignored) {}
                try{neighbours.add(board.getCell(x, y-1));} catch (Exception ignored) {}
                try{neighbours.add(board.getCell(x, y+1));} catch (Exception ignored) {}
                try{neighbours.add(board.getCell(x+1, y-1));} catch (Exception ignored) {}
                try{neighbours.add(board.getCell(x+1, y));} catch (Exception ignored) {}
                try{neighbours.add(board.getCell(x+1, y+1));} catch (Exception ignored) {}
                cell.addNeighbours(neighbours, DirectNeighbourhood.getInstance());
                y++;
            }
        }
    }
}
