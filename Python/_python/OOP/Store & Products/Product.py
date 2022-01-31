
import random


class Product:
    def __init__(self, name, price, category):
        self.name = name
        self.price = price
        self.category = category
        self.id = random.random()

    def update_price(self, percent_change, is_increased=True):
        if is_increased:
            self.price += self.price * percent_change
        else:
            self.price -= self.price * percent_change
        return self

    def print_info(self):
        print(
            f"\nName: {self.name}, Price: ${self.price}, Category: {self.category}\n")
        return self
