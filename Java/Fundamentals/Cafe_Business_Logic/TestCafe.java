import java.util.ArrayList;

public class TestCafe {
    public static void main(String[] args) {

        /*
         * You will need to add 1 line to this file to create an instance
         *       of the CafeUtil class.
         *      Tip: You will need to match the variable name used below.
         */
        CafeUtil appTest = new CafeUtil();
        /* ============ App test cases ============= */

        System.out.println("\n----- Try Meta coffee -----");
        System.out.printf("Purchases needed for week 6: %s \n\n", appTest.getStreakGoal(6));

        System.out.println("----- Order Total Test -----");
        double[] lineItems = { 3.0, 1.5, 4.0, 4.5 };
        System.out.printf("Order Total: %s \n\n", appTest.getOrderTotal(lineItems));

        System.out.println("----- Try Show Menu-----");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        // Test of Price Chart
        System.out.println("\nPrice Chart:\n");
        appTest.printPriceChart(menu.get(0), lineItems[0], 5);

        // Test display menu overloading
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(3.5);
        prices.add(5.0);
        prices.add(4.5);
        prices.add(2.0);
        appTest.displayMenu(menu, prices);

        System.out.println("\n----- Try add client-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

    }
}