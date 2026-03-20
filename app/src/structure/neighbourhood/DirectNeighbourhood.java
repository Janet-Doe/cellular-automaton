package structure.neighbourhood;

public class DirectNeighbourhood extends AbstractNeighbourhood{

    private static DirectNeighbourhood INSTANCE;
    
    private DirectNeighbourhood(){
        super();
    }

    public static DirectNeighbourhood getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DirectNeighbourhood();
        }
        return INSTANCE;
    }
}
