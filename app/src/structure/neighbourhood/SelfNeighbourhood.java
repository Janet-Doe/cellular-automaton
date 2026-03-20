package structure.neighbourhood;

/*
SelfNeighbourhood defines the cell neighbourhood composed of the cell itself.
*/
public class SelfNeighbourhood extends AbstractNeighbourhood {

    private static SelfNeighbourhood INSTANCE;
    
    private SelfNeighbourhood(){
        super();
    }

    public static SelfNeighbourhood getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SelfNeighbourhood();
        }
        return INSTANCE;
    }
    
}
