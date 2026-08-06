class Customerdtl {
    int customerId;
    String name;
    String email, phone;
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

class Payment {
    int paymentId;
    String paymentMethod;
    double amount;
    void makePayment() {
        System.out.println("make payment");
    }
}



class Profile {
    String address;
    String username;
    void updateProfile() {}
}

public class OnlineShopping {
    public static void main(String[] args) {
        Customerdtl c = new Customerdtl();
        Product p = new Product();
        Order o = new Order();
        Payment pay = new Payment();
        c.setName("Saisha");
        System.out.println("Name=> " + c.getName());
        c.register();
        c.login();
        p.displayProduct();
        o.placeOrder();
        pay.makePayment();

        System.out.println("Online Shopping System Executed Successfully.");
    }
}
