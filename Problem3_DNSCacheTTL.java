import java.util.*;

public class Problem3_DNSCacheTTL {

    class DNSEntry {
        String ip;
        long expiryTime;

        DNSEntry(String ip, long ttlSeconds) {
            this.ip = ip;
            this.expiryTime = System.currentTimeMillis() + ttlSeconds * 1000;
        }
    }

    private HashMap<String, DNSEntry> cache = new HashMap<>();
    private int hits = 0;
    private int misses = 0;

    public String resolve(String domain, String ip, long ttl) {

        if (cache.containsKey(domain)) {
            DNSEntry entry = cache.get(domain);
            if (System.currentTimeMillis() < entry.expiryTime) {
                hits++;
                return "Cache HIT: " + entry.ip;
            }
        }

        misses++;
        cache.put(domain, new DNSEntry(ip, ttl));
        return "Cache MISS: " + ip;
    }

    public void getStats() {
        int total = hits + misses;
        System.out.println("Hit rate: " + (hits * 100.0 / total) + "%");
    }
}