package dcst.model;

public class AcademicActivity extends Activity {
    private static final long serialVersionUID = 1L;
    private final String category;

    public AcademicActivity(String name, int year, int participants, String category) {
        super(name, year, participants, ActivityType.ACADEMIC);
        this.category = category;
    }

    @Override public String describe() {
        return category + " conducted for " + participants + " students";
    }
}
