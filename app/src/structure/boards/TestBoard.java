package structure.boards;

import structure.Cell;
import structure.neighbourhood.DirectNeighbourhood;

import java.util.HashSet;
import java.util.Set;

import changes.statechange.*;

public class TestBoard extends Board {

    public TestBoard(int width, int height, double initializingRatio) {
        Set<AbstractStateChange> rules = new HashSet<>();
        rules.add(new BaseOverpopulationConditionStateChange());
        rules.add(new BaseUnderpopulationConditionStateChange());
        rules.add(new BaseReproductionConditionStateChange());
        super(width, height, initializingRatio, rules);
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
                cell.addNeighbours(neighbours, DirectNeighbourhood.getInstance());
                y++;

            }
        }
    }
}
