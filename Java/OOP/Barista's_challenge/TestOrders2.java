public class TestOrders2 {

    public static void main(String[] args) {
        // Items
        Item2 item1 = new Item2("mocha", 2.5);
        Item2 item2 = new Item2("latte", 4.5);
        Item2 item3 = new Item2("drip coffe", 6);

        // Orders
        Order2 order1 = new Order2();
        Order2 order2 = new Order2();
        Order2 order3 = new Order2("Sanad");
        Order2 order4 = new Order2("Ahmad");
        Order2 order5 = new Order2("Jamal");

        // Add items
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item2);
        order2.addItem(item3);
        order3.addItem(item1);
        order3.addItem(item3);
        order4.addItem(item1);
        order4.addItem(item2);
        order5.addItem(item1);
        order5.addItem(item3);

        // Display
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();

        // Ready
        order1.setReady(true);
        order5.setReady(false);
        System.out.println(order1.getStatusMessage());
        System.out.println(order5.getStatusMessage());

    }
}
