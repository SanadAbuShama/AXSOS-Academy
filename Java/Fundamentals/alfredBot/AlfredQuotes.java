import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting() {
        // You don't need to code here, this is an example method
        return "Hello, nice to see you. How are you?";
    }

    public String guestGreeting(String name) {

        return String.format("Hello %s, nice to meet you", name);
    }

    public String guestGreeting(String name, Date date) {

        return String.format("Hello %s, nice to meet you on ", name) + date;
    }

    public String dateAnnouncement() {
        Date date = new Date();
        return "It is currently " + date;
    }

    public String respondBeforeAlexis(String conversation) {
        int alexisIndex = conversation.indexOf("Alexis");
        int alfredIndex = conversation.indexOf("Alfred");
        if (alexisIndex != -1) {
            return "Right away, sir. You're certainly not sophisticated enough for that";
        } else if (alfredIndex != -1) {
            return "At your service. As you wish, of course.";
        } else {
            return "Fine. And with that, I'll be off.";
        }

    }

    public String alfredMood() {
        int mood = (int) Math.floor((Math.random() * 2));
        if (mood == 0) {
            return "I am not in a good mood :(";
        } else {
            return "I am in a good mood :)";
        }

    }

}
