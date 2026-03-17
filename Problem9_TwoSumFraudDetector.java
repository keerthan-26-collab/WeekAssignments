import java.util.*;

public class Problem9_TwoSumFraudDetector {

    public void findTwoSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("Pair found: " +
                        complement + " + " + num);
                return;
            }

            map.put(num, 1);
        }
    }
}