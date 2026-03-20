package changes.comparison;

public abstract class ComparisonDecorator extends AbstractComparison{
    protected AbstractComparison comparison;

    public ComparisonDecorator(AbstractComparison comparison){
        this.comparison = comparison;
    }

    public ComparisonDecorator(){
        this.comparison = BaseTrueComparison.getInstance();
    }
    
}
