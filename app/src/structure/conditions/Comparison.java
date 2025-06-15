package structure.conditions;

public enum Comparison {
    STRICTLY_GREATER,
    GREATER,
    EQUALS,
    LOWER,
    STRICTLY_LOWER;

    public static String toString (Comparison c) {
        return switch (c) {
            case STRICTLY_GREATER -> "strictly greater than";
            case GREATER -> "greater than";
            case EQUALS -> "equivalent to";
            case LOWER -> "lower than";
            case STRICTLY_LOWER -> "strictly lower than";
        };
    }
}
