from Store import Store
from Product import Product


zara = Store('ZARA')

hat = Product('Hat', 10, 'clothes')
sneakers = Product('Sneakers', 50, 'clothes')
lipstick = Product('Lipstick', 5, 'cosmetics')

hat.print_info()
sneakers.print_info()
lipstick.print_info()


hat.update_price(0.02).print_info()


zara.add_product(hat).add_product(sneakers).display_products()

zara.sell_product(hat.id).display_products()

zara.add_product(hat).add_product(lipstick).display_products()

zara.set_clearance('clothes', 0.5).display_products()

zara.inflation(2).display_products()
