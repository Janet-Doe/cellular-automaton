package structure.Boards;

import structure.Board;
import structure.Cell;
import structure.conditions.Comparison;
import structure.conditions.BaseStateConditions.*;
import java.util.HashSet;
import java.util.Set;

public class TestBoard extends Board {

    public TestBoard(int height, int width, double initializingRatio) {
        super(height, width, initializingRatio);
        this.addCondition(new UnilateralDeathCondition(0.2, Comparison.LOWER));
        this.addCondition(new UnilateralDeathCondition(0.8, Comparison.GREATER));
        this.addCondition(new BilateralBirthCondition(0.3, 0.7));
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Set<Cell> neighbours = new HashSet<>();
                try{neighbours.add(this.getCell(x-1, y-1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x-1, y));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x-1, y+1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x, y-1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x, y+1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x+1, y-1));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x+1, y));} catch (Exception ignored) {}
                try{neighbours.add(this.getCell(x+1, y+1));} catch (Exception ignored) {}
                this.getCell(x, y).setNeighbours(neighbours);

            }
        }
    }
}
