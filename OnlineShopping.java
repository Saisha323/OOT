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
//abstraction 

class Order {
    int orderId;
    String orderDate;
    double amount;
    void placeOrder() {
        System.out.println("place order");
    }
}

//inheritance  
class Payment {
    int paymentId;
    String paymentMethod;
    double amount;
    void makePayment() {
        System.out.println("make payment");
    }
}
class onlinepayment extends Payment {
    char upiid;
    void makePayment(){
        System.out.println("make online payment");
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

class Delivery {
    int deliveryId;
    String deliveryStatus;
    void trackOrder() {}
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
public class OnlineShopping {
    public static void main(String[] args) {
        Customerdtl c = new Customerdtl();
        Product p = new Product();
        Order o = new Order();
        Payment pay = new Payment();
        onlinepayment payonline=new onlinepayment();

        c.setName("Saisha");
        System.out.println("Name=> " + c.getName());
        c.register();
        c.login();
        p.displayProduct();
        o.placeOrder();
       
        //inheritance & runtime polymorphism
        pay.makePayment();
        payonline.makePayment();
       
        System.out.println("Online Shopping System Executed Successfully.");
    }
}