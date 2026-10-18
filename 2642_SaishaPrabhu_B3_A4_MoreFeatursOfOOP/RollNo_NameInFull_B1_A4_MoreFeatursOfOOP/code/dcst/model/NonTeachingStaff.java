package dcst.model;

public class NonTeachingStaff extends Member {
    private static final long serialVersionUID = 1L;
    private final String post;

    public NonTeachingStaff(String name, String post) {
        super(name);
        this.post = post;
    }

    @Override public String role() { return "Non-Teaching: " + post; }
}
