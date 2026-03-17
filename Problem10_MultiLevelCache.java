import java.util.*;

public class Problem10_MultiLevelCache {

    private LinkedHashMap<String, String> L1;

    public Problem10_MultiLevelCache(int capacity) {
        L1 = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public void put(String key, String value) {
        L1.put(key, value);
    }

    public String get(String key) {
        return L1.get(key);
    }
}