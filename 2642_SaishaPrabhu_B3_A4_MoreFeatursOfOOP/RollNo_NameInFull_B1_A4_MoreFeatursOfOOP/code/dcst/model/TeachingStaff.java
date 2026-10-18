package dcst.model;

/**
 * Feature 3: Java does NOT allow "extends A, B" (multiple implementation inheritance of state).
 * It allows multiple INTERFACE inheritance. Here Teacher and Researcher both define duties();
 * the class must resolve the conflict itself.
 */
public class TeachingStaff extends Member implements Teacher, Researcher, Notifiable {
    private static final long serialVersionUID = 1L;
    private final String designation;

    public TeachingStaff(String name, String designation) {
        super(name);
        this.designation = designation;
    }

    @Override public String duties() {
        return Teacher.super.duties() + " AND " + Researcher.super.duties();
    }

    @Override public String role() { return designation; }
    @Override public String notifyMessage() { return "Dear " + name + ", faculty meeting at 3 PM."; }
}
