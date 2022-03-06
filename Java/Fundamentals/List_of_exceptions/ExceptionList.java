import java.util.ArrayList;

public class ExceptionList {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hello World");
        myList.add(48);
        myList.add("Goodbye World");
        for (int i = 0; i < myList.size(); i++) {
            try {
                int castedValue = (int) myList.get(i);
                System.out.println("\n" + castedValue);
            } catch (Exception e) {
                System.out.println("\n");
                System.out.println(e.getMessage());
                System.out.println("Error occured at index: " + i);

            }

        }

    }
}
