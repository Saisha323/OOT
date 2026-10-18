package dcst.model;

import java.io.Serializable;
import java.util.Objects;

/** A course/subject taught at DCST. Cloneable so deep cloning can copy it. */
public class Course implements Serializable, Cloneable, Reportable, Comparable<Course> {
    private static final long serialVersionUID = 1L;
    private final String code;
    private String name;
    private final int credits;
    private final Programme programme;

    public Course(String code, String name, int credits, Programme programme) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.programme = programme;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCredits() { return credits; }
    public Programme getProgramme() { return programme; }

    @Override public String report() {
        return code + " - " + name + " (" + credits + " credits, " + programme + ")";
    }

    @Override public Course clone() {
        try { return (Course) super.clone(); }
        catch (CloneNotSupportedException e) { throw new AssertionError(e); }
    }

    @Override public int compareTo(Course o) { return code.compareTo(o.code); }
    @Override public boolean equals(Object o) { return o instanceof Course c && c.code.equals(code); }
    @Override public int hashCode() { return Objects.hash(code); }
    @Override public String toString() { return code; }
}
