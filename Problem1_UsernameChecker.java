import java.util.*;

public class Problem1_UsernameChecker {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public void register(String username, int id) {
        users.put(username, id);
    }

    public List<String> suggest(String username) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String suggestion = username + i;
            if (!users.containsKey(suggestion))
                list.add(suggestion);
        }
        return list;
    }

    public String mostAttempted() {
        return Collections.max(attempts.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Problem1_UsernameChecker system = new Problem1_UsernameChecker();
        system.register("john_doe", 1);

        System.out.println(system.checkAvailability("john_doe"));
        System.out.println(system.suggest("john_doe"));
        System.out.println(system.mostAttempted());
    }
}