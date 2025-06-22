package structure;

import structure.conditions.StateCondition;
import java.util.*;

public abstract class Board {
    private ArrayList<ArrayList<Cell>> cells;
    private final int height;
    private final int width;
    private Set<StateCondition> conditions = new HashSet<>();
    private final Random seed = new Random();
    private int age = 0;

    public Board(int width, int height, double initializingRatio, Set<StateCondition> conditions) {
        this.width = width;
        this.height = height;
        this.conditions.addAll(conditions);
        buildBoard(initializingRatio);
    }

    public Board(int width, int height, double initializingRatio) {
        this.height = height;
        this.width = width;
        buildBoard(initializingRatio);
    }

    public void buildBoard(double initializingRatio) {
        this.cells = new ArrayList<>();
        for (int x = 0; x < height; x++) {
            ArrayList<Cell> line = new ArrayList<>();
            for (int y = 0; y < width; y++) {
                line.add(new BasicCell(initializingRatio, this.seed));
            }
            this.cells.add(line);
        }
    }

    public void addCondition(StateCondition condition) {
        conditions.add(condition);
    }

    public void addConditions(Set<StateCondition> conditions) {
        this.conditions.addAll(conditions);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<ArrayList<Cell>> getCells() {
        return cells;
    }

    public Cell getCell(int line, int column) {
        return cells.get(line).get(column);
    }

    public void clockTick(){
        this.age++;
        for (int x = 0; x < height; x++) {
            int i = 0;
            for (Cell cell : this.getCells().get(x)) {
                //System.out.println("UPDATING CELL (" + x + " ; " + i++ + ")");
                cell.tick(this.conditions);
            }
        }
        System.out.println(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < height; x++) {
            int y = 0;
            for (Cell cell : this.getCells().get(x))
                sb.append(cell);
            sb.append("\n");
        }
        return sb.toString();
    }
}
