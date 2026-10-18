package dcst.model;

/** Enum (feature 2). */
public enum ActivityType {
    ACADEMIC("Academic"), NON_ACADEMIC("Non-Academic");

    private final String label;
    ActivityType(String label) { this.label = label; }
    public String getLabel() { return label; }
}
