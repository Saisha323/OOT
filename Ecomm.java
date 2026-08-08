class Customerdtl {
    int customerId;
    String name;
    String email, phone;
    //encapsulation
    public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }
    void register() {}
    void login() {}
}

class Product {
    int productId;
    String productName;
    double price;
    String description;
    int stock;
    void displayProduct() {
        System.out.println("Display product");
    }
}

class ProductCategory {
    int categoryId;
    String categoryName;
}

class Order {
    int orderId;
    String orderDate;
    double amount;
    void placeOrder() {
        System.out.println("place order");
    }
}
//abstraction
abstract class Payment {
    int paymentId;
    double amount;
    abstract void makePayment(); 
}
class OnlinePayment extends Payment {
    String upiId;
    @Override
    void makePayment() {
        System.out.println("make online payment via UPI");
    }
}

class Wishlist {
    void addProduct() {}
    void removeProduct() {}
}

class Search {
    void searchProduct(String keyword) {}
}

class Offer {
    String coupon;
    double discount;
}
//inheritance
class Delivery {
    int deliveryId;
    String deliveryStatus;
    void trackOrder() {
        System.out.println("track order");
    }
}

class StandardDelivery extends Delivery {
    @Override
    void trackOrder() {
        System.out.println("standard delivery: 5-7 days");
    }
}
class ExpressDelivery extends Delivery {
    @Override
    void trackOrder() {
        System.out.println("express delivery: 1-2 days");
    }
}
class Review {
    int rating;
    String feedback;
}

class Profile {
    String address;
    String username;
    void updateProfile() {}
}
//Author name:Saisha Prabhu
//Roll no:2642
//Desc:e commerce site code with oop concepts
public class Ecomm {
    public static void main(String[] args) {
        Customerdtl c = new Customerdtl();
        Product p = new Product();
        Order o = new Order();
        Payment payonline = new OnlinePayment();  //runtime polymorphism
        payonline.makePayment();  
        c.setName("Saisha");
        System.out.println("Name=> " + c.getName());
        c.register();
        c.login();
        p.displayProduct();
        o.placeOrder();
        Delivery d = new Delivery();
        d.deliveryId = 101;
        d.deliveryStatus = "In Transit";
        d.trackOrder();
        Delivery delivery = new ExpressDelivery();
        delivery.trackOrder();

        Delivery delivery2 = new StandardDelivery();
        delivery2.trackOrder();

        System.out.println("Online Shopping System Executed Successfully.");
    }
}
