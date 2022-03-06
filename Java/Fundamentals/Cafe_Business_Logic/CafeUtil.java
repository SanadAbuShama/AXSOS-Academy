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

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Por favor, ingresa tu nombre:");
        String userName = System.console().readLine();
        System.err.println("Hello, " + userName);
        System.out.println(String.format("There are %d people in front of you", customers.size()));
        customers.add(userName);
        for (String name : customers) {
            System.out.println(name);
        }
    }

}
