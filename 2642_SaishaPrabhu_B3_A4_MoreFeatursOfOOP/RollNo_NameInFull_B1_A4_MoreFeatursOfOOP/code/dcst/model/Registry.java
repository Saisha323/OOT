package dcst.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Generic class (feature 8): a registry that can hold only Members (or subclasses). */
public class Registry<T extends Member> implements Iterable<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) { items.add(item); }
    public T get(int index) { return items.get(index); }
    public int size() { return items.size(); }
    @Override public Iterator<T> iterator() { return items.iterator(); }
}
