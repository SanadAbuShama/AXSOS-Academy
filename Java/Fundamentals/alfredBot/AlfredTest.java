import java.util.Date;

public class AlfredTest {
    /*
     * This main method will always be the starting point of a Java application
     * For now, we are using main to test all of our
     * AlfredQuotes methods.
     */
    public static void main(String[] args) {
        // Create an instance of AlfredQuotes to access all of your AlfredQuotes methods
        AlfredQuotes alfredBot = new AlfredQuotes();

        // Do some test greetings, providing the necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane");
        String testGuestGreeting2 = alfredBot.guestGreeting("Beth Kane", new Date());
        String testDateAnnouncement = alfredBot.dateAnnouncement();

        String alexisTest = alfredBot.respondBeforeAlexis(
                "Alexis! Play some low-fi beats.");
        String alfredTest = alfredBot.respondBeforeAlexis(
                "I can't find my yo-yo. Maybe Alfred knows where it is");
        String notRelevantTest = alfredBot.respondBeforeAlexis(
                "Maybe that's what Batman is all about. Not winning. Failing...");
        String moodTest = alfredBot.alfredMood();
        // Print the greetings to test.
        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testGuestGreeting2);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
        System.out.println(moodTest);

    }
}