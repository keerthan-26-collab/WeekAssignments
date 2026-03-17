public class Problem8_ParkingLotOpenAddressing {

    private String[] spots;
    private int capacity;

    public Problem8_ParkingLotOpenAddressing(int capacity) {
        this.capacity = capacity;
        spots = new String[capacity];
    }

    private int hash(String plate) {
        return Math.abs(plate.hashCode()) % capacity;
    }

    public void parkVehicle(String plate) {

        int index = hash(plate);

        while (spots[index] != null) {
            index = (index + 1) % capacity;
        }

        spots[index] = plate;
        System.out.println("Parked at spot " + index);
    }
}