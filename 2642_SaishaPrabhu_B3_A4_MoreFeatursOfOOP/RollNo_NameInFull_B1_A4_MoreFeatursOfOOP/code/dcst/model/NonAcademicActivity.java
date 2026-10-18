package dcst.model;

public class NonAcademicActivity extends Activity {
    private static final long serialVersionUID = 1L;
    private final String theme;

    public NonAcademicActivity(String name, int year, int participants, String theme) {
        super(name, year, participants, ActivityType.NON_ACADEMIC);
        this.theme = theme;
    }

    @Override public String describe() {
        return theme + " event with " + participants + " participants";
    }

    @Override public String notifyMessage() {   // overriding with own wording
        return "Get ready! " + name + " " + year + " is coming up - register now!";
    }
}
