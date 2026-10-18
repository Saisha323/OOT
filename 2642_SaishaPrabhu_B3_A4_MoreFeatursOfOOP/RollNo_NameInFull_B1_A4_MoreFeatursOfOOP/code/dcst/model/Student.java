package dcst.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Member implements Cloneable, Notifiable {
    private static final long serialVersionUID = 1L;
    private String rollNo;
    private int admissionYear;
    private Programme programme;
    private List<Course> courses = new ArrayList<>();

    // Constructor initialising ALL attributes (feature 1)
    public Student(String name, String rollNo, int admissionYear, Programme programme) {
        super(name);
        this.rollNo = rollNo;
        this.admissionYear = admissionYear;
        this.programme = programme;
    }

    // Overloaded constructor (feature 7)
    public Student(String name, String rollNo) {
        this(name, rollNo, 2025, Programme.MCA);
    }

    public String getRollNo() { return rollNo; }
    public int getAdmissionYear() { return admissionYear; }
    public Programme getProgramme() { return programme; }
    public List<Course> getCourses() { return courses; }
    public void addCourse(Course c) { courses.add(c); }

    @Override public String role() { return "Student"; }

    @Override public String report() {
        return super.report() + " | Roll " + rollNo + " | " + programme + " | Batch " + admissionYear
                + " | Courses: " + courses;
    }

    @Override public String notifyMessage() {
        return "Dear " + name + ", please check the DCST notice board for ISA/SEA schedules.";
    }

    /** SHALLOW clone: copies fields, but the 'courses' list object is SHARED (feature 10). */
    @Override public Student clone() {
        try { return (Student) super.clone(); }
        catch (CloneNotSupportedException e) { throw new AssertionError(e); }
    }

    /** DEEP clone: new list AND new Course objects (feature 10). */
    public Student deepClone() {
        Student copy = clone();
        copy.courses = new ArrayList<>();
        for (Course c : courses) copy.courses.add(c.clone());
        return copy;
    }
}
