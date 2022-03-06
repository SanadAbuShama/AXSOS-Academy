import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        int total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {

        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(String.format("%d %s", i, menuItems.get(i)));
        }

    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        } else {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println(String.format("\n%d %s -- $%.2f", i, menuItems.get(i), prices.get(i)));
            }
            return true;
        }

    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please, enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.println(String.format("There are %d people in front of you", customers.size()));
        customers.add(userName);
        for (String name : customers) {
            System.out.println(name);
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        for (int i = 1; i <= maxQuantity; i++) {
            double newPrice;
            if (i > 1) {
                newPrice = price * i - 0.5 * (i - 1);
            } else {
                newPrice = price;
            }

            System.out.println(String.format("%d - $%.2f", i, newPrice));
        }
    }

}
