package structure;

import structure.conditions.StateCondition;
import java.util.*;

public abstract class Board {
    private ArrayList<ArrayList<Cell>> cells;
    private final int height;
    private final int width;
    private Set<StateCondition> conditions = new HashSet<>();
    private Random seed = new Random();

    public Board(int height, int width, double initializingRatio, Set<StateCondition> conditions) {
        this.height = width;
        this.width = height;
        this.conditions.addAll(conditions);
        buildBoard(initializingRatio);
    }

    public Board(int height, int width, double initializingRatio) {
        this.height = width;
        this.width = height;
        buildBoard(initializingRatio);
    }

    public void buildBoard(double initializingRatio) {
        this.cells = new ArrayList<>();
        for (int x = 0; x < height; x++) {
            ArrayList<Cell> line = new ArrayList<>();
            this.cells.add(line);
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
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                this.getCell(x, y).tick(this.conditions);
            }
        }
        System.out.println(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                sb.append(getCell(x, y).toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
