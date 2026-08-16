#include <iostream>
#include <string>
using namespace std;

// encapsulation
class Customerdtl {
private:
    int customerId;
    string name;
    string email, phone;
public:
    string getName() {
        return this->name;
    }
    void setName(string name) {
        this->name = name;
    }
    void registerCustomer() {}   
    void login() {}
};

class Product {
public:
    int productId;
    string productName;
    double price;
    string description;
    int stock;
    void displayProduct() {
        cout << "Display product" << endl;
    }
};

class ProductCategory {
public:
    int categoryId;
    string categoryName;
};

class Order {
public:
    int orderId;
    string orderDate;
    double amount;
    void placeOrder() {
        cout << "place order" << endl;
    }
};

// abstraction
class Payment {
public:
    int paymentId;
    double amount;
    virtual void makePayment() = 0;   // pure virtual function = abstract method
    virtual ~Payment() {}             // virtual destructor, needed since we use base pointers
};

class OnlinePayment : public Payment {
public:
    string upiId;
    void makePayment() override {
        cout << "make online payment via UPI" << endl;
    }
};

class Wishlist {
public:
    void addProduct() {}
    void removeProduct() {}
};

class Search {
public:
    void searchProduct(string keyword) {}
};

class Offer {
public:
    string coupon;
    double discount;
};

// inheritance
class Delivery {
public:
    int deliveryId;
    string deliveryStatus;
    virtual void trackOrder() {
        cout << "track order" << endl;
    }
    virtual ~Delivery() {}
};

class StandardDelivery : public Delivery {
public:
    void trackOrder() override {
        cout << "standard delivery: 5-7 days" << endl;
    }
};

class ExpressDelivery : public Delivery {
public:
    void trackOrder() override {
        cout << "express delivery: 1-2 days" << endl;
    }
};

class Review {
public:
    int rating;
    string feedback;
};

class Profile {
public:
    string address;
    string username;
    void updateProfile() {}
};

// Author name: Saisha Prabhu
// Roll no: 2642
// Desc: e-commerce site code with OOP concepts (C++ version)
int main() {
    Customerdtl c;
    Product p;
    Order o;

    Payment* payonline = new OnlinePayment();  // runtime polymorphism via base pointer
    payonline->makePayment();

    c.setName("Saisha");
    cout << "Name=> " << c.getName() << endl;
    c.registerCustomer();
    c.login();

    p.displayProduct();
    o.placeOrder();

    Delivery d;
    d.deliveryId = 101;
    d.deliveryStatus = "In Transit";
    d.trackOrder();

    Delivery* delivery = new ExpressDelivery();
    delivery->trackOrder();

    Delivery* delivery2 = new StandardDelivery();
    delivery2->trackOrder();

    cout << "Online Shopping System Executed Successfully." << endl;

    delete payonline;
    delete delivery;
    delete delivery2;

    return 0;
}