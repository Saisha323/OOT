from abc import ABC, abstractmethod


class CustomerDtl:
    def __init__(self):
        self.customer_id = 0
       #encapsulation

    def get_name(self):
        return self.__name
    def set_name(self, name):
        self.__name = name
    def register(self):
        pass

    def login(self):
        pass


class Product:
    def __init__(self):
        self.product_id = 0
        self.product_name = ""
        self.price = 0.0
        self.description = ""
        self.stock = 0

    def display_product(self):
        print("Display product")


class ProductCategory:
    def __init__(self):
        self.category_id = 0
        self.category_name = ""


class Order:
    def __init__(self):
        self.order_id = 0
        self.order_date = ""
        self.amount = 0.0

    def place_order(self):
        print("place order")


# abstraction
class Payment(ABC):
    def __init__(self):
        self.payment_id = 0
        self.amount = 0.0

    @abstractmethod
    def make_payment(self):
        pass


class OnlinePayment(Payment):
    def __init__(self):
        super().__init__()
        self.upi_id = ""

    def make_payment(self):
        print("make online payment via UPI")


class Wishlist:
    def add_product(self):
        pass

    def remove_product(self):
        pass


class Search:
    def search_product(self, keyword):
        pass


class Offer:
    def __init__(self):
        self.coupon = ""
        self.discount = 0.0


# inheritance
class Delivery:
    def __init__(self):
        self.delivery_id = 0
        self.delivery_status = ""

    def track_order(self):
        print("track order")


class StandardDelivery(Delivery):
    def track_order(self):
        print("standard delivery: 5-7 days")


class ExpressDelivery(Delivery):
    def track_order(self):
        print("express delivery: 1-2 days")


class Review:
    def __init__(self):
        self.rating = 0
        self.feedback = ""


class Profile:
    def __init__(self):
        self.address = ""
        self.username = ""

    def update_profile(self):
        pass


# Author name: Saisha Prabhu
# Roll no: 2642
# Desc: e-commerce site code with OOP concepts


def main():
    c = CustomerDtl()
    p = Product()
    o = Order()

    payonline = OnlinePayment()   # runtime polymorphism
    payonline.make_payment()
#getter and setter methods
    c.set_name("Saisha"  )           
    print("Name=>", c.get_name())     
    c.register()
    c.login()
    p.display_product()
    o.place_order()

    d = Delivery()
    d.delivery_id = 101
    d.delivery_status = "In Transit"
    d.track_order()

    delivery = ExpressDelivery()
    delivery.track_order()

    delivery2 = StandardDelivery()
    delivery2.track_order()

    print("Online Shopping System Executed Successfully.")


if __name__ == "__main__":
    main()