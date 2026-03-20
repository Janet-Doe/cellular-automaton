package changes.comparison;

public class EqualComparison extends ComparisonDecorator{
    private int comparisonValue;

    public EqualComparison(int value){
        this.description = "[x =" + value + "]";
        this.comparisonValue = value;
        this.comparison = BaseTrueComparison.getInstance();
    }

    @Override
    public boolean compare(Object o) {
        if (!(o instanceof Number)){
            return false;
        }
        return ((int) o == this.comparisonValue);
    }

    @Override
    public String toString(){
        return description + this.comparisonValue;
    }


    
}
