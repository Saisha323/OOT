package dcst.model;

/** Enum (feature 2): programmes offered by the discipline. */
public enum Programme {
    MCA("Master of Computer Applications"),
    MSC_AI("M.Sc. Artificial Intelligence"),
    MSC_DS("M.Sc. Data Science");

    private final String fullName;
    Programme(String fullName) { this.fullName = fullName; }
    public String getFullName() { return fullName; }
}