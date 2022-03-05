public class CafeJava {
    public static void main(String[] args) {
        // VARIABLES DE LA APP
        // Líneas de texto que aparecerán en la app
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $"; // Menu variables (add yours below)

        // Variables de menú (agrega las tuyas a continuación)
        // double mochaPrice = 3.5;
        double dripCoffeePrice = 5.5;
        double lattePrice = 10.99;
        double cappuccinoPrice = 3.99;

        // Variables de nombre de cliente (agrega las tuyas a continuación)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Finalizaciones de pedidos (agrega las tuyas a continuación)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;

        System.out.println(generalGreeting);
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
            System.out.println(displayTotalMessage + dripCoffeePrice);
        } else {
            System.out.println(customer1 + pendingMessage);
        }

        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }

        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + 2 * lattePrice);
        } else {
            System.out.println(customer2 + pendingMessage);
        }
        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
            System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));
        } else {
            System.out.println(customer3 + pendingMessage);
        }

    }
}