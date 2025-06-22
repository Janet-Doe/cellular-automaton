package structure.boards;

import structure.Board;
import structure.Cell;
import structure.conditions.BaseStateConditions.*;
import java.util.HashSet;
import java.util.Set;

public class TestBoard extends Board {

    public TestBoard(int width, int height, double initializingRatio) {
        super(width, height, initializingRatio);
        this.addCondition(new BaseUnderpopulationCondition(1));
        this.addCondition(new BaseReproductionCondition(3));
        this.addCondition(new BaseOverpopulationCondition(4));
        for (int x = 0; x < height; x++) {
            int y = 0;
            for (Cell cell : this.getCells().get(x)) {
                Set<Cell> neighbours = new HashSet<>();
                try{neighbours.add(this.getCell(x-1, y-1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x-1, y));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x-1, y+1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x, y-1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x, y+1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x+1, y-1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x+1, y));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x+1, y+1));} catch (Exception ignored) {}
                cell.setNeighbours(neighbours);
                y++;

            }
        }
    }
}
