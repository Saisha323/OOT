package dcst.app;

import dcst.model.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/** DCST, Goa University (GBS) - NIRF data model. Assignment 4: more features of OOP. */
public class Main {

    static List<Student> students = new ArrayList<>();
    static Registry<TeachingStaff> faculty = new Registry<>();
    static List<NonTeachingStaff> nonTeaching = new ArrayList<>();
    static Set<Course> courses = new TreeSet<>();
    static List<Activity> activities = new ArrayList<>();

    static void section(String title) {
        System.out.println("\n==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        setup();
        referencing();       // 1
        statics();           // 2
        inheritance();       // 3
        access();            // 4
        abstractDemo();      // 5
        messagePassing();    // 6
        polymorphism();      // 7
        genericsAndCollections(); // 8
        exceptions();        // 9
        reflectionIoCloning();    // 10
        nirfSummary();
    }

    static void setup() {
       Course c1 = new Course("CSA-5000", "Operating Systems", 4, Programme.MCA);
Course c2 = new Course("CSA-5001", "Database Management Systems", 4, Programme.MCA);
Course c3 = new Course("CSA-5002", "Java Programming", 4, Programme.MCA);
Course c4 = new Course("CSA-5003", "Internet Technologies", 4, Programme.MCA);
Course c5 = new Course("CSA-5202", "FUNDAMENTALS OF DS", 4, Programme.MCA);
Course c6 = new Course("CSA-5005", "OBJECT-ORIENTED PROGRAMMING", 4, Programme.MCA);
Collections.addAll(courses, c1, c2, c3, c4, c5, c6);
courses.add(new Course("CSA-5000", "Duplicate (ignored by Set)", 4, Programme.MCA));

        Student a = new Student("Aarav Naik", "CST2301", 2023, Programme.MCA);
        Student b = new Student("Diya Gaonkar", "CST2402", 2024, Programme.MCA);
        Student c = new Student("Rohan Parab", "CST2503", 2025, Programme.MSC_AI);
        a.addCourse(c1); a.addCourse(c2);
        b.addCourse(c3); b.addCourse(c4);
        c.addCourse(c5); c.addCourse(c6);
        students.addAll(List.of(a, b, c));

        faculty.add(new TeachingStaff("Dr. Meera Kamat", "Associate Professor"));
        faculty.add(new TeachingStaff("Dr. Sameer Dessai", "Assistant Professor"));
        nonTeaching.add(new NonTeachingStaff("Mr. Joaquim Fernandes", "Lab Assistant"));
        nonTeaching.add(new NonTeachingStaff("Ms. Sneha Borkar", "Office Clerk"));

        int[] years = {2023, 2024, 2025};
        for (int y : years) {
            activities.add(new AcademicActivity("ISA", y, 60, "In-Semester Assessment"));
            activities.add(new AcademicActivity("Midpoint", y, 60, "Mid-point project review"));
            activities.add(new AcademicActivity("SEA", y, 60, "Semester End Assessment"));
            activities.add(new AcademicActivity("Study Tour", y, 40, "Industrial visit / study tour"));
            activities.add(new AcademicActivity("Placements", y, 35, "Campus placement drive"));
            activities.add(new NonAcademicActivity("InfoFest", y, 300, "Technical fest"));
            activities.add(new NonAcademicActivity("Plateaunia", y, 500, "Cultural fest"));
            activities.add(new NonAcademicActivity("Play-on", y, 150, "Sports meet"));
        }
    }

    // ---------- 1. Object referencing & constructors ----------
    static void referencing() {
        section("1. OBJECT REFERENCING & CONSTRUCTORS");
        Student s1 = new Student("Kiran Shet", "CST2504", 2025, Programme.MCA); // full constructor
        Student s2 = s1;                                                       // same reference
        System.out.println("s1 == s2 ? " + (s1 == s2));
        s2.setName("Kiran S. Shet");
        System.out.println("Changed via s2, but s1.getName() = " + s1.getName() + "  <-- side effect");
        Student s3 = new Student("Neha Kulkarni", "CST2505");                  // overloaded constructor
        System.out.println(s1.report());
        System.out.println(s3.report() + "  (defaults used)");
        students.add(s1);
        students.add(s3);
    }

    // ---------- 2. Static attributes, methods, enums ----------
    static void statics() {
        section("2. STATIC COUNTER, STATIC METHOD & ENUMS");
        Member.displayCount();
        System.out.println("Via getCount(): " + Member.getCount());
        System.out.println("Activity types:");
        for (ActivityType t : ActivityType.values()) System.out.println("  " + t + " -> " + t.getLabel());
        System.out.println("Programmes:");
        for (Programme p : Programme.values()) System.out.println("  " + p + " -> " + p.getFullName());
    }

    // ---------- 3. Multiple inheritance ----------
    static void inheritance() {
        section("3. MULTIPLE INHERITANCE");
        TeachingStaff t = faculty.get(0);
        System.out.println("Multiple INTERFACE inheritance: " + t.getName()
                + " is Teacher? " + (t instanceof Teacher)
                + ", Researcher? " + (t instanceof Researcher)
                + ", Reportable? " + (t instanceof Reportable));
        System.out.println("Both interfaces define duties(), so the class overrides it:");
        System.out.println("  " + t.duties());
        System.out.println("Implementation (class) inheritance: only ONE parent class allowed.");
        System.out.println("  TeachingStaff extends Member (single). 'extends Member, Other' would not compile.");
        System.out.println("Difference: interfaces give multiple TYPES/behaviour (no state); classes give state + code, single only.");
    }

    // ---------- 4. Access modifiers ----------
    static void access() {
        section("4. ACCESS MODIFIERS");
        AccessDemo d = new AccessDemo();
        d.showInside();
        AccessOutside.showFromOutside(d);
        new AccessOutside().showFromSubclass();
    }

    // ---------- 5. Abstract classes & interfaces ----------
    static void abstractDemo() {
        section("5. ABSTRACT CLASSES & INTERFACES");
        List<Member> people = new ArrayList<>();
        people.addAll(students);
        for (TeachingStaff t : faculty) people.add(t);
        people.addAll(nonTeaching);
        for (Member m : people) System.out.println("  role() = " + m.role());
        System.out.println("Activities describe themselves differently:");
        System.out.println("  " + activities.get(0).describe());
        System.out.println("  " + activities.get(5).describe());
        Reportable r = students.get(0);   // interface reference
        System.out.println("Reportable.report(): " + r.report());
    }

    // ---------- 6. Class as a type & message passing ----------
    static void sendNotification(Notifiable n) {      // accepts ANY Notifiable
        System.out.println("  >> " + n.notifyMessage());
    }

    static void messagePassing() {
        section("6. CLASS AS A TYPE & MESSAGE PASSING");
        sendNotification(students.get(0));
        sendNotification(faculty.get(1));
        sendNotification(activities.get(0));    // AcademicActivity
        sendNotification(activities.get(6));    // NonAcademicActivity (own wording)
    }

    // ---------- 7. Polymorphism ----------
    static void describe(Student s)  { System.out.println("  describe(Student)  -> " + s.getName()); }
    static void describe(Activity a) { System.out.println("  describe(Activity) -> " + a.getName()); }
    static void describe(String s)   { System.out.println("  describe(String)   -> " + s); }
    static void describe(Course c, int extra) {
        System.out.println("  describe(Course,int) -> " + c.getName() + " +" + extra);
    }

    static void polymorphism() {
        section("7. POLYMORPHISM");
        System.out.println("Overriding (runtime): same call, different report():");
        Member[] ms = { students.get(0), faculty.get(0), nonTeaching.get(0) };
        for (Member m : ms) System.out.println("  " + m.report());
        System.out.println("Overloading (compile time): same name, different parameters:");
        describe(students.get(0));
        describe(activities.get(0));
        describe("Plain text");
        describe(courses.iterator().next(), 2);
    }

    // ---------- 8. Generics & collections ----------
    static void genericsAndCollections() {
        section("8. GENERICS & COLLECTIONS");
        System.out.println("Generic class Registry<TeachingStaff> size = " + faculty.size());
        Utils.printAll("Students (List)", students);
        System.out.println("Generic method maxOf: " + Utils.maxOf(Arrays.asList(12, 45, 7))
                + " | " + Utils.maxOf(Arrays.asList("CST501", "CST602", "CST503")));

        Queue<Student> placementQueue = new ArrayDeque<>(students);   // Queue (FIFO)
        System.out.println("Queue - interview order:");
        while (!placementQueue.isEmpty()) System.out.println("    " + placementQueue.poll().getName());

        Set<Course> unique = new TreeSet<>(courses);                  // Set (no duplicates, sorted)
          Utils.printAll("Courses (TreeSet, duplicate CSA-5000 ignored)", unique);

        Map<Integer, List<Activity>> byYear = new TreeMap<>();        // Map
        for (Activity a : activities) byYear.computeIfAbsent(a.getYear(), k -> new ArrayList<>()).add(a);
        for (Map.Entry<Integer, List<Activity>> e : byYear.entrySet())
            System.out.println("  Map " + e.getKey() + " -> " + e.getValue().size() + " activities");
    }

    // ---------- 9. Exception handling ----------
    static void exceptions() {
        section("9. EXCEPTION HANDLING");
        String[] rolls = {"CST2301", "XYZ12"};
        for (String r : rolls) {
            try {
                Validator.checkRoll(r);
                System.out.println("  Roll " + r + " is valid");
            } catch (InvalidDataException e) {               // custom exception
                System.out.println("  Custom exception caught: " + e.getMessage());
            } finally {
                System.out.println("  finally: validation finished for " + r);
            }
        }
        try {
            int placed = 30, total = 0;
            System.out.println("Placement % = " + (placed * 100 / total));
        } catch (ArithmeticException e) {
            System.out.println("  Runtime error managed: " + e.getMessage());
        }
        try {
            int[] marks = new int[3];
            marks[3] = 90;
            Integer.parseInt("seventy");
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {   // multi-catch
            System.out.println("  Runtime error managed: " + e.getClass().getSimpleName());
        }
        try {
            throw new IllegalStateException("Thrown manually with 'throw'");
        } catch (IllegalStateException e) {
            System.out.println("  " + e.getMessage());
        }
    }

    // ---------- 10. Reflection, persistence, I/O, cloning ----------
    static void reflectionIoCloning() {
        section("10. REFLECTION, PERSISTENCE, I/O & CLONING");

        System.out.println("-- Reflection --");
        try {
            Class<?> c = Student.class;
            System.out.println("Class: " + c.getName() + " extends " + c.getSuperclass().getSimpleName());
            for (Class<?> i : c.getInterfaces()) System.out.println("  implements " + i.getSimpleName());
            for (Field f : c.getDeclaredFields())
                System.out.println("  field: " + Modifier.toString(f.getModifiers()) + " "
                        + f.getType().getSimpleName() + " " + f.getName());
            Method[] ms = c.getDeclaredMethods();
            Arrays.sort(ms, Comparator.comparing(Method::getName));
            StringBuilder sb = new StringBuilder("  methods:");
            for (Method m : ms) sb.append(' ').append(m.getName());
            System.out.println(sb);
            Student r = (Student) c.getConstructor(String.class, String.class)
                    .newInstance("Reflected Student", "CST2599");
            Field roll = c.getDeclaredField("rollNo");
            roll.setAccessible(true);
            System.out.println("  Created by reflection; private rollNo = " + roll.get(r));
        } catch (ReflectiveOperationException e) {
            System.out.println("  Reflection error: " + e);
        }

        System.out.println("-- RTTI --");
        List<Member> all = new ArrayList<>(students);
        for (TeachingStaff t : faculty) all.add(t);
        all.addAll(nonTeaching);
        for (Member m : all) {
            String kind = (m instanceof Student) ? "student" : (m instanceof TeachingStaff) ? "teaching" : "non-teaching";
            System.out.println("  " + m.getName() + " -> " + m.getClass().getSimpleName() + " (" + kind + ")");
        }

        System.out.println("-- Console I/O --");
        Scanner sc = new Scanner(System.in);
        System.out.print("  Enter roll number to search: ");
        String q = sc.hasNextLine() ? sc.nextLine().trim() : "CST2402";
        System.out.println(q);
        boolean found = false;
        for (Student s : students)
            if (s.getRollNo().equalsIgnoreCase(q)) { System.out.println("  Found: " + s.report()); found = true; }
        if (!found) System.out.println("  No student with roll number " + q);

        System.out.println("-- File I/O --");
        File report = new File("output/dcst_report.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(report))) {
            pw.println("DCST NIRF report");
            for (Activity a : activities) pw.println(a.report());
        } catch (IOException e) {
            System.out.println("  Write failed: " + e.getMessage());
        }
        try (BufferedReader br = new BufferedReader(new FileReader(report))) {
            int lines = 0;
            while (br.readLine() != null) lines++;
            System.out.println("  Wrote and read back " + report.getPath() + " (" + lines + " lines)");
        } catch (IOException e) {
            System.out.println("  Read failed: " + e.getMessage());
        }

        System.out.println("-- Persistence (serialization) --");
        File ser = new File("output/students.ser");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ser))) {
            out.writeObject(new ArrayList<>(students));
            System.out.println("  Saved " + students.size() + " students to " + ser.getPath());
        } catch (IOException e) {
            System.out.println("  Save failed: " + e.getMessage());
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ser))) {
            @SuppressWarnings("unchecked")
            List<Student> loaded = (List<Student>) in.readObject();
            System.out.println("  Loaded back: " + loaded.size() + " students, first = " + loaded.get(0).getName());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("  Load failed: " + e.getMessage());
        }

        System.out.println("-- Cloning --");
        Student orig = students.get(0);
        Student shallow = orig.clone();
        Student deep = orig.deepClone();
        orig.getCourses().get(0).setName("Advanced Java");   // change a Course inside the original
        System.out.println("  Original  course[0]: " + orig.getCourses().get(0).getName());
        System.out.println("  Shallow   course[0]: " + shallow.getCourses().get(0).getName() + "  (shared -> changed)");
        System.out.println("  Deep      course[0]: " + deep.getCourses().get(0).getName() + "  (independent -> unchanged)");
        System.out.println("  shallow.getCourses() == orig.getCourses() ? " + (shallow.getCourses() == orig.getCourses()));
        System.out.println("  deep.getCourses()    == orig.getCourses() ? " + (deep.getCourses() == orig.getCourses()));
    }

    // ---------- Final NIRF listing ----------
    static void nirfSummary() {
        section("NIRF SUMMARY - DCST, GBS, GOA UNIVERSITY (2023-2025)");
        Utils.printAll("Programmes & Courses", courses);
        Utils.printAll("Students", students);
        Utils.printAll("Teaching staff", toList(faculty));
        Utils.printAll("Non-teaching staff", nonTeaching);
        System.out.println("  Academic activities:");
        for (Activity a : activities) if (a.getType() == ActivityType.ACADEMIC) System.out.println("    " + a.report());
        System.out.println("  Non-academic activities:");
        for (Activity a : activities) if (a.getType() == ActivityType.NON_ACADEMIC) System.out.println("    " + a.report());
        Member.displayCount();
    }

    static <T extends Member> List<T> toList(Registry<T> r) {
        List<T> l = new ArrayList<>();
        for (T t : r) l.add(t);
        return l;
    }
}
