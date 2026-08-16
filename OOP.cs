using System;

// encapsulation
class Customerdtl
{
    int customerId;
    string name;
    string email, phone;

    // C# convention: use a Property instead of manual getName()/setName()
    public string Name
    {
        get { return this.name; }
        set { this.name = value; }
    }

    public void Register() { }
    public void Login() { }
}

class Product
{
    public int productId;
    public string productName;
    public double price;
    public string description;
    public int stock;

    public void DisplayProduct()
    {
        Console.WriteLine("Display product");
    }
}

class ProductCategory
{
    public int categoryId;
    public string categoryName;
}

class Order
{
    public int orderId;
    public string orderDate;
    public double amount;

    public void PlaceOrder()
    {
        Console.WriteLine("place order");
    }
}

// abstraction
abstract class Payment
{
    public int paymentId;
    public double amount;
    public abstract void MakePayment();
}

class OnlinePayment : Payment
{
    public string upiId;

    public override void MakePayment()
    {
        Console.WriteLine("make online payment via UPI");
    }
}

class Wishlist
{
    public void AddProduct() { }
    public void RemoveProduct() { }
}

class Search
{
    public void SearchProduct(string keyword) { }
}

class Offer
{
    public string coupon;
    public double discount;
}

// inheritance
class Delivery
{
    public int deliveryId;
    public string deliveryStatus;

    public virtual void TrackOrder()
    {
        Console.WriteLine("track order");
    }
}

class StandardDelivery : Delivery
{
    public override void TrackOrder()
    {
        Console.WriteLine("standard delivery: 5-7 days");
    }
}

class ExpressDelivery : Delivery
{
    public override void TrackOrder()
    {
        Console.WriteLine("express delivery: 1-2 days");
    }
}

class Review
{
    public int rating;
    public string feedback;
}

class Profile
{
    public string address;
    public string username;
    public void UpdateProfile() { }
}

// Author name: Saisha Prabhu
// Roll no: 2642
// Desc: e-commerce site code with OOP concepts (C# version)
class Ecomm
{
    static void Main(string[] args)
    {
        Customerdtl c = new Customerdtl();
        Product p = new Product();
        Order o = new Order();

        Payment payonline = new OnlinePayment(); // runtime polymorphism
        payonline.MakePayment();

        c.Name = "Saisha";
        Console.WriteLine("Name=> " + c.Name);
        c.Register();
        c.Login();

        p.DisplayProduct();
        o.PlaceOrder();

        Delivery d = new Delivery();
        d.deliveryId = 101;
        d.deliveryStatus = "In Transit";
        d.TrackOrder();

        Delivery delivery = new ExpressDelivery();
        delivery.TrackOrder();

        Delivery delivery2 = new StandardDelivery();
        delivery2.TrackOrder();

        Console.WriteLine("Online Shopping System Executed Successfully.");
    }
}