class animal{
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
//Single Inheritance (animal -> Cow)
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
//Multilevel inheritance (animal -> Cow -> calf)
class calf extends Cow {
    calf() {
        AnimalName = "Calf";
        takecare();
    }
    void specialcare() {
        feedamt(3);
        System.out.println("Providing special care for the Calf, including warmth and nutrition.");
    }
    
    /*void feedamt(int amt) {
        System.out.println("Feeding the Calf with " + amt + " units of milk replacer.");
    }*/
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
//Hierarchical inheritance (animal -> Cow / Goat)
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
//multiple inheritance through interfaces (Cost, Revenue)
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


//hybrid inheritance (Farm -> Profit implements Cost, Revenue)
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
public class Animalfarm {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.feedamt(5);
        cow.feedtype("grass");
        cow.vaccination();
        cow.vaccstatus(true);
        calf calf = new calf();
        calf.coworbull(false);
        calf.specialcare(); 
        calf.feedtype("milk replacer");
        calf.vaccination();
        calf.vaccstatus(false);
        Goat goat = new Goat();
        goat.feedamt(3);
        goat.feedtype("hay");
        goat.vaccination();
        goat.vaccstatus(true);
        Profit profit = new Profit();
        profit.farmDetails();
        profit.calculateCost();
        profit.calculateRevenue();
        profit.calculateProfit();   

    }
}