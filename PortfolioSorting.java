import java.util.*;

class Asset {
    String name;
    double returnRate;

    Asset(String name, double returnRate) {
        this.name = name;
        this.returnRate = returnRate;
    }

    public String toString() {
        return name + ":" + returnRate;
    }
}

public class PortfolioSorting {

    static void mergeSort(List<Asset> list) {
        list.sort(Comparator.comparingDouble(a -> a.returnRate));
    }

    static void quickSort(List<Asset> list) {
        list.sort((a, b) -> Double.compare(b.returnRate, a.returnRate));
    }

    public static void main(String[] args) {
        List<Asset> list = Arrays.asList(
            new Asset("AAPL", 12),
            new Asset("TSLA", 8),
            new Asset("GOOG", 15)
        );

        mergeSort(list);
        System.out.println("Merge: " + list);

        quickSort(list);
        System.out.println("Quick: " + list);
    }
}
