import java.util.*;

public class Problem7_AutocompleteSystem {

    private HashMap<String, Integer> queryFreq = new HashMap<>();

    public void updateFrequency(String query) {
        queryFreq.put(query,
                queryFreq.getOrDefault(query, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> results = new ArrayList<>();

        for (String query : queryFreq.keySet()) {
            if (query.startsWith(prefix))
                results.add(query);
        }

        results.sort((a, b) ->
                queryFreq.get(b) - queryFreq.get(a));

        return results.size() > 10 ?
                results.subList(0, 10) : results;
    }
}