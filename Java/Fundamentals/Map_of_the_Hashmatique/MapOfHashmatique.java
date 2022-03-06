import java.util.HashMap;
import java.util.Set;

public class MapOfHashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Dangerous", "I can see it that can't stop myself from lookin'");
        trackList.put("Gangnam Style", "Oppa Gangnam Style");
        trackList.put("Man in the Mirror", "I'm gonna make a change");
        trackList.put("They Don't Care About Us", "Don't worry what people say, we know the truth");
        System.out.println(String.format("Single Song: %s", trackList.get("Dangerous")));
        Set<String> keys = trackList.keySet();
        System.out.println("\nAll Songs:\n");
        for (String key : keys) {
            System.out.println(String.format("%s: %s", key, trackList.get(key)));
        }
    }
}
