package dcst.model;

/** Interface with a default method (used to show the "diamond" in feature 3). */
public interface Teacher {
    default String duties() { return "teaches courses and conducts ISA/SEA"; }
}
