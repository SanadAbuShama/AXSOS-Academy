import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item3> menu;
    private ArrayList<Order3> orders;

    public CoffeeKiosk() {
        menu = new ArrayList<Item3>();
        orders = new ArrayList<Order3>();
    }

    // Menu Getter
    public ArrayList<Item3> getMenu() {
        return menu;
    }

    // Menu Setter
    public void setMenu(ArrayList<Item3> menu) {
        this.menu = menu;

    }

    // Orders Getter
    public ArrayList<Order3> getOrders() {
        return orders;
    }

    // Orders Setter
    public void setOrders(ArrayList<Order3> orders) {
        this.orders = orders;

    }

    public void addMenuItem(String name, double price) {
        Item3 item = new Item3(name, price);
        item.setIndex(menu.size());
        menu.add(item);
    }

    public void displayMenu() {
        System.out.println("\n");
        for (Item3 item : menu) {
            System.out.println(String.format("%d %s -- $%.2f", item.getIndex(), item.getName(), item.getPrice()));
        }
        System.err.println("\n");
    }

    public void newOrder() {
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("\nPlease enter customer name for new order:");
        String name = System.console().readLine();
        // Your code:
        // Create a new order with the given input string
        Order3 order = new Order3(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        // Write a while loop to collect all user's order items
        while (!itemNumber.equals("q")) {
            // Get the item object from the menu, and add the item to the order
            Item3 item = menu.get(Integer.parseInt(itemNumber));
            order.addItem(item);
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details
        // as the example below. You may
        order.display();
        System.out.println(String.format("Total: $%.2f", order.getOrderTotal()));
    }

    public void addItemManually() {
        System.out.println("Please enter item name:");
        String itemName = System.console().readLine();
        System.out.println("Please enter item price:");
        double itemPrice = Double.parseDouble(System.console().readLine());
        addMenuItem(itemName, itemPrice);

    }
}
