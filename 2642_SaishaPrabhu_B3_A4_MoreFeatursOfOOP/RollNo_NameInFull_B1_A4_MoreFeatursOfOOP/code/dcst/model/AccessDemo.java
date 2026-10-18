package dcst.model;

/** Feature 4: all four access levels. */
public class AccessDemo {
    public String publicField = "public field";
    protected String protectedField = "protected field";
    String defaultField = "default (package-private) field";
    private String privateField = "private field";

    /** Inside the class everything is visible. */
    public void showInside() {
        System.out.println("  Inside class -> " + publicField + ", " + protectedField
                + ", " + defaultField + ", " + privateField);
    }

    private String secret() { return "private method result"; }
    public String revealSecret() { return secret(); }   // public door to a private method
}
