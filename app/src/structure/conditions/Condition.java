package structure.conditions;

public class Condition {
    private double ratio;
    private Comparison comparison;

    public Condition(double ratio, Comparison comparison) {
        this.ratio = ratio;
        this.comparison = comparison;
    }

    public double getRatio() {
        return ratio;
    }

    public Comparison getComparison() {
        return comparison;
    }

    public String toString() {
        return comparison + " " + ratio;
    }

}
