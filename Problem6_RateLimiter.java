import java.util.*;

public class Problem6_RateLimiter {

    class TokenBucket {
        int tokens;
        long lastRefill;
    }

    private HashMap<String, TokenBucket> clients = new HashMap<>();
    private final int LIMIT = 1000;

    public boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket());
        TokenBucket bucket = clients.get(clientId);

        long now = System.currentTimeMillis();

        if (now - bucket.lastRefill > 3600000) {
            bucket.tokens = 0;
            bucket.lastRefill = now;
        }

        if (bucket.tokens < LIMIT) {
            bucket.tokens++;
            return true;
        }

        return false;
    }
}