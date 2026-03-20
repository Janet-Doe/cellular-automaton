package changes.comparison;

public class BaseTrueComparison extends AbstractComparison{
    private static BaseTrueComparison INSTANCE;

    private BaseTrueComparison(){
        this.description = "";
    }

    public static BaseTrueComparison getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new BaseTrueComparison();
        }
        return INSTANCE;
    }

    @Override
    public boolean compare(Object o) {
        return true;
    }
    
}
