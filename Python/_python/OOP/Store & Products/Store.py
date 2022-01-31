class Store:
    def __init__(self, name):
        self.name = name
        self.products = []

    def add_product(self, new_product):
        self.products.append(new_product)
        return self

    def sell_product(self, id):
        print('\nSold Product:')
        for product in self.products:
            if product.id == id:
                sold_product = self.products.pop(self.products.index(product))
                sold_product.print_info()
        return self

    def inflation(self, percent_increase):
        for product in self.products:
            product.update_price(percent_increase)
        return self

    def set_clearance(self, category, percent_discount):
        for product in self.products:
            if product.category == category:
                product.update_price(percent_discount, False)
        return self

    def display_products(self):
        print('\nStore Products')
        for product in self.products:
            print(
                f"Product name: {product.name}, Product price: ${product.price}")

        return self
