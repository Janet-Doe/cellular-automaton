package changes.comparison;

public class GTComparison extends ComparisonDecorator {
    private int comparisonValue;

    public GTComparison(int comparisonValue){
        this.description = "[x >= " + comparisonValue + "]";
        this.comparisonValue = comparisonValue;
    }

    @Override
    public boolean compare(Object o) {
        if (!(o instanceof Number)){
            return false;
        }
        return ((int) o >= this.comparisonValue) && (this.comparison.compare(o));
    }
    
}
