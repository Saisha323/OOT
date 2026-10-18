package dcst.model;

import java.io.Serializable;

/** Abstract class (feature 5). Subclasses describe themselves differently. */
public abstract class Activity implements Reportable, Notifiable, Serializable {
    private static final long serialVersionUID = 1L;
    protected final String name;
    protected final int year;
    protected final int participants;
    private final ActivityType type;

    protected Activity(String name, int year, int participants, ActivityType type) {
        this.name = name;
        this.year = year;
        this.participants = participants;
        this.type = type;
    }

    public int getYear() { return year; }
    public String getName() { return name; }
    public ActivityType getType() { return type; }

    public abstract String describe();

    @Override public String report() {
        return type.getLabel() + " | " + year + " | " + name + " -> " + describe();
    }

    @Override public String notifyMessage() { return "Reminder: " + name + " (" + year + ")"; }
}
