import java.util.*;

public class Problem5_AnalyticsDashboard {

    private HashMap<String, Integer> views = new HashMap<>();
    private HashMap<String, Set<String>> unique = new HashMap<>();

    public void process(String url, String user) {
        views.put(url, views.getOrDefault(url, 0) + 1);
        unique.putIfAbsent(url, new HashSet<>());
        unique.get(url).add(user);
    }

    public static void main(String[] args) {
        Problem5_AnalyticsDashboard dash = new Problem5_AnalyticsDashboard();
        dash.process("/home", "u1");
        dash.process("/home", "u2");
        dash.process("/home", "u1");

        System.out.println(dash.views);
    }
}