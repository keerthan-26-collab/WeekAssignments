import java.util.*;

public class Problem4_PlagiarismDetector {

    public Map<String, Integer> extractNGrams(String text, int n) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\s+");

        for (int i = 0; i <= words.length - n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++)
                sb.append(words[i + j]).append(" ");

            String gram = sb.toString().trim();
            map.put(gram, map.getOrDefault(gram, 0) + 1);
        }

        return map;
    }
}