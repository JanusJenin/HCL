import java.util.*;

public class LibraryWaitlist {

    public static void main(String[] args) {

        // 1. ArrayList - room numbers in insertion order
        List<Integer> rooms = new ArrayList<>();
        rooms.add(101);
        rooms.add(102);
        rooms.add(103);
        System.out.println("Rooms: " + rooms);

        // 2. LinkedList - guest waiting queue
        Queue<String> guests = new LinkedList<>();
        guests.offer("Babu");
        guests.offer("Arun");
        guests.offer("Priya");
        System.out.println("Waiting guests: " + guests);
        System.out.println("Next guest: " + guests.poll());
        System.out.println("After serving: " + guests);

        // 3. HashSet - unique guest IDs
        Set<Integer> guestIds = new HashSet<>();
        guestIds.add(1001);
        guestIds.add(1002);
        guestIds.add(1001);
        System.out.println("Unique guest IDs: " + guestIds);

        // 4. LinkedHashSet - unique IDs, insertion order
        Set<String> bookingCodes = new LinkedHashSet<>();
        bookingCodes.add("BK101");
        bookingCodes.add("BK102");
        bookingCodes.add("BK101");
        System.out.println("Booking codes: " + bookingCodes);

        // 5. ArrayDeque - add/remove from both ends
        Deque<String> checkInQueue = new ArrayDeque<>();
        checkInQueue.offerLast("Guest A");
        checkInQueue.offerLast("Guest B");
        checkInQueue.offerFirst("Priority Guest");
        System.out.println("Check-in queue: " + checkInQueue);
        checkInQueue.pollFirst();
        System.out.println("After check-in: " + checkInQueue);

        // 6. PriorityQueue - smallest room number first
        PriorityQueue<Integer> priorityRooms = new PriorityQueue<>();
        priorityRooms.offer(305);
        priorityRooms.offer(201);
        priorityRooms.offer(102);
        System.out.println("Priority room order:");
        while (!priorityRooms.isEmpty()) {
            System.out.println(priorityRooms.poll());
        }

        // 7. HashMap - guest ID mapped to guest name
        Map<Integer, String> guestMap = new HashMap<>();
        guestMap.put(1001, "Babu");
        guestMap.put(1002, "Priya");
        System.out.println("Guest 1001: " + guestMap.get(1001));

        // 8. TreeMap - booking IDs sorted by key
        Map<Integer, String> bookings = new TreeMap<>();
        bookings.put(103, "Room 103");
        bookings.put(101, "Room 101");
        bookings.put(102, "Room 102");
        System.out.println("Sorted bookings: " + bookings);

        // 9. Safe removal using Iterator
        Iterator<Integer> iterator = rooms.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 102) {
                iterator.remove();
            }
        }
        System.out.println("Rooms after safe removal: " + rooms);

        // 10. Timing comparison
        List<Integer> timingList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            timingList.add(i);
        }
        long listTime = System.nanoTime() - start;

        Set<Integer> timingSet = new HashSet<>();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            timingSet.add(i);
        }
        long setTime = System.nanoTime() - start;

        System.out.println("ArrayList add time: " + listTime + " ns");
        System.out.println("HashSet add time: " + setTime + " ns");
    }
}

