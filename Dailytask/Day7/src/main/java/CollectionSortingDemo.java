import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Room implements Comparable<Room> {
    int roomNumber;
    int price;

    Room(int roomNumber, int price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    // Comparable: natural ordering by room number
    @Override
    public int compareTo(Room other) {
        return Integer.compare(this.roomNumber, other.roomNumber);
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " - Rs." + price;
    }
}

public class CollectionSortingDemo {

    public static void main(String[] args) {

        // 1. Array example: fixed size
        int[] roomArray = {103, 101, 102};
        Arrays.sort(roomArray);
        System.out.println("Sorted array: " +
                Arrays.toString(roomArray));

        // 2. Collection example: dynamic size
        List<Integer> roomList = new ArrayList<>();
        roomList.add(103);
        roomList.add(101);
        roomList.add(102);
        roomList.add(104);
        Collections.sort(roomList);
        System.out.println("Sorted collection: " + roomList);

        // 3. Comparable: sort by room number
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(103, 2000));
        rooms.add(new Room(101, 3000));
        rooms.add(new Room(102, 1500));

        Collections.sort(rooms);
        System.out.println("Comparable - room number:");
        for (Room room : rooms) {
            System.out.println(room);
        }

        // 4. Comparator: sort by price
        Comparator<Room> priceComparator =
                Comparator.comparingInt(room -> room.price);

        rooms.sort(priceComparator);
        System.out.println("Comparator - price:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}
