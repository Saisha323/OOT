package dcst.model;

import java.util.Collection;
import java.util.List;

/** Generic methods (feature 8). */
public class Utils {
    public static <T extends Reportable> void printAll(String title, Collection<? extends T> items) {
        System.out.println("  " + title + " (" + items.size() + ")");
        for (T t : items) System.out.println("    - " + t.report());
    }

    public static <T extends Comparable<T>> T maxOf(List<T> list) {
        T best = list.get(0);
        for (T t : list) if (t.compareTo(best) > 0) best = t;
        return best;
    }
}
