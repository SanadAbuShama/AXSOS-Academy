import java.util.ArrayList;

public class Order3 {
    private String name;
    private boolean ready;
    private ArrayList<Item3> items;

    public Order3() {
        name = "Guest";
        items = new ArrayList<Item3>();
    }

    public Order3(String name) {
        this.name = name;
        items = new ArrayList<Item3>();
    }

    // Name Setter
    public void setName(String name) {
        this.name = name;
    }

    // Name getter
    public String getName() {
        return name;
    }

    // Ready Setter
    public void setReady(boolean isReady) {
        ready = isReady;
    }

    // Ready getter
    public boolean isReady() {
        return ready;
    }

    // Items Setter
    public void setItems(ArrayList<Item3> items) {
        this.items = items;
    }

    // Items getter
    public ArrayList<Item3> getItems() {
        return items;
    }

    public void addItem(Item3 item) {
        this.items.add(item);

    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public void display() {
        System.out.println("\nCustomer name: " + name);
        for (Item3 item : items) {
            System.out.println(String.format("%s - $%.2f\n", item.getName(), item.getPrice()));
        }

    }

    public double getOrderTotal() {
        double total = 0;
        for (Item3 item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
