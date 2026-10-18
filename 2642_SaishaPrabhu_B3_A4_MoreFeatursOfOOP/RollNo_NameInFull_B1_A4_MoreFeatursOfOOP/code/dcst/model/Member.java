package dcst.model;

import java.io.Serializable;

/** Abstract base class (feature 5) for everyone who belongs to DCST. */
public abstract class Member implements Reportable, Serializable {
    private static final long serialVersionUID = 1L;

    private static int count = 0;          // static counter (feature 2)

    private final int id;                  // private  : only Member
    protected String name;                 // protected: Member + subclasses (+ same package)

    protected Member(String name) {
        this.name = name;
        this.id = ++count;                 // every new member bumps the counter
    }

    public static int getCount() { return count; }
    public static void displayCount() {    // static method (feature 2)
        System.out.println("Total members created so far: " + count);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /** Each subclass implements this differently (feature 5). */
    public abstract String role();

    @Override public String report() { return "[" + role() + " #" + id + "] " + name; }
}
