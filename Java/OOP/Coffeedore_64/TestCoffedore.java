public class TestCoffedore {
    public static void main(String[] args) {
        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();
        coffeeKiosk.addMenuItem("Drip Coffee", 3.5);
        coffeeKiosk.addMenuItem("Latte", 6.0);
        coffeeKiosk.addMenuItem("Mocha", 7.0);
        coffeeKiosk.addMenuItem("Plain Coffee", 2.0);
        coffeeKiosk.addItemManually();
        System.out.println("\nThe menu:");
        coffeeKiosk.displayMenu();
        coffeeKiosk.newOrder();

    }
}
