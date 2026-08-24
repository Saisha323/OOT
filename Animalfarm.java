import java.util.Scanner;

class animal {
    String AnimalName = "Generic Animal";

    void takecare() {
        System.out.println("Taking care of " + AnimalName);
    }
    void feedamt(int amt) {
        System.out.println("Feeding " + AnimalName + " with " + amt + " units of food.");
    }
    void feedtype(String type) {
        System.out.println("Feeding " + AnimalName + " with " + type + ".");
    }
    void vaccination() {
        System.out.println("Vaccinating " + AnimalName);
    }
    void vaccstatus(boolean status) {
        if (status) {
            System.out.println(AnimalName + " is vaccinated.");
        } else {
            System.out.println(AnimalName + " is not vaccinated.");
        }
    }
}

// ---------- Single Inheritance (animal -> Cow) ----------
class Cow extends animal {
    Cow() {
        AnimalName = "Cow";
        takecare();
    }

    void feedamt(int amt) {
        System.out.println("Feeding the Cow with " + amt + " units of hay.");
    }
    void feedtype(String type) {
        System.out.println("Feeding the Cow with " + type + ".");
    }
    void vaccination() {
        System.out.println("Vaccinating the Cow against common bovine diseases.");
    }
    void vaccstatus(boolean status) {
        if (status) {
            System.out.println("The Cow is vaccinated.");
        } else {
            System.out.println("The Cow is not vaccinated.");
        }
    }
    void coworbull(boolean isBull) {
        if (isBull) {
            System.out.println("This Cow is a Bull.");
        } else {
            System.out.println("This Cow is a Female Cow.");
        }
    }
}

// ---------- Multilevel Inheritance (animal -> Cow -> calf) ----------
class calf extends Cow {
    calf() {
        AnimalName = "Calf";
        takecare();
    }
    void specialcare() {
        feedamt(3);
        System.out.println("Providing special care for the Calf, including warmth and nutrition.");
    }
    void feedtype(String type) {
        System.out.println("Feeding the Calf with " + type + ".");
    }
    void vaccination() {
        System.out.println("Vaccinating the Calf against common bovine diseases.");
    }
    void vaccstatus(boolean status) {
        if (status) {
            System.out.println("The Calf is vaccinated.");
        } else {
            System.out.println("The Calf is not vaccinated.");
        }
    }
}

// ---------- Hierarchical Inheritance (animal -> Cow / Goat) ----------
class Goat extends animal {
    Goat() {
        AnimalName = "Goat";
        takecare();
    }
    void feedamt(int amt) {
        System.out.println("Feeding the Goat with " + amt + " units of hay.");
    }
    void feedtype(String type) {
        System.out.println("Feeding the Goat with " + type + ".");
    }
    void vaccination() {
        System.out.println("Vaccinating the Goat against common caprine diseases.");
    }
    void vaccstatus(boolean status) {
        if (status) {
            System.out.println("The Goat is vaccinated.");
        } else {
            System.out.println("The Goat is not vaccinated.");
        }
    }
}

// ---------- Multiple Inheritance through interfaces ----------
interface Cost {
    void calculateCost();
}
interface Revenue {
    void calculateRevenue();
}

class Farm {
    String farmName = "ABC Animal Farm";
    void farmDetails() {
        System.out.println("Farm Name: " + farmName);
    }
}

// ---------- Hybrid Inheritance (Farm -> Profit implements Cost, Revenue) ----------
class Profit extends Farm implements Cost, Revenue {
    int cost = 5000;
    int revenue = 8000;

    public void calculateCost() {
        System.out.println("Farm Cost = " + cost);
    }
    public void calculateRevenue() {
        System.out.println("Farm Revenue = " + revenue);
    }
    void calculateProfit() {
        int profit = revenue - cost;
        System.out.println("Farm Profit = " + profit);
    }
}

// ============ Menu-driven demo runner ============
public class AnimalFarmMenu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        do {
            printMenu();
            choice = readChoice();
            System.out.println();
            switch (choice) {
                case 1 -> demoSingleInheritance();
                case 2 -> demoMultilevelInheritance();
                case 3 -> demoHierarchicalInheritance();
                case 4 -> demoMultipleInheritance();
                case 5 -> demoHybridInheritance();
                case 6 -> demoAll();
                case 0 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice, please select a valid option.");
            }
            System.out.println();
        } while (choice != 0);

        sc.close();
    }

    static void printMenu() {
        System.out.println("=========================================");
        System.out.println(" ANIMAL FARM - INHERITANCE DEMO MENU");
        System.out.println("=========================================");
        System.out.println("1. Single Inheritance        (animal -> Cow)");
        System.out.println("2. Multilevel Inheritance     (animal -> Cow -> calf)");
        System.out.println("3. Hierarchical Inheritance   (animal -> Cow / Goat)");
        System.out.println("4. Multiple Inheritance       (interfaces: Cost, Revenue)");
        System.out.println("5. Hybrid Inheritance         (Farm -> Profit implements Cost, Revenue)");
        System.out.println("6. Run all demos");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    static int readChoice() {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a number: ");
            sc.next();
        }
        int val = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        return val;
    }

    // ---------- Individual demo methods ----------

    static void demoSingleInheritance() {
        System.out.println("--- Single Inheritance: animal -> Cow ---");
        Cow cow = new Cow();
        cow.feedamt(5);
        cow.feedtype("grass");
        cow.vaccination();
        cow.vaccstatus(true);
        cow.coworbull(false);
    }

    static void demoMultilevelInheritance() {
        System.out.println("--- Multilevel Inheritance: animal -> Cow -> calf ---");
        calf calf = new calf();
        calf.coworbull(false);      // inherited from Cow
        calf.specialcare();
        calf.feedtype("milk replacer");
        calf.vaccination();
        calf.vaccstatus(false);
    }

    static void demoHierarchicalInheritance() {
        System.out.println("--- Hierarchical Inheritance: animal -> Cow / Goat ---");
        Cow cow = new Cow();
        cow.feedamt(5);
        cow.feedtype("grass");
        cow.vaccination();
        cow.vaccstatus(true);

        System.out.println();

        Goat goat = new Goat();
        goat.feedamt(3);
        goat.feedtype("hay");
        goat.vaccination();
        goat.vaccstatus(true);
    }

    static void demoMultipleInheritance() {
        System.out.println("--- Multiple Inheritance via Interfaces: Cost, Revenue ---");
        Profit profit = new Profit();
        profit.calculateCost();
        profit.calculateRevenue();
    }

    static void demoHybridInheritance() {
        System.out.println("--- Hybrid Inheritance: Farm -> Profit implements Cost, Revenue ---");
        Profit profit = new Profit();
        profit.farmDetails();
        profit.calculateCost();
        profit.calculateRevenue();
        profit.calculateProfit();
    }

    static void demoAll() {
        demoSingleInheritance();
        System.out.println();
        demoMultilevelInheritance();
        System.out.println();
        demoHierarchicalInheritance();
        System.out.println();
        demoMultipleInheritance();
        System.out.println();
        demoHybridInheritance();
    }
}
