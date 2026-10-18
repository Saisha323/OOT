package dcst.app;

import dcst.model.AccessDemo;

public class AccessOutside extends AccessDemo {

    public void showFromSubclass() {
        System.out.println("  Subclass, other package -> " + publicField + ", " + protectedField);
   }

    public static void showFromOutside(AccessDemo d) {
        System.out.println("  Outside (plain object)  -> " + d.publicField + ", " + d.revealSecret());
  }
}
