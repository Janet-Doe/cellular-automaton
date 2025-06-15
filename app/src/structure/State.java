package structure;

public enum State {
    LIVING,
    DEAD,
    UNSPECIFIED;

    public static String toString(State st){
       return st.name();
    }
}
