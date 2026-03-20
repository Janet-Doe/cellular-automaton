package changes.comparison;

public class SLTComparison extends ComparisonDecorator {
    private int comparisonValue;

    public SLTComparison(int comparisonValue){
        this.description = "Cell must be lower than ";
        this.comparisonValue = comparisonValue;
    }

    @Override
    public boolean compare(Object o) {
        if (!(o instanceof Number)){
            return false;
        }
        return ((int) o < this.comparisonValue) && (this.comparison.compare(o));
    }
    
}
