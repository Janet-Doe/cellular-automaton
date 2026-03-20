package changes.comparison;

public class LTComparison extends ComparisonDecorator {
    private int comparisonValue;

    public LTComparison(int comparisonValue){
        this.description = "[x <= " + comparisonValue + "]";
        this.comparisonValue = comparisonValue;
    }

    @Override
    public boolean compare(Object o) {
        if (!(o instanceof Number)){
            return false;
        }
        return ((int) o <= this.comparisonValue) && (this.comparison.compare(o));
    }
    
}
