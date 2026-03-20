package changes.comparison;

public class SGTComparison extends ComparisonDecorator {
    private int comparisonValue;

    public SGTComparison(int comparisonValue){
        this.description = "[x > " + comparisonValue + "]";
        this.comparisonValue = comparisonValue;
    }

    @Override
    public boolean compare(Object o) {
        if (!(o instanceof Number)){
            return false;
        }
        return ((int) o > this.comparisonValue) && (this.comparison.compare(o));
    }
    
}
