import java.util.*;

public class Problem2_FlashSaleInventory {

    private HashMap<String, Integer> stock = new HashMap<>();
    private HashMap<String, Queue<Integer>> waiting = new HashMap<>();

    public void addProduct(String id, int qty) {
        stock.put(id, qty);
        waiting.put(id, new LinkedList<>());
    }

    public synchronized String purchase(String id, int user) {
        int available = stock.getOrDefault(id, 0);
        if (available > 0) {
            stock.put(id, available - 1);
            return "Success! Remaining: " + (available - 1);
        } else {
            waiting.get(id).add(user);
            return "Added to waiting list. Position: " + waiting.get(id).size();
        }
    }

    public static void main(String[] args) {
        Problem2_FlashSaleInventory inv = new Problem2_FlashSaleInventory();
        inv.addProduct("IPHONE", 2);

        System.out.println(inv.purchase("IPHONE", 101));
        System.out.println(inv.purchase("IPHONE", 102));
        System.out.println(inv.purchase("IPHONE", 103));
    }
}